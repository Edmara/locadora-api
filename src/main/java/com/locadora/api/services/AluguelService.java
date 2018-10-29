package com.locadora.api.services;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.locadora.api.domain.Aluguel;
import com.locadora.api.domain.Cliente;
import com.locadora.api.domain.Veiculo;
import com.locadora.api.dto.AluguelNewDTO;
import com.locadora.api.repositories.AluguelRepository;
import com.locadora.api.repositories.VeiculoRepository;

@Service
public class AluguelService {
	
	@Autowired
	private AluguelRepository repositorio;
	private VeiculoRepository repositorioVeiculos;

	
	public Aluguel find(Integer id) {
		
		Optional<Aluguel> obj = repositorio.findById(id);
		return obj.orElse(null);
		
	}
	
	private void UpdateStatus(Veiculo veiculo) {
		veiculo.setStatus("Reservado");
		repositorioVeiculos.save(veiculo);
	}
	
	@Transactional
	public Aluguel insert(Aluguel aluguel) {
		aluguel.setId(null);
		aluguel = repositorio.save(aluguel);
		
		return aluguel;
	}
	
	public Aluguel fromDTO(AluguelNewDTO aluguelDto) {
		Aluguel aluguel = new Aluguel(aluguelDto.getTransacao(), aluguelDto.getVeiculo(), aluguelDto.getDataInicio(), aluguelDto.getDataFim(), aluguelDto.getPreco());
		
		LocalDate dataAtual = LocalDate.now();
		
		if (aluguelDto.getDataInicio() == dataAtual) {
			UpdateStatus(aluguelDto.getVeiculo());
		}
		
		return aluguel;
	}
	
	
	
}
