package com.rhc.lab.domain;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * This class represents the domain model for a Concert Venue
 * 
 */
public class Venue implements Serializable, Comparable<Venue> {
	/**
   * 
   */
	private static final long serialVersionUID = -6165217833968313884L;

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

	/**
	 * Cleans up the leading "The" in band name for more accurate sorting
	 */
	@Override
	public int compareTo(Venue o) {
		String thisName = "";
		String otherName = "";

		if (this.getName().startsWith("The")
				|| this.getName().startsWith("the")) {
			thisName = this.getName().substring(3).trim();
		} else {
			thisName = this.getName();
		}
		if (o.getName().startsWith("The") || o.getName().startsWith("the")) {
			otherName = o.getName().substring(3).trim();
		} else {
			otherName = o.getName();
		}

		return thisName.compareTo(otherName);
	}

}
