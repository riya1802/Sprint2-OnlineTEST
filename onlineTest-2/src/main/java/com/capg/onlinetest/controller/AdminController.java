package com.capg.onlinetest.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.capg.onlinetest.exceptions.CannotAssignTestToAdminException;
import com.capg.onlinetest.exceptions.QuestionNotAddedException;
import com.capg.onlinetest.exceptions.QuestionNotFoundException;
import com.capg.onlinetest.exceptions.TestAlreadyAssignedException;
import com.capg.onlinetest.exceptions.TestNotAddedException;
import com.capg.onlinetest.exceptions.TestNotDeletedException;
import com.capg.onlinetest.exceptions.TestNotFoundException;
import com.capg.onlinetest.exceptions.UserListEmptyException;
import com.capg.onlinetest.exceptions.UserNotFoundException;
import com.capg.onlinetest.exceptions.WrongQuestionIdException;
import com.capg.onlinetest.exceptions.WrongTestIdException;
import com.capg.onlinetest.service.QuestionService;
import com.capg.onlinetest.service.TestService;
import com.capg.onlinetest.service.UserService;

/**
 * 
 * @author TEAM EINSTEIN 
 * ADMIN Controller
 */
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	UserService userService;
	@Autowired
	TestService testService;
	@Autowired
	QuestionService questionService;

	/**
	 * viewAllUser method
	 * 
	 * @return list of Users
	 */
	@GetMapping("/viewAllUsers")
	public ResponseEntity<?> viewAllUser() {
		try {
			return new ResponseEntity<List<User>>(userService.viewAllUser(), HttpStatus.OK);
		} catch (UserListEmptyException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NO_CONTENT);
		}
	}

	/**
	 * deleteUser method
	 * 
	 * @param userId
	 * @return String
	 */
	@DeleteMapping("/deleteUser/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable(value = "userId") int userId) {
		try {
			return new ResponseEntity<String>(userService.deleteUser(userId), HttpStatus.OK);
		} catch (UserNotFoundException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * assignTest method
	 * 
	 * @param userId
	 * @param testId
	 * @return String
	 */
	@PostMapping("/assignTest/{userId}/{testId}")
	public ResponseEntity<String> assignTest(@PathVariable(value = "userId") int userId,
			@PathVariable(value = "testId") int testId) {
		try {
			return new ResponseEntity<String>(userService.assignTest(userId, testId), HttpStatus.OK);
		} catch (TestAlreadyAssignedException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		} catch (TestNotFoundException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		} catch (CannotAssignTestToAdminException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
		} catch (UserNotFoundException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}

	}

	/**
	 * addTest method
	 * 
	 * @param Test Object
	 * @return String
	 */
	@PostMapping("/addTest")
	public ResponseEntity<?> addTest(@RequestBody Test test) {
		try {
			return new ResponseEntity<String>(testService.addTest(test), HttpStatus.OK);
		} catch (TestNotAddedException e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * viewAllTests method
	 * 
	 * @return list of tests
	 */
	@GetMapping("/viewAllTests")
	public List<Test> viewAllTest() {
		return testService.viewAllTests();
	}

	/**
	 * deleteTest method
	 * 
	 * @param testId
	 * @return String
	 */
	@DeleteMapping("/deleteTest/{id}")
	public ResponseEntity<String> deleteTest(@PathVariable(value = "id") int testId) {
		try {
			return new ResponseEntity<String>(testService.deleteTest(testId), HttpStatus.OK);
		} catch (TestNotDeletedException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		} catch (WrongTestIdException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * updateTest method
	 * 
	 * @param testId
	 * @param Test Object
	 * @return String
	 */
	@PutMapping("/updateTest/{id}")
	public ResponseEntity<String> updateTest(@PathVariable(value = "id") int testId, @RequestBody Test test) {
		try {
			return new ResponseEntity<String>(testService.updateTest(testId, test), HttpStatus.OK);
		} catch (TestNotFoundException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}

	}

	/**
	 * addQuestion method
	 * 
	 * @param testId
	 * @param question Object
	 * @return String
	 */
	@PostMapping("/addQuestion/{id}")
	public ResponseEntity<String> addQuestion(@PathVariable(value = "id") int testId, @RequestBody Question question) {
		try {
			return new ResponseEntity<String>(questionService.addQuestion(testId, question), HttpStatus.OK);
		} catch (QuestionNotAddedException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}

	/**
	 * updateQuestion method
	 * 
	 * @param questionId
	 * @param question object
	 * @return String
	 */
	@PutMapping("/updateQuestion/{id}")
	public ResponseEntity<String> updateQuestion(@PathVariable(value = "id") int qId, @RequestBody Question question) {
		try {
			return new ResponseEntity<String>(questionService.updateQuestion(qId, question), HttpStatus.OK);
		} catch (QuestionNotFoundException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

	/**
	 * deleteQuestion method
	 * 
	 * @param questionId
	 * @return String
	 */
	@DeleteMapping("/deleteQuestion/{id}")
	public ResponseEntity<String> deleteQuestion(@PathVariable(value = "id") int qId) {
		try {
			return new ResponseEntity<String>(questionService.deleteQuestion(qId), HttpStatus.OK);
		} catch (WrongQuestionIdException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}

	}

	/**
	 * viewAllQuestions method
	 * 
	 * @return list of all questions
	 */
	@GetMapping("/viewAllQuestions")
	public List<Question> viewAllQuestion() {
		return questionService.viewAllQuestions();
	}

	/**
	 * getResult method
	 * 
	 * @param Test Object
	 * @return float
	 */
	@PostMapping("/getResult")
	public float getResult(@RequestBody Test test) {
		return testService.calculateTotalMarks(test);
	}

}
