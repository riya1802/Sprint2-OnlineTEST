package com.capg.onlinetest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.capg.onlinetest.entity.User;

/**
 * 
 * @author Piyush
 * 'LOGIN' Test
 *
 */
@SpringBootTest
public class LoginTest {

	RestTemplate restTemplate;

	final String baseUrl = "http://localhost:9090/login";

	@BeforeEach
	public void setUp() {
		restTemplate = new RestTemplate();
	}

	/**
	 * Login Test 1
	 * 
	 * Valid credentials Test
	 */
	@Test
	public void loginTest1() {
		User user = new User(0, "Piyush", 0, 0, "capgemini");
		ResponseEntity<User> result = restTemplate.postForEntity(baseUrl, user, User.class);
		Assertions.assertEquals(200, result.getStatusCodeValue());
	}

	/**
	 * Login Test 2
	 * 
	 * Invalid userPassword Test
	 */
	@Test
	public void loginTest2() {
		User user=new User(0,"Piyush",0,0,"fantastic");  //invalid userPassword
		try {
			restTemplate.postForEntity(baseUrl, user, User.class);
			Assertions.fail();	
		}catch(HttpClientErrorException exception) {
			Assertions.assertEquals(401, exception.getRawStatusCode());
		}
		
	}

	/**
	 * Login Test 3
	 * 
	 * Invalid userName Test
	 */
	@Test
	public void loginTest3() {
		User user=new User(0,"Piyus",0,0,"capgemini");  //invalid userName
		try {
			restTemplate.postForEntity(baseUrl, user, User.class);
			Assertions.fail();	
		}catch(HttpClientErrorException exception) {
			Assertions.assertEquals(404, exception.getRawStatusCode());
		}
		
	}
}
