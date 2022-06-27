package com.bit.sts29.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	@Autowired
	PasswordEncoder passwordEncoder;
	
	
	@RequestMapping("/home")
	public String page1() {
		String msg = "abcd";
		String msg1 = passwordEncoder.encode(msg);
		String msg2 = passwordEncoder.encode(msg);
		String msg3 = passwordEncoder.encode(msg);
		
		System.out.println(msg);
		System.out.println(msg1);		
		System.out.println(msg2);		
		System.out.println(msg3);		
		System.out.println(passwordEncoder.encode(msg));		
		System.out.println(passwordEncoder.matches(msg,msg1));		
		System.out.println(passwordEncoder.matches(msg1,msg2));		
		System.out.println(passwordEncoder.matches(msg2,msg3));		
		return "home";
	}
	@RequestMapping("/")
	public String page2() {
		return "home";
	}
	@RequestMapping("/hello")
	public String page3() {
		return "hello";
	}
	@RequestMapping("/login")
	public String page4() {
		return "login";
	}
}
