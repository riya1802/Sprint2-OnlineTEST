package com.capg.onlinetest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

/**
 * 
 * @author Piyush
 * 'DELETE USER' TEST CASES
 *
 */
@SpringBootTest
public class DeleteUserTest {

	RestTemplate restTemplate;

	@BeforeEach
	public void setUp() {
		restTemplate = new RestTemplate();
	}

	/**
	 * DeleteUser Test 1
	 * 
	 * Valid userId
	 */
	@Test
	public void deleteUserTest1() {
		int userId = 420; // valid userId
		restTemplate.delete("http://localhost:9090/admin/deleteUser/" + userId);
	}

	/**
	 * Delete User Test 2 
	 * 
	 * Invalid userId Test
	 */
	@Test
	public void deleteUserTest2() {
		int userId = 100; // invalid userId
		try {
			restTemplate.delete("http://localhost:9090/admin/deleteUser/" + userId);
			Assertions.fail();
		} catch (HttpClientErrorException exception) {
			Assertions.assertEquals(404, exception.getRawStatusCode());
		}

	}

}
