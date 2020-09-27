package com.paytm.config;

import org.glassfish.jersey.server.ResourceConfig;

import com.paytm.resource.PaytmMallService;
import com.paytm.resource.PaytmServices;

/**
 * 
 * @author ravik
 *
 *Either write the annotation @ApplicationPath or specify inside the web.xml
 */
// @ApplicationPath("/*")
public class PaytmConfig extends ResourceConfig {

	public PaytmConfig() {
		
		// pass the object to the super class method, if you want to control the scope to Singletons.
		register(new PaytmMallService());
		
		// pass the object to the super class method, if you want to control the scope to Request Scope.
		register(PaytmServices.class);
	}
}
