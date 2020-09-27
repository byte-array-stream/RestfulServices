package com.autoconversion.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/product-details")
public class ProductDetails {

	@GET
	@Produces(MediaType.APPLICATION_XML)
	@Path("/details/{product-id}")
	public String productDetails(@PathParam("product-id") ProductID productID) {
		return "<product>"
				+ "<product-id>"
				+ "<product-no>"+productID.getProductNo()+"</product-no>"
				+ "<product-code>"+productID.getProductCode()+"</product-code>"
				+ "</product-id>"
				+ "</product>";
	}
}
