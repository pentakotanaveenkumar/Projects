package com.cognizant.service;

import com.cognizant.exception.UserAlreadyExistsException;
import com.cognizant.model.User;

public interface UserService {
	public void signUp(User user) throws UserAlreadyExistsException;
	
	public User getuserDetails(String username);
}
