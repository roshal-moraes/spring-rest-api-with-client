package com.roshal.cityrest.model;


public class City {
	private int id;
	private String name;
	private String country;
	private String population;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPopulation() {
		return population;
	}
	public void setPopulation(String population) {
		this.population = population;
	}
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "City [id=" + id + ", name=" + name + ", population=" + population + "]";
	}
	public City(int id, String name, String population) {
		this.id = id;
		this.name = name;
		this.population = population;
	}
	public City() {
		// TODO Auto-generated constructor stub
	}
	
	
}
