package com.malsolo.mercurius.simple.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.malsolo.mercurius.simple.domain.Event;

public interface EventRepository extends JpaRepository<Event, Long>{

}
