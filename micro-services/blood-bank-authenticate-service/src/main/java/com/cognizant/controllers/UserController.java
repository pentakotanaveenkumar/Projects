package com.cognizant.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.exception.UserAlreadyExistsException;
import com.cognizant.model.User;
import com.cognizant.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping
	public void signUp(@RequestBody @Valid User user) throws UserAlreadyExistsException {
		userService.signUp(user);
	}

	@GetMapping("/{username}")
	public User getUser(@PathVariable String username) {
		return userService.getuserDetails(username);
	}
}
