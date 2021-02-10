package com.thinkitive.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.thinkitive.dao.daoimplementation.TeacherDaoImplement;

import com.thinkitive.model.Teacher;
import com.thinkitive.service.QuestionService;
@RestController
@RequestMapping(value = "/teacher")

public class TeacherController {

	TeacherDaoImplement dao;
	@Autowired
	public void setDao(TeacherDaoImplement dao) {
		this.dao = dao;
	}

	QuestionService qser;
	@Autowired
public void setQser(QuestionService qser) {
	this.qser = qser;
}
	
	@PostMapping(value = "/login")
	public String  loginstudent( @RequestBody Teacher  t,HttpServletRequest request) {
		TeacherDaoImplement dao=new TeacherDaoImplement();
		System.out.println(t.getUsername());
		System.out.println(t.getPassword());
		if(t.getUsername()!=null && t.getPassword()!=null 	) {
			Teacher teacher=dao.getteacher(t.getUsername(), t.getPassword());	
			System.out.println( teacher.getName());
			request.getSession().setAttribute("username", teacher.getName());
			System.out.println(request.getSession().getAttribute("username"));
			request.getSession().setAttribute("id", teacher.getId());
			return"logeedin";
		}
		else {
			return "redirect:/";
		}
	
}
	
	
}
