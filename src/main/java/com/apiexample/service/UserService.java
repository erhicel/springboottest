package com.apiexample.service;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.apiexample.converter.UserConverter;
import com.apiexample.model.api.UserApiResponse;

public class UserService {

	@Autowired
	private UserConverter userConverter;

	public List<UserApiResponse> postListUser() {
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<UserApiResponse[]> userResponseEntity = restTemplate
				.getForEntity(URI.create("https://reqres.in/api/users"), UserApiResponse[].class);
		List<UserApiResponse> userResponseList = Arrays.asList(userResponseEntity.getBody());
		return userConverter.convert(userResponseList);
	}

}
