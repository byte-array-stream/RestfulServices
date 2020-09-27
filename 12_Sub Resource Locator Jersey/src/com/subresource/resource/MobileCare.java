package com.subresource.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

public class MobileCare {
	@GET
	@Path("/status/{jobNo}")
	@Produces(MediaType.TEXT_PLAIN)
	public String mobileRepairJobStatus(@PathParam("jobNo") String jobNo) {
		return "Mobile set with Job No :: " + jobNo + " has been proccessed with HashCode :: "+this.hashCode();
	}
}
