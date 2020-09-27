package com.jaxrs.client.resource;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class MerchantClient {

	public String fundTransfer(String toAccount, String fromAccount, float amount) {

		String BASE_URI = "http://localhost:8081/6_Jersey_Bootstrapping_AutoDetection_Option_6/api/";

		Client client = null;
		ClientBuilder clientBuilder = null;
		WebTarget webTarget = null;
		Response response = null;
		String msg = null;

		clientBuilder = ClientBuilder.newBuilder();
		// Open one connection using Client Object but we do not want Client to be
		// created an empty object that is Builder Design pattern.
		client = clientBuilder.build();
		webTarget = client.target(BASE_URI);
		webTarget =	webTarget.path("paytm");
		webTarget = webTarget.queryParam("to-acc", toAccount).queryParam("from-acc", fromAccount).queryParam("amount", amount);
		response = webTarget.request().accept(MediaType.TEXT_PLAIN).get();
		msg = response.readEntity(String.class);
		return msg;
	}
}
