package com.locadora.api.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.locadora.api.domain.Veiculo;
import com.locadora.api.dto.VeiculoDTO;
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
	
	@Transactional
	public Veiculo insert(Veiculo veiculo) {
		veiculo.setId(null);
		veiculo = repositorio.save(veiculo);
		return veiculo;
	}
	
	public Veiculo fromDTO(VeiculoDTO veiculoDTO) {
		return new Veiculo(veiculoDTO.getId(), veiculoDTO.getModelo(), veiculoDTO.getPlaca(), veiculoDTO.getValorDiaria());
	}
	
}
