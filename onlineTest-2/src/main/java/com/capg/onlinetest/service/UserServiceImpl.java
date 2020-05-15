package com.capg.onlinetest.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capg.onlinetest.dao.TestDao;
import com.capg.onlinetest.dao.UserDao;
import com.capg.onlinetest.entity.Test;
import com.capg.onlinetest.entity.User;
import com.capg.onlinetest.exceptions.CannotAssignTestException;
import com.capg.onlinetest.exceptions.IncorrectPasswordException;
import com.capg.onlinetest.exceptions.RecordNotFoundException;
import com.capg.onlinetest.exceptions.TestNotFoundException;
import com.capg.onlinetest.exceptions.UserNotFoundException;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	@Autowired
	TestDao testDao;

	// add the user
	public String addUser(User user) {
		userDao.save(user);
		return "User Created!!";
	}

	// update the user
	@Override
	public String updateUser(int userId, User userDetails) {
		Optional<User> findById = userDao.findById(userId);
		if (findById.isPresent()) {
			User user = findById.get();
			user.setUserName(userDetails.getUserName());
			user.setUserPassword(userDetails.getUserPassword());
			userDao.save(user);
			return "User Updated";
		} else
			throw new RecordNotFoundException("Record not present");
	}

	@Override
	public String deleteUser(int userId) {
		Optional<User> userById = userDao.findById(userId);
		if (userById.isPresent()) {
			userDao.delete(userById.get());
			return "User removed";
		} else
			throw new UserNotFoundException("! User ID doesn't exist !");
	}

	@Override
	public List<User> viewAllUser() {
		return userDao.findAll();
	}

	@Override
	public String assignTest(int userId, int testId) {
		Optional<User> userById = userDao.findById(userId);
		Optional<Test> testById = testDao.findById(testId);
		if (userById.isPresent()) {
			if (testById.isPresent()) {
				User user = userById.get();
				if (user.getTestId() == 0) {
					user.setTestId(testId);
					userDao.save(user);
					return "Test Assigned to user successfully";
				} else
					throw new CannotAssignTestException("! One Test is already assigned to this user !");

			} else
				throw new TestNotFoundException("! Test ID doesn't exist !");
		} else
			throw new UserNotFoundException("! User ID does not exist !");
	}

	@Override
	public String login(String userName, String userPassword) {
		int id = userDao.getIdByUserName(userName);
		Optional<User> findById = userDao.findById(id);
		if (findById.isPresent()) {
			User user = findById.get();
			if (user.getUserPassword().equals(userPassword)) {
				if (user.getIsAdmin() == 1)
					return "Logged in successfully as ADMIN";
				else
					return "Logged in successfully as USER";

			} else
				throw new IncorrectPasswordException("!! Incorrect Password !!");
		} else
			throw new UserNotFoundException("!! User Not Found !!");
	}
}