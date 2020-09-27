package com.jersey.optimized.client;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.client.Invocation;

public class PropertyAgentEndpointService extends EndpointService {

	String ENDPOINT_URI = "{city}/getProps/{property-type}/{area}";

	public String getProperties() {

		Map<String, String> pathParam = null;
		Map<String, String> matrixParam = null;

		pathParam = new HashMap<>();
		pathParam.put("property-type", "1BHK");
		pathParam.put("area", "Kukatpally");
		pathParam.put("city", "HYD");

		matrixParam = new HashMap<>();
		matrixParam.put("sq-yards", "4000");
		matrixParam.put("ptype", "Apartment");

		Invocation.Builder builder = resource(pathParam, null, matrixParam, ENDPOINT_URI);
		String response = builder.get().readEntity(String.class);
		
		return response;
	}
}
