package com.apiexample.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apiexample.model.Greeting;
import com.apiexample.service.GreetingService;

@RestController
@RequestMapping(value = "/rest")
public class GreetingRest {

	@Autowired
	public GreetingService greetingService;

	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name) {
		Greeting greeting = new Greeting();
		greeting.setName(greetingService.showMessage(name));
		return greeting;
	}

}
