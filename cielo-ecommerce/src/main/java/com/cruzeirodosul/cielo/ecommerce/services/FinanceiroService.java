package com.cruzeirodosul.cielo.ecommerce.services;

import java.io.IOException;

import com.cruzeirodosul.cielo.ecommerce.model.Transacao;


public interface FinanceiroService {
	Transacao consultaTransacao(String idTrn) throws IOException;
}
