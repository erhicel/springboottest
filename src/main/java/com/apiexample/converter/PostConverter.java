package com.apiexample.converter;

import org.springframework.stereotype.Component;

import com.apiexample.model.api.PostApiResponse;
import com.apiexample.model.extern.PostResponse;

@Component
public class PostConverter {

	public PostApiResponse convert(PostResponse weatherResponse) {
		PostApiResponse response = new PostApiResponse();
		response.setUpperName(weatherResponse.getTitle().toUpperCase());
		response.setUserId(weatherResponse.getUserId());
		response.setMessage(weatherResponse.getBody());
		return response;
	}

}
