package com.beanparam.resource;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

public class Property {

	@PathParam("loc")
	protected String location;
	@PathParam("city")
	protected String city;
	@MatrixParam("area")
	protected String area;
	@QueryParam("min")
	@DefaultValue("1000000")
	protected double minBudget;
	@QueryParam("max")
	@DefaultValue("450000000")
	protected double maxBudget;
	@QueryParam("facing")
	@DefaultValue("Sea Facing")
	protected String facing;

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public double getMinBudget() {
		return minBudget;
	}

	public void setMinBudget(double minBudget) {
		this.minBudget = minBudget;
	}

	public double getMaxBudget() {
		return maxBudget;
	}

	public void setMaxBudget(double maxBudget) {
		this.maxBudget = maxBudget;
	}

	public String getFacing() {
		return facing;
	}

	public void setFacing(String facing) {
		this.facing = facing;
	}

	@Override
	public String toString() {
		return "Property [location=" + location + ", city=" + city + ", area=" + area + ", minBudget=" + minBudget
				+ ", maxBudget=" + maxBudget + ", facing=" + facing + "]";
	}

}
