package com.custom.contenthandlers.readers;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.Consumes;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlType;

@Provider
@Consumes(MediaType.APPLICATION_XML)
public class CustomMessageReader implements MessageBodyReader<Object> {

	@Override
	public boolean isReadable(Class<?> classType, Type rawType, Annotation[] annotations, MediaType mediaType) {
		System.out.println("IsReadable() Method called..");
		if (classType.isAnnotationPresent(XmlType.class)) {
			return true;
		}
		return false;
	}

	@Override
	public Object readFrom(Class<Object> classType, Type rawType, Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, String> map, InputStream is) throws IOException, WebApplicationException {

		Object object = null;
		
		try {
			System.out.println("readFrom() Method called..");
			Unmarshaller unmarshaller = JAXBContext.newInstance(classType).createUnmarshaller();
			object = unmarshaller.unmarshal(is);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		
		return object;
	}

}
