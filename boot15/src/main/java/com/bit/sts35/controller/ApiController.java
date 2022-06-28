package com.bit.sts35.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bit.sts35.TokenServiceImpl;

@RestController
@RequestMapping("/api")
public class ApiController {
	@Autowired
	TokenServiceImpl tokenService;
	
	@PostMapping("/")
	public ResponseEntity<?> login(String name){
		// DB
//		return ResponseEntity.badRequest().build();
		// login -> token
		String token=tokenService.createToken(name, System.currentTimeMillis()+1000*60);
		return ResponseEntity.ok(token);
	}
	
	
	@GetMapping("/list")
	public ResponseEntity<?> getList(HttpServletRequest req){
		Map<String, Object> item1 = Map.of("sabun",1111,"ename","user1");
		Map<String, Object> item2 = Map.of("sabun",2222,"ename","user2");
		Map<String, Object> item3 = Map.of("sabun",3333,"ename","user3");
		List<Map<String,Object>> list = List.of(item1,item2,item3);
		
		String token = req.getHeader(HttpHeaders.AUTHORIZATION);
		if(tokenService.getTokenUser(token).equals("err")) {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
		}
		
		return ResponseEntity.ok(list);
		
		
	}
}
