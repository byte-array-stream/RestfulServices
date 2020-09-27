package com.serverresponses.resource;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

@Path("/safari")
public class SafariStoreServices {

	Properties props = null;

	public SafariStoreServices() {
		props = new Properties();
	}
	
	@POST
	@Path("/return")
	@Produces(MediaType.APPLICATION_XML)
	@Consumes({MediaType.APPLICATION_XML})
	public Response returnBook(InputStream is, @Context HttpHeaders headers) throws IOException, JAXBException {
		String headerName = null;
		UserInfo userInfo = null;
		
		headerName = headers.getHeaderString(HttpHeaders.CONTENT_TYPE);
		if("application/xml".equals(headerName)) {
			JAXBContext jaxbContext = JAXBContext.newInstance(UserInfo.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			userInfo = (UserInfo)unmarshaller.unmarshal(is);
		}else if("multipart/form-data".equals(headerName)) {
			props.load(is);
		}
		
		Reciept reciept = new Reciept();
		reciept.setInvoiceNo(props.getProperty("invoiceNo"));
		reciept.setAuthor(props.getProperty("author"));
		reciept.setBookIsbn(props.getProperty("isbn"));
		reciept.setTitle(props.getProperty("title"));
		reciept.setPrice(Integer.parseInt(props.getProperty("price")));
		reciept.setUser(userInfo.getUserName());
		reciept.setContactNo(userInfo.getContact());
		
		// Sending status code along with the data. We can go for RESPONSE as return type when we want to send our own
		// status code. But if we are happy with default status code we can simply send the Object as return type.
		Response response = Response.status(Status.ACCEPTED).entity(reciept).build(); 
		return response;
	}
	
}
