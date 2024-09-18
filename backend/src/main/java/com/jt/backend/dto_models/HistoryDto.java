package com.jt.backend.dto_models;

import lombok.Getter;
import lombok.Setter;


public class HistoryDto {
	

	@Getter
	@Setter
	private Long id;
	
	@Getter
	@Setter
	private String queryDate;
	

	@Getter
	@Setter
	private String queriedDate;
	

	@Getter
	@Setter
	private boolean allowed;
	

	@Getter
	@Setter
	private String plate;
	

	
}
