package com.malsolo.mercurius.simple.repository;

import org.springframework.stereotype.Component;

@Component
public class AddressRepositoryInitData extends AbstractInitData {

	@Override
	public String scriptName() {
		return "data_addresses.sql";
	}

}
