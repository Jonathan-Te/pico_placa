package com.jt.backend.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jt.backend.dto_models.RestrictionDto;


@RestController
@CrossOrigin(origins = "*")
public class RestrictionController {

	@PostMapping("/restriction")
	public ResponseEntity<?> signUp(@RequestBody RestrictionDto restrictionDto){
		
		
		return ResponseEntity.ok(null);
	}
}
