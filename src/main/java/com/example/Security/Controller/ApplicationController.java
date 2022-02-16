package com.example.Security.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Security.Model.User;
import com.example.Security.Service.ApplicationService;

@RestController
public class ApplicationController {
	
	@Autowired
	ApplicationService applicationService;
	
	@GetMapping("/")
	public String homePage() {
		return "This is Home Page";
	}
	
	@GetMapping("/dashboard")
	public String dashboard() {
		return "This is Dashbaord page";
	}
	
	@PostMapping("/createuser")
	public User createUser(@RequestBody User user) {
		return applicationService.createUser(user);
	}
	

}
