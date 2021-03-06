package com.thinkitive.DEMOSpringUsingHibernate.model;

import org.springframework.stereotype.Component;

@Component

public class Employee {
	
private int empid;
private String ename;
private int salary;
public Employee() {
	// TODO Auto-generated constructor stub
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + empid;
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Employee other = (Employee) obj;
	if (empid != other.empid)
		return false;
	return true;
}
@Override
public String toString() {
	return "Employee [empid=" + empid + ", ename=" + ename + ", salary=" + salary + "]";
}
public int getEmpid() {
	return empid;
}
public void setEmpid(int empid) {
	this.empid = empid;
}
public String getEname() {
	return ename;
}
public void setEname(String ename) {
	this.ename = ename;
}
public int getSalary() {
	return salary;
}
public void setSalary(int salary) {
	this.salary = salary;
}
public Employee(int empid, String ename, int salary) {
	super();
	this.empid = empid;
	this.ename = ename;
	this.salary = salary;
}

}
