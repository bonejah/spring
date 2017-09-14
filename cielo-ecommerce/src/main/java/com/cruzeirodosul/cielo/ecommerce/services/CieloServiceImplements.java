package com.cruzeirodosul.cielo.ecommerce.services;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cruzeirodosul.cielo.ecommerce.request.CieloRequestException;
import com.cruzeirodosul.cielo.ecommerce.sdk.CardToken;
import com.cruzeirodosul.cielo.ecommerce.sdk.CieloEcommerce;
import com.cruzeirodosul.cielo.ecommerce.sdk.Merchant;
import com.cruzeirodosul.cielo.ecommerce.sdk.QueryMerchantOrderResponse;
import com.cruzeirodosul.cielo.ecommerce.sdk.RecurrentSale;
import com.cruzeirodosul.cielo.ecommerce.sdk.Sale;
import com.cruzeirodosul.cielo.ecommerce.sdk.SaleResponse;
import com.cruzeirodosul.cielo.ecommerce.utils.CieloEcommerceProperties;

/**
 * This class contains implemantation of all methods API Cielo 3.0
 * 
 * @since 06/09/2017
 * @author bplima
 *
 */
@Service
public class CieloServiceImplements implements CieloService {

	@Autowired
	private CieloEcommerceProperties cieloProperties;

	@Autowired
	private Merchant merchant;
	
	@Autowired
	private CieloEcommerce cieloEcommerce;

	@Override
	public Sale createSaleCreditCard(Sale sale) throws IOException, CieloRequestException {
		setPropertiesEcommerce();	
		return this.cieloEcommerce.createSale(sale);
	}
	
	@Override
	public Sale createSaleDebitCard(Sale sale) throws IOException, CieloRequestException {
		setPropertiesEcommerce();	
		return this.cieloEcommerce.createSale(sale);
	}
	
	@Override
	public Sale querySale(String paymentId) throws IOException, CieloRequestException {
		Sale saleReturn = this.cieloEcommerce.querySale(paymentId);
		return saleReturn;
	}

	@Override
	public CardToken createCardToken(CardToken cardToken) throws IOException, CieloRequestException {
		CardToken cardTokenReturn = this.cieloEcommerce.createCardToken(cardToken);
		return cardTokenReturn;
	}

	@Override
	public QueryMerchantOrderResponse queryMerchantOrder(String merchantOrderId)
			throws IOException, CieloRequestException {
		QueryMerchantOrderResponse queryReturn = this.cieloEcommerce.queryMerchantOrder(merchantOrderId);
		return queryReturn;
	}

	@Override
	public RecurrentSale queryRecurrentSale(String recurrentPaymentId) throws IOException, CieloRequestException {
		RecurrentSale recurrentSale = this.cieloEcommerce.queryRecurrentSale(recurrentPaymentId);
		return recurrentSale;
	}

	@Override
	public RecurrentSale deactivateRecurrentSale(String recurrentPaymentId) throws IOException, CieloRequestException {
		this.cieloEcommerce.deactivateRecurrentSale(recurrentPaymentId);
		return null;
	}

	@Override
	public SaleResponse cancelSale(String paymentId, Integer amount) throws IOException, CieloRequestException {
		SaleResponse saleResponse = this.cieloEcommerce.cancelSale(paymentId, amount);
		return saleResponse;
	}

	@Override
	public SaleResponse cancelSale(String paymentId) throws IOException, CieloRequestException {
		SaleResponse saleResponse = this.cieloEcommerce.cancelSale(paymentId);
		return saleResponse;
	}

	@Override
	public SaleResponse captureSale(String paymentId, Integer amount, Integer serviceTaxAmount)
			throws IOException, CieloRequestException {
		SaleResponse saleResponse = this.cieloEcommerce.captureSale(paymentId, amount, serviceTaxAmount);
		return saleResponse;
	}

	@Override
	public SaleResponse captureSale(String paymentId, Integer amount) throws IOException, CieloRequestException {
		SaleResponse saleResponse = this.cieloEcommerce.captureSale(paymentId, amount);
		return saleResponse;
	}

	@Override
	public SaleResponse captureSale(String paymentId) throws IOException, CieloRequestException {
		SaleResponse saleResponse = this.cieloEcommerce.captureSale(paymentId);
		return saleResponse;
	}
	
	private void setPropertiesEcommerce() {
		System.out.println("CieloProperties - merchantId: " + this.cieloProperties.getMerchantId() + ", merchantKey: "
				+ this.cieloProperties.getMerchantKey());
		System.out.println("Merchant: " + this.merchant);
		System.out.println("CieloEcommerce: " + this.cieloEcommerce);
	}	
}