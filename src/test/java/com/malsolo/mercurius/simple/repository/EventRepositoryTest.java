package com.malsolo.mercurius.simple.repository;

import java.util.List;

import javax.transaction.Transactional;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.malsolo.mercurius.simple.MercuriusSimpleApplication;
import com.malsolo.mercurius.simple.domain.Event;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MercuriusSimpleApplication.class)
//@ContextConfiguration(classes = MercuriusSimpleApplication.class)
@Transactional
public class EventRepositoryTest {
	
	@Autowired
	EventRepositoryInitData initData;
	
	@Autowired
	EventRepository eventRepository;
	
	@Before
	public void populateDatabase() {
		initData.init();
	}
	
	@Test
	public void testMarkerMethod() {
	}
	
	@Test
	public void testFindAll() {
		List<Event> events = this.eventRepository.findAll();
		assertNotNull(events);
		assertTrue(events.size() > 0);
		assertEquals(3, events.size());
	}

}
