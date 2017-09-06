package com.bonejah.cielo.ecommerce.sdk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bonejah.cielo.ecommerce.utils.CieloEcommerceProperties;

/**
 * Merchant identification on Cielo
 */
@Component
public class Merchant {
	/**
	 * {@link Merchant#getId()}
	 */
	private final String id;

	/**
	 * {@link Merchant#getKey()}
	 */
	private final String key;

	@Autowired
	public Merchant(CieloEcommerceProperties properties) {
		this.id = properties.getMerchantId();
		this.key = properties.getMerchantKey();
	}
	
	public Merchant(String id, String key) {
		this.id = id;
		this.key = key;
	}

	/**
	 * Gets the merchant identification number
	 *
	 * @return the merchant identification number on Cielo
	 */
	public String getId() {
		return id;
	}

	/**
	 * Gets the merchant identification key
	 *
	 * @return the merchant identification key on Cielo
	 */
	public String getKey() {
		return key;
	}
}
