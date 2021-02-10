package com.thinkitive.dao.daoimplementation;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.thinkitive.dao.ExamDao;

import com.thinkitive.model.Exam;
import com.thinkitive.model.Question;
import com.thinkitive.model.Result;
import com.thinkitive.model.Student;

@Repository
public class ExamDaoImplement implements ExamDao {
	

	Configuration cfg=new Configuration();
	@Override
	public List<Exam> getallexam() {
		// TODO Auto-generated method stub
		
		
	
		cfg.addAnnotatedClass(Question.class);
		cfg.addAnnotatedClass(Exam.class);
		
		cfg.addAnnotatedClass(Result.class);
		cfg.addAnnotatedClass(Student.class);
		SessionFactory factory =cfg.configure().buildSessionFactory();
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		org.hibernate.Query q=session.createQuery("From Exam");
		List<Exam> l=q.list();
		
		tx.commit();
		session.close();
		factory.close();
		return l;
		
		
	}

	@Override
	public 	Exam getexam(int id) {
		// TODO Auto-generated method stub
		
		Exam e=new Exam();
		cfg.addAnnotatedClass(Exam.class);
	
		cfg.addAnnotatedClass(Result.class);
		cfg.addAnnotatedClass(Student.class);
		cfg.addAnnotatedClass(Question.class);
		SessionFactory factory =cfg.configure().buildSessionFactory();
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
	Criteria c=session.createCriteria(Exam.class);
	System.out.println("this is id"+id);
	c.add(Restrictions.eqOrIsNull("e_id", id));
	
	e= (Exam)c.uniqueResult();
	tx.commit();
	
	session.close();
	factory.close();
	return e;
	}

	@Override
	public void savexam(Exam exam) {
		// TODO Auto-generated method stub
		cfg.addAnnotatedClass(Exam.class);
		cfg.addAnnotatedClass(Question.class);
	
		
		cfg.addAnnotatedClass(Result.class);
		cfg.addAnnotatedClass(Student.class);
		SessionFactory factory =cfg.configure().buildSessionFactory();
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		session.save(exam);
		tx.commit();
		session.close();
		factory.close();
		
		
	}

	@Override
	public void editexam(Exam exam) {
		// TODO Auto-generated method stub
		cfg.addAnnotatedClass(Question.class);
		cfg.addAnnotatedClass(Exam.class);
		
		cfg.addAnnotatedClass(Result.class);
		cfg.addAnnotatedClass(Student.class);
		SessionFactory factory =cfg.configure().buildSessionFactory();
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		session.update(exam);
		tx.commit();
		session.close();
		factory.close();
		
	}

	@Override
	public void deletexam(int e_id ) {
		cfg.addAnnotatedClass(Question.class);
		cfg.addAnnotatedClass(Exam.class);
		
		cfg.addAnnotatedClass(Result.class);
		cfg.addAnnotatedClass(Student.class);
		SessionFactory factory =cfg.configure().buildSessionFactory();
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		Exam exam=new Exam();
		exam.setE_id(e_id);
		session.delete(exam);
		tx.commit();
		session.close();
		factory.close();
		
	}
	
	
	

	
	
}
