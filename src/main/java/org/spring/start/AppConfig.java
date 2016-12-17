package org.spring.start;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.config.java.AbstractCloudConfig;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig extends AbstractCloudConfig {
	/**
	 * config.name may be specified as env. variable, command line arg.
	 * (-Dconfig.name=) or application.properties
	 */
	@Value("${config.name}")
	String name = "World";
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

//	@Bean
//	public DataSource inventoryDataSource() {
//		return connectionFactory().dataSource("inventory-db-service");
//	}

	// @Bean
	// public MongoDbFactory documentMongoDbFactory() {
	// return connectionFactory().mongoDbFactory("document-service");
	// }
	//
	// // Generic service
	// @Bean
	// public Search search() {
	// return connectionFactory().service("search-service", Search.class);
	// }
	
	@Bean
	@RefreshScope
	public ExternalRESTService restServiceWithAuthentication(RestTemplate restTemplate,
			@Value("${rest.baseUrl}") String baseUrl, 
			@Value("${rest.username}") String username,
			@Value("${rest.password}") String password) {
		List<ClientHttpRequestInterceptor> interceptors = restTemplate.getInterceptors();
		interceptors.add(new BasicAuthorizationInterceptor(username, password));
		restTemplate.setInterceptors(interceptors);
		
		ExternalRESTService service = new ExternalRESTService(restTemplate, baseUrl);
		return service;
	}
}