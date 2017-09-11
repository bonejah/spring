package com.cruzeirodosul.cielo.ecommerce.services;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cruzeirodosul.cielo.ecommerce.request.CieloRequestException;
import com.cruzeirodosul.cielo.ecommerce.sdk.CardToken;
import com.cruzeirodosul.cielo.ecommerce.sdk.CieloEcommerce;
import com.cruzeirodosul.cielo.ecommerce.sdk.CreditCard;
import com.cruzeirodosul.cielo.ecommerce.sdk.Customer;
import com.cruzeirodosul.cielo.ecommerce.sdk.DebitCard;
import com.cruzeirodosul.cielo.ecommerce.sdk.Merchant;
import com.cruzeirodosul.cielo.ecommerce.sdk.Payment;
import com.cruzeirodosul.cielo.ecommerce.sdk.Payment.Type;
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
		readObjectsAutowired();	
		sale = createObjectSale(Type.CreditCard);
		return this.cieloEcommerce.createSale(sale);
	}
	
	@Override
	public Sale createSaleDebitCard(Sale sale) throws IOException, CieloRequestException {
		readObjectsAutowired();	
		sale = createObjectSale(Type.DebitCard);
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
	
	private void readObjectsAutowired() {
		System.out.println("CieloProperties - merchantId: " + this.cieloProperties.getMerchantId() + ", merchantKey: "
				+ this.cieloProperties.getMerchantKey());
		System.out.println("Merchant: " + this.merchant);
		System.out.println("CieloEcommerce: " + this.cieloEcommerce);
	}

	private Sale createObjectSale(Type typeSale) {
		Sale sale = null;
		String merchantOrderId = "2014111717";
		Customer customer = new Customer("Bruno Lima");
		Payment payment = null; 
		
		if (typeSale.equals(Type.CreditCard)) {
			payment = new Payment(7000, 1);
			payment.setType(Type.CreditCard);
			payment.setSoftDescriptor("123456789ABCD");
			payment.setCreditCard(new CreditCard("123", "Visa"));
			payment.getCreditCard().setCardNumber("1234123412341231");
			payment.getCreditCard().setHolder("Teste Holder");
			payment.getCreditCard().setExpirationDate("12/2030");
		} else if (typeSale.equals(Type.DebitCard)) {
			payment = new Payment(15700);
			payment.setType(Type.DebitCard);
			payment.setReturnUrl("http://www.cielo.com,br");
			payment.setDebitCard(new DebitCard("123", "Visa"));
			payment.getDebitCard().setCardNumber("4551870000000183");
			payment.getDebitCard().setHolder("Teste Bruno Lima");
			payment.getDebitCard().setExpirationDate("12/2030");
		}
		
		sale = new Sale(merchantOrderId);
		sale.setCustomer(customer);
		sale.setPayment(payment);
		return sale;
	}	
}