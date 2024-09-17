package com.jt.backend.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
public class RestrictionSchedule {
	
	@Id
	@GeneratedValue
	@Getter
	@Setter
	private Long id;
	
	@Column
	@Getter
	@Setter
	private String description;
	
	@Column
	@Getter
	@Setter
	private Double startTime;
	
	@Column
	@Getter
	@Setter
	private Double endTime;
	
	@Column
	@Getter
	@Setter
	private Date applicationDate;
	
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
	private String applicationDays;
	
	@Column
	@Getter
	@Setter
	private String lastDigitPlates;
	
	@Getter
	@Setter
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id",nullable =false)
	@JsonIgnore
	private User user;
	
	@OneToMany(cascade = CascadeType.ALL)
	@Getter
	@Setter
    private List<History> histories = new ArrayList<>();
	
}
