package com.locadora.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.locadora.api.domain.Marca;
import com.locadora.api.domain.Veiculo;
import com.locadora.api.repositories.MarcaRepository;
import com.locadora.api.repositories.VeiculoRepository;

@Service
public class VeiculoService {
	
	@Autowired
	private VeiculoRepository repositorio;
	
	@Autowired
	private MarcaRepository marcaRepositorio;
	
	public Veiculo find(Integer id) {
		
		Optional<Veiculo> obj = repositorio.findById(id);
		return obj.orElse(null);
		
	}
	
}
