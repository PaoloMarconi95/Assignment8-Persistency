<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
Login

<form name="frm" method="post" action="/Assignment8/Gateway">

Name: <input type="text" name="name">
Password: <input type="password" name="password">

<button type="submit" name="operation" value="login">Login</button>

</form>


<% String error = (String)request.getAttribute("error"); 
if(error != null){
%>
	<h3 style="color:red;">${error}</h3>
<%
}
%>

go <a href="/Assignment8/index.jsp">back</a>
</body>
</html>