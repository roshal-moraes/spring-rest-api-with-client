package com.roshal.cityrest.service;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.roshal.cityrest.model.City;


@Service
public class CityServiceRestClientImpl implements CityService {

	private RestTemplate restTemplate;

	private String crmRestUrl;
		
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Autowired
	public CityServiceRestClientImpl(RestTemplate theRestTemplate, 
										@Value("${crm.rest.url}") String theUrl) {
		restTemplate = theRestTemplate;
		crmRestUrl = theUrl;
				
		logger.info("Loaded property:  crm.rest.url=" + crmRestUrl);
	}
	
	@Override
	public List<City> getCities() {
		
		logger.info("in getCities(): Calling REST API " + crmRestUrl);

		// make REST call
		ResponseEntity<List<City>> responseEntity = 
											restTemplate.exchange(crmRestUrl, HttpMethod.GET, null, 
																  new ParameterizedTypeReference<List<City>>() {});

		// get the list of Citys from response
		List<City> Cities = responseEntity.getBody();

		logger.info("in getCities(): Cities" + Cities);
		
		return Cities;
	}

	@Override
	public City getCity(int theId) {

		logger.info("in getCity(): Calling REST API " + crmRestUrl);

		// make REST call
		City theCity = 
				restTemplate.getForObject(crmRestUrl + "/" + theId, 
										  City.class);

		logger.info("in saveCity(): theCity=" + theCity);
		
		return theCity;
	}

	@Override
	public void saveCity(City theCity) {

		logger.info("in saveCity(): Calling REST API " + crmRestUrl);
		
		int employeeId = theCity.getId();

		// make REST call
		if (employeeId == 0) {
			// add employee
			restTemplate.postForEntity(crmRestUrl, theCity, String.class);			
		
		} else {
			// update employee
			restTemplate.put(crmRestUrl, theCity);
		}

		logger.info("in saveCity(): success");	
	}

	@Override
	public void deleteCity(int theId) {

		logger.info("in deleteCity(): Calling REST API " + crmRestUrl);

		// make REST call
		restTemplate.delete(crmRestUrl + "/" + theId);

		logger.info("in deleteCity(): deleted City theId=" + theId);
	}

}
