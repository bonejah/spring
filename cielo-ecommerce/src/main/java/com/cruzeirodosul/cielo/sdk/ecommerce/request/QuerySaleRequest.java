package com.cruzeirodosul.cielo.sdk.ecommerce.request;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;

import com.cruzeirodosul.cielo.ecommerce.sdk.Environment;
import com.cruzeirodosul.cielo.ecommerce.sdk.Merchant;
import com.cruzeirodosul.cielo.ecommerce.sdk.Sale;

/**
 * Query a Sale by it's paymentId
 */
public class QuerySaleRequest extends AbstractSaleRequest<String, Sale> {
	public QuerySaleRequest(Merchant merchant, Environment environment) {
		super(merchant, environment);
	}

	@Override
	public Sale execute(String paymentId) throws IOException, CieloRequestException {
		String url = environment.getApiQueryURL() + "1/sales/" + paymentId;
		HttpGet request = new HttpGet(url);
		HttpResponse response = sendRequest(request);
		return readResponse(response, Sale.class);
	}
}
