package com.locadora.api.dto;

import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.locadora.api.domain.AluguelPK;

public class AluguelDTO {

	
	@JsonIgnore
	@EmbeddedId
	private AluguelPK id = new AluguelPK();

	@NotEmpty(message="Preenchimento obrigatório")
	private Date dataInicio;
	@NotEmpty(message="Preenchimento obrigatório")
	private Date dataFim;
	
	private Date dataPagamento;
	private Double preco;
	
	
	public AluguelDTO () {
		
	}


	public AluguelDTO(AluguelPK id, Date dataInicio, Date dataFim, Date dataPagamento, Double preco) {
		super();
		this.id = id;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.dataPagamento = dataPagamento;
		this.preco = preco;
	}


	public AluguelPK getId() {
		return id;
	}


	public void setId(AluguelPK id) {
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


	public Date getDataPagamento() {
		return dataPagamento;
	}


	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}


	public Double getPreco() {
		return preco;
	}


	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
}
