package io.kubeless;

import io.kubeless.Event;
import java.util.Map;
import java.util.Random;

import org.apache.log4j.Logger;
import com.google.gson.Gson;
import io.kubeless.Context;

public class BusyTempService {
	Logger logger = Logger.getLogger(BusyTempService.class);

	public String getTemp(Event event, Context context) {
		logger.info("From Event Data--> " + event.Data);

		Gson gson = new Gson();
		Map<String, String> inputMap = gson.fromJson(event.Data, Map.class);

		logger.info("Json map " + inputMap);
		logger.info("Start time in millis: " + System.currentTimeMillis());
		long count = 0l;
		for (long x = 0; x < Integer.MAX_VALUE; x++) {
			count += 1;
		}
		
		int temp = new Random().ints(0, 100).findAny().getAsInt();
		logger.info("Temperature = " + temp);
		
		logger.info("End time in millis: " + System.currentTimeMillis());
		
		return String.valueOf(temp);
	}
}
