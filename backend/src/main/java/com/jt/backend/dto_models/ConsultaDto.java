package com.jt.backend.dto_models;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConsultaDto {
	
	@Getter
	@Setter
	private Long id;
	
	@Getter
	@Setter
	private Date queryDate;
	
	@Getter
	@Setter
	private Date queriedDate;
	
	
	
	@Getter
	@Setter
	private String plate;

	
}
