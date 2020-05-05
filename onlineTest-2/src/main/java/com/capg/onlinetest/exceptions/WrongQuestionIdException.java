package com.capg.onlinetest.exceptions;

public class WrongQuestionIdException extends RuntimeException{
	public WrongQuestionIdException(String message) {
		super(message);
	}
}
