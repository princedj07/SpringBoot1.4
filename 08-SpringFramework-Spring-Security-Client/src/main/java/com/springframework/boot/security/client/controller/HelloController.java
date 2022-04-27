package com.springframework.boot.security.client.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping("/hello")
	public String helloController() {

		return "Welcme to Monsters World!!";
	}
}
