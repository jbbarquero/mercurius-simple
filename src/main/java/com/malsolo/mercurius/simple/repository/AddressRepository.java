package com.malsolo.mercurius.simple.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.malsolo.mercurius.simple.domain.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
