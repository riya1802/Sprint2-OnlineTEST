
package com.capg.onlinetest.model;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name = "TestTable")
public class Test {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int testId;
	private String testTitle;
	private LocalTime testDuration;
	@OneToMany(targetEntity = Question.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "testId", referencedColumnName = "testId")
	private Set<Question> testQuestions;
	private float testTotalMarks;
	private float testMarksScored;
	@Transient
	private Question currentQuestion;
	private LocalDateTime startTime;
	private LocalDateTime endTime;
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
	public LocalTime getTestDuration() {
		return testDuration;
	}
	public void setTestDuration(LocalTime testDuration) {
		this.testDuration = testDuration;
	}
	public Set<Question> getTestQuestions() {
		return testQuestions;
	}
	public void setTestQuestions(Set<Question> testQuestions) {
		this.testQuestions = testQuestions;
	}
	public float getTestTotalMarks() {
		return testTotalMarks;
	}
	public void setTestTotalMarks(float testTotalMarks) {
		this.testTotalMarks = testTotalMarks;
	}
	public float getTestMarksScored() {
		return testMarksScored;
	}
	public void setTestMarksScored(float testMarksScored) {
		this.testMarksScored = testMarksScored;
	}
	public Question getCurrentQuestion() {
		return currentQuestion;
	}
	public void setCurrentQuestion(Question currentQuestion) {
		this.currentQuestion = currentQuestion;
	}
	public LocalDateTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}
	public LocalDateTime getEndTime() {
		return endTime;
	}
	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}
	@Override
	public String toString() {
		return "Test [testId=" + testId + ", testTitle=" + testTitle + ", testDuration=" + testDuration
				+ ", testQuestions=" + testQuestions + ", testTotalMarks=" + testTotalMarks + ", testMarksScored="
				+ testMarksScored + ", currentQuestion=" + currentQuestion + ", startTime=" + startTime + ", endTime="
				+ endTime + "]";
	}
	
	
}






