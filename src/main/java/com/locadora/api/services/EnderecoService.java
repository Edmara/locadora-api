package com.locadora.api.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.locadora.api.domain.Endereco;
import com.locadora.api.repositories.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository repositorio;

	public Endereco buscar(Integer id) {

		Optional<Endereco> obj = repositorio.findById(id);
		return obj.orElse(null);

	}

}
