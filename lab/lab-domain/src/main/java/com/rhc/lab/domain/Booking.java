package com.rhc.lab.domain;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 
 * This class represents the persistent data model for a booking confirmed by
 * the lab business rules
 * 
 */
@Document(collection = "bookings")
public class Booking implements Serializable, Comparable<Booking> {
	/**
   * 
   */
	private static final long serialVersionUID = -3194593190599248428L;

	@Id
	private String id;
	private Venue venue;
	private Performer performer;
	private String open;
	private String close;

	public Booking() {
	}

	public Booking(BookingRequest bookingRequest) {
		this.venue = bookingRequest.getVenue();
		this.performer = bookingRequest.getPerformer();
		this.open = bookingRequest.getOpen();
		this.close = bookingRequest.getClose();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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

	public Performer getPerformer() {
		return performer;
	}

	public void setPerformer(Performer performer) {
		this.performer = performer;
	}

	@Override
	public int compareTo(Booking o) {
		if (this.getOpen() == null && o.getClose() == null)
			return 0;
		else if (o.getOpen() == null)
			return -1;
		else if (this.getOpen() == null)
			return 1;
		else
			return this.getOpen().compareToIgnoreCase(o.getOpen());

	}

}
