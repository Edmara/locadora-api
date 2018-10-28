package com.locadora.api.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.locadora.api.domain.Marca;
import com.locadora.api.dto.MarcaDTO;
import com.locadora.api.services.MarcaService;

@RestController
@RequestMapping(value = "/marcas")
public class MarcaResource {

	@Autowired
	private MarcaService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Marca> find(@PathVariable Integer id) {

		Marca obj = service.find(id);
		return ResponseEntity.ok().body(obj);

	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<MarcaDTO>> findAll() {

		List<Marca> listaMarcas = service.findAll();
		List<MarcaDTO> listaMarcasDto = listaMarcas.stream().map(obj -> new MarcaDTO(obj))
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(listaMarcasDto);

	}
	
	
	
	@RequestMapping(value="/page", method=RequestMethod.GET)
	public ResponseEntity<Page<MarcaDTO>> findPage(
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="nome") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction) {
		Page<Marca> listaMarcas = service.findPage(page, linesPerPage, orderBy, direction);
		Page<MarcaDTO> listaMarcasDto = listaMarcas.map(obj -> new MarcaDTO(obj));  
		return ResponseEntity.ok().body(listaMarcasDto); 
	}
	

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody MarcaDTO marcaDto) {
		Marca marca = service.fromDTO(marcaDto);
		marca = service.insert(marca);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(marca.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody MarcaDTO marcaDto, @PathVariable Integer id) {
		Marca marca = service.fromDTO(marcaDto);
		marca.setId(id);
		marca = service.update(marca);

		return ResponseEntity.noContent().build();

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}