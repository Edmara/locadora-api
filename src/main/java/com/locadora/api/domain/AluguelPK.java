package com.locadora.api.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class AluguelPK implements Serializable{
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name="transacao_id")
	private Transacao transacao;
	
	@ManyToOne
	@JoinColumn(name="veiculo_id")
	private Veiculo veiculo;
	
	
	public Transacao getTransacao() {
		return transacao;
	}
	public void setTransacao(Transacao transacao) {
		this.transacao = transacao;
	}
	public Veiculo getVeiculo() {
		return veiculo;
	}
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((veiculo == null) ? 0 : veiculo.hashCode());
		result = prime * result + ((transacao == null) ? 0 : transacao.hashCode());
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
		AluguelPK other = (AluguelPK) obj;
		if (veiculo == null) {
			if (other.veiculo != null)
				return false;
		} else if (!veiculo.equals(other.veiculo))
			return false;
		if (transacao == null) {
			if (other.transacao != null)
				return false;
		} else if (!transacao.equals(other.transacao))
			return false;
		return true;
	}

}
