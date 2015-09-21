package com.malsolo.mercurius.simple.application;

import java.util.List;

import org.springframework.stereotype.Service;

import com.malsolo.mercurius.simple.domain.Event;
import com.malsolo.mercurius.simple.repository.EventRepository;

@Service
public class EventManager {
	
	private final EventRepository eventRepository;

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
