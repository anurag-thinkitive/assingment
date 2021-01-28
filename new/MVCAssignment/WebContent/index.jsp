<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="Servlet" method="post">
<input type="number" name="number1">
<input type="number" name="number2"> 
<input type="submit"  name="submit" value="+">
<input type="submit" name="submit"  value="-">
<input type="submit" name="submit"  value="*">
<input type="submit" name="submit"  value="/">
</form>
<%
if(request.getAttribute("result")!=null)
{
	out.println("result is "+request.getAttribute("result"));
	
}


%>



</body>
</html>