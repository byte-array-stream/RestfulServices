package com.dynamicdispatching.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

public class HomeAppliancesCare {

	@GET
	@Path("/appliances/{jobNo}")
	@Produces(MediaType.TEXT_PLAIN)
	public String applianceStatus(@PathParam("jobNo") String jobNo) {
		return "Appliance with Job No :: " + jobNo + " has been proccessed with HashCode :: "+this.hashCode();
	}
}
