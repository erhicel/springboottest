package com.apiexample.service;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.apiexample.converter.UserConverter;
import com.apiexample.model.api.UserApiResponse;
import com.apiexample.model.extern.UserResponse;

@Service
public class UserService {

	@Autowired
	private UserConverter userConverter;

	public UserResponse userListUser() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<UserApiResponse> userResponseEntity = restTemplate
				.getForEntity(URI.create("https://reqres.in/api/users"), UserApiResponse.class);
		UserApiResponse userApiResponse = userResponseEntity.getBody();
		return userConverter.convertToUserResponse(userApiResponse);
	}

}
