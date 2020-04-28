
package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Entity

@Table(name="employee")
public class users {
	@Id
	private int userId;
		private String userName;
		@OneToOne
		@JoinColumn(name = "testId")
		private Test userTest;
		private String userPassword;
	private String password;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
