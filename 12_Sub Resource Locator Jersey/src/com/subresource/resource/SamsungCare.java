package com.subresource.resource;

import javax.ws.rs.Path;

@Path("/care")
public class SamsungCare {
	
	@Path("/mobile")
	public MobileCare mobileCare() {
		System.out.println("Mobile care called.");
		return new MobileCare();
	}
	
	@Path("/home-appliances")
	public HomeAppliancesCare homeAppliancesCare() {
		System.out.println("Home Appliances care called.");
		return new HomeAppliancesCare();
	}
}
