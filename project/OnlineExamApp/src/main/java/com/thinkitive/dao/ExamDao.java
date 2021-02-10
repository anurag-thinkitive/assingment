package com.thinkitive.dao;

import java.util.List;

import com.thinkitive.model.Exam;

public interface ExamDao {
	
	public List<Exam> getallexam();
	
	public Exam getexam(int id);
	public void savexam(Exam exam);
	public void editexam(Exam exam);
	public void deletexam(int e_id);

}
