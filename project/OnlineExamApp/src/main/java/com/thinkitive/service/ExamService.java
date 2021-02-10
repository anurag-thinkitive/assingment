package com.thinkitive.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.thinkitive.dao.daoimplementation.ExamDaoImplement;
import com.thinkitive.model.Exam;
import com.thinkitive.model.Question;
import com.thinkitive.model.Response;
import com.thinkitive.model.Result;
import com.thinkitive.model.Student;
@Service
public class ExamService {
	public ExamService() {
		// TODO Auto-generated constructor stub
	}

ExamDaoImplement dao;

@Autowired
public void setDao(ExamDaoImplement dao) {
	this.dao = dao;
}

QuestionService qser;
	@Autowired
	public void setQser(QuestionService qser) {
	this.qser = qser;
}

	public Exam getexam( int id) {
		ExamDaoImplement dao=new ExamDaoImplement();
		System.out.println("examser");
		return dao.getexam(id);
		
		
	}
	
	public Result checkanswer(Exam e,List<Response>  answeres,HttpServletRequest request) {
		Result result =new Result();
		Student student=new Student();
	
		System.out.println(request.getSession().getAttribute("username"));
		student.setName( (String) request.getSession().getAttribute("username"));
		student.setId((int) request.getSession().getAttribute("id"));
		
		
		QuestionService qser=new QuestionService();
		int totalmarks=0;
		List<Question >q =new ArrayList<Question>();
		q=e.getQuestions();
		for (Question question :q ) {
		for (Response bundle : answeres) {
			if (bundle.getQuestion()==(question.getQ_id())) {
				
				if(qser.checkIsCorrectAnswer(question, bundle.getAnswer())){
					totalmarks++;
				}
				
				
				
			}
		}
	}
		result.setExam(e);
		result.setMarks(totalmarks);
		result.setStudent(student);
		
		return result;
	}
	
	
	
	

}
