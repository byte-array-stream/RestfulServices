package com.contextparam.resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.PathSegment;
import javax.ws.rs.core.UriInfo;

@Path("/search")
public class SearchProperty {

	@GET
	@Path("/property/{loc}")
	@Produces(MediaType.APPLICATION_XML)
	public String property(@Context UriInfo uriInfo) {
		StringBuffer buffer = new StringBuffer();
		List<PathSegment> segments = uriInfo.getPathSegments();
		MultivaluedMap<String, String> queryParams = uriInfo.getQueryParameters();
		
		for(PathSegment segment : segments) {
			MultivaluedMap<String, String> matrixParam = segment.getMatrixParameters();
			buffer = buffer.append("<property><segment>")
				.append("<"+segment.toString()+">");
					for(String key : matrixParam.keySet()) {
						buffer = buffer.append("<matrix-param>")
										.append("<key>").append(key).append("</key>")
										.append("<value>"+matrixParam.get(key)+"</value>")
									.append("</matrix-param>");
					}
					
				buffer = buffer.append("</"+segment.toString()+">").append("</segment>")
				.append("<query-params>");
					for(String queryKey : queryParams.keySet()) {
						buffer = buffer.append("<key>").append(queryKey).append("</key>")
							  .append("<value>").append(queryParams.get(queryKey)).append("</value>");
					}
				buffer.append("</query-params>")	
			.append("</property>");
		}
		return buffer.toString();
	}
}
