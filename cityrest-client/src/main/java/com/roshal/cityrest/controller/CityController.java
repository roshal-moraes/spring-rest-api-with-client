package com.roshal.cityrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.roshal.cityrest.model.City;
import com.roshal.cityrest.service.CityService;

@Controller
@RequestMapping("/city")
public class CityController {

	// need to inject our City service
	@Autowired
	private CityService CityService;
	
	@GetMapping("/list")
	public String listCities(Model theModel) {
		
		// get Cities from the service
		List<City> theCities = CityService.getCities();
				
		// add the Cities to the model
		theModel.addAttribute("cities", theCities);
		
		return "list-city";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		City theCity = new City();
		
		theModel.addAttribute("city", theCity);
		
		return "city-form";
	}
	
	@PostMapping("/saveCity")
	public String saveCity(@ModelAttribute("city") City theCity) {
		
		// save the City using our service
		CityService.saveCity(theCity);	
		
		return "redirect:/city/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("CityId") int theId,
									Model theModel) {
		
		// get the City from our service
		City theCity = CityService.getCity(theId);	
		
		// set City as a model attribute to pre-populate the form
		theModel.addAttribute("city", theCity);
		
		// send over to our form		
		return "city-form";
	}
	
	@GetMapping("/delete")
	public String deleteCity(@RequestParam("CityId") int theId) {
		
		// delete the City
		CityService.deleteCity(theId);
		
		return "redirect:/city/list";
	}
}










