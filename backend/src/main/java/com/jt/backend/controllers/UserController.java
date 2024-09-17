package com.jt.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jt.backend.dto_models.UserDto;
import com.jt.backend.models.InternalMessages;
import com.jt.backend.services.UserServices;

@RestController
@CrossOrigin(origins = "*")
public class UserController {
	
	
	private UserServices userServices;
	
	@Autowired
	public UserController(UserServices userServices) {
		this.userServices=userServices;
	}
	
	@PostMapping("/signup")
	public ResponseEntity<?> signUp(@RequestBody UserDto userDto){
		
		InternalMessages response = this.userServices.signUpProcess(userDto);
		if(response.getId()==0) {
			return ResponseEntity.internalServerError().body(response.getAdditionalInfo());
		}else
		return ResponseEntity.ok().body(response.getMessage());
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> logIn(@RequestBody UserDto userDto){
		InternalMessages response = this.userServices.logInProcess(userDto);
		if(response.getId()==0) {
			return ResponseEntity.internalServerError().body(response.getAdditionalInfo());
		}else
		return ResponseEntity.ok().body(response.getAdditionalInfo());
	}
	
}
