package com.malsolo.mercurius.simple.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.malsolo.mercurius.simple.domain.Type;

public interface TypeRepository extends JpaRepository<Type, Long> {

}
