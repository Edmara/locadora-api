package com.locadora.api.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

public class VeiculoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String modelo;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String placa;

	private Double valorDiaria;
	
	private String marca;
	
	public VeiculoDTO() {
	}

	public VeiculoDTO(Integer id, String modelo, String placa, Double valorDiaria, String marca) {
		super();
		this.id = id;
		this.modelo = modelo;
		this.placa = placa;
		this.valorDiaria = valorDiaria;
		this.marca = marca;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Double getValorDiaria() {
		return valorDiaria;
	}

	public void setValorDiaria(Double valorDiaria) {
		this.valorDiaria = valorDiaria;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}
	
}
