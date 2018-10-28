package com.locadora.api.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.locadora.api.domain.enums.StatusPagamento;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Pagamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer id;
	private Integer status;

	@JsonIgnore
	@OneToOne
	@JoinColumn(name="venda_id")
	@MapsId
	private Venda venda;

	public Pagamento() {
	}

	public Pagamento(Integer id, StatusPagamento status, Venda venda) {
		super();
		this.id = id;
		this.status = (status==null) ? null : status.getCod();
		this.venda = venda;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public StatusPagamento getStatus() {
		return StatusPagamento.toEnum(status);
	}

	public void setStatus(StatusPagamento status) {
		this.status = status.getCod();
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
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
		Pagamento other = (Pagamento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
