/**
 * 
 */
package com.lab.jersey.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.lab.jersey.model.User;

/**
 * @author paolobonansea
 * 
 */
@Path("/user")
public class UserController {

	private static Map<Long, User> store = new HashMap<Long, User>();

	/**
	 * url http://localhost:8080/lab-jersey/user/create
	 * "Content-Type: application/json"
	 * 
	 * @param jsonParam
	 *            {"lastName":"last name 1","name":"test name 1","idAddress":"1"
	 *            }
	 * @return
	 */
	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(JSONObject jsonParam) {

		try {

			String name = jsonParam.getString("name");
			String lastName = jsonParam.getString("lastName");
			Long idAddress = Long.valueOf(jsonParam.getString("idAddress"));

			User user = new User();
			int sizeStore = store.size();
			Long id = Integer.valueOf(sizeStore++).longValue();
			user.setId(id);
			user.setName(name);
			user.setLastName(lastName);
			user.setIdAddress(idAddress);

			store.put(user.getId(), user);

			return Response.ok(user, MediaType.APPLICATION_JSON).build();

		} catch (NumberFormatException ex) {
			ex.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(ex.getMessage()).type("text/plain").build();
		} catch (JSONException ex) {
			ex.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(ex.getMessage()).type("text/plain").build();
		}
	}

	/**
	 * url http://localhost:8080/lab-jersey/user/update
	 * "Content-Type: application/json"
	 * 
	 * @param jsonParam
	 *            { "id": "1",
	 *            "lastName":"last name 1","name":"test name 1","idAddress":"1"}
	 * @return
	 */
	@POST
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response update(JSONObject jsonParam) {

		try {

			Long id = Long.valueOf(jsonParam.getString("id"));
			String name = jsonParam.getString("name");
			String lastName = jsonParam.getString("lastName");
			Long idAddress = Long.valueOf(jsonParam.getString("idAddress"));

			User user = new User();
			user.setId(id);
			user.setName(name);
			user.setLastName(lastName);
			user.setIdAddress(idAddress);

			store.put(user.getId(), user);

			return Response.ok(user, MediaType.APPLICATION_JSON).build();

		} catch (NumberFormatException ex) {
			ex.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(ex.getMessage()).type("text/plain").build();
		} catch (JSONException ex) {
			ex.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
					.entity(ex.getMessage()).type("text/plain").build();
		}
	}

	/**
	 * url http://localhost:8080/lab-jersey/user/delete/1
	 * 
	 * @param id
	 * @return response status, 200, 204, 404....
	 */
	@POST
	@Path("/delete/{id}")
	public Response delete(@PathParam("id") Long id) {

		store.remove(id);

		return Response.ok("<status>success</status>").build();

	}

	/**
	 * url http://localhost:8080/lab-jersey/user/1
	 * 
	 * @param id
	 *            user id
	 * @return 
	 *         {"idAddress":"1","lastName":"last name 1","name":"test name 1","id"
	 *         :"1"}
	 */
	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public User getUserById(@PathParam("id") Long id) {

		User user = store.get(id);

		return user;

	}

	/**
	 * url http://localhost:8080/lab-jersey/user/all
	 * 
	 * @return 
	 *         {"user":[{"idAddress":"1","lastName":"last name 1","name":"test name 1"
	 *         ,"id":"0"},
	 *         {"idAddress":"1","lastName":"last name 1","name":"test name 1"
	 *         ,"id":"2"}]}
	 */
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getUsers() {

		List<User> users = new ArrayList<User>();

		for (User user : store.values()) {
			users.add(user);
		}

		return users;

	}

	/**
	 * url http://localhost:8080/lab-jersey/user/country/4
	 * 
	 * @param countryId
	 *            country id
	 * @return 
	 *         {"user":[{"idAddress":"1","lastName":"last name 1","name":"test name 1"
	 *         ,"id":"0"},
	 *         {"idAddress":"1","lastName":"last name 1","name":"test name 1"
	 *         ,"id":"2"}]}
	 */
	@GET
	@Path("/country/{countryId}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getUsersByCountryId(@PathParam("countryId") Long countryId) {

		List<User> users = new ArrayList<User>();

		for (User user : store.values()) {
			users.add(user);
		}

		return users;

	}

	/**
	 * url http://localhost:8080/lab-jersey/user/company/1/country/4
	 * 
	 * @param companyId
	 *            company id
	 * @param countryId
	 *            country id
	 * @return 
	 *         {"user":[{"idAddress":"1","lastName":"last name 1","name":"test name 1"
	 *         ,"id":"0"},
	 *         {"idAddress":"1","lastName":"last name 1","name":"test name 1"
	 *         ,"id":"2"}]}
	 */
	@GET
	@Path("/company/{companyId}/country/{countryId}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getUsersByCompanyIdCountryId(
			@PathParam("companyId") Long companyId,
			@PathParam("countryId") Long countryId) {

		List<User> users = new ArrayList<User>();

		for (User user : store.values()) {
			users.add(user);
		}

		return users;

	}

}
