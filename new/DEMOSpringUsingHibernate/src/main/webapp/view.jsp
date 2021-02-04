<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page language="java" import="java.util.*" %>
<%@page language="java" import="com.thinkitive.DEMOSpringUsingHibernate.model.Employee" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>view</title>
</head>
<body>
<form action="hi2" >
<input type="text" name="empid" placeholder="enter empid">

<input type="submit"  name="submit" value="find">
<input type="submit"  name="submit" value="view-all">
</form>

<table border="1" width="303">
<tr>

<td width="168"><b>empid</b></td>
<td width="168"><b>ename</b></td>
<td width="168"><b>salary</b></td>
</tr>

<% 
if(request.getAttribute("mess")!=null){
List <Employee> data= (ArrayList<Employee>)request.getAttribute("mess");
for (Employee e:data )
{
%>
<tr>
<td width="119"><%=e.getEmpid()%></td>
<td width="168"><%=e.getEname()%></td>
<td width="168"><%=e.getSalary()%></td>
</tr>
<%}%>
<%}%>
</table>
</body>


</html>