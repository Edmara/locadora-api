package com.locadora.api.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.locadora.api.domain.Venda;
import com.locadora.api.services.VendaService;

@RestController
@RequestMapping(value = "/vendas")
public class VendaServiceResource {

	@Autowired
	private VendaService service;
	
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		
		Venda obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);

	}
}