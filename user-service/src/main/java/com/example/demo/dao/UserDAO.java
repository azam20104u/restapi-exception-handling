package com.example.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.UserResource;
import com.example.demo.repository.UserRepository;

@Component
public class UserDAO {

	@Autowired
	private UserRepository userRepository;

	public UserResource createUser(UserResource user) {
		return userRepository.save(user);
	}

	public UserResource findUserById(Integer id) {
		return userRepository.findById(id).orElse(null);
	}

	public List<UserResource> getAllUsers() {
		return userRepository.findAll();
	}

	public UserResource updateUser(Integer id, UserResource user) {
		UserResource userResource = userRepository.findById(id).orElse(null);
		if (userResource!= null) {
           userResource.setName(user.getName());
            userRepository.save(userResource);
        }
		return userResource;
	}

	public UserResource deleteUser(Integer id) {
		UserResource userResource = userRepository.findById(id).orElse(null);
		if (userResource!= null) {
			userRepository.delete(userResource);
		}
		return userResource;
	}
	
}
