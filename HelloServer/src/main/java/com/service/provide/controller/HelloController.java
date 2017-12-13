package com.service.provide.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloController {

	@Autowired
	DiscoveryClient discoveryClient;
	
	@RequestMapping(value = "/hello1", method = RequestMethod.GET)
	public String hello(@RequestParam String name){
		return "hello " + name;
	}
	
	@RequestMapping(value = "/hello2", method = RequestMethod.GET)
	public User  hello(@RequestHeader String name, @RequestHeader Integer age){
		
		return new  User(name,age);
	}
	@RequestMapping(value = "/hello3", method=RequestMethod.POST)
	public String hello(@RequestBody User user){
		return "Hello "+ user.getName() + ", " +user.getAge(); 
	}
	
	@GetMapping("/hello")
	public String index() {
		String  service= "services: "+discoveryClient.getServices();
		System.out.println(service);
		return "Hello,World";
	}
}
