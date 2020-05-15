package com.capg.onlinetest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capg.onlinetest.entity.User;
import com.capg.onlinetest.exceptions.IncorrectPasswordException;
import com.capg.onlinetest.exceptions.UserNotFoundException;
import com.capg.onlinetest.service.UserService;

@CrossOrigin(origins= "http://localhost:4200")
@RestController
public class LoginController {

	@Autowired
	UserService userService;
	
	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody User user){
	       try {
	    	  return new ResponseEntity<String>(userService.login(user.getUserName(),user.getUserPassword()),HttpStatus.OK);
	       }catch(IncorrectPasswordException e) {
	    	   return new ResponseEntity<String>(e.getMessage(),HttpStatus.UNAUTHORIZED);
	       }catch(UserNotFoundException e) {
	    	   return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
	       }
	}
}
