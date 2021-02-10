package com.thinkitive.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thinkitive.dao.daoimplementation.AdminDaoImplement;
import com.thinkitive.model.Admin;

@Service
public class AdminService {
	AdminDaoImplement dao=new AdminDaoImplement();
	
	@Autowired
public void setDao(AdminDaoImplement dao) {
		this.dao = dao;
	}


public 	Admin Login(String username,String password) {
	 return dao.getadmin(username, password);
	
	
}
	
}
