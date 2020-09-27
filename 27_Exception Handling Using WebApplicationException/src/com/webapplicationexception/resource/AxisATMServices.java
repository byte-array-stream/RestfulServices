package com.webapplicationexception.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;


@Path("/axis")
public class AxisATMServices {

	/**
	 * Here my resource method is returning data in two formats. first in XML and second is in JSON format.
	 * So we can negotiate the content by writing one request header called "ACCEPT =>  APPLICATION/JSON or APPLICATION/XML"
	 * 
	 * * We can throw WebApplicationException also when we have to throw exception with different msg or entity object. In this
	 * case we are not suppose to write ExceptionMapper.
	 */
	
	@PUT
	@Path("/withdraw/{accNo}/{amount}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })

	public Receipt withdraw(@PathParam("accNo") String accountNo, @PathParam("amount") int amount) {

		if (accountNo == null || accountNo.trim().length() < 4) {
			
			// Create the error response.
			ErrorResponse errorResponse = new ErrorResponse();
			errorResponse.setStatusCode(112);
			errorResponse.setMessage("Bad Request");
			errorResponse.setDetails("Invalid Account No..");
			
			// Create the HttpResponse body and give it to Jax- rs runtime.
			throw new WebApplicationException(Response.status(Status.BAD_REQUEST).entity(errorResponse).build());
		}

		// Or else return the correct response
		Receipt receipt = new Receipt();
		receipt.setAccountNo(accountNo);
		receipt.setAccountHolderName("sriman");
		receipt.setAmount(amount);
		receipt.setStatus("Successful !!");
		return receipt;
	}
}
