package com.roshal.cityrest.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.roshal.cityrest.entity.City;
import com.roshal.cityrest.service.CityService;


@RestController
@RequestMapping("/api")
public class CityRestController {

	// autowire the CityService
	@Autowired
	private CityService cityService;
	
	// add mapping for GET /citys
	@GetMapping("/cities")
	public List<City> getCities() {
		
		return cityService.getCities();
		
	}
	
	// add mapping for GET /citys/{cityId}
	
	@GetMapping("/cities/{cityId}")
	public City getCity(@PathVariable int cityId) {
		
		City theCity = cityService.getCity(cityId);
		
		if (theCity == null) {
			throw new CityNotFoundException("City id not found - " + cityId);
		}
		
		return theCity;
	}
	
	// add mapping for POST /citys  - add new city
	
	@PostMapping("/cities")
	public City addCity(@RequestBody City theCity) {
		
		// also just in case the pass an id in JSON ... set id to 0
		// this is force a save of new item ... instead of update
		
		theCity.setId(0);
		
		cityService.saveCity(theCity);
		
		return theCity;
	}
	
	// add mapping for PUT /citys - update existing city
	
	@PutMapping("/cities")
	public City updateCity(@RequestBody City theCity) {
		
		cityService.saveCity(theCity);
		
		return theCity;
		
	}
	
	// add mapping for DELETE /citys/{cityId} - delete city
	
	@DeleteMapping("/cities/{cityId}")
	public String deleteCity(@PathVariable int cityId) {
		
		City tempCity = cityService.getCity(cityId);
		
		// throw exception if null
		
		if (tempCity == null) {
			throw new CityNotFoundException("City id not found - " + cityId);
		}
				
		cityService.deleteCity(cityId);
		
		return "Deleted city id - " + cityId;
	}
	
}


















