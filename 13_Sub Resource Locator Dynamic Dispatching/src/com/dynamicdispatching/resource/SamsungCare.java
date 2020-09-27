package com.dynamicdispatching.resource;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/care")
public class SamsungCare {

	@Path("/{care-type}")
	public Object care(@PathParam("care-type") String type) {
		if (type.equals("home")) {
			return new HomeAppliancesCare();
		}
		return new MobileCare();
	}
}
