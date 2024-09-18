package com.jt.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jt.backend.dto_models.ExceptionDto;
import com.jt.backend.models.InternalMessages;
import com.jt.backend.services.ExceptionScheduleServices;

import jakarta.websocket.server.PathParam;
import utils.SecurityUtils;

@RestController
@CrossOrigin(origins = "*")
public class ExceptionController {

	private ExceptionScheduleServices exceptionScheduleServices;
	
	@Autowired
	public ExceptionController(ExceptionScheduleServices exceptionScheduleServices) {
		this.exceptionScheduleServices=exceptionScheduleServices;
	}
	
	@PostMapping("/exception")
	public ResponseEntity<?> addException(@RequestBody ExceptionDto exceptionDto){
		
		InternalMessages response = this.exceptionScheduleServices.createExceptionSchedule(exceptionDto,SecurityUtils.getCurrentUser());
		if(response.getId()==0) {
			return ResponseEntity.internalServerError().body(response.getAdditionalInfo());
		}else
		return ResponseEntity.ok().body(response.getMessage());
	}
	
	@GetMapping("/exception")
	public ResponseEntity<?> getException(){
		
		InternalMessages response = this.exceptionScheduleServices.getExceptionSchedule();
		if(response.getId()==0) {
			return ResponseEntity.internalServerError().body(response.getAdditionalInfo());
		}else
		return ResponseEntity.ok().body(response.getAdditionalInfo());
	}
	
	@DeleteMapping("/exception")
	public ResponseEntity<?> deleteException(@RequestBody ExceptionDto exceptionDto){

		InternalMessages response = this.exceptionScheduleServices.deleteExceptionSchedule(exceptionDto.getId());
		if(response.getId()==0) {
			return ResponseEntity.internalServerError().body(response.getAdditionalInfo());
		}else
			return ResponseEntity.ok().body(response.getAdditionalInfo());
	}
}