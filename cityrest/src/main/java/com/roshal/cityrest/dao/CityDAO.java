package com.roshal.cityrest.dao;

import java.util.List;

import com.roshal.cityrest.entity.City;

public interface CityDAO {

	public List<City> getCities();

	public void saveCity(City theCity);

	public City getCity(int theId);

	public void deleteCity(int theId);
	
}
