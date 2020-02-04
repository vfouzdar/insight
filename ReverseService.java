package io.kubeless;

import io.kubeless.Event;
import io.kubeless.Context;
//import org.apache.log4j.Logger;


public class ReverseService {
//Logger logger = Logger.getLogger(ReverseService.class.getName());
    
    public String reverseStr(Event event, Context context) {
       System.out.println("Event Data--> " + event.Data);
       //logger.info("From Event Data--> " + event.Data);
	//System.out.println("Request Data--> " + event.extensions.request);
        try {
            System.out.println("Sleeping for 2s");
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			System.out.println(e1);
		}
       return "wolleH";
    }
}
