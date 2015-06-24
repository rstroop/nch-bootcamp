package com.rhc.lab.domain;

import java.io.Serializable;

/**
 * 
 * This class represents the domain model for a Concert Performance
 * 
 */
public class Performer implements Serializable {
	/**
   * 
   */
	private static final long serialVersionUID = 4851772661932654506L;

	private String name;
	private String description;
	private PerformanceType type;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public PerformanceType getType() {
		return type;
	}

	public void setType(PerformanceType type) {
		this.type = type;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
