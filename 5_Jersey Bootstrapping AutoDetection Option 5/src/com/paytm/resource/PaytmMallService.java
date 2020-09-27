package com.paytm.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/*Printing hashcode to observe the behaviour of Rest Client. Since default scope if Request Scope, so for every request one
object will gets created, which will gets printed on server console. run the program and observe. Behaviour will not be singleton. */

@Path("/paytmmall")
public class PaytmMallService {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getProductPrice(@QueryParam("product-id") String productId) {
		
		System.out.println("Paytm mall hashcode ::"+this.hashCode());
		return "Price of the product "+productId+" is :: 938798.87";
	}
}
