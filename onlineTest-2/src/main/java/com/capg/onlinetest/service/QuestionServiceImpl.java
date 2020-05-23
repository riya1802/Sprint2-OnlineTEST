package com.capg.onlinetest.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capg.onlinetest.dao.QuestionDao;
import com.capg.onlinetest.dao.TestDao;
import com.capg.onlinetest.entity.Question;
import com.capg.onlinetest.entity.Test;
import com.capg.onlinetest.exceptions.NullException;
import com.capg.onlinetest.exceptions.QuestionNotAddedException;
import com.capg.onlinetest.exceptions.QuestionNotDeletedException;
import com.capg.onlinetest.exceptions.QuestionNotFoundException;
import com.capg.onlinetest.exceptions.WrongQuestionIdException;

/**
 * QUESTION SERVICE Implementation
 * @author TEAM EINSTEIN
 *
 */
@Service
public class QuestionServiceImpl implements QuestionService {
   @Autowired
   private QuestionDao questionDao;
   
   @Autowired
   private TestDao testDao;
   
   /**
    * @param testId, question object
    * @return String
    */
	@Override
	public String addQuestion(int testId, Question question) {
		Optional<Question> question1 = questionDao.findById(question.getQuestionId());
		if (!question1.isPresent()) {
		Test test=testDao.findById(testId).get();
		List<Question> ques=test.getTestQuestions();
		ques.add(question);
		test.setTestQuestions(ques);
		testDao.save(test);
		return "question added";
		}
		else 
			throw new QuestionNotAddedException("question already exists");
	}

	/**
	 * @param questionId
	 * @return String
	 */
	@Override
	public String deleteQuestion(int questionId){
		if(questionId!=0) {
		Optional<Question> findById=questionDao.findById(questionId);
		if(findById.isPresent()) {
			questionDao.deleteById(questionId);
			return "Question deleted";
		}
		else
			throw new QuestionNotDeletedException("Question is not Deleted");
		}
		else
		throw new WrongQuestionIdException("Question does not exist");
	}

	/**
	 * @param questionId, question object
	 * @return String
	 */
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
		else
			throw new QuestionNotFoundException("Question does not exist");
	}

	/**
	 * @return list of questions
	 */
	@Override
	public List<Question> viewAllQuestions() {
		List<Question> questionList=questionDao.findAll();
		if(questionList==null) 
			throw new NullException("Question List is Empty");
		else
			return questionDao.findAll();
		
	}

}

