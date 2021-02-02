package com.training;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo {
public static void main(String[] args) {
//	ApplicationContext context=new AnnotationConfigApplicationContext("com.training");
	ApplicationContext context =new ClassPathXmlApplicationContext("pom.xml");
	Employee e=context.getBean(Employee.class);
//	List<Address>l=new ArrayList<Address>() ;
//	l.add(new Address("city",6789));
//	l.add(new Address("hdi",6378));
//	e.setAddr(l);
//	e.setEmpid(123);
//	e.setName("dughi");
//	e.setSalary(780987);
	Address a=context.getBean(Address.class);
	System.out.println(e);
}
}
