	package com.locadora.api.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Reserva implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@EmbeddedId
	private ReservaPK id = new ReservaPK();

	private Date dataInicio;
	private Date dataFim;
	private Double preco;

	public Reserva() {

	}

	public Reserva(Venda venda, Veiculo veiculo, Date dataInicio, Date dataFim, Double preco) {
		super();
		id.setVenda(venda);
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
	public Venda getVenda() {
		return id.getVenda();
	}
	
	public Veiculo getVeiculo() {
		return id.getVeiculo();
	}

	public ReservaPK getId() {
		return id;
	}

	public void setId(ReservaPK id) {
		this.id = id;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
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
		Reserva other = (Reserva) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
}