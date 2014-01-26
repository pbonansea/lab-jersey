/**
 * 
 */
package com.lab.jersey.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.lab.jersey.exception.ServiceException;
import com.lab.jersey.hibernate.HibernateUtil;
import com.lab.jersey.model.City;

/**
 * @author paolobonansea
 *
 */
public class CityServiceImpl implements CityService {

	private static Logger LOG = Logger.getLogger(CityService.class);

	/* (non-Javadoc)
	 * @see com.lab.jersey.service.CityService#getAll()
	 */
	@Override
	public List<City> getAll() throws ServiceException {

		Session session = null;
		try {

			session = HibernateUtil.getSession();

			Criteria criteria = session.createCriteria(City.class);

			return criteria.list();

		} catch (HibernateException ex) {
			LOG.error("error city get all: " + ex.getMessage(), ex);
			throw new ServiceException(ex);
		}
	}

}
