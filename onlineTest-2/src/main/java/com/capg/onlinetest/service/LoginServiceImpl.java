package com.capg.onlinetest.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.onlinetest.dao.UserDao;
import com.capg.onlinetest.entity.User;
import com.capg.onlinetest.exceptions.IncorrectPasswordException;
import com.capg.onlinetest.exceptions.UserNotFoundException;

/**
 * 
 * @author Piyush
 * LOGIN SERVICE Implementation
 */
@Service
public class LoginServiceImpl implements LoginService{

	@Autowired
	private UserDao userDao;
	
	/**
	 * login override method
	 * @param userName, userPassword
	 * @return User object
	 */
	@Override
		public User login(String userName, String userPassword) {
			String id = userDao.getIdByUserName(userName);
			if(id!=null) {
				Optional<User> findById = userDao.findById(Integer.parseInt(id));
					User user = findById.get();
					if (user.getUserPassword().equals(userPassword)) {
						return user;
					} else
						throw new IncorrectPasswordException("!! Incorrect Password !!");
			}else
				throw new UserNotFoundException("!! User Not Found !!");
		}
}
