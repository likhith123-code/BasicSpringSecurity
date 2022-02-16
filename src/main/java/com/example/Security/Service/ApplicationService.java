package com.example.Security.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Security.Model.User;
import com.example.Security.Repository.ApplicationRepository;

@Service
public class ApplicationService {
	
	@Autowired
	ApplicationRepository applicationRepository;

	public User createUser(User user) {
		return applicationRepository.save(user);
	}
	
}
