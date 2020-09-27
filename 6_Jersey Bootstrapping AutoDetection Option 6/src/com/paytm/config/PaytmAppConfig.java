package com.paytm.config;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import com.paytm.resource.PaytmMallService;
import com.paytm.resource.PaytmServices;

public class PaytmAppConfig extends Application {

	private Set<Class<?>> classes;
	private Set<Object> singletons;

	public PaytmAppConfig() {
		classes = new HashSet<>();
		singletons = new HashSet<>();
	}

	@Override
	public Set<Class<?>> getClasses() {
		classes.add(PaytmServices.class);
		return classes;
	}

	@Override
	public Set<Object> getSingletons() {
		singletons.add(new PaytmMallService());
		return singletons;
	}

}
