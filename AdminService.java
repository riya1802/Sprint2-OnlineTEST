package com.capg.onlinetest.service;

import java.util.List;

import com.capg.onlinetest.model.Question;
import com.capg.onlinetest.model.Test;
import com.capg.onlinetest.model.User;

public interface AdminService {

	public List<User> getAllUsers();
	public String addTest(Test test);
	public String updateTest(Test test);
	public String deleteTest(int testId);
	public List<Test> getAllTests();
	
	public String addQuestions(int testId, Question question);
	public String updateQuestions(int testId,Question question);
	public String deleteQuestions(int testId,Question question);
	
	public String assignTest(int userId, int testId);

}
