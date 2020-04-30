package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Test;

@Repository
public interface TestDao extends JpaRepository<Test, Integer>{

}
