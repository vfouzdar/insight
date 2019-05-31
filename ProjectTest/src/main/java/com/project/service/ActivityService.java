package com.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.Activity;
import com.project.entity.User;
import com.project.repository.ActivityRepository;

import java.util.List;

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

	public List<Activity> getUserActivity(Activity activity){
		logger.info("searching for user activity in service -------------------------");
		return activityRepository.findAllByUserId(activity);
	}
}
