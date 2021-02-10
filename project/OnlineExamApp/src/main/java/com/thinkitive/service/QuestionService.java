package com.thinkitive.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.thinkitive.dao.QuestionDao;

import com.thinkitive.dao.daoimplementation.QuestionDaoImplement;
import com.thinkitive.model.Exam;
import com.thinkitive.model.Question;
import com.thinkitive.model.Response;
@Service
public class QuestionService {
	
	
	
	QuestionDaoImplement questiondao;
	
	ExamService examser;
	
	@Autowired
	public void setQuestiondao(QuestionDaoImplement questiondao) {
		this.questiondao = questiondao;
	}
	@Autowired
	public void setExamser(ExamService examser) {
		this.examser = examser;
	}

	public Boolean checkIsCorrectAnswer(Question question, String selectedanswer) {
		
		if (question.getAnswer().equalsIgnoreCase(selectedanswer)) {
			System.out.println(question.getAnswer());
			System.out.println(selectedanswer);
			
			return true;
			
		}else

		return false;
		
	}
	
	public Question getquestion(int id) {
		return questiondao.getquestion(id);
		
	}
	
	public List<Question> getallquestion(int e_id){
		QuestionDaoImplement questiondao=new QuestionDaoImplement();
		
	return	questiondao.getall( e_id);
	}
	public void save(Question q) {
		QuestionDaoImplement questiondao=new QuestionDaoImplement();
		questiondao.save(q);
		
	}
	public void delete(int q_id) {
		QuestionDaoImplement questiondao=new QuestionDaoImplement();
		questiondao.delete(q_id);
		
	}
	public void update(Question q) {
		// TODO Auto-generated method stub
		
		QuestionDaoImplement questiondao=new QuestionDaoImplement();
		questiondao.update(q);
	}
	
	

}
