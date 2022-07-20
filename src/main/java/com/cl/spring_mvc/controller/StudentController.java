package com.cl.spring_mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("save.jsp");
		return modelAndView;
	}

}
