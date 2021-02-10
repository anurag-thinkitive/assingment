package com.thinkitive.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.thinkitive.dao.daoimplementation.StudentDaoImplement;
import com.thinkitive.model.Student;

@Service
public class StudentService {

	
	StudentDaoImplement dao;
	
	
	public Student StudentLOgin(String username,String password) {
		StudentDaoImplement dao=new StudentDaoImplement();
		if(dao.getstudennt(username, password)!=null) 
			return dao.getstudennt(username, password);
		else {
			return null;
		}
	}
	
	public List<Student> allstudent(){
		
		return dao.getall();
	}
	
	

@Autowired
	public void setDao(StudentDaoImplement dao) {
		this.dao = dao;
	}
	
	
}
