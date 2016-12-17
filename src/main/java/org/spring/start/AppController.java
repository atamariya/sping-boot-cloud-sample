package org.spring.start;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

	@Autowired
	AppConfig config;
	
	@Autowired
	ExternalRESTService service;

	@RequestMapping("/")
	public String home1() {
//		Properties p = config.cloud().getCloudProperties();
//		System.out.println(p);
		String name = service.search("india");
		return name;
	}
}