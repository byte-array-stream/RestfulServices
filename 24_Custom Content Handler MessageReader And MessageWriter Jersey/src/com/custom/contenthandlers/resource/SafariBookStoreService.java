package com.custom.contenthandlers.resource;

import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/safari")
public class SafariBookStoreService {

	
	@POST
	@Path("/add")
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public Acknowledgement addBookToLibrary(Book book) {
		
		Acknowledgement acknowledgement = new Acknowledgement();
		acknowledgement.setLibraryBookId(UUID.randomUUID().toString());
		acknowledgement.setIsbn(book.getIsbn());
		acknowledgement.setTitle(book.getBookTitle());
		acknowledgement.setAuthor(book.getAuthor());
		acknowledgement.setPrice(book.getPrice());
		
		return acknowledgement;
	}
}
