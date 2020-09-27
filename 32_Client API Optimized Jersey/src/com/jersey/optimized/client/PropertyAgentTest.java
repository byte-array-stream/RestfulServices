package com.jersey.optimized.client;

public class PropertyAgentTest {

	public static void main(String[] args) {

		PropertyAgentEndpointService service = new PropertyAgentEndpointService();
		String response = service.getProperties();
		System.out.println(response);
	}

}
