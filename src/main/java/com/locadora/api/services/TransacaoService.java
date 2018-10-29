package com.locadora.api.services;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.locadora.api.domain.PagamentoComBoleto;
import com.locadora.api.domain.Aluguel;
import com.locadora.api.domain.Transacao;
import com.locadora.api.domain.enums.StatusPagamento;
import com.locadora.api.repositories.PagamentoRepository;
import com.locadora.api.repositories.AluguelRepository;
import com.locadora.api.repositories.TransacaoRepository;

@Service
public class TransacaoService {

	@Autowired
	private TransacaoRepository repositorio;

	@Autowired
	private BoletoService boletoService;

	@Autowired
	private PagamentoRepository pagamentoRepository;

	@Autowired
	private AluguelRepository reservaRepository;

	@Autowired
	private VeiculoService veiculoService;

	public Transacao find(Integer id) {

		Optional<Transacao> obj = repositorio.findById(id);
		return obj.orElse(null);

	}

	public Transacao insert(Transacao transacao) {
		transacao.setId(null);
		transacao.setDataCompra(new Date());
		transacao.getPagamento().setStatus(StatusPagamento.PENDENTE);
		transacao.getPagamento().setTransacao(transacao);

		if (transacao.getPagamento() instanceof PagamentoComBoleto) {
			PagamentoComBoleto pagto = (PagamentoComBoleto) transacao.getPagamento();
			boletoService.preencherPagamentoComBoleto(pagto, transacao.getDataCompra());
		}
		transacao = repositorio.save(transacao);

		pagamentoRepository.save(transacao.getPagamento());

		for (Aluguel reserva : transacao.getReservas()) {
			reserva.setPreco(veiculoService.find(reserva.getVeiculo().getId()).getValorDiaria());
			reserva.setTransacao(transacao);
		}
		reservaRepository.saveAll(transacao.getReservas());
		return transacao;
		
	}

}
