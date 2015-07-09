package com.rhc.lab.service.test;

import java.util.ArrayList;
import java.util.Collection;

import javax.annotation.Resource;

import org.apache.camel.EndpointInject;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.mock.MockEndpoint;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rhc.lab.dao.BookingRepository;
import com.rhc.lab.dao.VenueRepository;
import com.rhc.lab.domain.BookingRequest;
import com.rhc.lab.domain.PerformanceType;
import com.rhc.lab.domain.Performer;
import com.rhc.lab.domain.Venue;

/**
 * 
 * This class is an example Camel test showing mock endpoints and a Java DSL
 * mock route to process a message
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:camel-context.xml"})
@Profile("test")
public class RulesServiceTest {

	@EndpointInject(uri = "mock:end")
	protected MockEndpoint resultEndpoint;

	@Produce(uri = "direct:start")
	protected ProducerTemplate template;

	@Resource(name = "bookingDao")
	BookingRepository bookingRepo;
	@Resource(name = "venueDao")
	VenueRepository venueRepo;

	private Performer performer;

	@Before
	public void setUp() {
		venueRepo.deleteAll();
		Venue venue = new Venue();
		venue.setId("1");
		venue.setName("boo");
		venueRepo.save(venue);

		bookingRepo.deleteAll();

		performer = new Performer();
		performer.setName("Bob");
		performer.setType(PerformanceType.COMIC);
	}
	@Test
	public void testSendingBookingRequest() throws InterruptedException {
		BookingRequest booking = new BookingRequest();
		booking.setVenueName("boo");
		booking.setPerformer(performer);
		System.out.println("testing");
		resultEndpoint.expectedBodiesReceived(booking);
		Collection<Object> facts = new ArrayList<Object>();
		facts.add(booking);
		template.sendBody(booking);
		resultEndpoint.getReceivedExchanges();
		// TODO : add real tests once rules run.
		// resultEndpoint.assertIsSatisfied();
	}

}
