package com.custom.contenthandlers.writers;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlType;

import com.custom.contenthandlers.resource.Acknowledgement;

@Provider
@Produces(MediaType.APPLICATION_XML)
public class CustomMessageWriter implements MessageBodyWriter<Object> {

	@Override
	public long getSize(Object object, Class<?> classType, Type rawType, Annotation[] annotations,
			MediaType mediaType) {
		return 0;
	}

	@Override
	public boolean isWriteable(Class<?> classType, Type rawType, Annotation[] annotations, MediaType mediaType) {
		System.out.println("IsWritable() Method called..");
		if (classType.isAssignableFrom(Acknowledgement.class)) {
			return true;
		}
		return false;
	}

	@Override
	public void writeTo(Object object, Class<?> classType, Type rawType, Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, Object> map, OutputStream os) throws IOException, WebApplicationException {

		if (object.getClass().isAnnotationPresent(XmlType.class)) {
			try {
				System.out.println("WriteTo() Method called..");
				Marshaller marshaller = JAXBContext.newInstance(classType).createMarshaller();
				marshaller.marshal(object, os);
			} catch (JAXBException e) {
				e.printStackTrace();
			}
		}
	}

}
