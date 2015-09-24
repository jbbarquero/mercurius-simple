package com.malsolo.mercurius.simple.application;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.malsolo.mercurius.simple.MercuriusSimpleApplication;
import com.malsolo.mercurius.simple.domain.Event;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=MercuriusSimpleApplication.class)
public class EventManagerSpringTest {
	
	@Autowired
	private EventManager eventManager;
	
	@Test
	public void testShowAllEvents() {
		List<Event> events = this.eventManager.showAllEvents();
		assertNotNull(events);
		assertTrue(events.size() > 0);
		assertEquals(3, events.size());
	}

}
