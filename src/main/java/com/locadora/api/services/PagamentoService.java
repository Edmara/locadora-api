package com.locadora.api.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.locadora.api.domain.Pagamento;
import com.locadora.api.repositories.PagamentoRepository;

@Service
public class PagamentoService {
	
	@Autowired
	private PagamentoRepository repositorio;
	
	public Pagamento find(Integer id) {
		
		Optional<Pagamento> obj = repositorio.findById(id);
		return obj.orElse(null);
		
	}
	
	
}
