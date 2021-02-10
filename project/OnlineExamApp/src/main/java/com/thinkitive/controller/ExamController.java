package com.thinkitive.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.thinkitive.dao.daoimplementation.ExamDaoImplement;
import com.thinkitive.model.Exam;
import com.thinkitive.model.Question;
@RequestMapping( value = "/exam")
@RestController
public class ExamController {
	
	ExamDaoImplement dao;
	
	@Autowired
	public void setDao(ExamDaoImplement dao) {
		this.dao = dao;
	}
	
	



	@GetMapping(value = "/{id}")
	public  @ResponseBody Exam getexam(@PathVariable("id") int id,HttpServletResponse response) {
		
		ExamDaoImplement dao=new ExamDaoImplement();
		String url="/exam/submit/"+id;
		TimerTask task = new TimerTask() {
	        public void run() {
	            try {
					response.sendRedirect(url);
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }
	    };
	    Timer timer = new Timer("Timer");
	    
	    long delay = 1L;
	    timer.schedule(task, delay);
		
		Exam e=dao.getexam(id);
	
			
	
		
		return e;
		
		
	}
	
	
	
	public ExamController() {
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping(value = "/all")
	public List<Exam> getallexam(HttpServletRequest request){
		ExamDaoImplement dao=new ExamDaoImplement();
		if(request.getSession()!=null) {
			return dao.getallexam();	
		}else  return  null;
			
		
	
	}
	
	
	@PostMapping(value = "/create")
	public String createexam(@RequestBody Exam e,HttpServletRequest request) {
		ExamDaoImplement dao=new ExamDaoImplement();
		if(request.getSession()!=null) {
		dao.savexam(e);
		return "sucess";
		}else
			return "login first";
					}
	
	@PostMapping(value = "/edit")
	public String editexam(@RequestBody Exam exam,HttpServletRequest request) {
		ExamDaoImplement dao=new ExamDaoImplement();
		if(request.getSession()!=null) {
		dao.editexam(exam);
return "success";
		}else
		return "login first";
	}
	@PostMapping( value = "/delete/{id}")
	public String deletexam(@PathVariable("id") int id ,HttpServletRequest request) {
		ExamDaoImplement dao=new ExamDaoImplement();
		if(request.getSession()!=null) {
		dao.deletexam(id);
		return "deleted";
		}else
			return "loginfirst";
	}
	
	
	
	
	

}
