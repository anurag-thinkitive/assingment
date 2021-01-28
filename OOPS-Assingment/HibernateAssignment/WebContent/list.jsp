<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page language="java" import="java.util.*" %>
<%@page language="java" import="com.training.Employee" %>
<html>
<head>
<title>Data Page</title>
</head>
<body> 
<table border="1" width="303">
<tr>
<td width="119"><b>Empid</b></td>
<td width="168"><b>name</b></td>
<td width="168"><b>salary</b></td>
</tr>
<%Iterator itr;%>
<% List <Employee> data= (List)request.getAttribute("result");
for (Employee e:data )
{
%>
<tr>
<td width="119"><%=e.getEmpid()%></td>
<td width="168"><%=e.getEname()%></td>
<td width="168"><%=e.getSalary()%></td>
</tr>
<%}%>
</table>
</body>
</html>