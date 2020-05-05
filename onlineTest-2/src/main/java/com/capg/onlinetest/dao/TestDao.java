package com.capg.onlinetest.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.capg.onlinetest.entity.Test;

@Repository
public interface TestDao extends JpaRepository<Test, Integer> {

}
