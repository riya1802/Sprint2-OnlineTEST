package com.capg.onlinetest;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

/**
 * 
 * @author Piyush
 * 'VIEW ALL USER' TEST
 *
 */
@SpringBootTest
public class ViewAllUserTest {

	RestTemplate restTemplate;
	
	@BeforeEach
	public void setUp() {
		restTemplate = new RestTemplate();
	}
	
	/**
	 * View All Users Test
	 * 
	 */
	@Test
	public void viewAllUserTest() {
		ResponseEntity<?> list=restTemplate.getForEntity("http://localhost:9090/admin/viewAllUsers", List.class);
		Assertions.assertEquals(200, list.getStatusCodeValue());
	}
	
	
		
}
