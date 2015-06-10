package com.rhc.lab.service.test;

import org.apache.camel.EndpointInject;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Test;

public class RulesServiceTest extends CamelTestSupport {

	@EndpointInject(uri = "mock:result")
	protected MockEndpoint resultEndpoint;

	@Produce(uri = "direct:start")
	protected ProducerTemplate template;

	@Test
	public void testSendMatchingMessage() throws InterruptedException {
		String expectedBody = "{\"status\": \"CONFIRMED\"}";

		resultEndpoint.expectedBodiesReceived(expectedBody);

		template.sendBodyAndHeader(expectedBody, "foo", "bar");

		resultEndpoint.assertIsSatisfied();
	}

	@Test
	public void testSendNotMatchingMessage() throws InterruptedException {
		resultEndpoint.expectedMessageCount(0);

		template.sendBodyAndHeader("{\"status\": \"FAILED\"}", "foo",
				"notMatchedHeaderValue");

		resultEndpoint.assertIsSatisfied();
	}

	@Override
	protected RouteBuilder createRouteBuilder() {
		return new RouteBuilder() {
			public void configure() {
				from("direct:start").filter(header("foo").isEqualTo("bar")).to(
						"mock:result");
			}
		};
	}

}
