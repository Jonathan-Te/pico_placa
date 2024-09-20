package com.jt.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jt.backend.dto_models.ConsultaDto;
import com.jt.backend.models.InternalMessages;
import com.jt.backend.services.ValidationServices;

import utils.SecurityUtils;

@RestController
@CrossOrigin("*")
public class ValidationController {



	private ValidationServices validationServices;

	@Autowired
	public ValidationController(ValidationServices validationServices) {
		this.validationServices=validationServices;
	}

	@PostMapping("/validar")
	public ResponseEntity<?> getValidation(@RequestBody ConsultaDto consultaDto ){

		InternalMessages internalMessages = this.validationServices.isAllowed(consultaDto, SecurityUtils.getCurrentUser());

		if (internalMessages.getId()==0) {
			return ResponseEntity.internalServerError().body(internalMessages.getMessage());
		}else {
			return ResponseEntity.ok().body(internalMessages.getMessage());     
		}
	}



}
