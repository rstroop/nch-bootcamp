package com.rhc.lab.test.cucumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.ui.Model;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

// import com.rhc.lab.controller.LabController;

@ContextConfiguration("classpath:cucumber.xml")
public class BaseSteps {
	// @Autowired
	// private LabController labController;

	@Given("^a venue \"(.*?)\" with an occupancy of \"(.*?)\"$")
	public void a_venue_with_an_occupancy_of(String venueName, String occupancy)
			throws Throwable {
		// Set properties regarding venueName/occupancy
		// (Use MockMvc + appcontext)
		System.out.println("Given step: " + venueName + " " + occupancy);
	}

	@And("^the venue accomodates performances by a \"(.*?)\", \"(.*?)\"$")
	public void the_venue_accomodates_performances_by_a(String artistType1,
			String artistType2) throws Throwable {
		// Set properties regarding allowed performances
		System.out
				.println("And first step: " + artistType1 + " " + artistType2);
	}

	@And("^a request for a \"(.*?)\" performance by \"(.*?)\"$")
	public void a_request_for_a_performance_by(String type, String artistName)
			throws Throwable {
		// Set properties regarding performance requests
		System.out.println("And second step: " + type + " " + artistName);
	}

	@When("^validating the booking$")
	public void validating_the_booking() throws Throwable {
		// Validating process
		System.out.println("When step");
	}

	@Then("^the booking should be \"(.*?)\"$")
	public void the_booking_should_be(String bookingStatus) throws Throwable {
		// Match bookingStatus
		System.out.println("Then step: " + bookingStatus);
	}

	@Then("^template condition \"(.*?)\"$")
	public void template(String arg1) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
		throw new Exception();
	}

}