package com.bit.sts26.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.bit.sts26.domain.Emp;

@RestController
public class MainController {
	
	String apiPath="http://localhost:8070/api/emp";

	@GetMapping("/list")
	public ResponseEntity<String> list() throws URISyntaxException{
		URI url = new URI(apiPath);
		
		RestTemplate template = new RestTemplate();
		
		ResponseEntity<String> entity = template.exchange(url, HttpMethod.GET, null, String.class);
		return entity;
	}
	@GetMapping("/list/{num}")
	public ResponseEntity<?> One(@PathVariable int num) throws URISyntaxException{
		URI url = new URI(apiPath+"/"+num);
		
		RestTemplate template = new RestTemplate();
//		text/html
//		String result = template.getForObject(uri, String.class);
//		return ResponseEntity.ok(result);
//		application/json
//		ResponseEntity<?> result =  template.getForEntity(url, String.class);
//		return result;
		ResponseEntity<?> result = template.exchange(url, HttpMethod.GET, null, String.class);
		return result;
	}
	@PostMapping("/add")
	public ResponseEntity<?> add() throws URISyntaxException{
		URI url = new URI(apiPath);
		
		RestTemplate template= new RestTemplate();
		
//		LinkedMultiValueMap header = new LinkedMultiValueMap<>();
//		header .add("Content-Type", "application/json");
		
		HashMap<String, Object> params=new HashMap();
		params.put("ename", "test");
		params.put("pay", "1234");
		
		HttpHeaders headers=new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		 
//		HttpEntity entity=new HttpEntity<>(new Emp(0,1000,"test",null),headers);
//		HttpEntity entity=new HttpEntity<>(params,headers);
//		rereturn template.postForEntity(url, entity, String.class);
		
//		ResponseEntity<String> result = template.postForEntity(url, params, String.class);
//		return result;
//		String result = template.postForObject(url, params, String.class);
//		return ResponseEntity.ok(result);
		Map result = template.postForObject(url, params, Map.class);
		return ResponseEntity.ok(result);
	}
	
	@GetMapping("/update")
	public ResponseEntity<?> update() throws URISyntaxException{
		URI url = new URI(apiPath+"/"+1);
		RestTemplate template = new RestTemplate();
		
		Map<String, Object> params = new HashMap<>();
		params.put("sabun", 1);
		params.put("ename", "한글");
		params.put("pay", 1111);
		
		template.put(url, params);
//		jackson이 알아서 해줌?
		return null;
//		return ResponseEntity.ok(params);		
		
//		RequestEntity entity = new RequestEntity(params,HttpMethod.PUT,url);
//		template.exchange(url, HttpMethod.PUT, entity, String.class);
//		return ResponseEntity.ok(params);
//		ResponseEntity<String> result = template.exchange(url, HttpMethod.PUT, entity, String.class);
//		return result;
//		ResponseEntity<Void> result = template.exchange(url, HttpMethod.PUT, entity, Void.class);
//		return result;
	}
	
	@GetMapping("/delete/{sabun}")
	public ResponseEntity<?> delete(@PathVariable int sabun) throws URISyntaxException{
		URI url = new URI(apiPath+"/"+sabun);
		RestTemplate template=new RestTemplate();
		template.delete(url);
		return null;
	}
	
	@GetMapping("/head")
	public ResponseEntity<?> head() throws URISyntaxException{
		URI url = new URI("http://localhost:8070/api/");
		
//		Map<String, Object> header = new HashMap<>();
		MultiValueMap<String, String> header = new LinkedMultiValueMap<>();
		header.add("cors", "ABCD");
		
		RestTemplate template = new RestTemplate();
		
//		HttpEntity entity = new HttpEntity<>(null,header);
//		multivalue 집어넣으면 헤더, 아니면 바디
		HttpEntity entity = new HttpEntity<>(header);
		template.postForEntity(url, entity, null);
		return null;
	}
	
}
