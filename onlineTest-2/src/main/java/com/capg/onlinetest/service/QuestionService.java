package com.capg.onlinetest.service;

import java.util.List;
import com.capg.onlinetest.entity.Question;

/**
 * 
 * @author TEAM EINSTEIN
 * QUESTION SERVICE INTERFACE
 */
public interface QuestionService {

	public String addQuestion(int testId,Question question);
    public String deleteQuestion(int questionId);
    public String updateQuestion(int questionId,Question question);
    public List<Question> viewAllQuestions();
}
