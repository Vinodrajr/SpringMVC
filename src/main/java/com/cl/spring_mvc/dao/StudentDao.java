package com.cl.spring_mvc.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cl.spring_mvc.dto.Student;

@Repository
public class StudentDao {

	@Autowired
	EntityManager manager;

	public void saveStudent(Student student) {

		EntityTransaction transaction = manager.getTransaction();

		transaction.begin();

		manager.persist(student);

		transaction.commit();

	}

}
