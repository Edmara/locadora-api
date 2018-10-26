package com.locadora.api.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.locadora.api.domain.Veiculo;
import com.locadora.api.repositories.VeiculoRepository;

@Service
public class VeiculoService {
	
	@Autowired
	private VeiculoRepository repositorio;
	
	public Veiculo buscar(Integer id) {
		
		Optional<Veiculo> obj = repositorio.findById(id);
		return obj.orElse(null);
		
	}
	
	
}
