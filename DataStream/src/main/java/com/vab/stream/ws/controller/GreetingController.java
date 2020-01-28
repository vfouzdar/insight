package com.vab.stream.ws.controller;

import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	
	private static Log log = LogFactory.getLog(GreetingController.class);

	@RequestMapping("/greeting")
	public String greeting(@RequestParam(value = "name", defaultValue = "World") String name) throws UnknownHostException {		
		
		log.debug("Inside greeting controller");
		return new String(counter.incrementAndGet() + " - "+ String.format(template, name) +" from IP: " + Inet4Address.getLocalHost().getHostAddress());
	}
}