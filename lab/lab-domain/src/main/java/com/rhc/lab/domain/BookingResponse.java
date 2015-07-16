package com.rhc.lab.domain;

import java.io.Serializable;
import java.util.Collection;

import com.rhc.lab.kie.common.KieQuery;

/**
 * 
 * This class represents the domain model for a booking response that will go
 * through our Concert Booking application for artists and venue matching. This
 * payload will be returned to the UI after rules have fired to determine
 * whether or not the venue can be booked as per the requested time(s) and
 * performance type(s)
 * 
 */
public class BookingResponse implements Serializable {
	/**
   * 
   */
	private static final long serialVersionUID = 1074544082673724792L;

	@KieQuery(binding = "$bookingRequest", queryName = "getBookingRequests")
	private Collection<BookingRequest> bookingRequests;

	@KieQuery(binding = "$booking", queryName = "getBookings")
	private Collection<Booking> bookings;

	private BookingStatus bookingStatus;

	public Collection<BookingRequest> getBookingRequests() {
		return bookingRequests;
	}
	public void setBookingRequests(Collection<BookingRequest> bookingRequest) {
		this.bookingRequests = bookingRequest;
	}
	public Collection<Booking> getBookings() {
		return bookings;
	}
	public void setBookings(Collection<Booking> bookings) {
		this.bookings = bookings;
	}
	public BookingStatus getBookingStatus() {
		return bookingStatus;
	}
	public void setBookingStatus(BookingStatus bookingStatus) {
		this.bookingStatus = bookingStatus;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((bookings == null) ? 0 : bookings.hashCode());
		result = prime * result
				+ ((bookingRequests == null) ? 0 : bookingRequests.hashCode());
		result = prime * result
				+ ((bookingStatus == null) ? 0 : bookingStatus.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookingResponse other = (BookingResponse) obj;
		if (bookings == null) {
			if (other.bookings != null)
				return false;
		} else if (!bookings.equals(other.bookings))
			return false;
		if (bookingRequests == null) {
			if (other.bookingRequests != null)
				return false;
		} else if (!bookingRequests.equals(other.bookingRequests))
			return false;
		if (bookingStatus != other.bookingStatus)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "BookingResponse [bookingRequest=" + bookingRequests
				+ ", booking=" + bookings + ", bookingStatus=" + bookingStatus
				+ "]";
	}

}
