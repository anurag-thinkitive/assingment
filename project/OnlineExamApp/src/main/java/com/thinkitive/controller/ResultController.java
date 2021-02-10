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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.thinkitive.dao.ResultDao;
import com.thinkitive.dao.daoimplementation.ResultDaoImplementation;
import com.thinkitive.model.Exam;
import com.thinkitive.model.Question;
import com.thinkitive.model.Response;
import com.thinkitive.model.Result;
import com.thinkitive.model.Student;
import com.thinkitive.service.ExamService;

@RestController
@RequestMapping("/result")
public class ResultController {
	
	ResultDaoImplementation dao =new ResultDaoImplementation();

	ExamService exser= new ExamService();
	@Autowired
	 HttpSession session;
	
	
	@PostMapping(value = "/submit/{e_id}")
	public void createresult(@PathVariable( "e_id") int e_id,	@RequestBody List<Response> res,HttpServletRequest request) {
		System.out.println(e_id); 
		if(session.getAttribute("username")!=null) {
		Exam exam= exser.getexam(e_id);
		System.out.println(res);
	
	
	
		dao.saveresult(exser.checkanswer(exam, res,request));
		
		}
		
		
	}
	@GetMapping(value = "/all")
	public List<Result> getall() {
		
	return dao.getallresult();	
	}
	
	
	
	

}
