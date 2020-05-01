package com.capg.onlinetest.service;

import com.capg.onlinetest.model.Test;
import com.capg.onlinetest.model.User;

public interface UserService {

	public String addUser(User user);
	public String updateUser(User user);
	public int getResult(Test test);
	
}
