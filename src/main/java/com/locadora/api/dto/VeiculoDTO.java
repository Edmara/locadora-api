package com.locadora.api.dto;

import java.io.Serializable;

public class VeiculoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String modelo;
	private String placa;
	private Double valorDiaria;
	
	public VeiculoDTO() {
	}

	public VeiculoDTO(Integer id, String modelo, String placa, Double valorDiaria) {
		super();
		this.id = id;
		this.modelo = modelo;
		this.placa = placa;
		this.valorDiaria = valorDiaria;
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
	}

	public Double getValorDiaria() {
		return valorDiaria;
	}

	public void setValorDiaria(Double valorDiaria) {
		this.valorDiaria = valorDiaria;
	}
	
}
