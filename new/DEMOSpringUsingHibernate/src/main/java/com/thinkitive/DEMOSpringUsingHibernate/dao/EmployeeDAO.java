package com.thinkitive.DEMOSpringUsingHibernate.dao;

import java.util.List;

import com.thinkitive.DEMOSpringUsingHibernate.model.Employee;

public interface EmployeeDAO {
	
	public void addEmployee(Employee e);
	
	public void deleteEmployee(Employee e);
	public List<Employee> getEmployee(int empid);
	public void updateEmployee(Employee e);
	public List<Employee> getall ();

	;
}
