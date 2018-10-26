package com.locadora.api.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.locadora.api.domain.Cliente;
import com.locadora.api.domain.Marca;
import com.locadora.api.repositories.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repositorio;
	
	public Cliente buscar(Integer id) {
		
		Optional<Cliente> obj = repositorio.findById(id);
		return obj.orElse(null);
		
	}
	
	
}
