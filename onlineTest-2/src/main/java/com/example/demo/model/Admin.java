package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "AdminTable")
@Component
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int adminId;
	private String adminName;
	private String adminPassword;
	@OneToOne
	@JoinColumn(name = "testId")
	private Test adminTest;
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getAdminPassword() {
		return adminPassword;
	}
	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}
	public Test getAdminTest() {
		return adminTest;
	}
	public void setAdminTest(Test adminTest) {
		this.adminTest = adminTest;
	}
	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", adminName=" + adminName + ", adminPassword=" + adminPassword
				+ ", adminTest=" + adminTest + "]";
	}
	
	
}