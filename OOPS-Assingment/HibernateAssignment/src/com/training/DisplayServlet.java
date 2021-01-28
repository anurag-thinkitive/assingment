package com.training;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DisplayServlet
 */
@WebServlet("/DisplayServlet")
public class DisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw=response.getWriter();
		response.setContentType("text/html");
		
		
		MyDBConnection db=new MyDBConnection();
		
		
if(request.getParameter("submit").equals("insert")) {
	
	int empid=Integer.parseInt(request.getParameter("id"));
	String ename=request.getParameter("ename");
	int salary=Integer.parseInt(request.getParameter("salary"));
	Employee e=new Employee(empid,ename,salary);
		db.insertEmployee(e);	
		RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
		request.setAttribute("result","inserted");
		rd.forward(request, response);
		}
if(request.getParameter("submit").equals("update")) {

	int empid=Integer.parseInt(request.getParameter("id"));
	String ename=request.getParameter("ename");
	int salary=Integer.parseInt(request.getParameter("salary"));
	Employee e=new Employee(empid,ename,salary);
	db.updateEmployee(e);
	RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
	request.setAttribute("result","updated");
	rd.forward(request, response);
}
if(request.getParameter("submit").equals("delete")) {

	int empid=Integer.parseInt(request.getParameter("id"));
	String ename=request.getParameter("ename");
	int salary=Integer.parseInt(request.getParameter("salary"));
	Employee e=new Employee(empid,ename,salary);
	db.deleteemployee(e);
	RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
	request.setAttribute("result","delted");
	rd.forward(request, response);
}
if(request.getParameter("submit").equals("view")) {
	 
	RequestDispatcher rd=request.getRequestDispatcher("list.jsp");
	
	request.setAttribute("result",db.reademployee());
	
	rd.forward(request, response);
}
		
	}

}
