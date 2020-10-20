<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h4>Order Comfirmation</h4>
	<p> Thanks you for your order of <%=request.getParameter("NumberOfProduct") %>, <%= request.getParameter("NameofCustomer") %></p>
	<p> At $9.95, your bill will be $<%=Integer.parseInt(request.getParameter("NumberOfProduct"))*9.95%></p>
	<p> You will shortly recieve an email comfirmation at <%=request.getParameter("Email") %></p>	
</body>
</html>