package com.jt.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jt.backend.dto_models.RestrictionDto;
import com.jt.backend.models.InternalMessages;
import com.jt.backend.models.RestrictionSchedule;
import com.jt.backend.repositories.RestrictionScheduleRepository;

@Service
public class RestrictionScheduleServices {
	
	@Autowired
	private RestrictionScheduleRepository restrictionScheduleRepository;
	
	public InternalMessages createRestrictionSchedule(RestrictionDto restrictionDto) {
		
		RestrictionSchedule restrictionSchedule= new RestrictionSchedule();
		restrictionSchedule.setDescription(restrictionDto.getDescription());
		restrictionSchedule.setStartTime(restrictionDto.getStartTime());
		restrictionSchedule.setEndTime(restrictionDto.getEndTime());
		restrictionSchedule.setApplicationDate(restrictionDto.getApplicationDate());
		restrictionSchedule.setApplicationDays(restrictionDto.getApplicationDays());
		restrictionSchedule.setLastDigitPlates(restrictionDto.getLastDigitPlates());
		
		try {
			this.restrictionScheduleRepository.save(restrictionSchedule);
			return new InternalMessages();
		}catch(Exception e) {
			
			return new InternalMessages(0,"Error",e.toString());
		}
	}
}
