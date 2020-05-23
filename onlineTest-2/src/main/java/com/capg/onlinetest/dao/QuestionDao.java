package com.capg.onlinetest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.capg.onlinetest.entity.Question;

/**
 * 
 * @author TEAM EINSTEIN
 * 
 * QuestionDao Repository
 */
@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {

}
