package com.locadora.api.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.locadora.api.domain.Telefone;
import com.locadora.api.repositories.TelefoneRepository;

@Service
public class TelefoneService {
	
	@Autowired
	private TelefoneRepository repositorio;
	
	public Telefone buscar(Integer id) {
		
		Optional<Telefone> obj = repositorio.findById(id);
		return obj.orElse(null);
		
	}
}
