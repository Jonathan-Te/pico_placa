package com.jt.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jt.backend.dto_models.CarDto;
import com.jt.backend.dto_models.UserDto;
import com.jt.backend.models.Car;
import com.jt.backend.models.InternalMessages;
import com.jt.backend.models.User;
import com.jt.backend.repositories.CarRepository;

@Service
public class CarServices {

	@Autowired
	private CarRepository carRepository;
	
	public InternalMessages addCar(CarDto carDto, User user) {
		
		Car car= new Car();
		car.setModel(carDto.getModel());
		car.setBrand(carDto.getBrand());
		car.setColour(carDto.getColour());
		car.setPlate(carDto.getPlate());
		car.setUser(user);
		
		try {
			this.carRepository.save(car);
			return new InternalMessages();
		}catch (Exception e) {
			return new InternalMessages(0,"Error",e.toString());
		}
	}
	
	public InternalMessages getCars(Long userId) {
		InternalMessages internalMessages = new InternalMessages();
				
		try {
			internalMessages.setAdditionalInfo(this.carRepository.findByUserId(userId));
			return internalMessages;
		}catch (Exception e) {
			return new InternalMessages(0,"Error",e.toString());
		}
	}
}
