package com.capg.onlinetest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.capg.onlinetest.entity.Answer;

/**
 * 
 * @author TEAM EINSTEIN
 *
 * AnswerDao Repository
 */
@Repository
public interface AnswerDao extends JpaRepository<Answer, Integer> {

}
