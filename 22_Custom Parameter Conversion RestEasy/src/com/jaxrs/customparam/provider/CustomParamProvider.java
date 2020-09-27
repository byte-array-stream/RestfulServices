package com.jaxrs.customparam.provider;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.ext.ParamConverter;
import javax.ws.rs.ext.ParamConverterProvider;
import javax.ws.rs.ext.Provider;

import com.jaxrs.customparam.converter.AwbNoCustomConverter;
import com.jaxrs.customparam.resource.AwbNo;

@Provider
public class CustomParamProvider implements ParamConverterProvider {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public <T> ParamConverter<T> getConverter(Class<T> classType, Type type, Annotation[] annotations) {
		
		ParamConverter<T> paramConverter  = null;
		
		if(classType.isAssignableFrom(AwbNo.class)) {
			paramConverter = new AwbNoCustomConverter();
		}
		return paramConverter;
	}
	
	
}
