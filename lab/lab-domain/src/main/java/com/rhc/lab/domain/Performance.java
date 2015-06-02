package com.rhc.lab.domain;

/**
 * 
 * This class represents the domain model for a Concert Performance
 * 
 */
public class Performance {

	private String name;
	private PerformanceType type;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public PerformanceType getType() {
		return type;
	}

	public void setType(PerformanceType type) {
		this.type = type;
	}

}
