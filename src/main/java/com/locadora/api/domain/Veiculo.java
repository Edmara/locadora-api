package com.locadora.api.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Veiculo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String modelo;
	private String placa;
	private String valorDiaria;

//	private List<Marca> marcas = new ArrayList<>();

	public Veiculo() {
	}

	public Veiculo(Integer id, String modelo, String placa, String valorDiaria) {
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
		this.placa = placa;
	}

	public String getValorDiaria() {
		return valorDiaria;
	}

	public void setValorDiaria(String valorDiaria) {
		this.valorDiaria = valorDiaria;
	}
//
//	public List<Marca> getMarcas() {
//		return marcas;
//	}
//
//	public void setMarcas(List<Marca> marcas) {
//		this.marcas = marcas;
//	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Veiculo other = (Veiculo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
