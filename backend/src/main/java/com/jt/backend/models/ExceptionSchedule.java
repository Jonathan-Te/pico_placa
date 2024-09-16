package com.jt.backend.models;

import java.util.ArrayList;
import java.util.Date;
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
public class ExceptionSchedule {
	
	@Id
	@GeneratedValue
	@Getter
	@Setter
	private Long id;
	
	@Column
	@Getter
	@Setter
	private String Description;
	
	@Column
	@Getter
	@Setter
	private Double StartTime;
	
	@Column
	@Getter
	@Setter
	private Double EndTime;
	
	@Column
	@Getter
	@Setter
	private Date ApplicationDate;
	
	@Column
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
	
	@Column
	@Getter
	@Setter
	private String LastDigitPlates;
	
	@OneToMany(cascade = CascadeType.ALL)
	@Getter
	@Setter
    private List<History> histories = new ArrayList<>();
	
}