package com.roshal.cityrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.roshal.cityrest.dao.CityDAO;
import com.roshal.cityrest.entity.City;


@Service
public class CityServiceImpl implements CityService {

	// need to inject city dao
	@Autowired
	private CityDAO cityDAO;
	
	@Override
	@Transactional
	public List<City> getCities() {
		return cityDAO.getCities();
	}

	@Override
	@Transactional
	public void saveCity(City theCity) {

		cityDAO.saveCity(theCity);
	}

	@Override
	@Transactional
	public City getCity(int theId) {
		
		return cityDAO.getCity(theId);
	}

	@Override
	@Transactional
	public void deleteCity(int theId) {
		
		cityDAO.deleteCity(theId);
	}
}





