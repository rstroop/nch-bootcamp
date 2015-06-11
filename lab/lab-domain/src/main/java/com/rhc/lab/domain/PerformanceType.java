package com.rhc.lab.domain;

import java.io.Serializable;

/**
 * 
 * This enumerated type represents the domain model for performance types to be
 * used in Booking Requests
 * 
 */
public enum PerformanceType implements Serializable {

	BALLET("Dance"), BAND("Band"), COMEDIAN("Comedian"), MUSICAL("Musical"), ORCHESTRA(
			"Orchestra"), PLAY("Play"), RALLY("Rally"), SCREENING(
			"Film Screening");

	private String performanceType;

	PerformanceType(String performanceType) {
		this.performanceType = performanceType;
	}

	public String toString() {
		return performanceType;
	}
}
