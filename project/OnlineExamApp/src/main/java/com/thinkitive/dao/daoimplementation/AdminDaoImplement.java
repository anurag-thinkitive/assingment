package com.thinkitive.dao.daoimplementation;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import com.thinkitive.dao.AdminDao;
import com.thinkitive.model.Admin;
import com.thinkitive.model.Exam;
import com.thinkitive.model.Question;
import com.thinkitive.model.Result;
import com.thinkitive.model.Student;
import com.thinkitive.model.Teacher;

@Service
public class AdminDaoImplement implements AdminDao{
	Configuration cfg=new Configuration();
	
	@Override
	public List<Admin> getalladmin() {
		cfg.addAnnotatedClass(Admin.class);
		
		
		SessionFactory factory= cfg.configure().buildSessionFactory();
		Session session =factory.openSession();
		Transaction tx=session.beginTransaction();
		
		Query q=session.createQuery("From Admin");
		
		List<Admin> l=q.list();// TODO Auto-generated method stub
		
		tx.commit();
		session.close();
		factory.close();
		return l;
	}

	
	
	public String getpassword( String username) {
		
		cfg.addAnnotatedClass(Admin.class);
		SessionFactory factory= cfg.configure().buildSessionFactory();
		Session session =factory.openSession();
		Transaction tx=session.beginTransaction();	
		Criteria c=session.createCriteria(Admin.class);
		c.add(Restrictions.eqOrIsNull("username",username ));
		Admin admi=(Admin) c.uniqueResult();
		
		tx.commit();
		session.close();
		factory.close();
		return admi.getPassword();
	}
	
	public boolean setstatus(Admin a) {
		cfg.addAnnotatedClass(Admin.class);
		SessionFactory factory= cfg.configure().buildSessionFactory();
		Session session =factory.openSession();
		Transaction tx=session.beginTransaction();	
		
		a.setStatus(true);
		session.save(a);
		tx.commit();
		session.close();
		factory.close();
		return true;
		
		
	}
public boolean setstatus(Student s) {
	cfg.addAnnotatedClass(Student.class);
	SessionFactory factory= cfg.configure().buildSessionFactory();
	Session session =factory.openSession();
	Transaction tx=session.beginTransaction();	
	
	s.setStatus(true);
	session.save(s);
	tx.commit();
	session.close();
	factory.close();
	return true;	
	}
public boolean setstatus(Teacher t) {
	cfg.addAnnotatedClass(Teacher.class);
	SessionFactory factory= cfg.configure().buildSessionFactory();
	Session session =factory.openSession();
	Transaction tx=session.beginTransaction();	
	
	t.setStatus(true);
	session.save(t);
	tx.commit();
	session.close();
	factory.close();
	return true;
}

	
	public boolean getstatus(String username ) {
		cfg.addAnnotatedClass(Admin.class);
		SessionFactory factory= cfg.configure().buildSessionFactory();
		Session session =factory.openSession();
		Transaction tx=session.beginTransaction();	
		Criteria c=session.createCriteria(Admin.class);
		c.add(Restrictions.eqOrIsNull("username",username ));
		Admin admi=(Admin) c.uniqueResult();
return admi.isStatus();
	}

	

	@Override
	public Admin getadmin( String username,String password) {
		cfg.addAnnotatedClass(Admin.class);
		SessionFactory factory= cfg.configure().buildSessionFactory();
		Session session =factory.openSession();
		Transaction tx=session.beginTransaction();	
		Criteria c=session.createCriteria(Admin.class);
		c.add(Restrictions.eqOrIsNull("username",username ));
		c.add(Restrictions.eqOrIsNull("password", password));
	
	return (Admin) c.uniqueResult();
		
	}

	



}
