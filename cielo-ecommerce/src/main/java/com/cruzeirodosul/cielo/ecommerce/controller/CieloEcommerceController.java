package com.cruzeirodosul.cielo.ecommerce.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cruzeirodosul.cielo.ecommerce.sdk.Sale;
import com.cruzeirodosul.cielo.ecommerce.services.CieloService;
import com.cruzeirodosul.cielo.sdk.ecommerce.request.CieloError;
import com.cruzeirodosul.cielo.sdk.ecommerce.request.CieloRequestException;

@RestController
@RequestMapping("/cielo-ecommerce/")
public class CieloEcommerceController {
	
	@Autowired
	private CieloService cieloService;

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "testeApiCielo", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String teste() {
		return cieloService.testeApiCielo();
	}
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "methodsApiCielo", method = RequestMethod.GET)
	public ModelAndView methodsApiCielo() {
		ModelAndView modelAndView =  new ModelAndView("methodsApiCielo");
		return modelAndView;
	}

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "createSale", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Sale createSale() throws IOException, CieloRequestException {
		try {
			Sale saleReturn = cieloService.createSale(new Sale(null));
			System.out.println(saleReturn);
			return saleReturn;
		} catch (IOException ioException) {
			throw new IOException(ioException.getMessage());
		} catch (CieloRequestException cException) {
			throw new CieloRequestException(cException.getMessage(), new CieloError(0, ""), new Throwable());
		}
	}
	
	
}
