package com.cognizant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.exception.UserAlreadyExistsException;
import com.cognizant.model.User;
import com.cognizant.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	/* UserDao userDao; */
	AppUserDetailsService appUserDetailsService;
	
	@Autowired
	UserRepository userRepository;
	@Override
	public void signUp(User user) throws UserAlreadyExistsException {
		appUserDetailsService.signUp(user);
	}
	@Override
	public User getuserDetails(String username) {
		return userRepository.findbyUsername(username);
	}

}
