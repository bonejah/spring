package com.cruzeirodosul.cielo.ecommerce.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cruzeirodosul.cielo.ecommerce.dto.TransacaoDTO;
import com.cruzeirodosul.cielo.ecommerce.services.FinanceiroService;

@RestController
@RequestMapping("/financeiro/")
public class FinanceiroController {
	
	@Autowired
	FinanceiroService financeiroService;
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "validaTransacaoCieloEcommerce/{idTrn}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public TransacaoDTO validaTransacaoCieloEcommerce(@PathVariable String idTrn) throws IOException {
		try {
			TransacaoDTO transacaoDto = financeiroService.validaTransacaoCieloEcommerce(idTrn);
			return transacaoDto;
		} catch (IOException ioException) {
			throw new IOException(ioException.getMessage());
		} 
	}

}
