package com.thinkitive.dao;

import java.util.List;

import com.thinkitive.model.Admin;
import com.thinkitive.model.Exam;
import com.thinkitive.model.Result;
import com.thinkitive.model.Teacher;

public interface TeacherDao {
	

	
	
	public Teacher getteacher( String username, String password);
	List<Teacher> getallteacher();

}
