package com.vab.relay.controller;

import java.net.UnknownHostException;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RelayController {

	private static Log log = LogFactory.getLog(RelayController.class);
	
	@Autowired
	private RestTemplate restTemplate;
	

	@RequestMapping("/greeting")
	public String greeting(@RequestParam(value = "name", defaultValue = "World") String name) throws UnknownHostException {		
		
		log.debug("Inside Relay controller");
		
		String url = "http://datastream-service/greeting?name=From Relay";
		
		log.info("URL to call = " + url);
		
		String response = restTemplate.getForObject(url, String.class);
		
		log.info("Response from DataStream = " + Objects.toString(response, "NULL"));
		
		return response;
	}
	
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}
}