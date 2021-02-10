package com.thinkitive.dao;

import java.util.List;

import com.thinkitive.model.Admin;

public interface AdminDao {
	
	public List<Admin> getalladmin();
	

	
	
	
	public Admin getadmin( String username, String password);


}
