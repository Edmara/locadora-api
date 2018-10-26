package com.locadora.api.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.locadora.api.domain.Reserva;
import com.locadora.api.repositories.ReservaRepository;

@Service
public class ReservaService {
	
	@Autowired
	private ReservaRepository repositorio;
	
	public Reserva buscar(Integer id) {
		
		Optional<Reserva> obj = repositorio.findById(id);
		return obj.orElse(null);
		
	}
	
	
}
