package com.rhc.lab.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.rhc.lab.domain.BookingRequest;
import com.rhc.lab.service.proxy.LabProxySender;

/**
 * 
 * This class is the home controller for lab web application.
 * 
 */
@Controller
@RequestMapping("/")
public class LabController {

	@Autowired
	protected LabProxySender labProxySender;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView printHello(ModelMap model) {
		labProxySender.submit(new BookingRequest());
		return new ModelAndView("index", "message", "Associate Consulting Bootcamp");
	}

	public void setSender(LabProxySender sender) {
		this.labProxySender = sender;
	}

}
