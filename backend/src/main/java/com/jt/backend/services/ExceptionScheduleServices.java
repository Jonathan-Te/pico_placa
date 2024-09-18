package com.jt.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jt.backend.dto_models.ExceptionDto;
import com.jt.backend.dto_models.RestrictionDto;
import com.jt.backend.models.ExceptionSchedule;
import com.jt.backend.models.InternalMessages;
import com.jt.backend.models.RestrictionSchedule;
import com.jt.backend.models.User;
import com.jt.backend.repositories.ExceptionScheduleRepository;

@Service
public class ExceptionScheduleServices {
	
	@Autowired
	private ExceptionScheduleRepository exceptionScheduleRepository;
	
	public InternalMessages createExceptionSchedule(ExceptionDto exceptionDto, User user) {
		ExceptionSchedule exceptionSchedule= new ExceptionSchedule();
		exceptionSchedule.setDescription(exceptionDto.getDescription());
		exceptionSchedule.setStartTime(exceptionDto.getStartTime());
		exceptionSchedule.setEndTime(exceptionDto.getEndTime());
		exceptionSchedule.setApplicationDate(exceptionDto.getApplicationDate());
		exceptionSchedule.setApplicationDays(exceptionDto.getApplicationDays());
		exceptionSchedule.setLastDigitPlates(exceptionDto.getLastDigitPlates());
		exceptionSchedule.setUser(user);
		
		try {
			this.exceptionScheduleRepository.save(exceptionSchedule);
			return new InternalMessages();
		}catch(Exception e) {
			
			return new InternalMessages(0,"Error",e.toString());
		}
	}
	
	public InternalMessages getExceptionSchedule() {
		InternalMessages internalMessages =new InternalMessages();
		try {
			internalMessages.setAdditionalInfo(this.exceptionScheduleRepository.findAll());
			return internalMessages;
		}catch(Exception e) {
			
			return new InternalMessages(0,"Error",e.toString());
		}
		
	}
public InternalMessages deleteExceptionSchedule(Long id) {
		
		try {
			this.exceptionScheduleRepository.deleteById(id);
			return new InternalMessages();
		}catch(Exception e) {
			
			return new InternalMessages(0,"Error",e.toString());
		}
		
	}
}
