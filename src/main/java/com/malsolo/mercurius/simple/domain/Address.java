package com.malsolo.mercurius.simple.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Data
public class Address {

	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull
	@Size(max = 200)
	private String email;
}
