package com.roshal.cityrest.service;

import java.util.List;

import com.roshal.cityrest.model.City;

public interface CityService {

	public List<City> getCities();

	public void saveCity(City theCity);

	public City getCity(int theId);

	public void deleteCity(int theId);
	
}
