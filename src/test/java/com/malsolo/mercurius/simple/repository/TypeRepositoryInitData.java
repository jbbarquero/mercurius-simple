package com.malsolo.mercurius.simple.repository;

import org.springframework.stereotype.Component;

@Component
public class TypeRepositoryInitData extends AbstractInitData {

	@Override
	public String scriptName() {
		return "data_types.sql";
	}

}
