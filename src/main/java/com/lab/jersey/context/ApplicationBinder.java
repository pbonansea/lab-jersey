/**
 * 
 */
package com.lab.jersey.context;

import org.glassfish.hk2.utilities.binding.AbstractBinder;

import com.lab.jersey.service.CityService;
import com.lab.jersey.service.CityServiceImpl;
import com.lab.jersey.service.CompanyService;
import com.lab.jersey.service.CompanyServiceImpl;
import com.lab.jersey.service.UserService;
import com.lab.jersey.service.UserServiceImpl;

/**
 * @author paolobonansea
 *
 */
public class ApplicationBinder extends AbstractBinder {

	@Override
    protected void configure() {
		
        bind(UserServiceImpl.class).to(UserService.class);
        bind(CompanyServiceImpl.class).to(CompanyService.class);
        bind(CityServiceImpl.class).to(CityService.class);
        
	}
	
}
