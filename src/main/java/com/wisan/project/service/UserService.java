package com.wisan.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wisan.project.entities.User;
import com.wisan.project.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User findById(Long id) {
		return userRepository.findById(id).get();
	}
	
	public User insert(User obj) {
		return userRepository.save(obj);
		
	}
	
	public void delete(Long id) {
		userRepository.deleteById(id);
	}

}
