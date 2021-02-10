package com.thinkitive.dao.daoimplementation;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.thinkitive.dao.ResultDao;
import com.thinkitive.model.Exam;
import com.thinkitive.model.Question;
import com.thinkitive.model.Result;
import com.thinkitive.model.Student;
@Repository
public class ResultDaoImplementation  implements ResultDao{

	Configuration cfg=new Configuration();
	
	@Override
	public List<Result> getallresult() {
		// TODO Auto-generated method stub
		cfg.addAnnotatedClass(Question.class);
		cfg.addAnnotatedClass(Exam.class);
		
		cfg.addAnnotatedClass(Result.class);
		cfg.addAnnotatedClass(Student.class);
		SessionFactory factory =cfg.configure().buildSessionFactory();
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		org.hibernate.Query q=session.createQuery("From Result");
		List<Result> l=q.list();
		
		tx.commit();
		session.close();
		factory.close();
		return l;
	}

	@Override
	public List<Result> getresult(int id) {
		// TODO Auto-generated method stub
		cfg.addAnnotatedClass(Question.class);
		cfg.addAnnotatedClass(Exam.class);
		
		cfg.addAnnotatedClass(Result.class);
		cfg.addAnnotatedClass(Student.class);
		SessionFactory factory =cfg.configure().buildSessionFactory();
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
	Criteria c=session.createCriteria(Result.class);
	c.add(Restrictions.eqOrIsNull("r_id", id));
	List<Result> l=c.list();
	tx.commit();
	session.close();
	factory.close();
	return l;
		
	}
	public Result getresultbystudent(int s_id) {
		// TODO Auto-generated method stub
		cfg.addAnnotatedClass(Question.class);
		cfg.addAnnotatedClass(Exam.class);
		
		cfg.addAnnotatedClass(Result.class);
		cfg.addAnnotatedClass(Student.class);
		SessionFactory factory =cfg.configure().buildSessionFactory();
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		org.hibernate.Query q=session.createQuery("From Result where student_s_id=:s_id");
		q.setParameter("s_id", s_id);
Result res=(Result) q.uniqueResult();

	System.out.println(res.getMarks());
	tx.commit();
	session.close();
	factory.close();
	return res;
		
	}
	

	@Override
	public void saveresult(Result r) {
		// TODO Auto-generated method stub
		cfg.addAnnotatedClass(Question.class);
		cfg.addAnnotatedClass(Exam.class);
		
		cfg.addAnnotatedClass(Result.class);
		cfg.addAnnotatedClass(Student.class);
		SessionFactory factory =cfg.configure().buildSessionFactory();
		Session session=factory.openSession();
		Transaction tx=session.beginTransaction();
		session.save(r);
		tx.commit();
		session.close();
		factory.close();
	}

	

}
