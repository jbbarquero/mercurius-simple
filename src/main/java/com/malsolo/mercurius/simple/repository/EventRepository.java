package com.malsolo.mercurius.simple.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.malsolo.mercurius.simple.domain.Event;

public interface EventRepository extends JpaRepository<Event, Long> {
	
	public List<Event> findByIdType(Long idType);

}
