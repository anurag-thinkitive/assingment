package com.thinkitive.dao;

import java.util.List;

import com.thinkitive.model.Exam;
import com.thinkitive.model.Question;

public interface QuestionDao {

	
	public List<Question> getall(int e_id);
	
	public List<Question> get(Exam e);
	public void save(Question q);
	public void update(Question q);
	public void delete(int q_id );
	
	
}
