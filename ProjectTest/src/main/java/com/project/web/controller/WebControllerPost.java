package com.project.web.controller;

import java.util.GregorianCalendar;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.project.entity.Activity;
import com.project.entity.User;
import com.project.service.ActivityService;
import com.project.service.UserService;
import com.project.web.model.UserForm;
import com.project.web.model.UserLoginForm;

@Controller
public class WebControllerPost implements WebMvcConfigurer {
	private static final Logger logger = LoggerFactory.getLogger(WebControllerPost.class);

	@Autowired
	private UserService userService;
	
	@Autowired
	private ActivityService activityService;

	// TODO: public void addViewControllers(ViewControllerRegistry registry) {
	// registry.addViewController("/login").setViewName("login");

	@GetMapping("/")
	public String showForm() {
		logger.info("\n\n\n\n##########################Show Home Form");
		return "homepage";
	}

	@GetMapping("/ShowLoginForm")
	public String showLogIn(UserLoginForm userLoginForm) {
		logger.info("\n\n\n\n##########################Show LogIn Form");
		return "login";
	}

	@GetMapping("/ShowRegisterForm")
	public String showRegisterForm(UserForm userForm) {
		logger.info("\n\n\n\n##########################Show Register Form");
		return "register";

	}

	@PostMapping("/RegisterUser")
	public String checkUserInfo(@Valid UserForm userForm, BindingResult bindingResult) {
		logger.info("\n\n\n\n##########################Show Register Form");

		if (bindingResult.hasErrors()) {
			return "register";
		} else {

			User user = new User();
			Activity activity = new Activity();
			user.mapUserForm(userForm);

			user = userService.registerUser(user);
			logger.info("redirecting to registerform----------------------------------");
			if (user != null) {
				logger.info("User RegisterForm -----------------------");
				userForm.mapUser(user);

				activity.setType("New User registered");
				logger.info("Set new activity---------------------------------");
				activity.setCreateDate(GregorianCalendar.getInstance().getTime());
				activityService.saveNewActivity(activity);
				
				return "register_success";
			} else {
				bindingResult.rejectValue("emailId", "user.exist", "User already exist");
				logger.info("User Exist------------------");
				return "register";
			}

		}

	}

	@PostMapping("/LoginUser")
	public String checkUserLoginInfo(@Valid UserLoginForm userLoginForm, BindingResult bindingResult,
			UserForm userForm, HttpSession session) {
		logger.info("\n\n\n\n##########################Show Login Form\n\n");

		logger.info("\n\n\n\n Session not null=" + (session!=  null));
		if(session!=  null ){
			logger.info("\n\n\n\n Session get LastAccessedTime=" + (session.getLastAccessedTime()));
		}
		
		if (bindingResult.hasErrors()) {
			return "error";
		} else {
		
			User user = new User();
			user.mapUserLoginForm(userLoginForm);
			user = userService.findUserByEmailId(user);
			logger.info("redirecting to form----------------------------------");
			if (user != null) {
				Activity activity = new Activity();
				logger.info("User logged in -----------------------");
				userForm.mapUser(user);
				session.setAttribute(WebConstants.SESSION_EMAIL_ID, user.getEmailId());
				
				activity.setType("User Loggedin");
				activity.setCreateDate(GregorianCalendar.getInstance().getTime());
				logger.info("Set new activity---------------------------------");
				activityService.saveNewActivity(activity);
				
				return "register_success";
				
			} else {
				logger.info("wrong user------------------");
				return "login";
			}
		}

	}

}
