package com.capg.onlinetest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

/**
 * 
 * @author Piyush
 * 'ASSIGN TEST' TEST
 *
 */
@SpringBootTest
public class AssignTestTest {

	RestTemplate restTemplate;

	@BeforeEach
	public void setUp() {
		restTemplate = new RestTemplate();
	}

	/**
	 * AssignTest Test 1
	 * 
	 * Valid userId and testId Test
	 */
	@Test
	public void assignTestTest1() {
		int userId = 7;
		int testId = 1002;
		ResponseEntity<String> result = restTemplate
				.postForEntity("http://localhost:9090/admin/assignTest/" + userId + "/" + testId, null, String.class);
		Assertions.assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * AssignTest Test 2
	 * 
	 * Invalid userId Test
	 */
	@Test
	public void assignTestTest2() {
		int userId = 90; // invalid userId
		int testId = 1002;
		try {
			restTemplate.postForEntity("http://localhost:9090/admin/assignTest/" + userId + "/" + testId, null,
					String.class);
			Assertions.fail();
		} catch (HttpClientErrorException exception) {
			Assertions.assertEquals(404, exception.getRawStatusCode());
		}
	}

	/**
	 * AssignTest Test 3
	 * 
	 * Invalid TestId Test
	 */
	@Test
	public void assignTestTest3() {
		int userId = 6;
		int testId = 2000; // invalid testId
		try {
			restTemplate.postForEntity("http://localhost:9090/admin/assignTest/" + userId + "/" + testId, null,
					String.class);
			Assertions.fail();
		} catch (HttpClientErrorException exception) {
			Assertions.assertEquals(404, exception.getRawStatusCode());
		}
	}

	/**
	 * AssignTest Test 4
	 * 
	 * Invalid Assignment to Valid UserId Test (Test cannot be assigned to Admin)
	 */
	@Test
	public void assignTest4() {
		int userId = 1;   // valid userId of Admin (Invalid userId to assign test)
		int testId = 1002;  // valid testId
		try {
			restTemplate.postForEntity("http://localhost:9090/admin/assignTest/" + userId + "/" + testId, null,
					String.class);
			Assertions.fail();
		} catch (HttpClientErrorException exception) {
			Assertions.assertEquals(409, exception.getRawStatusCode());
		}

	}

	/**
	 * AssignTest Test 5
	 * 
	 * Invalid assignment to valid userId and testId (One Test already assigned to user)
	 */
	@Test
	public void assignTest5() {
		int userId = 2;   // valid userId 
		int testId = 1001;  // valid testId
		try {
			restTemplate.postForEntity("http://localhost:9090/admin/assignTest/" + userId + "/" + testId, null,
					String.class);
			Assertions.fail();
		} catch (HttpClientErrorException exception) {
			Assertions.assertEquals(400, exception.getRawStatusCode());
		}

	}

}
