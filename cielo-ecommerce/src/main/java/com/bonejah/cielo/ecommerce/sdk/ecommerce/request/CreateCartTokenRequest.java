package com.bonejah.cielo.ecommerce.sdk.ecommerce.request;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;

import com.bonejah.cielo.ecommerce.sdk.Environment;
import com.bonejah.cielo.ecommerce.sdk.Merchant;
import com.bonejah.cielo.ecommerce.sdk.ecommerce.CardToken;
import com.google.gson.GsonBuilder;



public class CreateCartTokenRequest extends AbstractSaleRequest<CardToken, CardToken> {
	public CreateCartTokenRequest(Merchant merchant, Environment environment) {
		super(merchant, environment);
	}

	@Override
	public CardToken execute(CardToken param) throws IOException, CieloRequestException {
		String url = environment.getApiUrl() + "1/card/";
		HttpPost request = new HttpPost(url);
		request.setEntity(new StringEntity(new GsonBuilder().create().toJson(param)));
		HttpResponse response = sendRequest(request);
		return readResponse(response, CardToken.class);
	}
}