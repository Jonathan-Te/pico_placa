package com.jt.backend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jt.backend.dto_models.CarDto;
import com.jt.backend.dto_models.UserDto;
import com.jt.backend.models.InternalMessages;
import com.jt.backend.services.CarServices;

import utils.SecurityUtils;

@RestController
@CrossOrigin(origins = "*")
public class CarController {
	
	private CarServices carServices;
	
	@Autowired
	public CarController(CarServices carServices) {
		this.carServices=carServices;
	}
	
	@PostMapping("/car")
	public ResponseEntity<?> addCar(@RequestBody CarDto carDto){
		
		InternalMessages response = this.carServices.addCar(carDto,SecurityUtils.getCurrentUser());
		
		if (response.getId()==0) {
			return ResponseEntity.internalServerError().body(response.getMessage());
		}else {
			return ResponseEntity.ok().body(response.getMessage());     
		}
		
	}
	
	@GetMapping("/car")
	public ResponseEntity<?> getCars(){
		InternalMessages response = this.carServices.getCars(SecurityUtils.getCurrentUser().getId());
		
		if (response.getId()==0) {
			return ResponseEntity.internalServerError().body(response.getMessage());
		}else {
			try {
				//return ResponseEntity.ok().body(response.getAdditionalInfo());
				List parsedList = (List)(response.getAdditionalInfo()) ;
				return ResponseEntity.ok().body(parsedList);
			}catch (Exception e) {
				return ResponseEntity.ok().body(response.getAdditionalInfo().toString());
			}
			  
		}
	}
	

}
