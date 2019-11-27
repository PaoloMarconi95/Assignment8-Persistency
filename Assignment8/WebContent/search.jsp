<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="design.pattern.User"
import="design.pattern.Address"%>
<html>

<head>
<meta charset="UTF-8">
<title>Search a User</title>
</head>


<body>

<h1>Search a User</h1>

<p>Search by</p>

<form name="frm" method="get" action="/Assignment8/Gateway">

  <input type="radio" name="by" value="name" checked> Name<br>
  <input type="radio" name="by" value="address"> Address<br>
  <input type="radio" name="by" value="bestfriend"> Best Friend<br>
  
  <input type="text" name="value"><br>
  
  <button type="submit" name="operation" value="search">Search</button>
  
</form>

<% 
if((User)request.getAttribute("loggedUser") != null){ %>
<p> 
Id found: ${loggedUser.id} <br>
Name found: ${loggedUser.name} <br>
Address found: ${loggedUser.address.getName()} <br>
Password found: ${loggedUser.password} <br>
Best friend found: ${loggedUser.bestfriend} <br>
</p>
<%}%>

<h3 style="color:red;">${out}</h3>

Go <a href="index.jsp">Back</a> 

</body>
</html>