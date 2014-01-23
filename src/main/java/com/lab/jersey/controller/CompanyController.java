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

import com.lab.jersey.model.Company;

/**
 * @author paolobonansea
 * 
 */
@Path("/company")
public class CompanyController {

	private static Map<Long, Company> store = new HashMap<Long, Company>();

	static {

		Company company1 = new Company();
		company1.setId(1L);
		company1.setName("company 1");
		company1.setCityId(12L);
		store.put(company1.getId(), company1);

		Company company2 = new Company();
		company2.setId(2L);
		company2.setName("company 2");
		company2.setCityId(12L);
		store.put(company2.getId(), company2);

	}

	/**
	 * url http://localhost:8080/lab-jersey/company/all
	 * 
	 * @return 
	 *         [{"id":1,"name":"company 1","cityId":12},{"id":2,"name":"company 2"
	 *         ,"cityId":12}]
	 */
	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Company> getCompanies() {

		List<Company> companies = new ArrayList<Company>();

		for (Company company : store.values()) {
			companies.add(company);
		}

		return companies;

	}

}
