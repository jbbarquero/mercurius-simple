package com.malsolo.mercurius.simple.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Data
public class Notification {

	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "TYPE_ID", nullable = false)
	private Type type;

	private Long idEvent;

	@NotNull
	private Date creationDate;
	
	@Size(max = 100)
	private String idMessage;
	
}
