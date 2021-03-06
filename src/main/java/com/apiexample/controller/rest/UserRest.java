package com.apiexample.controller.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apiexample.model.extern.UserResponse;
import com.apiexample.service.UserService;

@RestController
@RequestMapping(value = "/rest")
public class UserRest {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserService userService;

	@GetMapping("/users")
	public UserResponse postListUser() {
		return userService.userListUser();
	}

}
