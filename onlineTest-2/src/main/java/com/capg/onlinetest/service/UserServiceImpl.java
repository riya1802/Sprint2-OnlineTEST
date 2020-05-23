package com.capg.onlinetest.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capg.onlinetest.dao.TestDao;
import com.capg.onlinetest.dao.UserDao;
import com.capg.onlinetest.entity.Test;
import com.capg.onlinetest.entity.User;
import com.capg.onlinetest.exceptions.CannotAssignTestToAdminException;
import com.capg.onlinetest.exceptions.RecordNotFoundException;
import com.capg.onlinetest.exceptions.TestAlreadyAssignedException;
import com.capg.onlinetest.exceptions.TestNotFoundException;
import com.capg.onlinetest.exceptions.UserListEmptyException;
import com.capg.onlinetest.exceptions.UserNotFoundException;

/**
 * USER SERVICE Implementation
 * 
 * @author TEAM EINSTEIN
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	@Autowired
	private TestDao testDao;

	/**
	 * @author TEAM EINSTEIN
	 * @param User Object
	 * @return String
	 */
	public String addUser(User user) {
		userDao.save(user);
		return "User Created!!";
	}

	/**
	 * @author TEAM EINSTEIN
	 * @param userId, User Object
	 * @return String
	 */
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

	/**
	 * @author Piyush
	 * Delete User override method
	 * @param userId
	 * @return String
	 */
	@Override
	public String deleteUser(int userId) {
		Optional<User> userById = userDao.findById(userId);
		if (userById.isPresent()) {
			userDao.delete(userById.get());
			return "User removed";
		} else
			throw new UserNotFoundException("! User ID doesn't exist !");
	}

	/**
	 * @author Piyush
	 * viewALlUser override method
	 * @return list of all users
	 */
	@Override
	public List<User> viewAllUser() {
		List<User> userList = userDao.findAll();
		if (!userList.isEmpty()) {
			return userList;
		} else
			throw new UserListEmptyException("! No User Found !");
	}

	/**
	 * @author Piyush
	 * AssignTest override method
	 * @param userId, testId
	 * @return String
	 */
	@Override
	public String assignTest(int userId, int testId) {
		Optional<User> userById = userDao.findById(userId);
		Optional<Test> testById = testDao.findById(testId);
		if (userById.isPresent()) {
			if (userById.get().getIsAdmin() == 0) {
				if (testById.isPresent()) {
					User user = userById.get();
					if (user.getTestId() == 0) {
						user.setTestId(testId);
						userDao.save(user);
						return "Test Assigned to user successfully";
					} else
						throw new TestAlreadyAssignedException("! One Test is already assigned to this user !");

				} else
					throw new TestNotFoundException("! Test ID doesn't exist !");
			} else
				throw new CannotAssignTestToAdminException("! Test cannot be assigned to Admin !");
		} else
			throw new UserNotFoundException("! User ID does not exist !");
	}

}