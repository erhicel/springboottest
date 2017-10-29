package com.apiexample.converter;

import org.springframework.stereotype.Component;

@Component
public class GreetingConverter {

	public String messageToUppercase(String name) {

		if (!name.isEmpty()) {
			name = name.toUpperCase();
		}

		return name;

	}

}
