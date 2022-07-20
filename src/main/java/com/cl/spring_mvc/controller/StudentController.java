package com.cl.spring_mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cl.spring_mvc.dao.StudentDao;
import com.cl.spring_mvc.dto.Student;

@Controller
public class StudentController {
	@Autowired
	StudentDao dao;

	@RequestMapping(value = "login", method = RequestMethod.GET)
	public ModelAndView studentLogin() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("Login.jsp");
		modelAndView.addObject("student", new Student());
		return modelAndView;

	}

	@RequestMapping("savestudent")
	public ModelAndView saveStudent(@ModelAttribute Student student) {
		dao.saveStudent(student);
		List<Student> list = dao.getAllStudent();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("std", list);
		modelAndView.setViewName("view.jsp");
		return modelAndView;
	}

	@RequestMapping("delete")
	public ModelAndView deleteStudent(@RequestParam int id) {
		dao.deleteStudent(id);// deleted student
		List<Student> students = dao.getAllStudent();// fetching the list after deleting
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("std", students);
		modelAndView.setViewName("view.jsp");
		return modelAndView;
	}

	@RequestMapping("edit")
	public ModelAndView editStudent(@RequestParam int id) {

		Student student = dao.getbyID(id);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("student", student);
		modelAndView.setViewName("edit.jsp");
		return modelAndView;

	}

	@RequestMapping("updatestudent")
	public ModelAndView viewStudent(@ModelAttribute Student student) {
		dao.updateStudnet(student);
		List<Student> students = dao.getAllStudent();// fetching the list after deleting
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("std", students);
		modelAndView.setViewName("view.jsp");
		return modelAndView;

	}
}
