package com.locadora.api.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.locadora.api.domain.Marca;
import com.locadora.api.repositories.MarcaRepository;

@Service
public class MarcaService {
	
	@Autowired
	private MarcaRepository repositorio;
	
	public Marca buscar(Integer id) {
		
		Optional<Marca> obj = repositorio.findById(id);
		return obj.orElse(null);
		
	}
	
	
}
