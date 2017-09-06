package com.bonejah.cielo.ecommerce.services;

import java.io.IOException;

import com.bonejah.cielo.ecommerce.sdk.ecommerce.Sale;
import com.bonejah.cielo.ecommerce.sdk.ecommerce.request.CieloRequestException;

public interface CieloService {
	public String teste();
	public Sale createSale() throws IOException, CieloRequestException;
}
