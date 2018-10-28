package com.locadora.api.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.locadora.api.domain.Venda;
import com.locadora.api.repositories.VendaRepository;

@Service
public class VendaService {
	
	@Autowired
	private VendaRepository repositorio;
	
	public Venda find(Integer id) {
		
		Optional<Venda> obj = repositorio.findById(id);
		return obj.orElse(null);
		
	}
	
	
}
