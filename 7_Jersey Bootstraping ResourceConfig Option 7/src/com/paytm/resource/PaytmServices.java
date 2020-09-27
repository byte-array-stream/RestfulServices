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
	** This bootstrap option is specific to Jersey Impl. because ResourceConfig class is provided by the Jersey Impl.
	
	This is the seventh way of bootstraping, In this we are simply declaring fully qualified name of the Dispatcher servlet 
	(ServletContainer) provided by Jersey Impl. To this servlet we have passed. 
	
	 Major beauty of this option is, this is the quickest way to bootstrap the Jersey Impl and when we want to control 
	 the scope of object creation we should go for this bootstraping option.
	 And pass this class Object or class to register() method of the ResourceConfig class. 
	 We are imply overriding the methid accroding to our need, whichever class we want to be singleton put it inside register(Object)
	 methods and whichever class we want to be REQUEST SCOPE, put it inside register(class) method.
*/