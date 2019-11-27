<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="design.pattern.User"
import="design.pattern.Address"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User private page</title>
</head>
<body>

<h2> ${loggedUser.name}'s Profile Page</h2>

<p> 
Your id: ${loggedUser.id} <br>
Your Name: ${loggedUser.name} <br>
Your Address: ${loggedUser.address.getName()} <br>
Your Password: ${loggedUser.password} <br>
Your Best friend: ${loggedUser.bestfriend} <br>
</p>
<form name="frm" method="post" action="/Assignment8/Gateway">

<input type="hidden" name="refId" id="refId" value="${loggedUser.id}"></input>

<button type="submit" name="operation" value="delete">Delete my account</button>

</form>

<h3>Update your Profile</h3>

<form name="frm" method="post" action="/Assignment8/Gateway">
<p>
<input type="hidden" name="refId" id="refId" value="${loggedUser.id}"></input>
Id: <input type="text" name="id"><br>
Name: <input type="text" name="name"><br>
Address: <input type="text" name="address"><br>
Password: <input type="password" name="password"><br>
BestFriend: <input type="text" name="bestfriend"><br>
</p>
<button type="submit" name="operation" value="update">Update</button>

</form>

<h3 style="color:red;">${out}</h3>

<a href="login.jsp">Login Page</a> 
</body>
</html>