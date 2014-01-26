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
import com.lab.jersey.model.Company;

/**
 * @author paolobonansea
 *
 */
public class CompanyServiceImpl implements CompanyService {

	private static Logger LOG = Logger.getLogger(CompanyService.class);

	/* (non-Javadoc)
	 * @see com.lab.jersey.service.CompanyService#getAll()
	 */
	@Override
	public List<Company> getAll() throws ServiceException {

		Session session = null;
		try {

			session = HibernateUtil.getSession();

			Criteria criteria = session.createCriteria(Company.class);

			return criteria.list();

		} catch (HibernateException ex) {
			LOG.error("error company get all: " + ex.getMessage(), ex);
			throw new ServiceException(ex);
		}
	}

}
