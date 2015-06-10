package com.rhc.lab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * This class is the home controller for lab web application.
 * 
 */
@Controller
@RequestMapping("/")
public class LabController {

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView printHello(ModelMap model) {
		return new ModelAndView("index", "message", "Hello World");
	}

}
