package com.jt.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jt.backend.dto_models.UserDto;
import com.jt.backend.models.InternalMessages;
import com.jt.backend.models.User;
import com.jt.backend.repositories.UserRepository;

@Service
public class UserServices {
	
	@Autowired
	private UserRepository userRepository;
	
	public InternalMessages signUpProcess(UserDto userDto) {
		
		User user=new User();
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassw(userDto.getPassw());
		user.setProfile(userDto.getProfile());
		
		try {
			this.userRepository.save(user);
			return new InternalMessages();
		}catch(Exception e) {
			
			return new InternalMessages(0,"Error",e.toString());
		}
		
	}
}
