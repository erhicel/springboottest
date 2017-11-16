package com.apiexample.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.apiexample.model.api.UserApi;
import com.apiexample.model.api.UserApiResponse;
import com.apiexample.model.extern.User;
import com.apiexample.model.extern.UserResponse;

@Component
public class UserConverter {

	public UserResponse convertToUserResponse(UserApiResponse userApiResponse) {
		UserResponse response = new UserResponse();

		response.setUserList(converToUserList(userApiResponse.getData()));

		return response;
	}

	private List<User> converToUserList(List<UserApi> userApiResponseList) {
		User user = new User();
		List<User> listUserResponse = new ArrayList<User>();

		for (UserApi userApi : userApiResponseList) {

			user.setFullName(convertToFullName(userApi));
			user.setControlNumber(convertToControlNumber(userApi));
			user.setAvatar(userApi.getAvatar());
			listUserResponse.add(user);
		}

		return listUserResponse;

	}

	private Long convertToControlNumber(UserApi userApi) {

		Long firstNumber = userApi.getid();
		String[] sentences = userApi.getAvatar().split(".");
		Long secondNumber = Long.valueOf(sentences[2].substring(sentences[2].length() - 4, sentences[2].length() - 1));
		return firstNumber + secondNumber;
	}

	private String convertToFullName(UserApi userApi) {

		return userApi.getFirst_name() + " " + userApi.getLast_name();

	}

}
