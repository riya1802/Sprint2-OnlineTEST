package com.capg.onlinetest.service;

import java.util.List;
import com.capg.onlinetest.entity.User;

/**
 * 
 * @author TEAM EINSTEIN
 * USER SERVICE INTERFACE
 */
public interface UserService {
	
	public String addUser(User user);
	public String updateUser(int userId, User userDetails);
	public String deleteUser(int userId);
	public List<User> viewAllUser();
	public String assignTest(int userId,int testId);
}
