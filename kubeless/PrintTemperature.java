package io.kubeless;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

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
				String url = Objects.toString(inputMap.get(KEY_URL), DEFAULT_URL);

				RestTemplate restTemplate = new RestTemplate();
				
				IntStream.range(0, numberOfCalls).parallel().forEach(current -> {
					callApi(current, restTemplate, url);
				});
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
