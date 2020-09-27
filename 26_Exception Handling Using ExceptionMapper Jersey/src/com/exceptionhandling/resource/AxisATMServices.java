package com.exceptionhandling.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.exceptionhandling.exception.InvalidDataException;

@Path("/axis")
public class AxisATMServices {

	/**
	 * Here my resource method is returning data in two formats. first in XML and second is in JSON format.
	 * So we can negotiate the content by writing one request header called "ACCEPT =>  APPLICATION/JSON or APPLICATION/XML"
	 * 
	 * * We should go for Exception mapper when we have one exception being used in several classes. Rather writing creating 
	 * response in each class we can write the response in one Mapper class and will bind with provider annotation.
	 */
	
	@PUT
	@Path("/withdraw/{accNo}/{amount}")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	@Consumes({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })

	public Receipt withdraw(@PathParam("accNo") String accountNo, @PathParam("amount") int amount) {

		if (accountNo == null || accountNo.trim().length() < 4) {
			throw new InvalidDataException();
		}

		Receipt receipt = new Receipt();
		receipt.setAccountNo(accountNo);
		receipt.setAccountHolderName("sriman");
		receipt.setAmount(amount);
		receipt.setStatus("Successful !!");
		return receipt;
	}
}
