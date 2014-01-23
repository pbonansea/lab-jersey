package com.lab.jersey.test;

import javax.ws.rs.core.UriBuilder;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.config.DefaultClientConfig;

@RunWith(Suite.class)
@SuiteClasses({ AddressControllerTest.class, CompanyControllerTest.class,
		UserControllerTest.class })
public class ControllersTests extends BaseTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		config = new DefaultClientConfig();
		client = Client.create(config);
		service = client.resource(UriBuilder.fromUri("http://" + HOST + ":" + PORT + "/" + APPLICATION)
				.build());
	
	}
	
}
