package com.jt.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jt.backend.dto_models.RestrictionDto;
import com.jt.backend.models.InternalMessages;
import com.jt.backend.services.RestrictionScheduleServices;


@RestController
@CrossOrigin(origins = "*")
public class RestrictionController {

	private RestrictionScheduleServices restrictionScheduleServices;
	
	@Autowired
	public RestrictionController(RestrictionScheduleServices restrictionScheduleServices) {
		this.restrictionScheduleServices=restrictionScheduleServices;
	}
	
	@PostMapping("/restriction")
	public ResponseEntity<?> addRestriction(@RequestBody RestrictionDto restrictionDto){
		
		InternalMessages response = this.restrictionScheduleServices.createRestrictionSchedule(restrictionDto);
		if(response.getId()==0) {
			return ResponseEntity.internalServerError().body(response.getAdditionalInfo());
		}else
		return ResponseEntity.ok().body(response.getMessage());
	}
}
