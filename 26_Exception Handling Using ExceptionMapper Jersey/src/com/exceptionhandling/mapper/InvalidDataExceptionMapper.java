package com.exceptionhandling.mapper;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.exceptionhandling.exception.ErrorResponse;
import com.exceptionhandling.exception.InvalidDataException;

@Provider
public class InvalidDataExceptionMapper implements ExceptionMapper<InvalidDataException> {

	@Override
	public Response toResponse(InvalidDataException e) {

		ErrorResponse errResponse = new ErrorResponse();

		// OO1 is not any predefined code, rather it is an application defined or we can
		// say for evry application there will be an
		// programmer defined code. Like in this application 001 is an application
		// defined status code for Invalid Data Or Bad Request..
		
		errResponse.setStatusCode(001);
		errResponse.setMessage("Bad Request");
		errResponse.setDetails("Invalid Data sent as part of the request");
		Response response = Response.status(Status.BAD_REQUEST).entity(errResponse).build();

		return response;
	}

}
