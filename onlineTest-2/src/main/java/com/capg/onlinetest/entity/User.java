package com.capg.onlinetest.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "UserTable")
public class User {
	@Id
	private Integer userId;
	@Size(min=5,max=20,message="User name should be minimum 5 and maximum 20 characters long")
	private String userName;
	private int testId;
	private int isAdmin;
	@Size(min=8,message="Password should be minimum 8 characters long")
	private String userPassword;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getTestId() {
		return testId;
	}
	public void setTestId(int testId) {
		this.testId = testId;
	}
	public int getIsAdmin() {
		return isAdmin;
	}
	public void setAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public User( String userName, int testId, int isAdmin, String userPassword) {
		
		
		this.userName = userName;
		this.testId = testId;
		this.isAdmin = isAdmin;
		this.userPassword = userPassword;
	}
	public User(){}
}
