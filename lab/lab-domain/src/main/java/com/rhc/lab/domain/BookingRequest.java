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

	private String venueName;
	private String open;
	private String close;
	private Performer performer;

	public String getVenueName() {
		return venueName;
	}

	public void setVenueName(String venueName) {
		this.venueName = venueName;
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

	public Performer getPerformer() {
		return performer;
	}

	public void setPerformer(Performer performer) {
		this.performer = performer;
	}

}
