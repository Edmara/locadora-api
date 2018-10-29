package com.locadora.api.resources;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.locadora.api.domain.Veiculo;
import com.locadora.api.dto.VeiculoDTO;
import com.locadora.api.services.VeiculoService;

@RestController
@RequestMapping(value = "/veiculos")
public class VeiculoResource {

	@Autowired
	private VeiculoService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Veiculo> find(@PathVariable Integer id) {

		Veiculo obj = service.find(id);
		return ResponseEntity.ok().body(obj);

	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody VeiculoDTO veiculoDto) {
		Veiculo veiculo = service.fromDTO(veiculoDto);
		veiculo = service.insert(veiculo);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(veiculo.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

}