package com.bonejah.cielo.ecommerce.services;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bonejah.cielo.ecommerce.sdk.Merchant;
import com.bonejah.cielo.ecommerce.sdk.ecommerce.CieloEcommerce;
import com.bonejah.cielo.ecommerce.sdk.ecommerce.CreditCard;
import com.bonejah.cielo.ecommerce.sdk.ecommerce.Customer;
import com.bonejah.cielo.ecommerce.sdk.ecommerce.Payment;
import com.bonejah.cielo.ecommerce.sdk.ecommerce.Payment.Type;
import com.bonejah.cielo.ecommerce.sdk.ecommerce.Sale;
import com.bonejah.cielo.ecommerce.sdk.ecommerce.request.CieloRequestException;
import com.bonejah.cielo.ecommerce.utils.CieloEcommerceProperties;

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
	public Sale createSale() throws IOException, CieloRequestException {
		System.out.println("CieloProperties - merchantId: " + this.cieloProperties.getMerchantId() + ", merchantKey: "
				+ this.cieloProperties.getMerchantKey());
		System.out.println("Merchant: " + this.merchant);
		System.out.println("CieloEcommerce: " + this.cieloEcommerce);	
		
		// Criando o objeto Sale
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
		
		return this.cieloEcommerce.createSale(sale);
	}
}