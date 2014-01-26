/**
 * 
 */
package com.lab.jersey.context;

import org.apache.log4j.Logger;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.server.ResourceConfig;


/**
 * 
 * @author paolobonansea
 * 
 */
public class ApplicationContext extends ResourceConfig {
	
	private static Logger LOG = Logger.getLogger(ApplicationContext.class);

	public ApplicationContext() {
		
        register(new ApplicationBinder());
        register(JacksonFeature.class);
        LOG.info("application initialized");
        
    }
	
}
