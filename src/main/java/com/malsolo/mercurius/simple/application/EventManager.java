package com.malsolo.mercurius.simple.application;

import java.util.Date;
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
		Event eventToSave = new Event(null, newEvent.getIdType(),
				newEvent.getCode(), newEvent.getData(),
				newEvent.getCreationDate(), new Date(), null, 0);
		return this.eventRepository.save(eventToSave);
	}

	public List<Event> showAllEvents() {
		return this.eventRepository.findAll();
	}

}
