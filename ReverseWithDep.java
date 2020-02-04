package io.kubeless;

import io.kubeless.Event;

import java.util.Map;

import org.apache.log4j.Logger;

import com.google.gson.Gson;

import io.kubeless.Context;


public class ReverseWithDep {
	Logger logger = Logger.getLogger(ReverseWithDep.class);
    
    public String reverseStr(Event event, Context context) {
       logger.info("From Event Data--> " + event.Data);
	
        try {
        	Gson gson = new Gson();
        	Map<String, String> inputMap= gson.fromJson(event.Data, Map.class);
        	
        	logger.info("Json map " + inputMap);
        	logger.info("Sleeping for 2s");
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			System.out.println(e1);
		}
       return "wolleH";
    }
}
