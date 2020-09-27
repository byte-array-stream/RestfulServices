package com.jaxrs.client.test;

import com.jaxrs.client.resource.MerchantClient;

public class ClientApiTest {
	
	public static void main(String[] args) {
		MerchantClient client = new MerchantClient();
		String response = client.fundTransfer("ACC7938","ACC72987",64872.32f);
		System.out.println(response);
	}
}
