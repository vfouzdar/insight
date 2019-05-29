package com.project.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.project.web.model.UserForm;

@Controller
@SessionAttributes(WebConstants.SESSION_EMAIL_ID) 
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(WebControllerPost.class);

	@GetMapping("/ShowEditForm")
	public String showEditForm(UserForm userForm, @SessionAttribute(WebConstants.SESSION_EMAIL_ID) String userIdentifier, BindingResult bindingResult) {
		logger.info("\n\n\n\n##########################Show Edit Form");
		userIdentifier="neelam@gmail.com";
		
		if(StringUtils.hasText(userIdentifier)){
			
			logger.info("##############/n/n/n Email available=" + userIdentifier);
			//TODO:fetch user using emailId
			//Convert user to userForm
		}else{
			bindingResult.rejectValue("emailId", "user.notLogged", "User Not LoggedIn");
			return "login";
		}
		return "";

	}
}
