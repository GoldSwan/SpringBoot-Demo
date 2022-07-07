package com.swan.springbootdev.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {
	@GetMapping("/hello")
	public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
		return String.format("Hello %s!", name);
	}
}
