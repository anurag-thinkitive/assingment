package com.thinkitive.dao.daoimplementation;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.thinkitive.dao.QuestionDao;

import com.thinkitive.model.Exam;
import com.thinkitive.model.Question;
import com.thinkitive.model.Result;
import com.thinkitive.model.Student;
@Repository
public class QuestionDaoImplement implements QuestionDao {

	Configuration cfg=new Configuration();
	Question q=new Question();
	@Override
	public List<Question> getall(int e_id) {
		// TODO Auto-generated method stub
		cfg.addAnnotatedClass(Question.class);
		cfg.addAnnotatedClass(Exam.class);
		
		cfg.addAnnotatedClass(Result.class);
		cfg.addAnnotatedClass(Student.class);
		SessionFactory factory= cfg.configure().buildSessionFactory();
		Session session =factory.openSession();
		Transaction tx=session.beginTransaction();
		Criteria c=session.createCriteria(Question.class);
		c.add(Restrictions.eqOrIsNull("e_id",e_id ));
		
		
		List<Question> l=c.list();
		
		
		
		return l;
	}

	@Override
	public List<Question> get( Exam e) {
		cfg.addAnnotatedClass(Question.class);
		
		cfg.addAnnotatedClass(Exam.class);
		
		cfg.addAnnotatedClass(Result.class);
		cfg.addAnnotatedClass(Student.class);
		SessionFactory factory =cfg.configure().buildSessionFactory();
		Session session=factory.openSession();
		
		Transaction tx=session.beginTransaction();
	Criteria c=session.createCriteria(Question.class);
	c.add(Restrictions.eqOrIsNull("exam", e));
	List<Question> l=c.list();
	tx.commit();
	session.close();
	factory.close();
	
	return l;
	}
	public Question getquestion(int id) {
		cfg.addAnnotatedClass(Question.class);
		cfg.addAnnotatedClass(Exam.class);
	
		cfg.addAnnotatedClass(Result.class);
		cfg.addAnnotatedClass(Student.class);
		SessionFactory factory =cfg.configure().buildSessionFactory();
		Session session=factory.openSession();
		
		Transaction tx=session.beginTransaction();
	Criteria c=session.createCriteria(Question.class);
	c.add(Restrictions.eqOrIsNull("q_id",id ));
	return (Question) c.uniqueResult();
	
	}

	@Override
	public void save(Question q) {
		// TODO Auto-generated method stub
		
		cfg.addAnnotatedClass(Question.class);
		cfg.addAnnotatedClass(Exam.class);
		
		cfg.addAnnotatedClass(Result.class);
		cfg.addAnnotatedClass(Student.class);
		SessionFactory factory =cfg.configure().buildSessionFactory();
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		
		session.save(q);
		tx.commit();
		session.close();
		factory.close();
		
	}

	@Override
	public void update(Question q) {
		// TODO Auto-generated method stub
		
		cfg.addAnnotatedClass(Question.class);
		cfg.addAnnotatedClass(Exam.class);
		
		cfg.addAnnotatedClass(Result.class);
		cfg.addAnnotatedClass(Student.class);
		SessionFactory factory =cfg.configure().buildSessionFactory();
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		session.update(q);
		tx.commit();
		session.close();
		factory.close();
		
	}

	@Override
	public void delete(int id ) {
		// TODO Auto-generated method stub
		

		cfg.addAnnotatedClass(Question.class);
		cfg.addAnnotatedClass(Exam.class);
	
		cfg.addAnnotatedClass(Result.class);
		cfg.addAnnotatedClass(Student.class);
		SessionFactory factory =cfg.configure().buildSessionFactory();
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		Question q=new Question();
		q.setQ_id(id);
		session.delete(q);
		tx.commit();
		session.close();
		factory.close();
	}

}
