package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.Activity;
import com.project.repository.ActivityRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class ActivityService {
	Logger logger = LoggerFactory.getLogger(ActivityRepository.class);
	
	@Autowired
	ActivityRepository activityRepository;
	
	public Activity saveNewActivity(Activity activity){
		logger.info("Set new activity in repo---------------------------------");
		return activityRepository.save(activity);
	}

}
