package com.capg.onlinetest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.onlinetest.dao.TestDao;
import com.capg.onlinetest.entity.Question;
import com.capg.onlinetest.entity.Test;
import com.capg.onlinetest.exceptions.NullException;
import com.capg.onlinetest.exceptions.TestNotAddedException;
import com.capg.onlinetest.exceptions.TestNotDeletedException;
import com.capg.onlinetest.exceptions.TestNotFoundException;
import com.capg.onlinetest.exceptions.WrongTestIdException;

@Service
public class TestServiceImpl implements TestService {

	@Autowired
	TestDao testDao;

	@Override
	public Test addTest(Test test) {
		Optional<Test> findById = testDao.findById(test.getTestId());
		if (!findById.isPresent()) {
		return testDao.save(test);
		}
		else
			throw new TestNotAddedException("! Test is already added !");
	}

	@Override
	public String deleteTest(int testId) {
		if(testId!=0) {
          Optional<Test> findById = testDao.findById(testId);
		if (findById.isPresent()) {
			testDao.deleteById(testId);
			return "Test deleted";
		}
		
		else {
			throw new TestNotDeletedException("Test is not Deleted");
		}
		}
		else {
		   throw new WrongTestIdException("Test does not exist for this Test ID");
	}
	}
	@Override
	public String updateTest(int testId, Test test) {
		Optional<Test> tst = testDao.findById(testId);
		if (tst.isPresent()) {
			Test t = tst.get();
			t.setStartTime(test.getStartTime());
			t.setEndTime(test.getEndTime());
			t.setTestDuration(test.getTestDuration());
			t.setTestTitle(test.getTestTitle());
			t.setTestTotalMarks(test.getTestTotalMarks());
			testDao.save(t);
			return "Test Updated";
		} else
			throw new TestNotFoundException("Test does not exist so cannot be updated");

	}

	@Override
	public List<Test> viewAllTests() {
		List<Test> testList= testDao.findAll();
		if(testList== null) {
			throw new NullException("Test List is Empty!");
		}
		else
			return testList;
	}

	@Override
	public float calculateTotalMarks(Test test) {
		 int marks = 0;
		int id = test.getTestId();
		Optional<Test> tst = testDao.findById(id);
		if (tst.isPresent()) {
			Test test1 = tst.get();
			List<Question> questions = test1.getTestQuestions();
			List<Question> questions1 = test.getTestQuestions();
			for (Question q : questions) {
				for (Question q1 : questions1) {
					if ((q.getQuestionId() == q1.getQuestionId()) && (q.getQuestionAnswer() == q1.getChosenAnswer())) {
						marks = marks + q.getQuestionMarks();
						continue;
					}
				}

			}
			return marks;
		}
		
		else
			throw new TestNotFoundException("! Test is not present !");
	}

}