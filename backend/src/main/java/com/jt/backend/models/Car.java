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
public class Car {
	
	@Id
	@GeneratedValue
	@Getter
	@Setter
	private long id;
	
	@Column
	@Getter
	@Setter
	private String model;
	
	@Column
	@Getter
	@Setter
	private String brand;
	
	@Column
	@Getter
	@Setter
	private String plate;
	
	@Column
	@Getter
	@Setter
	private String colour;
	
	@OneToMany(cascade = CascadeType.ALL)
	@Getter
	@Setter
    private List<History> histories = new ArrayList<>();
}
