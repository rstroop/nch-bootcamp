package com.rhc.lab.drools;

import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import com.rhc.lab.domain.BookingRequest;

public class DroolsTest {
	
	@Test
	public void runRules(){
		BookingRequest request = new BookingRequest();
		
		KieServices ks = KieServices.Factory.get();
		KieContainer kContainer = ks.getKieClasspathContainer();
		KieSession ksession = kContainer.newKieSession();
		
		ksession.insert(request);
		ksession.fireAllRules();
	}

}
