package com.subresource.common;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/samsung")
public class ApplicationConfig extends Application {

	public ApplicationConfig() {
		System.out.println("App config constructor called.");
	}
		
}
