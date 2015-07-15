package com.rhc.lab.test.cucumber;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.test.context.ContextConfiguration;

import com.rhc.lab.domain.Booking;
import com.rhc.lab.domain.BookingRequest;
import com.rhc.lab.domain.PerformanceType;
import com.rhc.lab.domain.Performer;
import com.rhc.lab.domain.Venue;
import com.rhc.lab.kie.api.StatelessDecisionService;
import com.rhc.lab.test.repository.BookingCucumberRepository;
import com.rhc.lab.test.repository.VenueCucumberRepository;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.*;

// import com.rhc.lab.controller.LabController;

@ContextConfiguration("classpath:cucumber.xml")
public class BaseSteps {
	@Resource(name = "localDecisionServiceBean")
	private StatelessDecisionService decisionService;
	private VenueCucumberRepository venueRepo = new VenueCucumberRepository();
	private BookingCucumberRepository bookingRepo = new BookingCucumberRepository();

	private Venue venue = new Venue();
	private Booking booking = new Booking();
	
	private BookingRequest request = new BookingRequest();
	private List<Object> facts;

	@Given("^a venue \"(.*?)\" with an occupancy of \"(.*?)\"$")
	public void a_venue_with_an_occupancy_of(String venueName, String occupancy)
			throws Throwable {
		// Set properties regarding venueName/occupancy
		venue.setName(venueName);
		venue.setCapacity(Integer.parseInt(occupancy));

//		// (Test repo-maps) Add venue to venueRepo
//		if (venueRepo.findByName(venueName).isEmpty()) {
//			venueRepo.save(venue);
//		}
		
		request.setVenueName(venueName);
		System.out.println("Given step: " + venueName + " " + occupancy);
	}

	@And("^the venue accomodates performances by a \"(.*?)\", \"(.*?)\"$")
	public void the_venue_accomodates_performances_by_a(String artistType1,
			String artistType2) throws Throwable {
		// Set properties regarding allowed performances
		ArrayList<PerformanceType> accomodations = new ArrayList<PerformanceType>();
		accomodations.add(PerformanceType.valueOf(artistType1.toUpperCase()));
		accomodations.add(PerformanceType.valueOf(artistType2.toUpperCase()));
		venue.setAccomodations(accomodations);
		
		System.out.println("And first step: " + artistType1 + " " + artistType2);
	}

	@And("^a request for a \"(.*?)\" performance by \"(.*?)\"$")
	public void a_request_for_a_performance_by(String type, String artistName)
			throws Throwable {
		// Set properties regarding performance requests
		Performer performer = new Performer();
		performer.setName(artistName);
		try {
			performer.setType(PerformanceType.valueOf(type.toUpperCase()));
		}
		catch (Exception e) {
			throw new Exception("Type '"+type+"' does not exist");
		}
		request.setPerformer(performer);
		
//		// (Test repo-maps) Add booking to bookingRepo
//		booking.setPerformer(performer);
//		booking.setVenueName(venue.getName());
//		bookingRepo.save(booking);
//		
		System.out.println("And second step: " + type + " " + artistName);
	}

	@When("^validating the booking$")
	public void validating_the_booking() throws Throwable {
		// Run rules
		facts = new ArrayList<Object>();
		facts.add(request);
		decisionService.execute(facts);
		
		System.out.println("When step");
	}

	@Then("^the booking should be \"(.*?)\"$")
	public void the_booking_should_be(String bookingStatus) throws Throwable {
		// Match bookingStatus from results
		
//		// (Test repo-maps) Validate accomodations 
//		for (PerformanceType type : venueRepo.findByName(venue.getName()).get(0).getAccomodations()) {
//			if (type.equals(booking.getPerformer().getType())) {
//				assert(true);
//				return
//			}
//		}
//		assert(false);
		
		System.out.println("Then step: " + bookingStatus);
	}

}