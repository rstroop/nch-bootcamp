package com.rhc.lab.domain;

import java.io.Serializable;

/**
 * 
 * This class represents the domain model for a booking request that will go
 * through our Concert Booking application for artists and venue matching
 * 
 */
public class BookingRequest implements Serializable {
	/**
   * 
   */
	private static final long serialVersionUID = 1086652316465244736L;

	private Venue venue;
	private String open;
	private String close;
	private Performance performance;
	private String description;

	public Venue getVenue() {
		return venue;
	}

	public void setVenue(Venue venue) {
		this.venue = venue;
	}

	public String getOpen() {
		return open;
	}

	public void setOpen(String open) {
		this.open = open;
	}

	public String getClose() {
		return close;
	}

	public void setClose(String close) {
		this.close = close;
	}

	public Performance getPerformance() {
		return performance;
	}

	public void setPerformance(Performance performance) {
		this.performance = performance;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
