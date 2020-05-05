package com.capg.onlinetest.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capg.onlinetest.dao.TestDao;
import com.capg.onlinetest.entity.Question;
import com.capg.onlinetest.entity.Test;

@Service
public class TestServiceImpl implements TestService {
   
	@Autowired
	TestDao testDao;
	
	@Override
	public Test addTest(Test test) {
		return testDao.save(test);
	}

	@Override
	public String deleteTest(int testId) {
		Optional<Test> findById=testDao.findById(testId);
		if(findById.isPresent()) {
			testDao.deleteById(testId);
			return "Test deleted";
		}
		return "Test does not exist";
	}
	

	@Override
	public String updateTest(int testId,Test test) {
		// TODO Auto-generated method stub
		Optional<Test> tst=testDao.findById(testId);
		if(tst.isPresent())
		{
			Test t=tst.get();
			t.setStartTime(test.getStartTime());
			t.setEndTime(test.getEndTime());
			t.setTestDuration(test.getTestDuration());
			//t.setTestQuestions(test.getTestQuestions());
			t.setTestTitle(test.getTestTitle());
			t.setTestTotalMarks(test.getTestTotalMarks());
			testDao.save(t);
			return "Test Updated";
		}
		else
			return "Test Does not exist";
		
	}

	@Override
	public List<Test> viewAllTests() {
		return testDao.findAll();
	}
	
	public float CalculateMarks(Test test) {
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
		} else
			return 0;
	}

}
