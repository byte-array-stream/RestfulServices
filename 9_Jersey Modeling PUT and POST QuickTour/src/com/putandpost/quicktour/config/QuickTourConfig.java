package com.putandpost.quicktour.config;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.putandpost.quicktour.resource.QuickTour;

@ApplicationPath("/api")
public class QuickTourConfig extends Application {
	Set<Object> singletons = null;
	QuickTour quickTour = null;
	
	public QuickTourConfig() {
		singletons = new HashSet<>();
		quickTour = new QuickTour();
		singletons.add(quickTour);
	}

	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}
	
}
