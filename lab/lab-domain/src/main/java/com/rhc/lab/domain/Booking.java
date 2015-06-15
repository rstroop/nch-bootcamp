package com.rhc.lab.domain;

import org.joda.time.DateTime;

public class Booking {

	private Venue venue;
	private Performance performance;
	private DateTime open;
	private DateTime close;
	private String description;

	public Booking() {
	}

	public Booking(BookingRequest request) {
		this.venue = request.getVenue();
		this.performance = request.getPerformance();
		this.description = request.getDescription();
		this.open = request.getOpen();
		this.close = request.getClose();
	}

	public Venue getVenue() {
		return venue;
	}

	public void setVenue(Venue venue) {
		this.venue = venue;
	}

	public Performance getPerformance() {
		return performance;
	}

	public void setPerformance(Performance performance) {
		this.performance = performance;
	}

	public DateTime getOpen() {
		return open;
	}

	public void setOpen(DateTime open) {
		this.open = open;
	}

	public DateTime getClose() {
		return close;
	}

	public void setClose(DateTime close) {
		this.close = close;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
