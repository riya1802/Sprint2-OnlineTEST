package com.capg.onlinetest.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capg.onlinetest.dao.UserDao;
import com.capg.onlinetest.model.Test;
import com.capg.onlinetest.model.User;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserDao userDao;
	
	@Override
	public String addUser(User user) {
		Optional<User> findById = userDao.findById(user.getUserId());
		if(!findById.isPresent()) {
			userDao.save(user);
			return "! User Added!";
		}
		return "! User Already Present!";
	}
	@Override
	public String updateUser(User user) {
		Optional<User> findById = userDao.findById(user.getUserId());
		if(findById.isPresent()) {
			userDao.save(user);
			return "! User Updated!";
		}
		return "! User Not Found !";
	}
	
	@Override
	public int getResult(Test test) {
		return 0;
	}
	
}
