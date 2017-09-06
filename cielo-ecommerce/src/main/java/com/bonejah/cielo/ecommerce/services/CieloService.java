package com.bonejah.cielo.ecommerce.services;

import java.io.IOException;

import com.bonejah.cielo.ecommerce.sdk.ecommerce.CardToken;
import com.bonejah.cielo.ecommerce.sdk.ecommerce.QueryMerchantOrderResponse;
import com.bonejah.cielo.ecommerce.sdk.ecommerce.RecurrentSale;
import com.bonejah.cielo.ecommerce.sdk.ecommerce.Sale;
import com.bonejah.cielo.ecommerce.sdk.ecommerce.SaleResponse;
import com.bonejah.cielo.ecommerce.sdk.ecommerce.request.CieloRequestException;

/**
 * This Interface contains all methods API Cielo 3.0
 * 
 * @since 06/09/2017
 * @author bplima
 * 
 */
public interface CieloService {
	public String teste();
	
	public Sale createSale(Sale sale) throws IOException, CieloRequestException;
	public Sale querySale(String paymentId) throws IOException, CieloRequestException;
	
	public CardToken createCardToken(CardToken cardToken) throws IOException, CieloRequestException;
	public QueryMerchantOrderResponse queryMerchantOrder(String merchantOrderId) throws IOException, CieloRequestException;
	
	public RecurrentSale queryRecurrentSale(String recurrentPaymentId) throws IOException, CieloRequestException;
	public RecurrentSale deactivateRecurrentSale(String recurrentPaymentId) throws IOException, CieloRequestException;
	
	public SaleResponse cancelSale(String paymentId, Integer amount) throws IOException, CieloRequestException;
	public SaleResponse cancelSale(String paymentId) throws IOException, CieloRequestException;
	
	public SaleResponse captureSale(String paymentId, Integer amount, Integer serviceTaxAmount) throws IOException, CieloRequestException;
	public SaleResponse captureSale(String paymentId, Integer amount) throws IOException, CieloRequestException;
	public SaleResponse captureSale(String paymentId) throws IOException, CieloRequestException;
}