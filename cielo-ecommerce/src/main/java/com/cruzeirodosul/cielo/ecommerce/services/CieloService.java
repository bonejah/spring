package com.cruzeirodosul.cielo.ecommerce.services;

import java.io.IOException;

import com.cruzeirodosul.cielo.ecommerce.request.CieloRequestException;
import com.cruzeirodosul.cielo.ecommerce.sdk.CardToken;
import com.cruzeirodosul.cielo.ecommerce.sdk.QueryMerchantOrderResponse;
import com.cruzeirodosul.cielo.ecommerce.sdk.RecurrentSale;
import com.cruzeirodosul.cielo.ecommerce.sdk.Sale;
import com.cruzeirodosul.cielo.ecommerce.sdk.SaleResponse;

/**
 * This Interface contains all methods API Cielo 3.0
 * 
 * @since 06/09/2017
 * @author bplima
 * 
 */
public interface CieloService {
	public Sale createSaleCreditCard(Sale sale) throws IOException, CieloRequestException;
	public Sale createSaleDebitCard(Sale sale) throws IOException, CieloRequestException;
	public Sale querySale(String paymentId) throws IOException, CieloRequestException;
	public QueryMerchantOrderResponse queryMerchantOrder(String merchantOrderId) throws IOException, CieloRequestException;
	
	public CardToken createCardToken(CardToken cardToken) throws IOException, CieloRequestException;
	public RecurrentSale queryRecurrentSale(String recurrentPaymentId) throws IOException, CieloRequestException;
	public RecurrentSale deactivateRecurrentSale(String recurrentPaymentId) throws IOException, CieloRequestException;
	public SaleResponse cancelSale(String paymentId, Integer amount) throws IOException, CieloRequestException;
	public SaleResponse cancelSale(String paymentId) throws IOException, CieloRequestException;
	public SaleResponse captureSale(String paymentId, Integer amount, Integer serviceTaxAmount) throws IOException, CieloRequestException;
	public SaleResponse captureSale(String paymentId, Integer amount) throws IOException, CieloRequestException;
	public SaleResponse captureSale(String paymentId) throws IOException, CieloRequestException;
}