package com.malsolo.mercurius.simple.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.malsolo.mercurius.simple.domain.Event;
import com.malsolo.mercurius.simple.repository.EventRepository;

@Service
public class EventManager {
	
	private final EventRepository eventRepository;

	@Autowired
	public EventManager(EventRepository eventRepository) {
		this.eventRepository = eventRepository;
	}
	
	public Event createEvent(Event newEvent) {
		return this.eventRepository.save(newEvent);
	}
	
	public List<Event> showAllEvents() {
		return this.eventRepository.findAll();
	}
	

}
