package com.beanparam.resource;

import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/search")
public class SearchProperty {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/{loc}/{city}")
	public String searchProperty(@BeanParam Property property) {
		
		return property.toString();
	}
}
