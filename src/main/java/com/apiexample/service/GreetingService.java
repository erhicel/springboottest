package com.apiexample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apiexample.converter.GreetingConverter;

@Service
public class GreetingService {

	@Autowired
	public GreetingConverter greetingConverter;

	public String showMessage(String name) {

		return greetingConverter.messageToUppercase(name);
	}
}
