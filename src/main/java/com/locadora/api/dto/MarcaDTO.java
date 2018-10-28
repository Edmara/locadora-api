package com.locadora.api.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.locadora.api.domain.Marca;

public class MarcaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	
	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min=3, max=20, message="O tamanho deve ser entre 3 e 20 caracteres")
	public MarcaDTO() {
	}

	
	public MarcaDTO(Marca marca) {
		id = marca.getId();
		nome = marca.getNome();
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
