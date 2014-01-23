/**
 * 
 */
package com.lab.jersey.test;

import static org.junit.Assert.assertEquals;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sun.jersey.api.client.ClientResponse;

/**
 * @author paolobonansea
 * 
 */
public class UserControllerTest extends BaseTest {
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception { }

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception { }

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception { }

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception { }
	
	@Test
	public void testCreate() {
		
		String jsonObject = "{\"lastName\":\"last name 1\",\"name\":\"test name 1\",\"idAddress\":\"1\"}";
		
		ClientResponse response = service.path("user").path("create")
				.type(MediaType.APPLICATION_JSON)
				.post(ClientResponse.class, jsonObject);
				
		assertEquals(response.getStatus(), Response.Status.OK.getStatusCode());
				
	}
	
	@Test
	public void testUpdate() {

		String jsonObject = "{ \"id\": \"1\", \"lastName\":\"last name 1\",\"name\":\"test name 1\",\"idAddress\":\"1\"}";
		
		ClientResponse response = service.path("user").path("update")
				.type(MediaType.APPLICATION_JSON)
				.post(ClientResponse.class, jsonObject);
		
		assertEquals(response.getStatus(), Response.Status.OK.getStatusCode());

	}
	
	@Test
	public void testDelete() {

		ClientResponse response = service.path("user").path("delete/" + 1)
				.type(MediaType.APPLICATION_JSON)
				.post(ClientResponse.class);
		
		assertEquals(response.getStatus(), Response.Status.OK.getStatusCode());

	}
	
	@Test
	public void testGetById() {

		ClientResponse response = service.path("user/" + 1)
				.get(ClientResponse.class);
		
		assertEquals(response.getStatus(), Response.Status.OK.getStatusCode());

	}
	
	@Test
	public void testGetAll() {

		ClientResponse response = service.path("user").path("all")
				.get(ClientResponse.class);
		
		assertEquals(response.getStatus(), Response.Status.OK.getStatusCode());

	}
 	
	@Test
	public void testGetByCountryId() {

		ClientResponse response = service.path("user").path("country/" + 1)
				.get(ClientResponse.class);
		
		assertEquals(response.getStatus(), Response.Status.OK.getStatusCode());

	}
	
	@Test
	public void testGetByCompanyIdCountryId() {

		ClientResponse response = service.path("user").path("company/" + 1)
				.path("country/" + 1)
				.get(ClientResponse.class);
		
		assertEquals(response.getStatus(), Response.Status.OK.getStatusCode());

	}

}