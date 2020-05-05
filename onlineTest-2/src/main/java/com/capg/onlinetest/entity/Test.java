package com.capg.onlinetest.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "TestTable")
public class Test {
	@Id
	private int testId;
	private String testTitle;
	@OneToMany(targetEntity = Question.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "testId", referencedColumnName = "testId")
	private List<Question> testQuestions;
	private int testDuration;
	private int testTotalMarks;
	@Transient
	private int currentQuestion;
	private Date startTime;
	private Date endTime;
	
	public int getTestId() {
		return testId;
	}

	public void setTestId(int testId) {
		this.testId = testId;
	}

	public String getTestTitle() {
		return testTitle;
	}

	public void setTestTitle(String testTitle) {
		this.testTitle = testTitle;
	}

	public List<Question> getTestQuestions() {
		return testQuestions;
	}

	public void setTestQuestions(List<Question> testQuestions) {
		this.testQuestions = testQuestions;
	}

	public int getTestDuration() {
		return testDuration;
	}

	public void setTestDuration(int testDuration) {
		this.testDuration = testDuration;
	}

	public int getTestTotalMarks() {
		return testTotalMarks;
	}

	public void setTestTotalMarks(int testTotalMarks) {
		this.testTotalMarks = testTotalMarks;
	}

	public int getCurrentQuestion() {
		return currentQuestion;
	}

	public void setCurrentQuestion(int currentQuestion) {
		this.currentQuestion = currentQuestion;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	

	public Test(int testId, String testTitle, List<Question> testQuestions, int testDuration, int testTotalMarks,
			int currentQuestion, Date startTime, Date endTime) {
		super();
		this.testId = testId;
		this.testTitle = testTitle;
		this.testQuestions = testQuestions;
		this.testDuration = testDuration;
		this.testTotalMarks = testTotalMarks;
		this.currentQuestion = currentQuestion;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public Test() {}

}
