package com.rhc.lab.test.json;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import org.joda.time.DateTime;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import com.rhc.lab.domain.BookingRequest;
import com.rhc.lab.domain.Performance;
import com.rhc.lab.domain.PerformanceType;
import com.rhc.lab.domain.Venue;

/**
 * 
 * This JUnit test class tests Jackson mapping of JSON to and from the Java
 * domain model
 * 
 */
public class JsonPayloadTest {

	@Test
	public void shouldMarshalAndUnmarshalJson() throws IOException {
		ObjectMapper om = new ObjectMapper();
		om.registerModule(new JodaModule());

		BookingRequest request = new BookingRequest();
		Performance performance1 = new Performance();
		Performance performance2 = new Performance();
		Venue venue = new Venue();

		venue.setName("Brooklyn Bowl");
		venue.setCity("Brooklyn");
		venue.setCapacity(8000);
		venue.setAccomodations(new ArrayList<PerformanceType>(Arrays.asList(
				PerformanceType.BAND, PerformanceType.ORCHESTRA,
				PerformanceType.RALLY)));
		performance1.setName("Foo Fighters");
		performance1.setType(PerformanceType.BAND);
		performance2.setName("Brooklyn Symphony Orchestra");
		performance2.setType(PerformanceType.ORCHESTRA);

		request.setVenue(venue);
		DateTime d1 = DateTime.now();
		DateTime d2 = DateTime.now().plusHours(4);
		request.setOpen(d1);
		request.setClose(d2);
		request.getPerformances().add(performance1);
		request.getPerformances().add(performance2);

		String requestString = om.writer().writeValueAsString(request);

		assertNotNull(requestString);
		System.out.println(om.writerWithDefaultPrettyPrinter()
				.writeValueAsString(request));

		BookingRequest r = om.readValue(requestString, BookingRequest.class);
		assertNotNull(r.getOpen());
		assertNotNull(r.getClose());
		for (Performance p : r.getPerformances()) {
			assertNotNull(p.getName(), p.getType());
			if (p.getName().equals("Foo Fighters")) {
				assertEquals(PerformanceType.BAND, p.getType());
			} else if (p.getName().equals("Brooklyn Symphony Orchestra")) {
				assertEquals(PerformanceType.ORCHESTRA, p.getType());
			}
		}
	}

}
