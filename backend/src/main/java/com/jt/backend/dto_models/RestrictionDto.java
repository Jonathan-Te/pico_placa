package com.jt.backend.dto_models;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

public class RestrictionDto {
		
		
		@Getter
		@Setter
		private Long id;
		
		@Getter
		@Setter
		private String Description;
		
		@Getter
		@Setter
		private Double StartTime;
		
		@Getter
		@Setter
		private Double EndTime;
		
		@Getter
		@Setter
		private Date ApplicationDate;
		
		@Getter
		@Setter
		/* 0: Lunes
		 * 1: Martes
		 * 2: Miercoles
		 * 3: Jueves
		 * 4: Viernes
		 * 5: Sabado
		 * 6: Domingo*/
		private String ApplicationDays;
		
		@Getter
		@Setter
		private String LastDigitPlates;
}
