package com.capg.onlinetest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.capg.onlinetest.entity.User;

@Repository
public interface UserDao extends JpaRepository<User, Integer> {

}
