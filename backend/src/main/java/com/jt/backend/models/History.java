package com.jt.backend.models;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
public class History {
	
	@Id
	@GeneratedValue
	@Getter
	@Setter
	private Long id;
	
	@Column
	@Getter
	@Setter
	private Date queryDate;
	
	@Column
	@Getter
	@Setter
	private Date queriedDate;
	
	@Column
	@Getter
	@Setter
	private boolean allowed;
	
	@Column
	@Getter
	@Setter
	private String plate;
	
	@Getter
	@Setter
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id",nullable =true)
	@JsonIgnore
	private User user;
	
	@Getter
	@Setter
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "car_id",nullable =true)
	private Car car;
	
	@Getter
	@Setter
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "restriction_schedule_id",nullable =true)
	private RestrictionSchedule restrictionSchedule;
	
	@Getter
	@Setter
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "exception_schedule_id",nullable =true)
	private ExceptionSchedule exceptionSchedule;
	
	
}
