package com.jt.backend.dto_models;


import lombok.Getter;
import lombok.Setter;

public class CarDto {
	
	@Getter
	@Setter
	private long id;
	
	@Getter
	@Setter
	private String model;
	
	@Getter
	@Setter
	private String brand;
	
	@Getter
	@Setter
	private String plate;
	
	@Getter
	@Setter
	private String colour;

}
