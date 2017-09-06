package com.bonejah.cielo.ecommerce.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
@ConfigurationProperties
public class CieloEcommerceProperties {
	
	@Value("${cielo.ecommerce.sandbox.merchantId}")
	private String merchantId;
	
	@Value("${cielo.ecommerce.sandbox.merchantKey}")
	private String merchantKey;

	public String getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	public String getMerchantKey() {
		return merchantKey;
	}

	public void setMerchantKey(String merchantKey) {
		this.merchantKey = merchantKey;
	}
}
