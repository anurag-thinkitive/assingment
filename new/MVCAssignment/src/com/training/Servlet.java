package com.training;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter pw=response.getWriter();
		Integer num1= Integer.parseInt(request.getParameter("number1"));
		Integer num2=Integer.parseInt(request.getParameter("number2"));
		Calculator cal=new Calculator();
		double ans=0;
		
		if(request.getParameter("submit").equals("+")) {
			 ans=cal.add(num1, num2);
		}
		if(request.getParameter("submit").equals("-")) {
			ans=cal.sub(num1, num2);
		}
		if(request.getParameter("submit").equals("*")) {
			ans=cal.mul(num1, num2);
		}
		if(request.getParameter("submit").equals("/")) {
			ans=cal.div(num1, num2);
		}
		RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
		request.setAttribute("answer", ans);
		rd.forward(request, response);
		
		
	}

}
