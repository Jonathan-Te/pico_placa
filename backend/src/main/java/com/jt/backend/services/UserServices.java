package com.jt.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jt.backend.dto_models.UserDto;
import com.jt.backend.models.InternalMessages;
import com.jt.backend.models.User;
import com.jt.backend.repositories.UserRepository;

import utils.SecurityUtils;

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


	public InternalMessages logInProcess(UserDto userDto) {
		InternalMessages internalMessages = new InternalMessages();
		try {
			List<User> userList = this.userRepository.findUserByEmailAndPassw(userDto.getEmail(), userDto.getPassw());
			if (userList.size()==1) {
				SecurityUtils.setCurrentUser(userList.get(0));
				internalMessages.setAdditionalInfo(userList.get(0));
				return internalMessages;
			}else {
				return new InternalMessages(0,"Error",null);
			}


		}catch(Exception e) {

			return new InternalMessages(0,"Error",e.toString());
		}

	}
}
