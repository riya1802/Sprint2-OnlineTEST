package com.capg.onlinetest.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capg.onlinetest.dao.QuestionDao;
import com.capg.onlinetest.dao.TestDao;
import com.capg.onlinetest.entity.Question;
import com.capg.onlinetest.entity.Test;

@Service
public class QuestionServiceImpl implements QuestionService {
   @Autowired
   QuestionDao questionDao;
   
   @Autowired
   TestDao testDao;
   
	@Override
	public String addQuestion(int testId, Question question) {
		Optional<Question> question1 = questionDao.findById(question.getQuestionId());
		if(!question1.isPresent()) {
		  Test test=testDao.findById(testId).get();
		  List<Question> ques=test.getTestQuestions();
		  ques.add(question);
		  test.setTestQuestions(ques);
		  testDao.save(test);
		  return "Question added";
		}
		return "Question already exists";
		
	}

	@Override
	public String deleteQuestion(int questionId) {
		Optional<Question> findById=questionDao.findById(questionId);
		if(findById.isPresent()) {
			questionDao.deleteById(questionId);
			return "Question deleted";
		}
		return "Question does not exist";
	}

	@Override
	public String updateQuestion(int questionId,Question ques) {
		
		Optional<Question> findById=questionDao.findById(questionId);
		if(findById.isPresent()) {
			Question q=findById.get();
			q.setQuestionTitle(ques.getQuestionTitle());
			q.setQuestionOptions(ques.getQuestionOptions());
			q.setQuestionAnswer(ques.getQuestionAnswer());
			q.setQuestionMarks(ques.getQuestionMarks());
			questionDao.save(q);
			return "Question Updated";
		}
		return "Question does not exist";
	}

	@Override
	public List<Question> viewAllQuestions() {
		System.out.println(questionDao.findAll());
		return questionDao.findAll();
	}

}

