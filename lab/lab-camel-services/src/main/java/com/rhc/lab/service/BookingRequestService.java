package com.rhc.lab.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.camel.Body;
import org.apache.commons.collections4.IteratorUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.rhc.lab.dao.BookingRepository;
import com.rhc.lab.dao.VenueRepository;
import com.rhc.lab.domain.Booking;
import com.rhc.lab.domain.BookingRequest;
import com.rhc.lab.domain.Venue;

public class BookingRequestService {

	private static final Logger logger = LoggerFactory
			.getLogger(BookingRequestService.class);

	// @Resource(name = "bookingDao")\
	@Autowired
	BookingRepository bookingRepo;
	// @Resource(name = "venueDao")
	@Autowired
	VenueRepository venueRepo;

	public BookingRequestService() {

	}

	public List<Object> buildSession(@Body BookingRequest request)
			throws Exception {

		// collect all the relevent data for the ksession
		List<Object> facts = collectSingleVenueForSession(request);
		// post the facts to the body of the exchange
		// put on the in so we do not loose the headers
		return facts;
	}

	public boolean saveBooking(@Body Booking booking) {
		try {
			bookingRepo.save(booking);
		} catch (Exception e) {
			logger.error(e.toString());
			return false;
		}
		return true;
	}

	/**
	 * Returns all venues and bookings for every
	 * 
	 * @return
	 */
	private List<Object> collectForKnowledgeSession() {
		Iterable<Booking> bookings = bookingRepo.findAll();
		Iterable<Venue> venues = venueRepo.findAll();

		List<Object> facts = new ArrayList<Object>();
		facts.addAll(IteratorUtils.toList(bookings.iterator()));
		facts.addAll(IteratorUtils.toList(venues.iterator()));
		return facts;
	}

	/**
	 * Returns the venue mentioned in the request and all bookings associated
	 * with that venue
	 * 
	 * @param request
	 * @return
	 */
	public List<Object> collectSingleVenueForSession(
			@Body BookingRequest request) {
		System.out.println("collect venue:" + request.getVenueName());
		System.out.println(venueRepo);
		List<Venue> venue = venueRepo.findByName(request.getVenueName());
		System.out.println(venue);
		List<Booking> bookings = bookingRepo.findByVenueName(request
				.getVenueName());

		List<Object> facts = new ArrayList<Object>();
		facts.addAll(venue);
		facts.addAll(bookings);
		facts.add(request);
		return facts;
	}

}
