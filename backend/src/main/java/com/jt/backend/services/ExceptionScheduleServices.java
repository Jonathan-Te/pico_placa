package com.jt.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jt.backend.dto_models.RestrictionDto;
import com.jt.backend.models.ExceptionSchedule;
import com.jt.backend.models.InternalMessages;
import com.jt.backend.models.RestrictionSchedule;
import com.jt.backend.repositories.ExceptionScheduleRepository;

@Service
public class ExceptionScheduleServices {
	
	@Autowired
	private ExceptionScheduleRepository exceptionScheduleRepository;
	
	public InternalMessages createExceptionSchedule(RestrictionDto restrictionDto) {
		ExceptionSchedule exceptionSchedule= new ExceptionSchedule();
		exceptionSchedule.setDescription(restrictionDto.getDescription());
		exceptionSchedule.setStartTime(restrictionDto.getStartTime());
		exceptionSchedule.setEndTime(restrictionDto.getEndTime());
		exceptionSchedule.setApplicationDate(restrictionDto.getApplicationDate());
		exceptionSchedule.setApplicationDays(restrictionDto.getApplicationDays());
		exceptionSchedule.setLastDigitPlates(restrictionDto.getLastDigitPlates());
		
		try {
			this.exceptionScheduleRepository.save(exceptionSchedule);
			return new InternalMessages();
		}catch(Exception e) {
			
			return new InternalMessages(0,"Error",e.toString());
		}
	}
}
