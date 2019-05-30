package com.project.web.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.project.entity.User;
import com.project.service.UserService;
import com.project.web.model.UserForm;
import com.project.web.model.UserLoginForm;

@Controller
public class UserController {

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@GetMapping("/ShowEditForm")
	public String showEditForm(UserForm userForm, BindingResult bindingResult, HttpSession session) {
		logger.info("\n\n\n\n##########################Show Edit Form");
		String userIdentifier = (String) session.getAttribute(WebConstants.SESSION_EMAIL_ID);
		logger.info("\n\n\n\n########################## userIdentifier= " + userIdentifier);

		if (StringUtils.hasText(userIdentifier)) {
			User user = new User();
			user.setEmailId(userIdentifier);

			logger.info("##############/n/n/n Email available=" + userIdentifier);
			user = userService.findUserByEmailId(user);
			userForm.mapUser(user);
			return "editform";
		} else {
			bindingResult.rejectValue("emailId", "user.notLogged", "User Not LoggedIn");
			return "login";
		}

	}

	@PostMapping("/editUser")
	public String editUserProfile(@Valid UserForm userForm, BindingResult bindingResult, HttpSession session) {
		logger.info("\n\n\n\n##########################Editing profile \n\n");

		if (bindingResult.hasErrors()) {
			return "error";
		} else {

			User user = new User();
			user.mapUserForm(userForm);
			user = userService.updateUserByEmailId(user);
			logger.info("##############/n/n/n Profile Updated");
			userForm.mapUser(user);
			return "register_success";
		}

	}

}
