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

import com.thinkitive.dao.TeacherDao;
import com.thinkitive.model.Admin;
import com.thinkitive.model.Result;
import com.thinkitive.model.Teacher;

@Service
public class TeacherDaoImplement implements TeacherDao {
Configuration cfg=new Configuration();
	

	@Override
	public List<Teacher> getallteacher() {
		cfg.addAnnotatedClass(Teacher.class);
		
		
		SessionFactory factory= cfg.configure().buildSessionFactory();
		Session session =factory.openSession();
		Transaction tx=session.beginTransaction();
		
		Query q=session.createQuery("From Teacher");
		
		List<Teacher> l=q.list();// TODO Auto-generated method stub
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
		return admi.getPassword();
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
	public Teacher getteacher(String username, String password) {
		// TODO Auto-generated method stub
		cfg.addAnnotatedClass(Teacher.class);
		SessionFactory factory= cfg.configure().buildSessionFactory();
		Session session =factory.openSession();
		Transaction tx=session.beginTransaction();	
		Criteria c=session.createCriteria(Teacher.class);
		c.add(Restrictions.eqOrIsNull("username",username ));
		c.add(Restrictions.eqOrIsNull("password", password));
		tx.commit();
		session.close();
		factory.close();
		
		return (Teacher)c.uniqueResult();
		
	}
	
	
}
