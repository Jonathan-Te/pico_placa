package com.jt.backend.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jt.backend.dto_models.ConsultaDto;
import com.jt.backend.models.ExceptionSchedule;
import com.jt.backend.models.History;
import com.jt.backend.models.InternalMessages;
import com.jt.backend.models.RestrictionSchedule;
import com.jt.backend.models.User;
import com.jt.backend.models.ValidationObject;
import com.jt.backend.repositories.ExceptionScheduleRepository;
import com.jt.backend.repositories.HistoryRepository;
import com.jt.backend.repositories.RestrictionScheduleRepository;

import utils.DateUtils;
import utils.SecurityUtils;

@Service
public class ValidationServices {

	private ValidationObject validationObject = new ValidationObject();

	@Autowired
	public HistoryRepository historyRepository;

	@Autowired
	public ExceptionScheduleRepository exceptionScheduleRepository;

	@Autowired
	public RestrictionScheduleRepository restrictionScheduleRepository;

	public ValidationServices (HistoryRepository historyRepository,ExceptionScheduleRepository exceptionScheduleRepository, RestrictionScheduleRepository restrictionScheduleRepository){
		this.historyRepository= historyRepository;
		this.exceptionScheduleRepository=exceptionScheduleRepository;
		this.restrictionScheduleRepository=restrictionScheduleRepository;
	}

	public InternalMessages isAllowed (ConsultaDto consultaDto, User user) {
		History history= new History();
		history.setPlate(consultaDto.getPlate());
		history.setQueriedDate(consultaDto.getQueriedDate());
		history.setQueryDate(consultaDto.getQueryDate());
				
		InternalMessages internalMessages =new InternalMessages();
		List<RestrictionSchedule> restrictionScheduleList = new ArrayList<>();
		try {
			restrictionScheduleList=this.restrictionScheduleRepository.findAll();

		}catch(Exception e) {
			return new InternalMessages(0,"Error consultando las restricciones en la Base de datos",e.toString());
		}
		
		
		List<ExceptionSchedule> exceptionScheduleList = new ArrayList<>();
		try {
			exceptionScheduleList=this.exceptionScheduleRepository.findAll();

		}catch(Exception e) {
			return new InternalMessages(0,"Error consultando las excepciones en la Base de datos",e.toString());
		}

		if(this.applyRestriction(consultaDto, restrictionScheduleList)){
			if(this.applyException(consultaDto, exceptionScheduleList)) {
				//puede circular aunque exista una restriccion
				if(SecurityUtils.isLogedBoolean()) {
					history.setUser(user);
					history.setAllowed(true);
					historyRepository.save(history);
				}
				return new InternalMessages(1,"Se puede cirular",this.validationObject);
			}else {
				//no puede circular existe una restriccion y no exciste una excepcion
				if(SecurityUtils.isLogedBoolean()) {
					history.setUser(user);
					history.setAllowed(false);
					historyRepository.save(history);
				}
				return new InternalMessages(1,"No puede cirular",this.validationObject);
			}
		}else {
			//no existe restricciones
			if(SecurityUtils.isLogedBoolean()) {
				history.setUser(user);
				history.setAllowed(true);
				historyRepository.save(history);
			}
			return new InternalMessages(1,"Se puede cirular",this.validationObject);
			
		}
	}



	private boolean applyRestriction(ConsultaDto consultaDto, List<RestrictionSchedule> restrictionScheduleList) {
		
		

		List<RestrictionSchedule> datesWithRestritionsList= restrictionScheduleList.stream().filter(restrictionScheduleItem->DateUtils.compareTwoDates(consultaDto.getQueriedDate(),restrictionScheduleItem.getApplicationDate())).toList();

		for (RestrictionSchedule dateWithRestrition : datesWithRestritionsList) {
			if (DateUtils.isBetween(consultaDto.getQueriedDate(), dateWithRestrition.getStartTime(), dateWithRestrition.getEndTime())) {
				if(dateWithRestrition.getLastDigitPlates().contains(consultaDto.getPlate().substring(consultaDto.getPlate().length()-1))) {
					validationObject.setRestrictedBoolean(true);
					validationObject.setRestriction(dateWithRestrition);
					return true;
				}

			}
		}

		List<RestrictionSchedule> daysWithRestritionsList=restrictionScheduleList.stream().filter(restrictionScheduleItem->DateUtils.compareTwoDays(consultaDto.getQueriedDate(),restrictionScheduleItem.getApplicationDays())).toList();

		for (RestrictionSchedule dayWithRestrition : daysWithRestritionsList) {
			if (DateUtils.isBetween(consultaDto.getQueriedDate(), dayWithRestrition.getStartTime(), dayWithRestrition.getEndTime())) {
				if(dayWithRestrition.getLastDigitPlates().contains(consultaDto.getPlate().substring(consultaDto.getPlate().length()-1))) {
					validationObject.setRestrictedBoolean(true);
					validationObject.setRestriction(dayWithRestrition);
					return true;
				}
			}
		}
		validationObject.setRestrictedBoolean(false);
		return false;
	}
	
	private boolean applyException(ConsultaDto consultaDto, List<ExceptionSchedule> exceptionScheduleList) {


		List<ExceptionSchedule> datesWithExceptionList=exceptionScheduleList.stream().filter(exceptionScheduleItem->DateUtils.compareTwoDates(consultaDto.getQueriedDate(),exceptionScheduleItem.getApplicationDate())).toList();

		for (ExceptionSchedule dateWithException : datesWithExceptionList) {
			if (DateUtils.isBetween(consultaDto.getQueriedDate(), dateWithException.getStartTime(), dateWithException.getEndTime())) {
				if(dateWithException.getLastDigitPlates().contains(consultaDto.getPlate().substring(consultaDto.getPlate().length()-1))) {
					validationObject.setExcentedBoolean(true);
					validationObject.setException(dateWithException);
					
					return true;
				}

			}
		}

		List<ExceptionSchedule> daysWithExceptionList=exceptionScheduleList.stream().filter(ExceptionScheduleItem->DateUtils.compareTwoDays(consultaDto.getQueriedDate(),ExceptionScheduleItem.getApplicationDays())).toList();

		for (ExceptionSchedule dayWithException : daysWithExceptionList) {
			if (DateUtils.isBetween(consultaDto.getQueriedDate(), dayWithException.getStartTime(), dayWithException.getEndTime())) {
				if(dayWithException.getLastDigitPlates().contains(consultaDto.getPlate().substring(consultaDto.getPlate().length()-1))) {
					validationObject.setExcentedBoolean(true);
					validationObject.setException(dayWithException);
					return false;
				}
			}
		}
		validationObject.setExcentedBoolean(false);
		return false;
	}
	
}
