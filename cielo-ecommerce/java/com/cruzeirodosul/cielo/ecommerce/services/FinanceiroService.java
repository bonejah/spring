package com.cruzeirodosul.cielo.ecommerce.services;

import java.io.IOException;

import com.cruzeirodosul.cielo.ecommerce.dto.TransacaoDTO;

public interface FinanceiroService {
	TransacaoDTO validaTransacaoCieloEcommerce(String idTrn) throws IOException;
}
