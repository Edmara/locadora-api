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

import com.locadora.api.domain.Marca;
import com.locadora.api.domain.Transacao;
import com.locadora.api.dto.MarcaDTO;
import com.locadora.api.services.TransacaoService;

@RestController
@RequestMapping(value = "/transacoes")
public class TransacaoResource {

	@Autowired
	private TransacaoService service;
	
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Transacao> find(@PathVariable Integer id) {
		
		Transacao transacao = service.find(id);
		return ResponseEntity.ok().body(transacao);

	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody Transacao venda) {
		venda = service.insert(venda);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(venda.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}