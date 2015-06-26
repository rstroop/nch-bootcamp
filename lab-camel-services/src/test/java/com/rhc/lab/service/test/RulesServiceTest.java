package com.rhc.lab.service.test;

import org.apache.camel.EndpointInject;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.apache.camel.test.spring.CamelSpringTestSupport;
import org.apache.camel.test.spring.CamelTestContextBootstrapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.BootstrapWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rhc.lab.domain.BookingRequest;

/**
 * 
 * This class is an example Camel test showing mock endpoints and a Java DSL
 * mock route to process a message
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:src/main/resources/camel-context.xml"})
public class RulesServiceTest extends CamelSpringTestSupport {

	@EndpointInject(uri = "mock:end")
	protected MockEndpoint resultEndpoint;

	@Produce(uri = "direct:execute-rules")
	protected ProducerTemplate template;

	@Test
	public void testSendingBookingRequest() throws InterruptedException {
		BookingRequest booking = new BookingRequest();
		resultEndpoint.expectedBodiesReceived(booking);
		template.sendBody(booking);
		// TODO : add real tests once rules run.
		resultEndpoint.assertIsSatisfied();
	}

	@Override
	protected AbstractApplicationContext createApplicationContext() {
		// TODO Auto-generated method stub
		return new ClassPathXmlApplicationContext(
				"classpath*:camel-context.xml");
	}

}
