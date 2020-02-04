package io.kubeless;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

public class PrintTemperature {
	Logger logger = Logger.getLogger(PrintTemperature.class);

	private final static Integer DEFAULT_THREAD_COUNT = 10;
	private final static Integer DEFAULT_NUMBER_OF_CALLS = 10;
	private final static String DEFAULT_URL = "http://getTemp/getTemp";

	private final static String KEY_PARALLEL_THREAD = "parallel";
	private final static String KEY_NUMBER_OF_CALLS = "callCount";
	private final static String KEY_URL = "url";

	public String getTemp(Event event, Context context) {
		logger.info("From Event Data--> " + event.Data);

		try {
			Gson gson = new Gson();
			if (null != event.Data && event.Data.trim().length() > 0) {
				Map<String, String> inputMap = gson.fromJson(event.Data, Map.class);
				logger.info("Json map " + inputMap);

				Integer parallelCount = Integer
						.valueOf(Objects.toString(inputMap.get(KEY_PARALLEL_THREAD), DEFAULT_THREAD_COUNT.toString()));
				Integer numberOfCalls = Integer.valueOf(
						Objects.toString(inputMap.get(KEY_NUMBER_OF_CALLS), DEFAULT_NUMBER_OF_CALLS.toString()));
				final String url = Objects.toString(inputMap.get(KEY_URL), DEFAULT_URL);

				final RestTemplate restTemplate = new RestTemplate();
				
				logger.info("Number of calls to API=" + numberOfCalls);
				
				
				ExecutorService exec = Executors.newFixedThreadPool(parallelCount);
				try {
					for(int current=0 ; current < numberOfCalls;current++){
						final Integer innerMi = new Integer(current);
				        exec.submit(new Runnable() {
				        	
				            @Override
				            public void run() {
				            	callApi(innerMi, restTemplate, url);
				            }
				        });
				    }
				} finally {
				    exec.shutdown();
				}
				
				
				logger.info("After Join");
			}
		} catch (Exception e) {
			logger.error("Error while getting temperature", e);
			return "FAILURE";
		}
		return "SUCCESS";
	}

	private ResponseEntity<String> callApi(int current, RestTemplate restTemplate, String url) {
		logger.info("Calling index= " + current);
		ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
		logger.info("Response index= " + current);
		return response;
	}
}
