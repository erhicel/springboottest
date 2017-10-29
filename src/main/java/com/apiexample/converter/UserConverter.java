package com.apiexample.converter;

import org.springframework.stereotype.Component;

import com.apiexample.model.api.UserApiResponse;

@Component
public class UserConverter {

	public convertToUserApiResponse convert(UserApiResponse userResponseList) {
		UserApiResponse response = new UserApiResponse();

		response.setdata(userResponseList);

		return response;
	}

}
