<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="design.pattern.User"%>

<%
String username=(String)request.getAttribute("username");
User user=(User)request.getAttribute("user");
%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Front Controller Example</title>
</head>
<body>

<p>
Hi, my name is ${user.getUsername()} and i'm  ${user.getName()}

</p>

Go <a href="login.jsp">Logout</a> 
</body>
</html>