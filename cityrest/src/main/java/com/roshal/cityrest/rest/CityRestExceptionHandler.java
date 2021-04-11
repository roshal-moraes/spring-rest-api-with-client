package com.roshal.cityrest.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CityRestExceptionHandler {

	// Add an exception handler for CityNotFoundException
	
	@ExceptionHandler
	public ResponseEntity<CityErrorResponse> handleException(CityNotFoundException exc) {
		
		// create CityErrorResponse
		
		CityErrorResponse error = new CityErrorResponse(
											HttpStatus.NOT_FOUND.value(),
											exc.getMessage(),
											System.currentTimeMillis());
		
		// return ResponseEntity
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	
	// Add another exception handler ... to catch any exception (catch all)

	@ExceptionHandler
	public ResponseEntity<CityErrorResponse> handleException(Exception exc) {
		
		// create CityErrorResponse
		
		CityErrorResponse error = new CityErrorResponse(
											HttpStatus.BAD_REQUEST.value(),
											exc.getMessage(),
											System.currentTimeMillis());
		
		// return ResponseEntity
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
}

