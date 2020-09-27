package com.matrixparam.resource;

import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


/**
 * @author ravik
 * 
 * Matrix Parameter can be used when we want addition data along with the primary data. We can place Matrix Param anywhere within the URL. In following URL sq-yards and area
 * is Matrix Param.
 * 
 * http://localhost:8082/15_Matrix_Parameter/api/agent/hyd/getProps/plot;sq-yards=200;ptype=flat?area=ameerpet
 * 
 * Above is VALID URL's.
 * 
 * Matrix Parameters works with both JERSEY and RestEasy Implementations. To work with Jersey simply remove the JAR from lib diractory and add Jersey Jars. 
 * 
 * Matrix Paramter works with @PathParam only. It does not work with @QueryParam.
 */
@Path("/agent/{city}")
public class PropertyAgent {

	/* http://localhost:8082/15_Matrix_Parameter/api/agent/hyd/getProps/plot;sq-yards=200?area=ameerpet;ptype=flat
	 * 
	 * If we write URL in this way, it JAX-RS Injction for Matrix Param will not happen. Rather complete value of area will be printed.
	 * Ex::- <area>ameerpet;ptype=flat</area>     <== this will be the value of area.
	 *  
	 *  */	
	@PathParam("city") 
	String city;
	
	@GET
	@Path("/getProps/{property-type}/{area}")
	@Produces(MediaType.APPLICATION_XML)
	public String getProperties(@PathParam("property-type") String propertyType, @PathParam("area") String area, 
			@MatrixParam("sq-yards") String sqYards, @MatrixParam("ptype") String ptype ) {
		System.out.println(sqYards);
		return new StringBuffer().append("<property>")
									.append("<property-type>").append(propertyType).append("</property-type>")
									.append("<city>").append(city).append("</city>")
									.append("<area>").append(area).append("</area>")
									.append("<sqYards>").append(sqYards).append("</sqYards>")
								 .append("</property>").toString();
	}
}
