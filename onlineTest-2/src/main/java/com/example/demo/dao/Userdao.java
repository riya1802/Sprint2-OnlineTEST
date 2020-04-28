package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.model.users;

public class Userdao {
	@Repository
	@Transactional
	public class StudentDao {
		@PersistenceContext
		EntityManager em;

		

		public List<users> getAlluser() {
			List<users> li = em.createQuery("from Student s").getResultList();
			return li;

		}
	
	public void saveUser(users user) {
		em.persist(user);
		
	}
}
}