package com.bonejah.cielo.ecommerce.services;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bonejah.cielo.ecommerce.sdk.Merchant;
import com.bonejah.cielo.ecommerce.sdk.ecommerce.CieloEcommerce;
import com.bonejah.cielo.ecommerce.sdk.ecommerce.Environment;
import com.bonejah.cielo.ecommerce.sdk.ecommerce.Sale;
import com.bonejah.cielo.ecommerce.sdk.ecommerce.request.CieloRequestException;
import com.bonejah.cielo.ecommerce.utils.CieloEcommerceProperties;

@Service
public class CieloServiceImplements implements CieloService {
	
	
	private CieloEcommerce cieloEcommerce;
	
	@Autowired
	private CieloEcommerceProperties cieloProperties;
	
	public void setCieloProperties(CieloEcommerceProperties cielo) {
		this.cieloProperties = cielo;
	}
	
	private Merchant merchant;
	
	public CieloServiceImplements() {
		this.merchant = new Merchant(cieloProperties.getMerchantId(), cieloProperties.getMerchantKey());
		this.cieloEcommerce = new CieloEcommerce(merchant, Environment.SANDBOX);
	}
	
	@Override
	public String teste() {
		return "Teste API Cielo 3.0";
	}

	@Override
	public Sale createSale(Sale sale) throws IOException, CieloRequestException {
		Sale saleResult = this.cieloEcommerce.createSale(sale);
		return saleResult;
	}
}
