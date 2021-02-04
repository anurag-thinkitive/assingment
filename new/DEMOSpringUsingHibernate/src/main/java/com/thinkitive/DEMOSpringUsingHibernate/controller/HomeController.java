package com.thinkitive.DEMOSpringUsingHibernate.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.thinkitive.DEMOSpringUsingHibernate.dao.EMPLOYEEDAOIMPL;
import com.thinkitive.DEMOSpringUsingHibernate.model.Employee;


@Controller
public class HomeController {
	@Autowired
	EMPLOYEEDAOIMPL d;
	@RequestMapping(value="/")
	public ModelAndView test(HttpServletResponse response) throws IOException{
		return new ModelAndView("home");
	}
	
	ModelAndView model= new ModelAndView();
	
	@RequestMapping(value="/hi" ,method = RequestMethod.POST)
	public ModelAndView ddl(Integer empid,String name,Integer salary,String submit ) throws IOException{
		Employee e=new Employee();
		e.setEmpid(empid);
		e.setEname(name);
		e.setSalary(salary);
		if(submit.equals("add")) {
			
		d.addEmployee(e);
	
		model.addObject("result","inseted");
		model.setViewName("index.jsp");
		
		
		}else
			if(submit.equals("update")) {
				
				d.updateEmployee(e);
				model.addObject("result","updated");
				model.setViewName("index.jsp");
			}
			else
				if(submit.equals("delete")){
					
					d.deleteEmployee(e);
					model.addObject("result","deleted");
					model.setViewName("index.jsp");
				}
			
		
		return model;
	}
	@RequestMapping(value="/hi2")
	public ModelAndView dml(Integer empid,String submit,ModelAndView model) {
		
		List<Employee> l1=new ArrayList<Employee>();
		if(submit.equals("find")) {
			l1=d.getEmployee(empid);
			
			model.addObject("mess",l1);
			model.setViewName("view.jsp");
			
		}else 	if(submit.equals("view-all")) {
			
			
			l1=d.getall();
			model.addObject("mess",l1);
			model.setViewName("view.jsp");
		}
		return model;
	}
}
