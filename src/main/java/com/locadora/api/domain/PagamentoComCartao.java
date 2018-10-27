package com.locadora.api.domain;

import javax.persistence.Entity;

import com.locadora.api.domain.enums.StatusPagamento;

@Entity
public class PagamentoComCartao extends Pagamento {
	private static final long serialVersionUID = 1L;

	private Integer numeroParcelas;

	public PagamentoComCartao() {

	}

	public PagamentoComCartao(Integer id, StatusPagamento status, Venda venda, Integer numeroParcelas) {
		super(id, status, venda);
		this.numeroParcelas = numeroParcelas;
	}

	public Integer getNumeroParcelas() {
		return numeroParcelas;
	}

	public void setNumeroParcelas(Integer numeroParcelas) {
		this.numeroParcelas = numeroParcelas;
	}

}
