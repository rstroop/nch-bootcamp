package com.rhc.lab.drools;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.rhc.lab.domain.BookingRequest;
import com.rhc.lab.kie.api.StatelessDecisionService;
import com.rhc.lab.kie.service.impl.LocalStatelessDecisionService;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations= {"classpath:kie-context.xml"} )
public class DroolsTest {
	// TODO: Figured out why junit is angry here
	// @Resource(name ="localDecisionService")
	private StatelessDecisionService decisionService;

	@Ignore
	@Test
	public void shouldAutowireDecisionService() {
		Assert.assertNotNull(decisionService);
	}

	@Test
	public void runRules() {

		BookingRequest request = new BookingRequest();

		LocalStatelessDecisionService service = new LocalStatelessDecisionService(
				"kbase");

		List<Object> facts = new ArrayList<Object>();
		facts.add(request);

		service.execute(facts);

	}

}
