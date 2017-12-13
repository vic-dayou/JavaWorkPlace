package com.feign.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

	@Autowired
	HelloService helloService;
	
	@RequestMapping(value = "/feign-consumer", method = RequestMethod.GET)
	public String helloConsumer(){
		return helloService.hello();
	}
	
	@RequestMapping(value = "/feign-consumer2", method =  RequestMethod.GET)
	public String helloConsumer2(){
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(helloService.hello()).append("\n");
		stringBuilder.append(helloService.hello("kjxz")).append("\n");
		stringBuilder.append(helloService.hello("kjxz",5)).append("\n");
		stringBuilder.append(helloService.hello(new User("keji", 5))).append("\n");
		return stringBuilder.toString();
	}
}
