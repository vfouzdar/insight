package com.project.web.controller;

import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;

import com.project.entity.Activity;
import com.project.entity.ActivityType;
import com.project.entity.User;
import com.project.repository.ActivityRepository;
import com.project.service.ActivityService;
import com.project.service.UserService;
import com.project.web.model.ActivityForm;

@Controller
public class ActivityController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UserService userService;
	
	@Autowired
	ActivityService activityService;
	
	@GetMapping("/ShowActivityForm")
	public String showActivity(ActivityForm activityForm, HttpSession session){
		logger.info("\n\n\n\n##########################Show Activity Form");
		String userIdentifier = (String) session.getAttribute(WebConstants.SESSION_EMAIL_ID);
		logger.info("\n\n\n\n########################## userIdentifier= " + userIdentifier);

		//if (StringUtils.hasText(userIdentifier)) {
			User user = new User();
			Activity activity = new Activity();
			
			user.setEmailId(userIdentifier);

			logger.info("##############/n/n/n Email available=" + userIdentifier);
			user = userService.findUserByEmailId(user);
			logger.info(user.getEmailId() + "-------------------------------------");
			activity.setUserId(user.getId());
			
			logger.info(activity.getUserId() + "----------------------------------------");
			List<Activity> activityList = activityService.getUserActivity(activity);
			
			activityList.stream().forEach((act) -> logger.info(act.getActivityType().toString() + act.getId() + act.getCreateDate()));
			activityForm.setUserId(user.getId());
			activityForm.mapActivity(activityList);
			
			

			return "activity";
		
	}

}
