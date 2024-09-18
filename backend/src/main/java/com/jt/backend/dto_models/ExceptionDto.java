package com.jt.backend.dto_models;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

public class ExceptionDto {
		
		
		@Getter
		@Setter
		private Long id;
		
		@Getter
		@Setter
		private String description;
		
		@Getter
		@Setter
		private Double startTime;
		
		@Getter
		@Setter
		private Double endTime;
		
		@Getter
		@Setter
		private Date applicationDate;
		
		@Getter
		@Setter
		/* 1: Lunes
		 * 2: Martes
		 * 3: Miercoles
		 * 4: Jueves
		 * 5: Viernes
		 * 6: Sabado
		 * 0: Domingo*/
		private String applicationDays;
		
		@Getter
		@Setter
		private String lastDigitPlates;
}
