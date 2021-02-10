package com.thinkitive.dao;

import java.util.List;

import com.thinkitive.model.Student;

public interface StudentDao {
	
	
	public Student getstudennt(String username,String password);
	
	public List<Student> getall();
	
	
	
	

}
