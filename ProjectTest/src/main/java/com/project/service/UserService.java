package com.project.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.User;
import com.project.repository.UserRepository;

@Service
public class UserService {

	private static final Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserRepository userRepository;

	public User registerUser(User user) {
		if (user != null)
			logger.info("-----------########## Not Null");
		return userRepository.save(user);

	}
	

	public User checkUserAuthentication(User user) {
		
		return userRepository.userExist(user);
	}

}
