package com.capg.onlinetest.controller;

import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Answer {
	@Id	
	@GeneratedValue(strategy = GenerationType.AUTO)
	private  BigInteger answerId;
	private String answerName;
	public BigInteger getAnswerId() {
		return answerId;
	}
	public void setAnswerId(BigInteger answerId) {
		this.answerId = answerId;
	}
	public String getAnswerName() {
		return answerName;
	}
	public void setAnswerName(String answerName) {
		this.answerName = answerName;
	}
	public Answer(BigInteger answerId, String answerName) {
		super();
		this.answerId = answerId;
		this.answerName = answerName;
	}
	public Answer() {
		super();
	}
	
	

}
