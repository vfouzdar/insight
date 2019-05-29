package com.project.web.controller;

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

import com.project.entity.User;
import com.project.service.UserService;
import com.project.web.model.UserForm;
import com.project.web.model.UserLoginForm;

@Controller
@SessionAttributes(WebConstants.SESSION_EMAIL_ID) 
public class WebControllerPost implements WebMvcConfigurer {
	private static final Logger logger = LoggerFactory.getLogger(WebControllerPost.class);

	@Autowired
	private UserService userService;

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
			user.mapUserForm(userForm);

			user = userService.registerUser(user);
			logger.info("redirecting to registerform----------------------------------");
			if (user != null) {
				logger.info("User RegisterForm -----------------------");
				userForm.mapUser(user);
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
			UserForm userForm, @ModelAttribute(WebConstants.SESSION_EMAIL_ID) String userIdentifier) {
		logger.info("\n\n\n\n##########################Show Login Form");

		if (bindingResult.hasErrors()) {
			return "error";
		} else {

			User user = new User();
			user.mapUserLoginForm(userLoginForm);
			user = userService.checkUserAuthentication(user);
			logger.info("redirecting to form----------------------------------");
			if (user != null) {
				logger.info("User logged in -----------------------");
				userForm.mapUser(user);
				userIdentifier = userForm.getEmailId();
				return "register_success";
			} else {
				logger.info("wrong user------------------");
				return "login";
			}
		}

	}
	
	@ModelAttribute(WebConstants.SESSION_EMAIL_ID)
	public String getSessionEmailId(){
		return null;
	}

}
