package com.thinkitive.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thinkitive.dao.daoimplementation.AdminDaoImplement;
import com.thinkitive.dao.daoimplementation.ResultDaoImplementation;
import com.thinkitive.dao.daoimplementation.StudentDaoImplement;
import com.thinkitive.model.Admin;
import com.thinkitive.model.Result;
import com.thinkitive.model.Student;

import com.thinkitive.service.StudentService;
@RequestMapping(value = "/studentlogin")
@RestController
public class StudentController {
	
	StudentService studservice;
	ResultDaoImplementation dao;
@Autowired	
	public void setDao(ResultDaoImplementation dao) {
		this.dao = dao;
	}

@Autowired
	public void setStudservice(StudentService studservice) {
		this.studservice = studservice;
	}

@Autowired
 HttpSession session;


@GetMapping(value = "/all")
	public List<Student> getall(){
		StudentService studservice=new StudentService();
		return studservice.allstudent();
		
	}

	
	@PostMapping(value = "/login")
	public String  loginstudent( @RequestBody Student  s,HttpServletRequest request) {
		StudentDaoImplement dao=new StudentDaoImplement();
		System.out.println(s.getUsername());
		System.out.println(s.getPassword());
		if(s.getUsername()!=null && s.getPassword()!=null 	) {
			Student student=dao.getstudennt(s.getUsername(), s.getPassword());	
			System.out.println( student.getName());
			request.getSession().setAttribute("username", student.getName());
			System.out.println(session.getAttribute("username"));
			request.getSession().setAttribute("id", student.getId());
			return"logeedin";
		}
		else {
			return "redirect:/";
		}
		
		
		
		
		
		
		
	}
	@GetMapping(value = "/result")
	public int getresult(HttpServletRequest request){
		ResultDaoImplementation dao=new ResultDaoImplementation();
		System.out.println(request.getSession().getAttribute("id"));
		
		Result r=dao.getresultbystudent((int) request.getSession().getAttribute("id") );	
		return r.getMarks();
			
		
		
	}
	
	
	
	
	
	
	@GetMapping(value = "/logout")
	public void logout() {
		session.invalidate();
	}
	
	@GetMapping(value = "\forgot")
	public String forgotpassword(Student stud) {
		StudentDaoImplement dao=new StudentDaoImplement();
		return dao.getpassword(stud.getUsername());
	}
	

}
