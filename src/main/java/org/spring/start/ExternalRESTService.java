package org.spring.start;

import org.springframework.web.client.RestTemplate;

public class ExternalRESTService {
    private RestTemplate restTemplate;
    private String baseUrl;

	public ExternalRESTService(RestTemplate restTemplate, String baseUrl) {
		super();
		this.restTemplate = restTemplate;
		this.baseUrl = baseUrl;
	}

	public String search(String str){
    	String zipcodesUrl = "/api/v1/messages/search?q=" + str;
		String result = restTemplate.getForObject(baseUrl + zipcodesUrl, String.class);
        return result;
    }
}
