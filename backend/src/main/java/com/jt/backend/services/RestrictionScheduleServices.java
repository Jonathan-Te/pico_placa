package com.jt.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jt.backend.dto_models.RestrictionDto;
import com.jt.backend.models.InternalMessages;
import com.jt.backend.models.RestrictionSchedule;
import com.jt.backend.models.User;
import com.jt.backend.repositories.RestrictionScheduleRepository;

@Service
public class RestrictionScheduleServices {
	
	@Autowired
	private RestrictionScheduleRepository restrictionScheduleRepository;
	
	public InternalMessages createRestrictionSchedule(RestrictionDto restrictionDto, User user) {
		
		RestrictionSchedule restrictionSchedule= new RestrictionSchedule();
		restrictionSchedule.setDescription(restrictionDto.getDescription());
		restrictionSchedule.setStartTime(restrictionDto.getStartTime());
		restrictionSchedule.setEndTime(restrictionDto.getEndTime());
		restrictionSchedule.setApplicationDate(restrictionDto.getApplicationDate());
		restrictionSchedule.setApplicationDays(restrictionDto.getApplicationDays());
		restrictionSchedule.setLastDigitPlates(restrictionDto.getLastDigitPlates());
		restrictionSchedule.setUser(user);
		
		try {
			this.restrictionScheduleRepository.save(restrictionSchedule);
			return new InternalMessages();
		}catch(Exception e) {
			
			return new InternalMessages(0,"Error",e.toString());
		}
	}
	
	public InternalMessages getRestrictionSchedule() {
		InternalMessages internalMessages =new InternalMessages();
		try {
			internalMessages.setAdditionalInfo(this.restrictionScheduleRepository.findAll());
			return internalMessages;
		}catch(Exception e) {
			
			return new InternalMessages(0,"Error",e.toString());
		}
		
	}
	
	public InternalMessages deleteRestrictionSchedule(Long id) {
		
		try {
			this.restrictionScheduleRepository.deleteById(id);
			return new InternalMessages();
		}catch(Exception e) {
			
			return new InternalMessages(0,"Error",e.toString());
		}
		
	}
	
}
