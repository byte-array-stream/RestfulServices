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

/**
	This is the sixth way of bootstraping, In this we are simply declaring fully qualified name of the Dispatcher servlet 
	(ServletContainer) provided by Jersey Impl. To this servlet we have passed. 
	
	 Major beauty of this option is, this is the quickest way to bootstrap the Jersey Impl and when we want to control 
	 the scope of object creation we should go for this bootstraping option.
	 Pass the Application itself as servlet name. So that JAX-RS Runtime can autodetect the Application class, since it is API provided
	 class it is independent from Vendor specific implementation.
*/