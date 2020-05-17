package com.capg.onlinetest.service;

import java.util.List;
import com.capg.onlinetest.entity.Test;

public interface TestService {

	public String addTest(Test test);
    public String deleteTest(int testId);
    public String updateTest(int testId, Test test);
    public List<Test> viewAllTests();
    public float calculateTotalMarks(Test test);
}
