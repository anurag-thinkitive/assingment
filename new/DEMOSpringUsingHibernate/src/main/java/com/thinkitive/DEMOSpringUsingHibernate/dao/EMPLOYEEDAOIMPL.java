package com.thinkitive.DEMOSpringUsingHibernate.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.thinkitive.DEMOSpringUsingHibernate.model.Employee;
@Service
public class EMPLOYEEDAOIMPL  implements EmployeeDAO{
public EMPLOYEEDAOIMPL() {
	// TODO Auto-generated constructor stub
}

Configuration cfg =new Configuration();
SessionFactory factory=cfg.configure().buildSessionFactory();

@Override
public void addEmployee(Employee e) {
Session session=factory.openSession();
	
	Transaction tx=session.beginTransaction();

	session.save(e);
	
	tx.commit();

	session.close();	// TODO Auto-generated method stub
	
}

@Override
public void deleteEmployee(Employee e) {
	
	// TODO Auto-generated method stub
Session session=factory.openSession();
	
	Transaction tx=session.beginTransaction();

	
	session.delete(e);
	
	tx.commit();
}

@Override
public List getEmployee(int empid) {
	// TODO Auto-generated method stub
List<Employee>	l=new ArrayList<Employee>();

Session session=factory.openSession();
Transaction t=session.beginTransaction();
Criteria c=session.createCriteria(Employee.class);
c.add(Restrictions.eqOrIsNull("empid", empid));
l=c.list();

System.out.println(l);
t.commit();
session.close();
factory.close();
return l;
}

@Override
public void updateEmployee(Employee e) {
	// TODO Auto-generated method stub
Session session=factory.openSession();
	
	Transaction tx=session.beginTransaction();

	session.update(e);
	
	tx.commit();

	session.close();
}

@Override
public List<Employee> getall() {
	// TODO Auto-generated method stub
	Session session=factory.openSession();
	
	Transaction tx=session.beginTransaction();

	Query q= session.createQuery("From Employee ");
	List l=q.list();
	
	
	session.close();
	
	return l;
}











}
