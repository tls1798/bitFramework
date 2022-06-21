package com.bit.sts23.boot04.controller;

import java.util.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

	@GetMapping("/")
	public String index() {
		return "<h1>Hello World</h1>";
	}
	
	@GetMapping("/api")
	public List<?> test1() {
		List<Map<String, Object>> list=new ArrayList<>();
		Map<String, Object> map = new LinkedHashMap<>();
		map.put("username", "tester");
		map.put("result", true);
		list.add(map);
		return list;
	}
	
	@GetMapping("/test")
	public String test2() {
		if(true) throw new IllegalArgumentException("에러발생");
		return "callErr";
	}
}
