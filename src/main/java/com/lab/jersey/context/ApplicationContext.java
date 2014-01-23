/**
 * 
 */
package com.lab.jersey.context;

import java.util.Map;

import com.sun.jersey.api.core.ResourceConfig;

/**
 * Optional class to initialize things in the context, for example data base
 * connection. For this example disabled, to enabled should change the web.xml.
 * 
 * @author paolobonansea
 * 
 */
public class ApplicationContext extends ResourceConfig {

	public ApplicationContext() {

		System.out.println("application initialized");

	}

	@Override
	public boolean getFeature(String arg0) {
		return false;
	}

	@Override
	public Map<String, Boolean> getFeatures() {
		return null;
	}

	@Override
	public Map<String, Object> getProperties() {
		return null;
	}

	@Override
	public Object getProperty(String arg0) {
		return null;
	}

}
