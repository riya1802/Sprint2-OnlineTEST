package com.capg.onlinetest.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.onlinetest.dao.UserDao;
import com.capg.onlinetest.entity.User;
import com.capg.onlinetest.exceptions.IncorrectPasswordException;
import com.capg.onlinetest.exceptions.UserNotFoundException;

@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	UserDao userDao;
	
	@Override
		public int login(String userName, String userPassword) {
			int id = userDao.getIdByUserName(userName);
			Optional<User> findById = userDao.findById(id);
			if (findById.isPresent()) {
				User user = findById.get();
				if (user.getUserPassword().equals(userPassword)) {
					if (user.getIsAdmin() == 1)
						return 1;
					else
						return 0;

				} else
					throw new IncorrectPasswordException("!! Incorrect Password !!");
			} else
				throw new UserNotFoundException("!! User Not Found !!");
		}
}
