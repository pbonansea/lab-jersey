/**
 * 
 */
package com.lab.jersey.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.lab.jersey.model.Address;

/**
 * @author paolobonansea
 * 
 */
@Path("/address")
public class AddressController {

	private static Map<Long, Address> store = new HashMap<Long, Address>();

	static {

		Address address1 = new Address();
		address1.setId(1L);
		address1.setPostCode("E2 9NJ");
		store.put(address1.getId(), address1);

		Address address2 = new Address();
		address2.setId(2L);
		address2.setPostCode("E2 9NJ");
		store.put(address2.getId(), address2);

		Address address3 = new Address();
		address3.setId(3L);
		address3.setPostCode("E2 9NJ");
		store.put(address3.getId(), address3);

	}

	/**
	 * url http://localhost:8080/lab-jersey/address/all
	 * 
	 * @return 
	 *         [{"id":1,"postCode":"E2 9NJ","cityId":null},{"id":2,"postCode":"E2 9NJ"
	 *         ,"cityId":null},{"id":3,"postCode":"E2 9NJ","cityId":null}]
	 */
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Address> getAddresss() {

		List<Address> addresses = new ArrayList<Address>();

		for (Address address : store.values()) {
			addresses.add(address);
		}

		return addresses;

	}

}
