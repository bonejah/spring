package com.cruzeirodosul.cielo.ecommerce.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cruzeirodosul.cielo.ecommerce.request.CieloError;
import com.cruzeirodosul.cielo.ecommerce.request.CieloRequestException;
import com.cruzeirodosul.cielo.ecommerce.sdk.QueryMerchantOrderResponse;
import com.cruzeirodosul.cielo.ecommerce.sdk.Sale;
import com.cruzeirodosul.cielo.ecommerce.services.CieloService;

/**
 * This class represents the controller for all requisitions with Cielo Ecommerce
 * 
 * @since 06/09/2017
 * @author bplima
 * 
 */
@RestController
@RequestMapping("/cielo-ecommerce/")
public class CieloEcommerceController {
	
	@Autowired
	private CieloService cieloService;

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "methodsApiCielo", method = RequestMethod.GET)
	public ModelAndView methodsApiCielo() {
		ModelAndView modelAndView =  new ModelAndView("methodsApiCielo");
		return modelAndView;
	}

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "createSaleCreditCard", method = RequestMethod.POST
		,consumes = MediaType.APPLICATION_JSON_VALUE
		,produces = MediaType.APPLICATION_JSON_VALUE)
	public Sale createSaleCreditCard(@RequestBody Sale sale) throws IOException, CieloRequestException {
		try {
			Sale saleReturn = cieloService.createSaleCreditCard(sale);
			return saleReturn;
		} catch (IOException ioException) {
			throw new IOException(ioException.getMessage());
		} catch (CieloRequestException cException) {
			throw new CieloRequestException(cException.getMessage(), new CieloError(0, ""), new Throwable());
		}
	}
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "createSaleDebitCard", method = RequestMethod.POST
		,consumes = MediaType.APPLICATION_JSON_VALUE
		,produces = MediaType.APPLICATION_JSON_VALUE)
	public Sale createSaleDebitCard(@RequestBody Sale sale) throws IOException, CieloRequestException {
		try {
			Sale saleReturn = cieloService.createSaleDebitCard(sale);
			return saleReturn;
		} catch (IOException ioException) {
			throw new IOException(ioException.getMessage());
		} catch (CieloRequestException cException) {
			throw new CieloRequestException(cException.getMessage(), new CieloError(0, ""), new Throwable());
		}
	}
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "querySale/{paymentId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Sale querySale(@PathVariable String paymentId) throws IOException, CieloRequestException {
		try {
			Sale saleReturn = cieloService.querySale(paymentId);
			return saleReturn;
		} catch (IOException ioException) {
			throw new IOException(ioException.getMessage());
		} catch (CieloRequestException cException) {
			throw new CieloRequestException(cException.getMessage(), new CieloError(0, ""), new Throwable());
		}
	}
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "queryMerchantOrderId/{merchantOrderId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public QueryMerchantOrderResponse queryMerchantOrderId(@PathVariable String merchantOrderId) throws IOException, CieloRequestException {
		try {
			QueryMerchantOrderResponse merchantOrderResponse = cieloService.queryMerchantOrder(merchantOrderId);
			return merchantOrderResponse;
		} catch (IOException ioException) {
			throw new IOException(ioException.getMessage());
		} catch (CieloRequestException cException) {
			throw new CieloRequestException(cException.getMessage(), new CieloError(0, ""), new Throwable());
		}
	}
}
