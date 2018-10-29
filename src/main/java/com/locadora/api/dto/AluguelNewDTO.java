package com.locadora.api.dto;

import java.time.LocalDate;

import javax.persistence.EmbeddedId;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.locadora.api.domain.AluguelPK;
import com.locadora.api.domain.Transacao;
import com.locadora.api.domain.Veiculo;

public class AluguelNewDTO {

	
	@JsonIgnore
	@EmbeddedId
	private AluguelPK id = new AluguelPK();

	private Transacao transacao;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private LocalDate dataInicio;
	@NotEmpty(message="Preenchimento obrigatório")
	private LocalDate dataFim;
	
	private Veiculo veiculo;
	private LocalDate dataPagamento;
	private Double preco;
	
	
	public AluguelNewDTO () {
		
	}


	public AluguelNewDTO(Transacao transacao, Veiculo veiculo, LocalDate dataInicio, LocalDate dataFim, Double preco, LocalDate dataPagamento) {
		super();
		id.setTransacao(transacao);
		id.setVeiculo(veiculo);
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


	public LocalDate getDataPagamento() {
		return dataPagamento;
	}


	public void setDataPagamento(LocalDate dataPagamento) {
		this.dataPagamento = dataPagamento;
	}


	public Double getPreco() {
		return preco;
	}


	public void setPreco(Double preco) {
		this.preco = preco;
	}


	public Veiculo getVeiculo() {
		return veiculo;
	}


	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}


	public Transacao getTransacao() {
		return id.getTransacao();
	}


	public void setTransacao(Transacao transacao) {
		id.setTransacao(transacao);
	}
	
}
