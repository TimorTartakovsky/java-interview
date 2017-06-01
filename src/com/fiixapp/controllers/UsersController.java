package com.fiixapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fiixapp.models.UserModel;
import com.fiixapp.service.user.UserService;

@RestController
public class UsersController {	
	

	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/userFind/{userId}", method = RequestMethod.GET)
	public String userFind(@PathVariable("userId") long userId) {
	 	UserModel userModel = userService.getUserById(userId);
	 	if(userModel != null)
	 	return String.format("User Details : %s", userModel.getUserDedails());
	 	return "User not exist";
	}
	
	
}
