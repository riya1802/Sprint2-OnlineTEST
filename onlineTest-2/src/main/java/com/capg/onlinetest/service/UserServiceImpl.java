package com.capg.onlinetest.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capg.onlinetest.dao.TestDao;
import com.capg.onlinetest.dao.UserDao;
import com.capg.onlinetest.entity.Test;
import com.capg.onlinetest.entity.User;


@Service
public class UserServiceImpl implements UserService {
    
	@Autowired
	UserDao userDao;
	@Autowired
	TestDao testDao;
	@Override
	
	public String addUser(User user) {
		    userDao.save(user);
			return "User Created!!"; 
	}

	@Override
	public String updateUser(int userId,User userDetails) {
		Optional<User> findById=userDao.findById(userId);
		if(findById.isPresent()) {
			User user=findById.get();
			user.setUserName(userDetails.getUserName());
			user.setUserPassword(userDetails.getUserPassword());
			userDao.save(user);
			return "User Updated";
		}
		return "User does not exist";
	}

	@Override
	public List<User> viewAllUser() {
		
		return userDao.findAll();
	}
	
	@Override
	public String assignTest(int userId,int testId)
	{
		Optional<User> findById=userDao.findById(userId);
		Optional<Test> test=testDao.findById(testId);
		if(findById.isPresent() && test.isPresent()) {
			User user=findById.get();
			user.setTestId(testId);
			userDao.save(user);
			return "Test Assigned to user";
		}
		return "User or Test does not exist";
	}
}


