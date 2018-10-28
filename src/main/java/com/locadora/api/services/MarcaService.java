package com.locadora.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.locadora.api.domain.Marca;
import com.locadora.api.dto.MarcaDTO;
import com.locadora.api.repositories.MarcaRepository;
import com.locadora.api.services.exceptions.DataIntegrityException;
import com.locadora.api.services.exceptions.ObjectNotFoundException;

@Service
public class MarcaService {

	@Autowired
	private MarcaRepository repositorio;

	public Marca find(Integer id) {

		Optional<Marca> obj = repositorio.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Marca.class.getName()));

	}

	public Marca insert(Marca obj) {
		obj.setId(null);
		return repositorio.save(obj);
	}

	public Marca update(Marca marca) {
		Marca newMarca = find(marca.getId());
		updateData(newMarca, marca);
		return repositorio.save(newMarca);
	}

	private void updateData(Marca newMarca, Marca marca) {
		newMarca.setNome(marca.getNome());
	}

	public void delete(Integer id) {
		find(id);
		try {
			repositorio.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma marca com veículos");

		}

	}

	public List<Marca> findAll() {
		return repositorio.findAll();
	}	
	
	
	public Page<Marca> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repositorio.findAll(pageRequest);
	}
	
	public Marca fromDTO(MarcaDTO marcaDto) {
		return new Marca(marcaDto.getId(), marcaDto.getNome());
	}
}
