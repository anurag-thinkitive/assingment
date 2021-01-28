<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DB-OPERATION</title>
</head>
<body>
<form action="DisplayServlet" method="post">
<input type="number" name="id" placeholder="enter employee id">
<input type="text" name="ename" placeholder="enter name">
<input type="number" name="salary" placeholder="enter salary">
<input type="submit" name="submit" value="insert">
<input type="submit" name="submit" value="delete">
<input type="submit" name="submit" value="update">
<input type="submit" name="submit" value="view">
</form>
<%
if(request.getAttribute("result")!=null)
{
	out.println("result is "+request.getAttribute("result"));
}
%>

</body>
</html>