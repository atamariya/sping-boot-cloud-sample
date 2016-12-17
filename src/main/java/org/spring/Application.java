package org.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.java.AbstractCloudConfig;

@SpringBootApplication
public class Application extends AbstractCloudConfig {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
