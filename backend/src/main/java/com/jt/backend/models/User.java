package com.jt.backend.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
public class User {
	@Id
	@GeneratedValue
	@Getter
	@Setter
	private Long id;
	
	@Column
	@Getter
	@Setter
	private String name;
	
	@Column(unique=true, nullable=false)
	@Getter
	@Setter
	private String email;
	
	@Column
	@Getter
	@Setter
	private String passw;
	
	@Column
	@Getter
	@Setter
	// 0: usuario 
	// 1: admin
	private int profile; 	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "id")
	@Getter
	@Setter
    private List<Car> cars = new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "id")
	@Getter
	@Setter
    private List<RestrictionSchedule> restrictionSchedules = new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "id")
	@Getter
	@Setter
    private List<ExceptionSchedule> exceptionSchedules = new ArrayList<>();
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "id")
	@Getter
	@Setter
    private List<History> histories = new ArrayList<>();
	
}
