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

import com.thinkitive.dao.daoimplementation.QuestionDaoImplement;
import com.thinkitive.model.Question;
import com.thinkitive.model.Response;
import com.thinkitive.service.QuestionService;
@RequestMapping(value = "/question")
@RestController
public class QuestionController {
	public QuestionController() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	QuestionService qser;
	

@Autowired
	public void setQser(QuestionService qser) {
		this.qser = qser;
	}

	
	
@GetMapping(value = "/all/{e_id}")
public List<Question> getallquestions(@PathVariable("e_id")int e_id,HttpServletRequest request) {
	if(request.getSession()!=null) {
	QuestionService qser=new QuestionService();
	
	return qser.getallquestion(e_id);
	}
	else
		return null;
	
	
}


@PostMapping(value = "/add")
public String addquestion( @RequestBody Question q,HttpServletRequest request) {
	if(request.getSession()!=null) {
	QuestionService qser=new QuestionService();
	qser.save(q);
	return "added";
}
	else 
		return "loginfirst";
	
}

@PostMapping(value = "/delete/{id}")
public String deletequestion(@PathVariable("id") int id,HttpServletRequest request) {
	if(request.getSession()!=null) {
	QuestionService qser=new QuestionService();
	qser.delete(id);
	return "deleted";
}
else
	return "failed";
}

@PostMapping(value = "/update")
public void updatequestion(@RequestBody Question q) {
	QuestionService qser=new QuestionService();
	qser.update(q);
}

@GetMapping(value = "/{q_id}/next")
public Question getnextquestion(@PathVariable("q_id") int id, @RequestBody List<Response> res) {
	
	QuestionService qser=new QuestionService();
	return qser.getquestion(id);
	
	
}
@GetMapping(value = "/{q_id}/previous")
public Question getpreviousquestion(@PathVariable("q_id") int id) {
	QuestionService qser=new QuestionService();
	return qser.getquestion(id);
}








}
