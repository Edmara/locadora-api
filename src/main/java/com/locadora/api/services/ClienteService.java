package com.locadora.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.locadora.api.domain.Cliente;
import com.locadora.api.domain.Endereco;
import com.locadora.api.domain.enums.TipoCliente;
import com.locadora.api.dto.ClienteDTO;
import com.locadora.api.dto.ClienteNewDTO;
import com.locadora.api.repositories.ClienteRepository;
import com.locadora.api.repositories.EnderecoRepository;
import com.locadora.api.services.exceptions.DataIntegrityException;
import com.locadora.api.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepositorio;
	@Autowired
	private EnderecoRepository enderecoRepository;


	public Cliente find(Integer id) {
		Optional<Cliente> cliente = clienteRepositorio.findById(id);
		return cliente.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
	}

	public Cliente update(Cliente cliente) {
		Cliente newCliente = find(cliente.getId());
		updateData(newCliente, cliente);
		return clienteRepositorio.save(newCliente);
	}

	public void delete(Integer id) {
		find(id);
		try {
			clienteRepositorio.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir porque há vendas relacionadas");
		}
	}
	
	@Transactional
	public Cliente insert(Cliente cliente) {
		cliente.setId(null);
		cliente = clienteRepositorio.save(cliente);
		enderecoRepository.saveAll(cliente.getEnderecos());
		return cliente;
	}

	public List<Cliente> findAll() {
		return clienteRepositorio.findAll();
	}

	public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return clienteRepositorio.findAll(pageRequest);
	}

	public Cliente fromDTO(ClienteDTO clienteDto) {
		return new Cliente(clienteDto.getId(), clienteDto.getNome(), clienteDto.getEmail(), null, null, null);
	}

	public Cliente fromDTO(ClienteNewDTO clienteDto) {
		Cliente cliente = new Cliente(null, clienteDto.getNome(), clienteDto.getEmail(), clienteDto.getCpfOuCnpj(),
				clienteDto.getCnh(), TipoCliente.toEnum(clienteDto.getTipo()));
		Endereco endereco = new Endereco(null, clienteDto.getLogradouro(), clienteDto.getNumero(),
				clienteDto.getComplemento(), clienteDto.getBairro(), clienteDto.getCep(), clienteDto.getCidade(),
				clienteDto.getEstado(), cliente);

		cliente.getEnderecos().add(endereco);
		cliente.getTelefones().add(clienteDto.getTelefone1());
		if (clienteDto.getTelefone2() != null) {
			cliente.getTelefones().add(clienteDto.getTelefone2());
		}
		if (clienteDto.getTelefone3() != null) {
			cliente.getTelefones().add(clienteDto.getTelefone3());
		}
		
		return cliente;
	}

	private void updateData(Cliente newCliente, Cliente cliente) {
		newCliente.setNome(cliente.getNome());
		newCliente.setEmail(cliente.getEmail());
	}

}