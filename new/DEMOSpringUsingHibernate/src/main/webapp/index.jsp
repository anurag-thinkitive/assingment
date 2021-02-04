<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="hi" method="post"  >
<input type="number" name="empid" placeholder="enter empid">
<input type="text" name="name" placeholder="enter name">
<input type="number" name="salary" placeholder="enter salary">
<input type="submit"  name="submit" value="add">
<input type="submit"  name="submit" value="update">
<input type="submit"  name="submit" value="delete">


</form>
<a href="view.jsp">view </a>
<%
if(request.getAttribute("result")!=null){
	out.println((String)request.getAttribute("result"));	
}

%>
</body>
</html>