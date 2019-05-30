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
		if (!checkUserExistence(user)) {
			logger.info("checking for emailid -----------------------------------------");
			if (user != null){
				logger.info("-----------########## Not Null");
			return userRepository.save(user);
			}
		}

		return null;
	}

	public User findUserByEmailId(User user) {

		return userRepository.userExist(user);
	}

	public boolean checkUserExistence(User user) {
		return userRepository.findByEmailId(user);
	}
	
	public User updateUserByEmailId(User user){
		return userRepository.updateUser(user);
	}
}
