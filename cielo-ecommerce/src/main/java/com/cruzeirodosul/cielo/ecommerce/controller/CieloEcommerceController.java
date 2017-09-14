package com.cruzeirodosul.cielo.ecommerce.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cruzeirodosul.cielo.ecommerce.request.CieloError;
import com.cruzeirodosul.cielo.ecommerce.request.CieloRequestException;
import com.cruzeirodosul.cielo.ecommerce.sdk.QueryMerchantOrderResponse;
import com.cruzeirodosul.cielo.ecommerce.sdk.Sale;
import com.cruzeirodosul.cielo.ecommerce.services.CieloService;

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
		,produces = MediaType.APPLICATION_JSON_VALUE)
	public Sale createSaleCreditCard(@RequestBody Sale sale) throws IOException, CieloRequestException {
		try {
			System.out.println(sale);
			
//			Sale saleReturn = cieloService.createSaleCreditCard(sale);
//			System.out.println(saleReturn);
//			return saleReturn;
			return sale;
		} finally {
			
		}
//		} catch (IOException ioException) {
//			throw new IOException(ioException.getMessage());
//		} catch (CieloRequestException cException) {
//			throw new CieloRequestException(cException.getMessage(), new CieloError(0, ""), new Throwable());
//		}
	}
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "createSaleDebitCard", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Sale createSaleDebitCard() throws IOException, CieloRequestException {
		try {
			Sale saleReturn = cieloService.createSaleDebitCard(new Sale(null));
			System.out.println(saleReturn);
			return saleReturn;
		} catch (IOException ioException) {
			throw new IOException(ioException.getMessage());
		} catch (CieloRequestException cException) {
			throw new CieloRequestException(cException.getMessage(), new CieloError(0, ""), new Throwable());
		}
	}
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "querySale", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Sale querySale() throws IOException, CieloRequestException {
		try {
			//String paymentId = "425bd932-49b8-4633-9822-e02e42f27d61";
			String paymentId = "ac85bbb8-a34d-4627-a028-cb00a68ab261";
			Sale saleReturn = cieloService.querySale(paymentId);
			System.out.println(saleReturn);
			return saleReturn;
		} catch (IOException ioException) {
			throw new IOException(ioException.getMessage());
		} catch (CieloRequestException cException) {
			throw new CieloRequestException(cException.getMessage(), new CieloError(0, ""), new Throwable());
		}
	}
	
	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "queryMerchantOrderId", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public QueryMerchantOrderResponse queryMerchantOrderId() throws IOException, CieloRequestException {
		try {
			String merchantOrderId = "2014111717";
			QueryMerchantOrderResponse merchantOrderResponse = cieloService.queryMerchantOrder(merchantOrderId );
			return merchantOrderResponse;
		} catch (IOException ioException) {
			throw new IOException(ioException.getMessage());
		} catch (CieloRequestException cException) {
			throw new CieloRequestException(cException.getMessage(), new CieloError(0, ""), new Throwable());
		}
	}
	
}
