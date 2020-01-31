package io.kubeless;

import io.kubeless.Event;
import io.kubeless.Context;


public class ReverseService {
    
    public String reverseStr(Event event, Context context) {
       System.out.println(event.Data);

       return "wolleH";
    }
}
