package com.bonejah.cielo.ecommerce.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bonejah.cielo.ecommerce.utils.CieloEcommerceProperties;

@RestController
@RequestMapping("/cielo-ecommerce/")
public class PropertiesController {
	private static final Logger logger = LoggerFactory.getLogger(PropertiesController.class);

	@Autowired
	private CieloEcommerceProperties cielo;

	public void setCieloProperties(CieloEcommerceProperties cielo) {
		this.cielo = cielo;
	}

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "welcome", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String welcome(Map<String, Object> model) {
		String cieloProperties = "MerchantId: " + cielo.getMerchantId() + ", MerchantKey: " + cielo.getMerchantKey();
		logger.debug("Welcome {}", cielo);
		model.put("message", cieloProperties);
		//return "welcome";
		return cieloProperties;
	}
}
