package com.capg.onlinetest.service;

import java.util.List;
import com.capg.onlinetest.entity.User;

public interface UserService {
	
	public String addUser(User User);
	public String updateUser(int UserId, User userDetails);
	public List<User> viewAllUser();
	public String assignTest(int userId,int testId);
}
