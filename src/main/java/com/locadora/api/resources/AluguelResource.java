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

import com.locadora.api.domain.Aluguel;
import com.locadora.api.domain.Cliente;
import com.locadora.api.dto.AluguelNewDTO;
import com.locadora.api.services.AluguelService;

@RestController
@RequestMapping(value = "/alugueis")
public class AluguelResource {

	@Autowired
	private AluguelService service;
	
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Aluguel> find(@PathVariable Integer id) {
		
		Aluguel obj = service.find(id);
		return ResponseEntity.ok().body(obj);

	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody AluguelNewDTO aluguelDto) {
		Aluguel aluguel= service.fromDTO(aluguelDto);
		aluguel= service.insert(aluguel);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(aluguel.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
}