package com.rhc.lab.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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

	@Autowired
	protected LabProxySender labProxySender;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView printHello(ModelMap model) {
		labProxySender.submit(new BookingRequest());

		Venue v1 = new Venue();
		Venue v2 = new Venue();
		v1.setName("Madison Square garden");
		v2.setName("The Brooklyn Bowl");
		v1.setCapacity(11000);
		v2.setCapacity(8000);
		v1.setCity("New York City");
		v2.setCity("Brooklyn");
		v1.setAccomodations(new ArrayList<PerformanceType>(Arrays
				.asList(PerformanceType.BAND)));
		v2.setAccomodations(new ArrayList<PerformanceType>(Arrays
				.asList(PerformanceType.BAND)));

		List<Venue> venues = new ArrayList<Venue>(Arrays.asList(v1, v2));
		Collections.sort(venues);

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("message", "Associate Consultant Bootcamp");
		modelAndView.addObject("venues", venues);
		modelAndView.setViewName("index");

		return modelAndView;
	}

	@RequestMapping(value = "/bookingRequest", method = RequestMethod.GET)
	public String greetingForm(Model model) {
		model.addAttribute("bookingRequest", new BookingRequest());
		return "bookingRequest";
	}

	@RequestMapping(value = "/bookingRequest", method = RequestMethod.POST)
	public String greetingSubmit(@ModelAttribute BookingRequest bookingRequest,
			Model model) {
		model.addAttribute("bookingRequest", bookingRequest);
		return "result";
	}

}
