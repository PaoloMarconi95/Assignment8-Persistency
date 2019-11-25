<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%
String error = (String)request.getAttribute("error");
%>

<html>

<head>

<meta charset="UTF-8">
<title>Register</title>

</head>

<body>

<h1>Register</h1>

<form name="frm" method="post" action="/Assignment8/Create">

Id: <input type="text" name="id"><br>
Name: <input type="text" name="name"><br>
Address: <input type="text" name="address"><br>
Password: <input type="text" name="password"><br>
BestFriend: <input type="text" name="bestfriend"><br>

<button type="submit" name="create" value="Register">Register</button>

</form>

<% if(error != null)%>
	<h3 style="color:red;">${error}</h3>

go <a href="/Assignment8/index.jsp">back</a>

</body>

</html>