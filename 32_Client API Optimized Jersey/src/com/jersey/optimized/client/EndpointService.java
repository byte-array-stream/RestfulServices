package com.jersey.optimized.client;

import java.util.Map;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;

public abstract class EndpointService {

	private final String BASE_URI = "http://localhost:8081/15_Matrix_Parameter/api/agent/";

	public Invocation.Builder resource(Map<String, String> pathParam, Map<String, String> queryParam,
			Map<String, String> matrixParam, String endPointUri) {

		WebTarget target = ClientBuilder.newBuilder().build().target(BASE_URI + endPointUri);

		if (pathParam != null && pathParam.size() > 0) {
			for (String key : pathParam.keySet()) {
				target = target.resolveTemplate(key, pathParam.get(key));
			}
		}

		if (matrixParam != null && matrixParam.size() > 0) {
			for (String key : matrixParam.keySet()) {
				target = target.matrixParam(key, matrixParam.get(key));
			}
		}

		if (queryParam != null && queryParam.size() > 0) {
			for (String key : queryParam.keySet()) {
				target = target.queryParam(key, queryParam.get(key));
			}
		}
		
		System.out.println(target.getUri().toString());
		Invocation.Builder invocationBuilder = target.request();
		return invocationBuilder;
	}
}
