
package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.stereotype.Service;

import com.example.demo.dao.Userdao;
import com.example.demo.model.users;

public class UserService {
	@Service
	public class userService {
		@Autowired
		Userdao uDao;
		
		public void adduser(users user)
		{
			uDao.saveUser(user);
		}
		public List<users> getAll()
		{
			return uDao.getAllStudent();
		}
	}

}
