package com.locadora.api.services;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.locadora.api.domain.PagamentoComBoleto;

@Service
public class BoletoService {
	
	public void preencherPagamentoComBoleto(PagamentoComBoleto pagamento, Date dataCompra) {
		
		Calendar calendario = Calendar.getInstance();
		calendario.setTime(dataCompra);
		calendario.add(Calendar.DAY_OF_MONTH, 7);
		pagamento.setDataVencimento(calendario.getTime());
		
	}

}
