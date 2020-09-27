package com.formparameter.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/add-property")
public class PropertyRegistrar {
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	// Use this media type whenever your are sending data through forms. Because servlet container always receives the data
	// in this format only.
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String regiterProperty(@FormParam("property-name") String propertyName, 
								  @FormParam("location") String location,
								  @FormParam("city") String city,
								  @FormParam("country") String country,
								  @FormParam("owner") String owner){
		return "Property has been registered with the following details... Property Name ::"+propertyName
				+ "  location :: "+location
				+ "  city :: "+city
				+ "  country :: "+country
				+ "  owner"+owner;
	}
}
