package com.roshal.cityrest.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.roshal.cityrest.entity.City;

@Repository
public class CityDAOImpl implements CityDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
			
	@Override
	public List<City> getCities() {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// create a query  ... sort by last name
		Query<City> theQuery = 
				currentSession.createQuery("from City",
											City.class);
		
		// execute query and get result list
		List<City> cities = theQuery.getResultList();
				
		// return the results		
		return cities;
	}

	@Override
	public void saveCity(City theCity) {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save/upate the customer ... finally LOL
		currentSession.saveOrUpdate(theCity);
		
	}

	@Override
	public City getCity(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve/read from database using the primary key
		City theCity = currentSession.get(City.class, theId);
		
		return theCity;
	}

	@Override
	public void deleteCity(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete object with primary key
		Query theQuery = 
				currentSession.createQuery("delete from City where id=:cityId");
		theQuery.setParameter("cityId", theId);
		
		theQuery.executeUpdate();		
	}

}











