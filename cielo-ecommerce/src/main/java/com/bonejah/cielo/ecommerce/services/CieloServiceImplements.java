package com.bonejah.cielo.ecommerce.services;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bonejah.cielo.ecommerce.sdk.Merchant;
import com.bonejah.cielo.ecommerce.sdk.ecommerce.CardToken;
import com.bonejah.cielo.ecommerce.sdk.ecommerce.CieloEcommerce;
import com.bonejah.cielo.ecommerce.sdk.ecommerce.CreditCard;
import com.bonejah.cielo.ecommerce.sdk.ecommerce.Customer;
import com.bonejah.cielo.ecommerce.sdk.ecommerce.Payment;
import com.bonejah.cielo.ecommerce.sdk.ecommerce.Payment.Type;
import com.bonejah.cielo.ecommerce.sdk.ecommerce.QueryMerchantOrderResponse;
import com.bonejah.cielo.ecommerce.sdk.ecommerce.RecurrentSale;
import com.bonejah.cielo.ecommerce.sdk.ecommerce.Sale;
import com.bonejah.cielo.ecommerce.sdk.ecommerce.SaleResponse;
import com.bonejah.cielo.ecommerce.sdk.ecommerce.request.CieloRequestException;
import com.bonejah.cielo.ecommerce.utils.CieloEcommerceProperties;

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
	public String teste() {
		return "Teste API Cielo 3.0";
	}

	@Override
	public Sale createSale(Sale sale) throws IOException, CieloRequestException {
		readObjectsAutowired();	
		sale = createObjectSale();
		return this.cieloEcommerce.createSale(sale);
	}
	
	@Override
	public Sale querySale(String paymentId) throws IOException, CieloRequestException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CardToken createCardToken(CardToken cardToken) throws IOException, CieloRequestException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QueryMerchantOrderResponse queryMerchantOrder(String merchantOrderId)
			throws IOException, CieloRequestException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RecurrentSale queryRecurrentSale(String recurrentPaymentId) throws IOException, CieloRequestException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RecurrentSale deactivateRecurrentSale(String recurrentPaymentId) throws IOException, CieloRequestException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SaleResponse cancelSale(String paymentId, Integer amount) throws IOException, CieloRequestException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SaleResponse cancelSale(String paymentId) throws IOException, CieloRequestException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SaleResponse captureSale(String paymentId, Integer amount, Integer serviceTaxAmount)
			throws IOException, CieloRequestException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SaleResponse captureSale(String paymentId, Integer amount) throws IOException, CieloRequestException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SaleResponse captureSale(String paymentId) throws IOException, CieloRequestException {
		// TODO Auto-generated method stub
		return null;
	}
	
	private void readObjectsAutowired() {
		System.out.println("CieloProperties - merchantId: " + this.cieloProperties.getMerchantId() + ", merchantKey: "
				+ this.cieloProperties.getMerchantKey());
		System.out.println("Merchant: " + this.merchant);
		System.out.println("CieloEcommerce: " + this.cieloEcommerce);
	}

	private Sale createObjectSale() {
		String merchantOrderId = "2014111703";
		Customer customer = new Customer("Bruno Lima");
		Payment payment = new Payment(7000, 1);
		payment.setType(Type.CreditCard);
		payment.setSoftDescriptor("123456789ABCD");
		payment.setCreditCard(new CreditCard("123", "Visa"));
		payment.getCreditCard().setCardNumber("1234123412341231");
		payment.getCreditCard().setHolder("Teste Holder");
		payment.getCreditCard().setExpirationDate("12/2030");
		
		Sale sale = new Sale(merchantOrderId);
		sale.setCustomer(customer);
		sale.setPayment(payment);
		return sale;
	}
}