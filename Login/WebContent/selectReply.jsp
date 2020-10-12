<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
	
</head>
<%@ page import="java.util.ArrayList" %> 
<%
	request.setAttribute("alertMsg", "data add sucess");
	String processor = request.getParameter("processor");
	processor = processor == null ? "Not select processor" : processor;
	
	String monitor = request.getParameter("chk-accessories");
	
	String[] accessories = request.getParameterValues("list-accessories");
	
	String listAcc = monitor == null ? "" : "Monitor<br>";
	for	(int i = 0; i < accessories.length; i++) {
		listAcc += accessories[i] + "<br>";
	}
%>

<body>

<div class="container">
  <h2>Order Summary:</h2>          
  <table class="table table-bordered">
  <thead>
    <tr>
      <th scope="col">Processor</th>
      <th scope="col">Accessories</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td><%= processor %></td>
      <td><%= listAcc %></td>
    </tr>
  </tbody>
</table>
</div>

</body>
</html>