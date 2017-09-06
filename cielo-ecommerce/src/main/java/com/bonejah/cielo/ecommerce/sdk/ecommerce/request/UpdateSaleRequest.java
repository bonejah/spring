package com.bonejah.cielo.ecommerce.sdk.ecommerce.request;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.utils.URIBuilder;

import com.bonejah.cielo.ecommerce.sdk.Environment;
import com.bonejah.cielo.ecommerce.sdk.Merchant;
import com.bonejah.cielo.ecommerce.sdk.ecommerce.SaleResponse;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Capture or cancel a Sale
 */
public class UpdateSaleRequest extends AbstractSaleRequest<String, SaleResponse> {
	private final String type;
	private Integer amount;
	private Integer serviceTaxAmount;

	public UpdateSaleRequest(String type, Merchant merchant, Environment environment) {
		super(merchant, environment);
		this.type = type;
	}

	@Override
	public SaleResponse execute(String paymentId) throws IOException, CieloRequestException {
		SaleResponse sale = null;

		try {
			URIBuilder builder = new URIBuilder(environment.getApiUrl() + "1/sales/" + paymentId + "/" + type);

			if (amount != null) {
				builder.addParameter("amount", amount.toString());
			}

			if (serviceTaxAmount != null) {
				builder.addParameter("serviceTaxAmount", serviceTaxAmount.toString());
			}

			HttpPut request;
			request = new HttpPut(builder.build().toString());
			HttpResponse response = sendRequest(request);
			sale = readResponse(response, SaleResponse.class);
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

		return sale;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public void setServiceTaxAmount(Integer serviceTaxAmount) {
		this.serviceTaxAmount = serviceTaxAmount;
	}
}