package com.pathandsubresource.resource;

import java.io.IOException;
import java.io.OutputStream;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.StreamingOutput;

@Path("/product")
public class ProductManager {

	/*
	 * Sub resource method is useful when we have more than one method with same HTTP method designator.  
	 */
	
	// Sub resource 
	@GET
	// Passing as Path Patameter
	@Path("/info/{id}")
	@Produces(MediaType.APPLICATION_XML)
	public StreamingOutput getProductDetails(@PathParam("id") String productId) {
		return new ProductInfoWriter(productId);
	}

	private class ProductInfoWriter implements StreamingOutput {
		String id;

		public ProductInfoWriter(String id) {
			this.id = id;
		}

		@Override
		public void write(OutputStream os) throws IOException, WebApplicationException {
			StringBuffer stringBuffer = new StringBuffer();
			stringBuffer.append("<product-info>").append("<product-id>").append(id).append("<product-id>")
					.append("<product-name>").append("Washing Machine").append("<product-name>")
					.append("<product-price>").append("1234.78").append("<product-price>").append("<quantity>")
					.append("48").append("<quantity>").append("</product-info>");
			os.write(stringBuffer.toString().getBytes());
		}

	}
}
