package com.capg.onlinetest.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AnswerTable")
public class Answer {

	@Id
	private int answerId;
	private String value;

	public int getAnswerId() {
		return answerId;
	}


	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}


	public String getValue() {
		return value;
	}


	public void setValue(String value) {
		this.value = value;
	}
	
	public Answer(int answerId, String value) {
		super();
		this.answerId = answerId;
		this.value = value;
	}


	public Answer() {}

}
