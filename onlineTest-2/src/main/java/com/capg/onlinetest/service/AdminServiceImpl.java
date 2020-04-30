package com.capg.onlinetest.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.onlinetest.dao.TestDao;
import com.capg.onlinetest.dao.UserDao;
import com.capg.onlinetest.model.Question;
import com.capg.onlinetest.model.Test;
import com.capg.onlinetest.model.User;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	TestDao testDao;

	@Autowired
	UserDao userDao;

	@Override
	public String addTest(Test test) {
		Optional<Test> testById = testDao.findById(test.getTestId());
		if (!testById.isPresent()) {
			testDao.save(test);
			return "! Test Saved !";
		}
		return "! Test Already Exists !";
	}

	@Override
	public String updateTest(Test test) {
		Optional<Test> testById = testDao.findById(test.getTestId());
		if (testById.isPresent()) {
			testDao.save(test);
			return "! Test Updated !";
		}
		return "! Test Not Found !";
	}

	@Override
	public String deleteTest(int testId) {
		Optional<Test> testById = testDao.findById(testId);
		if (testById.isPresent()) {
			testDao.delete(testById.get());
			return "! Test Deleted !";
		}
		return "! Test Not Found !";
	}

	@Override
	public String addQuestions(int testId, Question question) {
		Optional<Test> testById = testDao.findById(testId);
		if (testById.isPresent()) {
			Test test = testById.get();
			if (!test.getTestQuestions().contains(question.getQuestionId())) {
				test.getTestQuestions().add(question);
				return "! Question Added !";
			} else
				return "! Question Already Exists !";
		}
		return "! Test Not Found !";
	}

	@Override
	public String updateQuestions(int testId, Question question) {
		Optional<Test> testById = testDao.findById(testId);
		if (testById.isPresent()) {
			Test test = testById.get();
			if (test.getTestQuestions().contains(question.getQuestionId())) {
				test.getTestQuestions().add(question);
				return "! Question Updated !";
			} else
				return "! Question Not Found !";
		}
		return "! Test Not Found !";
	}

	@Override
	public String deleteQuestions(int testId, Question question) {
		Optional<Test> testById = testDao.findById(testId);
		if (testById.isPresent()) {
			Test test = testById.get();
			if (test.getTestQuestions().contains(question.getQuestionId())) {
				test.getTestQuestions().remove(question);
				return "! Question Deleted !";
			} else
				return "! Question Not Found !";
		}
		return "! Test Not Found !";
	}

	@Override
	public List<User> getAllUsers() {
		List<User> findAll = userDao.findAll();
		if (!findAll.isEmpty()) {
			return findAll;
		}
		return null;
	}

	@Override
	public List<Test> getAllTests() {
		List<Test> findAll = testDao.findAll();
		if (!findAll.isEmpty()) {
			return findAll;
		}
		return null;
	}

	@Override
	public String assignTest(int userId, int testId) {
		Optional<Test> testById = testDao.findById(testId);
		if (testById.isPresent()) {
			Test test = testById.get();
			Optional<User> userById = userDao.findById(userId);
			if (userById.isPresent()) {
				User user = userById.get();
				user.setUserTest(test);
				return "! Test Assigned !";
			} 
			else {
				return "! User Not Found!";
			}
		}
		return "! Test Not Found !";
	}

}
