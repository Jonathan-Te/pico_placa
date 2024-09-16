package com.jt.backend.dto_models;


import lombok.Getter;
import lombok.Setter;

public class UserDto {


	@Getter
	@Setter
	private Long id;
	@Getter
	@Setter

	private String name;

	@Getter
	@Setter
	private String email;

	@Getter
	@Setter	
	private String passw;

	@Getter
	@Setter	
	private int profile; 

}
