package com.paytm.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/paytm")
public class PaytmServices {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String payMoney(@QueryParam("to-acc") String toAcc, @QueryParam("from-acc") String fromAcc, @QueryParam("amount") float amount) {
		
		/*Printing hashcode to observe the behaviour of Rest Client. Since default scope if Request Scope, so for every request one
		object will gets created, which will gets printed on server console. run the program and observe.*/
		System.out.println(this.hashCode());
		return "Amount of " +amount+ " has been tranfered from account "+ fromAcc + " to account" +toAcc;
	}
}

