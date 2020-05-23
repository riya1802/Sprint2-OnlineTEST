package com.capg.onlinetest.controller;

import javax.validation.Valid;

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
import com.capg.onlinetest.service.LoginService;

/**
 * 
 * @author Piyush LOGIN Controller
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class LoginController {

	@Autowired
	LoginService loginService;

	/**
	 * login method
	 * 
	 * @param User Object
	 * @return User Object
	 */
	@PostMapping("/login")
	public ResponseEntity<?> login(@Valid @RequestBody User user) {
		try {
			return new ResponseEntity<User>(loginService.login(user.getUserName(), user.getUserPassword()),
					HttpStatus.OK);
		} catch (IncorrectPasswordException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.UNAUTHORIZED);
		} catch (UserNotFoundException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
}
