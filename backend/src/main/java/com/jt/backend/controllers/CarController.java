package com.jt.backend.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jt.backend.dto_models.CarDto;
import com.jt.backend.dto_models.UserDto;

@RestController
@CrossOrigin(origins = "*")
public class CarController {
	
	@PostMapping("/car")
	public ResponseEntity<?> signUp(@RequestBody CarDto carDto){
		return ResponseEntity.ok(null);
	}
	
	@GetMapping("/car")
	public ResponseEntity<?> signUp(){
		return ResponseEntity.ok(null);
	}
	

}
