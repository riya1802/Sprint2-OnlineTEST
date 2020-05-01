package com.capg.onlinetest.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.capg.onlinetest.model.Question;
import com.capg.onlinetest.model.Test;
import com.capg.onlinetest.model.User;
import com.capg.onlinetest.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	AdminService adminService;
	
	@GetMapping("/allUsers")
	public List<User> getAllUser() {
		  return adminService.getAllUsers();
	}

	@PostMapping("/addTest")
	public String addTest(@RequestBody Test test) {
		return adminService.addTest(test);
	}

	@PutMapping("/updateTest")
	public String updateTest(@RequestBody Test test) {	
		return adminService.updateTest(test);
	}

	@DeleteMapping("/deleteTest/{id}")
	public String deleteTest(@PathVariable("id") int testId) {
		  return adminService.deleteTest(testId);
	}

	@GetMapping("/allTest")
	public List<Test> getAllTest() {
		return adminService.getAllTests();
	}

	@PostMapping("/addQuestion/{testId}")
	public String addQuestion(@PathVariable("testId") int testId, @RequestBody Question question) {
		return adminService.addQuestions(testId, question);
	}

	@DeleteMapping("/deleteQuestion/{testId}")
	public String deleteQuestion(@PathVariable("testId") int testId, @RequestBody Question question) {
		  return adminService.deleteQuestions(testId, question);
	}
	
	@PutMapping("/updateQuestion/{testId}")
	public String updateQuestion(@PathVariable("testId") int testId, @RequestBody Question question) {
          return adminService.updateQuestions(testId, question);
	}
	
	@PostMapping("/assignTest/{userId&testId}")
	public String assignTest(@PathVariable("userId") int userId, @PathVariable("testId") int testId) {
		return adminService.assignTest(userId, testId);
	}
	
}
