package com.thinkitive.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thinkitive.dao.daoimplementation.AdminDaoImplement;
import com.thinkitive.model.Admin;
import com.thinkitive.model.Exam;

@RestController
@RequestMapping(value = "/admin")
public class AdminLoginController {
	
	AdminDaoImplement dao;
	@Autowired
	public void setDao(AdminDaoImplement dao) {
		this.dao = dao;
	}
	@Autowired
	HttpSession session;
	

	@GetMapping(value = "/all")
	
	public List<Admin> getall(HttpServletRequest request){
		if(request.getSession()!=null) {
		AdminDaoImplement dao=new AdminDaoImplement();
		return dao.getalladmin();
		}else
			return null;
	}
	@PostMapping(value = "/login")
	public String  getAdmin(Admin a,HttpServletRequest request) {
		AdminDaoImplement dao=new AdminDaoImplement();
		if(a.getUsername()!=null && a.getPassword()!=null && dao.getstatus(a.getUsername())) {
			Admin admin=dao.getadmin(a.getUsername(), a.getPassword());	
			request.getSession().setAttribute("username", admin.getUsername());
			request.getSession().setAttribute("id", admin.getId());
			return "logedin";
		}else {
			return "try agin";
		}
	
		
		
		
	}
	
	@GetMapping(value = "\forgot")
	public String forgotpassword(Admin a) {
		AdminDaoImplement dao=new AdminDaoImplement();
		return dao.getpassword(a.getUsername());
	}
	
	

	

	@GetMapping(value = "/logout")
	public void logout() {
		session.invalidate();
	}
	
	
	
	
	
	

}
