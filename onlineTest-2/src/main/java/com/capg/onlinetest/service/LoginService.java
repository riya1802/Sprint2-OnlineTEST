package com.capg.onlinetest.service;

import com.capg.onlinetest.entity.User;

/**
 * 
 * @author Piyush
 * LOGIN SERVICE INTERFACE
 */
public interface LoginService {

	/**
	 * Abstract method
	 * @param userName
	 * @param userPassword
	 * @return User object
	 */
	public User login(String userName, String userPassword);
}
