package com.capg.onlinetest.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.onlinetest.model.Test;
import com.capg.onlinetest.model.User;
import com.capg.onlinetest.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin("http://localhost:4200")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/addUser")
	public String addUser(@RequestBody User user) {
			return userService.addUser(user);
	}
	@PutMapping("/updateUser")
	public String updateUser(@RequestBody User user) {
			return userService.updateUser(user);
	}
    @GetMapping("/getResult")
    public int getResult(@RequestBody Test test) {
    	return userService.getResult(test);
    }
	
	
}
