package com.ericsson.hargray;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Component
public class ExcelController implements CommandLineRunner {

	private final Logger logger = LoggerFactory.getLogger(ExcelController.class);

	@Value(value = "${excel.sourceFile.location}")
	private String sourceFileLocation;

	@Value(value = "${excel.sheet.name}")
	private String sheetName;
	
	@Value(value="${output.file.header}")
	private String headerRow;
	
	@Value(value = "${excel.sheet.csv.columnIndex}")
	private String csvColIndexToRead;
	
	@Value(value = "${excel.sheet.columnIndex.userStory}")
	private String csvColIndexUserStory;
	
	@Value(value = "${excel.userstory.separator}")
	private String splitRegex;

	@Value(value = "${excel.jira.issues.apiurl}")
	private String jiraIssueUrl;
	
	@Value(value = "${excel.jira.issues.browseurl}")
	private String jiraBrowseUrl;

	@Value(value = "${excel.jira.username}")
	private String jiraUsername;

	@Value(value = "${excel.jira.password}")
	private String jiraPassword;

	private StringBuilder strBuilder = new StringBuilder();

	@Override
	public void run(String... args) throws Exception {

		try {
			FileInputStream file = new FileInputStream(new File(sourceFileLocation));
			Workbook workbook = new XSSFWorkbook(file);
			Sheet sheet = workbook.getSheet(sheetName);

			String[] colIndexArr = csvColIndexToRead.split(",");
			
			File directory = new File("");
			String fileName = directory.getAbsolutePath() + File.separator + "Requirements_US_Report_" + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + ".csv";
			strBuilder.append(headerRow+"\n");
			try(FileWriter fileWriter = new FileWriter(new File(fileName))) {
			
				ExecutorService executor = Executors.newFixedThreadPool(20);
				// Skip first row
				for (int rowIndex = 1; rowIndex < sheet.getLastRowNum(); rowIndex++) {
				//for (int rowIndex = 1; rowIndex < 10; rowIndex++) {
					final int finalRowIndex = rowIndex;

					executor.submit(() -> {
				    	
						Row row = sheet.getRow(finalRowIndex);
						
						String cellData = "";
						for (String colIndex : colIndexArr) {
							cellData += "\"" + row.getCell(new Integer(colIndex)).getStringCellValue() + "\",";
						}
						String userStories = row.getCell(new Integer(csvColIndexUserStory)).getStringCellValue();
				    	
				    	strBuilder.append(getJiraStatusforUS(cellData, userStories));
				    	
				    	logger.info("COMPLETED " + finalRowIndex);
			    		
				    });
				}
				executor.shutdown();
				
				while(!executor.isTerminated()) {
					logger.debug("Executor still running. Check again in 30s");
					
					Thread.sleep(30000);
				}
				logger.debug("\n\n=========\n WRITING to file\n\n\n\n==================\n\n\n\n");
				fileWriter.write(strBuilder.toString());
				
			}catch(IOException e) {
				logger.error("Error while writing to file", e);
			}

		} catch (Exception e) {
			logger.error("Error while getting data from Jira", e);
		}
	}

	private String getJiraStatusforUS(String cellData, String userStories) {
		String[] usArr = userStories.split(splitRegex);
		
		StringBuilder rowBuilder = new StringBuilder();
		for (String usKey : usArr) {

			if (StringUtils.hasText(usKey)) {
				
				try {
					
					rowBuilder
						.append(cellData)
						.append("\"").append(usKey).append("\",")
						;
					logger.debug(rowBuilder.toString());
					Entity jiraEntity = getFromJira(jiraIssueUrl + usKey, Entity.class);
					
					rowBuilder
						.append("\"").append(jiraEntity.fields.summary)
						.append("\",\"").append(jiraEntity.getStatus())
						.append("\",\"").append(jiraEntity.getResolution())
						.append("\",\"").append(jiraBrowseUrl + usKey)
						.append("\",\"").append(jiraEntity.getEpic())
						.append("\"").append("\n");

				}catch(HttpClientErrorException e) {
					rowBuilder
						.append("\"Not found in Jira")
						.append("\"\n");
					logger.error("Error while getting UserStory="+usKey, e);
				}
								
			}

		}
		return rowBuilder.toString();
	}

	private <T> T getFromJira(String url, Class returnType) {
		RestTemplate restTemplate = new RestTemplate();
		logger.debug("URL=" + url);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		String base64 = new String(Base64.getEncoder().encode((jiraUsername+":"+jiraPassword).getBytes()));
		headers.set("Authorization", "Basic " + base64);

		HttpEntity request = new HttpEntity(headers);

		ResponseEntity<T> response = restTemplate.exchange(url, HttpMethod.GET, request, returnType);
		if (response != null && response.getBody() != null) {
			logger.debug("Received response records.");
			return response.getBody();
		}
		return null;
	}

}

@JsonIgnoreProperties(ignoreUnknown = true)
class Entity {

	public String key;

	public Fields fields;

	public String getResolution() {
		if (this.fields != null && this.fields.resolution != null) {
			if (StringUtils.hasText(this.fields.resolution.name)) {
				return this.fields.resolution.name.trim();
			}
		}
		return "Unresolved";
	}

	public String getStatus() {
		if (this.fields != null && this.fields.status != null) {
			if (StringUtils.hasText(this.fields.status.name)) {
				return this.fields.status.name.trim();
			}
		}
		return "NULL";
	}
	
	public String getEpic() {
		if (this.fields != null && this.fields.epic != null) {
			if (StringUtils.hasText(this.fields.epic.name)) {
				return "(" + this.fields.epic.key +") "+ this.fields.epic.name.trim();
			}
		}
		return "NULL";
	}

}

class Fields {
	
	public String summary;
	
	public Status status;

	public Status resolution;
	
	public Status epic;

	static class Status {

		public String description;

		public String name;
		
		public String key;
	}
}
