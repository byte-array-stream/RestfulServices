package com.contenthandler.resource;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.StreamingOutput;

/**
 * @author ravik
 *
 *         ==> Allowable Input parameters 
 *         InputStream, Reader, File, Byte[], String, Source, MultivaluedMap
 *
 *         ==> Allowable Return types 
 *         StreamingOutput, File, Byte[], String
 */

@Path("/safari")
public class SafariBookServices {

	@POST
	@Path("/add-book")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.TEXT_PLAIN)
	public String addBookIntoLibrary(InputStream is) throws IOException {
		StringBuffer stringBuffer = null;
		int c = 0;
		stringBuffer = new StringBuffer();
		while ((c = is.read()) != -1) {
			stringBuffer.append((char) c);
		}
		return stringBuffer.toString();
	}

	@PUT
	@Path("/update-chapter")
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public StreamingOutput updateBookChapter(Reader reader) {

		return new StreamingOutput() {

			@Override
			public void write(OutputStream os) throws IOException, WebApplicationException {
				int c = 0;
				while ((c = reader.read()) != -1) {
					os.write((char) c);
				}
			}
		};
	}

	@GET
	@Path("/print")
	@Produces(MediaType.MULTIPART_FORM_DATA)
	public Response printBookPdf(@QueryParam("isbn") String isbn) {
		/*
		 * We can not send file directly by putting return type as File. We can do this but at client it will not be recieved as PDF
		 * file, rather it will be recieved as Unknow extension file with unknown file name also.
		 * 
		 * To avoid this we have the content type in the repsonse itself. That is why we need to set the Content type as PDF in
		 * the response header.
		*/
		
		ResponseBuilder response = Response.ok((Object) new File("C:\\Users\\ravik\\OneDrive\\json.pdf"));
        response.header("Content-Disposition", "attachment; filename=json.pdf");
        return response.build();
    }
	
	@PUT
	@Path("/add-pdf")
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public String addBookPdf(File file) throws IOException {
		
		// Read the file
		FileReader reader = new FileReader(file);
		StringBuffer buffer = new StringBuffer();
		int c = 0;
		while ((c=reader.read())>-1) {
			buffer.append((char)c);
		}
		reader.close();
		return buffer.toString();
	}
	
	@POST
	@Path("/add-preface")
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_XML)
	public byte[] addPreface(byte[] preface) {
		
		// Whatever the data we will send in any format, it will be dumped as byte[]. As part of the response I am not doing
		// anything rather I am simply returning the same XML data.
		
		StringBuffer buffer = new StringBuffer();
		for(int i=0; i>=preface.length; i++) {
			buffer.append((char)preface[i]);
		}
		return buffer.toString().getBytes();
	}
	
	@GET
	@Path("/info/{isbn}")
	@Produces(MediaType.APPLICATION_XML)
	public Book getBookInfo(@PathParam("isbn") String isbn) {
		
		/**
		 * RESTful has some built in MessageReaders and MessageWriters which helps in converting the data into the respected type.
		 * i.e. I have written response header as Application/XML then automatically it will converts the Object into XML.
		 * but given our class must and should be annotated with Jax-B annotation.
		 * 
		 * Same phenomenon is applicable for JSON also. In case of JSON it will convert the object into JSON itself.
		 * Since JSON is nothing but a string type data we do not need to bind it with JAX-B annotation.
		 */
		Book book = new Book();
		book.setIsbn(isbn);
		book.setBookTitle("The Fault In Our Stars");
		book.setPrice(250);
		book.setAuthor("John Green");
		return book;
	}
}
