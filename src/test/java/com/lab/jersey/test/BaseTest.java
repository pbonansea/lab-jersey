/**
 * 
 */
package com.lab.jersey.test;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;

/**
 * @author paolobonansea
 *
 */
public abstract class BaseTest {

	protected static ClientConfig config;
	protected static Client client;
	protected static WebResource service;

	protected static final String HOST = "localhost";
	protected static String PORT = "8080";
	protected static String APPLICATION = "lab-jersey";
	
}
