<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h4>Thanks for joining our email list</h4>
	<br>
	<label>Email :<%= request.getParameter("Email") %></label>  
	<br>
	<label>First Name : <%= request.getParameter("Firstname") %></label> 
	 <br>
	<label>Last Name :  <%= request.getParameter("Lastname") %> </label>
	<br>
</body>
</html>