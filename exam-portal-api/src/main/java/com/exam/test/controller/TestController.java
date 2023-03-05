package com.exam.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@GetMapping("/hello/{name}")
	public String getHello(@PathVariable("name") String name) {
		System.out.println("Inside the get Hello Method");
		return "Hello Mr. " + name;
	}

}
