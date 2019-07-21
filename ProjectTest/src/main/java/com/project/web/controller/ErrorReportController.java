package com.project.web.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.service.ErrorReportService;

@RestController
public class ErrorReportController {
	
	@RequestMapping("/errorReport")
	public Map<String, Long> errorReport( @RequestParam String filePath )
	{
		ErrorReportService errorReportService = new ErrorReportService();
		
		Map<String, Long> map = new HashMap<>();
		
		try {
			map = errorReportService.filePath(filePath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
		
	}

}
