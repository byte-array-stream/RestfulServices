package com.jersey.client;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;

public class RestClientService {
	// Accessing all the methods of Project No 23 "Content Handlers Allowable
	// Parameters And Return Types"

	private final String BASE_URI = "http://localhost:8081/23_Content_Handler_Allowable_Return_Type_And_Parameter/api/safari";
	
	// It is a simple GET request.
	public Book getBookInfo(String isbn) {
		return ClientBuilder.newClient().target(BASE_URI).path("info").path("{isbn}").resolveTemplate("isbn", isbn)
				.request().accept(MediaType.APPLICATION_XML).get().readEntity(Book.class);
	}
	
	// In this case we need to send the data in Request Body. Provider will only give the req and resp XML. By looking the 
	// XML structure we need to send the data. In this case provider is accepting the data in form of XML, so we can either send 
	// Object and JAX-RS will convert it into XML OR we can send String with XML.
	public String addPreface(Book preface) {
		
		return ClientBuilder.newClient().target(BASE_URI).path("add-preface").request().
				header("Content-Type", MediaType.APPLICATION_XML).accept(MediaType.APPLICATION_XML)
				.post(Entity.xml(preface)).readEntity(String.class);
		
	}
}
