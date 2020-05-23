package com.capg.onlinetest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.capg.onlinetest.entity.User;

/**
 * 
 * @author TEAM EINSTEIN
 * 
 * UserDao Repository
 */
@Repository
public interface UserDao extends JpaRepository<User, Integer> {

	/**
	 * Gets ID of User by userName
	 * @param userName
	 * @return String
	 */
	@Query("select u.userId from User u where u.userName=?1")
	public String getIdByUserName(String userName);
}
