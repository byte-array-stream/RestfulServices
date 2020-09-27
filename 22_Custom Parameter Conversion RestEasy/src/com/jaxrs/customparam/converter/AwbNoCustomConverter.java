package com.jaxrs.customparam.converter;

import javax.ws.rs.ext.ParamConverter;

import com.jaxrs.customparam.resource.AwbNo;

public class AwbNoCustomConverter<T> implements ParamConverter<AwbNo<T>>{

	@Override
	public AwbNo<T> fromString(String param) {
		AwbNo<T> awbNo = new AwbNo<T>();
		awbNo.setAreaCode(Integer.parseInt(param.substring(4, 6)));
		awbNo.setTrackingCode(param.substring(0,4));
		return awbNo;
	}

	@Override
	public String toString(AwbNo<T> awbNo) {
		return awbNo.getTrackingCode()+""+awbNo.getAreaCode();
	}
}
