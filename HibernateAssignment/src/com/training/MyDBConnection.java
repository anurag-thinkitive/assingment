package com.training;



import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class MyDBConnection {
 public MyDBConnection() {
	// TODO Auto-generated constructor stub
	
}
 Configuration cfg =new Configuration();
	SessionFactory factory=cfg.configure().buildSessionFactory();
	
 
 
	public void insertEmployee(Employee e) {
		
		Session session=factory.openSession();
		
		Transaction tx=session.beginTransaction();

		session.save(e);
		
		tx.commit();

		session.close();
	
	
	}
	public List reademployee() {
		Session session=factory.openSession();
		
		Transaction tx=session.beginTransaction();

		Query q= session.createQuery("From Employee ");
		List l=q.list();
		
		
		session.close();
		
		return l;
	}
	public void deleteemployee(Employee e) {
		Session session=factory.openSession();
		
		Transaction tx=session.beginTransaction();

		
		session.delete(e);
		
		tx.commit();

		
		
	}
public void updateEmployee(Employee e) {
		
		Session session=factory.openSession();
		
		Transaction tx=session.beginTransaction();

		session.update(e);
		
		tx.commit();

		session.close();
	
	
	}
	
	
	
}
