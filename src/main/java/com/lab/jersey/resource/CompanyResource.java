/**
 * 
 */
package com.lab.jersey.resource;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.lab.jersey.exception.ApplicationException;
import com.lab.jersey.exception.ServiceException;
import com.lab.jersey.service.CompanyService;

/**
 * @author paolobonansea
 * 
 */
@Path("/company")
public class CompanyResource {

	private final CompanyService service;
	
	@Inject
	public CompanyResource(final CompanyService service) {
		this.service = service;
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
	public Response getCompanies() {

		try {
		
			return Response.ok(this.service.getAll()).build();

		} catch (ServiceException ex) {
			return new ApplicationException(ex.getMessage()).getResponse();
		}
	}

}
