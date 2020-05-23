package com.capg.onlinetest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.onlinetest.entity.Test;
import com.capg.onlinetest.entity.User;
import com.capg.onlinetest.exceptions.RecordNotFoundException;
import com.capg.onlinetest.exceptions.TestNotFoundException;
import com.capg.onlinetest.service.TestService;
import com.capg.onlinetest.service.UserService;

/**
 * 
 * @author TEAM EINSTEIN
 * USER Controller
 */
@CrossOrigin(origins= "http://localhost:4200")
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	@Autowired
	TestService testService;
	
	/**
	 * 
	 * @param user 
	 * @return String
	 */
	@PostMapping("/addUser")
	public ResponseEntity<String> addUser(@RequestBody User user) {
			return new ResponseEntity<String>(userService.addUser(user),HttpStatus.OK);
	}

	/**
	 * 
	 * @param id
	 * @param user object
	 * @return String
	 */
	@PutMapping("/updateUser/{id}")
	public ResponseEntity<String> updateUser(@PathVariable(value = "id") int id, @RequestBody User user) {
		try {
			return new ResponseEntity<String>(userService.updateUser(id, user),HttpStatus.OK);
		}catch(RecordNotFoundException e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
		
	}

	/**
	 * 
	 * @param test object
	 * @return float
	 */
	@PostMapping("/getResult")
	public ResponseEntity<?> getResult(@RequestBody Test test) {
		try {
			return new ResponseEntity<>(testService.calculateTotalMarks(test),HttpStatus.OK);
		}catch(TestNotFoundException e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
		}
  }
	
}
