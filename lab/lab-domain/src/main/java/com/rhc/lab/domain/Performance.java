package com.rhc.lab.domain;

import java.io.Serializable;

/**
 * 
 * This class represents the domain model for a Concert Performance
 * 
 */
public class Performance implements Serializable {
	/**
   * 
   */
	private static final long serialVersionUID = 4851772661932654506L;

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
