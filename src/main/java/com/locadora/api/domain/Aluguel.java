	package com.locadora.api.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Aluguel implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@EmbeddedId
	private AluguelPK id = new AluguelPK();

	private LocalDate dataInicio;
	private LocalDate dataFim;
	private Double preco;

	public Aluguel() {

	}

	public Aluguel(Transacao transacao, Veiculo veiculo, LocalDate dataInicio, LocalDate dataFim, Double preco) {
		super();
		id.setTransacao(transacao);
		id.setVeiculo(veiculo);
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.preco = preco;
	}
	
	public double getSubTotal(LocalDate dataInicio, LocalDate dataFim) {
		Long quantidadeDias = ChronoUnit.DAYS.between(dataInicio, dataFim);
		return preco * quantidadeDias;
	}
	
	
	@JsonIgnore
	public Transacao getTransacao() {
		return id.getTransacao();
	}
	
	public Veiculo getVeiculo() {
		return id.getVeiculo();
	}
	
	public void setTransacao(Transacao transacao) {
		id.setTransacao(transacao);
	}	

	public void setTransacao(Veiculo veiculo) {
		 id.setVeiculo(veiculo);
	}
	
	public AluguelPK getId() {
		return id;
	}

	public void setId(AluguelPK id) {
		this.id = id;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public LocalDate getDataFim() {
		return dataFim;
	}

	public void setDataFim(LocalDate dataFim) {
		this.dataFim = dataFim;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

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
		Aluguel other = (Aluguel) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
}