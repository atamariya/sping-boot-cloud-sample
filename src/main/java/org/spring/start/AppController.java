package org.spring.start;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

	@Autowired
	AppConfig config;
	
	@Autowired
	ExternalRESTService service;

	@RequestMapping("/")
	public String home() {
		return config.name;
	}

	@RequestMapping("/search/{param}")
	public String home1(@PathVariable String param) {
//		Properties p = config.cloud().getCloudProperties();
//		System.out.println(p);
		String name = service.search(param);
		return name;
	}
}