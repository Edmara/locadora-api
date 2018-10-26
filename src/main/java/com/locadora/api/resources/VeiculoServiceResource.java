package com.locadora.api.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.locadora.api.domain.Veiculo;
import com.locadora.api.services.VeiculoService;

@RestController
@RequestMapping(value = "/veiculos")
public class VeiculoServiceResource {

	@Autowired
	private VeiculoService service;
	
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		
		Veiculo obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);

	}
}