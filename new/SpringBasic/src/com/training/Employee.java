package com.training;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;


/*@Component*/
public class Employee {
private int empid;
private String name;
private int salary;
/*@Autowired*/
private List<Address> addr;




public Employee(List<Address> addr) {
	super();
	this.addr = addr;
}

public Employee(int empid, String name, int salary, List<Address> addr) {
	super();
	this.empid = empid;
	this.name = name;
	this.salary = salary;
	this.addr = addr;
}

public List<Address> getAddr() {
	return addr;
}
@Required
public void setAddr(List<Address> addr) {
	this.addr = addr;
}

public Employee() {
	// TODO Auto-generated constructor stub
}

public int getEmpid() {
	return empid;
}
public void setEmpid(int empid) {
	this.empid = empid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getSalary() {
	return salary;
}
public void setSalary(int salary) {
	this.salary = salary;
}
public Employee(int empid, String name, int salary) {
	super();
	this.empid = empid;
	this.name = name;
	this.salary = salary;
}

@Override
public String toString() {
	return "Employee [empid=" + empid + ", name=" + name + ", salary=" + salary + ", addr=" + addr + "]";
}

	
	
}
