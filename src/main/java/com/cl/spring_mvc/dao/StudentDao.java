package com.cl.spring_mvc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

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

	public List<Student> getAllStudent() {
		Query query = manager.createQuery("select s from Student s");
		return query.getResultList();
	}

	public void deleteStudent(int id) {
		Student student = manager.find(Student.class, id);
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		manager.remove(student);
		transaction.commit();
	}

}
