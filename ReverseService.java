package io.kubeless;

import io.kubeless.Event;
import io.kubeless.Context;


public class ReverseService {
    
    public String reverseStr(Event event, Context context) {
       System.out.println("Event Data--> " + event.Data);
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
