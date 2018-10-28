package com.locadora.api.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.locadora.api.domain.Veiculo;
import com.locadora.api.dto.VeiculoDTO;
import com.locadora.api.resources.util.URL;
import com.locadora.api.services.VeiculoService;

@RestController
@RequestMapping(value = "/veiculos")
public class VeiculoResource {

	@Autowired
	private VeiculoService service;
	
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Veiculo> find(@PathVariable Integer id) {
		
		Veiculo obj = service.find(id);
		return ResponseEntity.ok().body(obj);

	}
	
}