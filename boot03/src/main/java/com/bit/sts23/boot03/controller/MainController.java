package com.bit.sts23.boot03.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
public class MainController {
	
	@GetMapping("/")
	public String index() {
		return "rest api service";
	}
}
