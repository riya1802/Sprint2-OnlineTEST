package com.capg.onlinetest.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.capg.onlinetest.entity.Question;
import com.capg.onlinetest.entity.Test;
import com.capg.onlinetest.entity.User;
import com.capg.onlinetest.service.QuestionService;
import com.capg.onlinetest.service.TestService;
import com.capg.onlinetest.service.UserService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	UserService userService;
	@Autowired
	TestService testService;
	@Autowired
	QuestionService questionService;
	
	@GetMapping("/viewAllUsers")
	public List<User> viewAllUser() {
		return userService.viewAllUser();
	}
	
	@PostMapping("/addTest")
	public Test addTest(@RequestBody Test test) {
		return testService.addTest(test);
	}

	@GetMapping("/viewAllTests")
	public List<Test> viewAllTest() {
		return testService.viewAllTests();
	}

	@DeleteMapping("/deleteTest/{id}")
	public String deleteTest(@PathVariable(value = "id") int testId) {
		return testService.deleteTest(testId);
	}

	@PutMapping("/updateTest/{id}")
	public String updateTest(@PathVariable(value = "id") int testId, @RequestBody Test test) {
		return testService.updateTest(testId, test);

	}

	@PostMapping("/addQuestion/{id}")
	public String addQuestion(@PathVariable(value = "id") int testId, @RequestBody Question question) {
			return questionService.addQuestion(testId, question);

	}

	@PutMapping("/updateQuestion/{id}")
	public String updateQuestion(@PathVariable(value = "id") int qId, @RequestBody Question question) {
		return questionService.updateQuestion(qId, question);
	}

	@DeleteMapping("/deleteQuestion/{id}")
	public String deleteQuestion(@PathVariable(value = "id") int qId) {
		return questionService.deleteQuestion(qId);
	}

	@GetMapping("/viewAllQuestions")
	public List<Question> viewAllQuestion() {
		return questionService.viewAllQuestions();
	}

	
	@PostMapping("/getResult")
	public float getResult(@RequestBody Test test) {
		return testService.CalculateMarks(test);
	}

	@PostMapping("/assignTest/{userId}/{testId}")
	public String assignTest(@PathVariable(value = "userId") int userId, @PathVariable(value = "testId") int testId) {
		return userService.assignTest(userId, testId);
	}

}
