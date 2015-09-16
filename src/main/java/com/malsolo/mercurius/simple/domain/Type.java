package com.malsolo.mercurius.simple.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Data
public class Type {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@NotNull
	@Size(max = 50)
	private String name;

	@NotNull
	@Size(max = 150)
	private String description;
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(
		name = "TYPE_ADDRESS",
		joinColumns = @JoinColumn(name = "TYPE_ID"),
		inverseJoinColumns = @JoinColumn(name = "ADDRESS_ID")
	)
	private Set<Address> addresses = new HashSet<>();
}
