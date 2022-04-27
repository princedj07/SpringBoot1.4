package org.spring.boot.app.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@Value("${welcome.message}")
	private String welcomeMessage;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String helloWorld() {

		return welcomeMessage;
	}
	
	@GetMapping(value = "/home")
	public String getHome() {

		return "Welcome to Home!!";
	}

}
