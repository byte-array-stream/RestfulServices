package com.cookieandheader.resource;

import javax.ws.rs.CookieParam;
import javax.ws.rs.DELETE;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/agent")
public class PropertyAgent {
	// For header
	@DELETE
	@Path("/unlilst")
	@Produces(MediaType.TEXT_PLAIN)
	public String unlistProperty(@HeaderParam("property-no") String propertyNo) {
		return "Property with " + propertyNo + " has been unlisted from registrar office.";
	}

	// For Cookie
	@PUT
	@Path("/update/{prop-no}")
	@Produces(MediaType.TEXT_PLAIN)
	public String updateProperty(@CookieParam("agent-no") String agentNo, @PathParam("prop-no") String propertyNo) {
		return "Agent ::" + agentNo + " has been updated with property :: " + propertyNo;
	}
}
