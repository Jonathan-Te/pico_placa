package com.jt.backend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
public class History {
	
	@Id
	@GeneratedValue
	@Getter
	@Setter
	private Long id;
	
	@Column
	@Getter
	@Setter
	private String queryDate;
	
	@Column
	@Getter
	@Setter
	private String queriedDate;
	
	@Column
	@Getter
	@Setter
	private boolean allowed;
	
	@Column
	@Getter
	@Setter
	private String plate;
	
}
