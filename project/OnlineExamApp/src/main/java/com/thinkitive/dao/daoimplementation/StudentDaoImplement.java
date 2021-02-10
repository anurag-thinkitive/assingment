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

import com.thinkitive.dao.StudentDao;
import com.thinkitive.model.Admin;
import com.thinkitive.model.Exam;
import com.thinkitive.model.Question;
import com.thinkitive.model.Result;
import com.thinkitive.model.Student;

@Service
public class StudentDaoImplement implements StudentDao {
Configuration cfg=new Configuration();
	@Override
	public Student getstudennt(String username, String password) {
		// TODO Auto-generated method stub
		cfg.addAnnotatedClass(Student.class);
		cfg.addAnnotatedClass(Result.class);
		cfg.addAnnotatedClass(Question.class);
		cfg.addAnnotatedClass(Exam.class);
		
		

		SessionFactory factory= cfg.configure().buildSessionFactory();
		Session session =factory.openSession();
		Transaction tx=session.beginTransaction();	
		Criteria c=session.createCriteria(Student.class);
		c.add(Restrictions.eqOrIsNull("username",username ));
		c.add(Restrictions.eqOrIsNull("password", password));
	
	return (Student) c.uniqueResult();
	}
	
	public String getpassword( String username) {
		
		cfg.addAnnotatedClass(Student.class);
		SessionFactory factory= cfg.configure().buildSessionFactory();
		Session session =factory.openSession();
		Transaction tx=session.beginTransaction();	
		Criteria c=session.createCriteria(Student.class);
		c.add(Restrictions.eqOrIsNull("username",username ));
		Student stud=(Student) c.uniqueResult();
		return stud.getPassword();
	}

	@Override
	public List<Student> getall() {
		// TODO Auto-generated method stub
	cfg.addAnnotatedClass(Student.class);
		
		
		SessionFactory factory= cfg.configure().buildSessionFactory();
		Session session =factory.openSession();
		Transaction tx=session.beginTransaction();
		
		Query q=session.createQuery("From Student");
		
		List<Student> l=q.list();// TODO Auto-generated method stub
		return l;
	}

	

	

}
