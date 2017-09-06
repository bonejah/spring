package com.bonejah.cielo.ecommerce.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bonejah.cielo.ecommerce.sdk.ecommerce.Sale;
import com.bonejah.cielo.ecommerce.sdk.ecommerce.request.CieloError;
import com.bonejah.cielo.ecommerce.sdk.ecommerce.request.CieloRequestException;
import com.bonejah.cielo.ecommerce.services.CieloService;

@RestController
@RequestMapping("/cielo-ecommerce/")
public class CieloController {
	@Autowired
	private CieloService cieloService;

	@Autowired
	private Sale sale;

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "teste", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String teste() {
		return cieloService.teste();
	}

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "createSale", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Sale createSale() throws IOException, CieloRequestException {
		try {
			return cieloService.createSale(sale);
		} catch (IOException ioException) {
			throw new IOException(ioException.getMessage());
		} catch (CieloRequestException cException) {
			throw new CieloRequestException(cException.getMessage(), new CieloError(0, ""), new Throwable());
		}
	}
}
