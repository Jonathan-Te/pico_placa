package com.jt.backend.models;

import lombok.Getter;
import lombok.Setter;

public class ValidationObject {
	
	@Getter
	@Setter
	private boolean restrictedBoolean;
	
	@Getter
	@Setter
	private RestrictionSchedule restriction;
	
	@Getter
	@Setter
	private boolean excentedBoolean;
	
	@Getter
	@Setter
	private ExceptionSchedule exception;

}
