package com.rhc.lab.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.rhc.lab.dao.BookingRepository;
import com.rhc.lab.dao.VenueRepository;
import com.rhc.lab.domain.Booking;
import com.rhc.lab.domain.BookingRequest;
import com.rhc.lab.domain.PerformanceType;
import com.rhc.lab.domain.Venue;
import com.rhc.lab.service.proxy.LabProxySender;

/**
 * 
 * This class is the home controller for lab web application.
 * 
 */
@Controller
public class LabController {

	@Resource(name = "venueDao")
	private VenueRepository venueDao;

	@Resource(name = "bookingDao")
	private BookingRepository bookingDao;

	@Resource(name = "labProxySender")
	private LabProxySender labProxySender;

	/**
	 * GET method for the Lab Homepage
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(ModelMap model) {

		// read all venues from venue repository
		List<Venue> venues = (List<Venue>) venueDao.findAll();
		Collections.sort(venues);

		// read all bookings from booking repository
		List<Booking> bookings = (List<Booking>) bookingDao.findAll();
		Collections.sort(bookings);

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("message", "Associate Consultant Bootcamp");
		modelAndView.addObject("venues", venues);
		modelAndView.addObject("bookings", bookings);
		modelAndView.setViewName("index");

		return modelAndView;
	}

	/**
	 * GET method for the Booking Request form
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/bookingRequest", method = RequestMethod.GET)
	public String newbookingRequest(Model model) {

		// populate venues to select from
		List<Venue> venues = (List<Venue>) venueDao.findAll();
		List<String> venueList = new ArrayList<String>();
		// populate performance types to select from
		List<PerformanceType> performanceTypes = new ArrayList<PerformanceType>(
				Arrays.asList(PerformanceType.values()));

		for (Venue venue : venues) {
			venueList.add(venue.getName());
		}

		Collections.sort(performanceTypes);

		model.addAttribute("performanceTypes", performanceTypes);
		model.addAttribute("venues", venueList);
		model.addAttribute("bookingRequest", new BookingRequest());
		return "bookingRequest";
	}

	/**
	 * POST method for the Booking Request form
	 * 
	 * @param bookingRequest
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/bookingRequest", method = RequestMethod.POST)
	public String submitBookingRequest(
			@ModelAttribute BookingRequest bookingRequest, Model model) {

		// labProxySender.submit(bookingRequest);

		bookingDao.save(new Booking(bookingRequest));
		return "redirect:" + "/";
	}

	/**
	 * GET method for the Venue form
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/venue", method = RequestMethod.GET)
	public String newVenue(Model model) {

		// populate performance types to select from
		List<PerformanceType> performanceTypes = new ArrayList<PerformanceType>(
				Arrays.asList(PerformanceType.values()));
		Collections.sort(performanceTypes);

		model.addAttribute("performanceTypes", performanceTypes);
		model.addAttribute("venue", new Venue());
		return "venue";
	}

	/**
	 * POST method for the Venue form
	 * 
	 * @param venue
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/venue", method = RequestMethod.POST)
	public String submitVenue(@ModelAttribute Venue venue, Model model) {
		venueDao.save(venue);

		model.addAttribute("venue", venue);
		return "redirect:" + "/";
	}

}
