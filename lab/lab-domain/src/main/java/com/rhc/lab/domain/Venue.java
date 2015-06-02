package com.rhc.lab.domain;

import java.util.List;

/**
 * 
 * This class represents the domain model for a Concert Venue
 *
 */
public class Venue {

    private String name;
    private String city;
    private Integer capacity;
    private List<PerformanceType> accomodations;

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getCity() {
	return city;
    }

    public void setCity(String city) {
	this.city = city;
    }

    public Integer getCapacity() {
	return capacity;
    }

    public void setCapacity(Integer capacity) {
	this.capacity = capacity;
    }

    public List<PerformanceType> getAccomodations() {
	return accomodations;
    }

    public void setAccomodations(List<PerformanceType> accomodations) {
	this.accomodations = accomodations;
    }

}
