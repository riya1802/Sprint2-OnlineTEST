package com.capg.onlinetest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.capg.onlinetest.entity.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {

	@Query("select u.userId from User u where u.userName=?1")
	public int getIdByUserName(String userName);
}
