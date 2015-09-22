package com.malsolo.mercurius.simple.web;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.malsolo.mercurius.simple.application.EventManager;
import com.malsolo.mercurius.simple.domain.Event;

@RestController
@RequestMapping("/events")
public class EventController {
	
	private final EventManager eventManager;

	@Autowired
	public EventController(EventManager eventManager) {
		this.eventManager = eventManager;
	}

	@RequestMapping(method = POST)
	public Event create(@Valid Event event) {
		return this.eventManager.createEvent(event);
	}
	
	@RequestMapping(method = GET)
	public List<Event> events() {
		return this.eventManager.showAllEvents();
	}
}
