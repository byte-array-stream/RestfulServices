package com.jaxrs.customparam.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/courier")
public class BlueDartCourierService {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/status/{awbNo}")
	public String getCourierStatus(@PathParam("awbNo") AwbNo<?> airwayBillNo) {
		return "Area Code ::" + airwayBillNo.getAreaCode() + " Airway Tracking No :: " + airwayBillNo.getTrackingCode();
	}
}
