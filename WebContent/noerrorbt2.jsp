<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h4>Order Confirmation</h4>
	<p> Thanks you for your order of , <c:out value="${numberbackup}"></c:out>, <c:out value="${name}"></c:out> </p>
	<p> At $9.95, your bill will be $<c:out value="${numberbackup*9.95}"></c:out></p>
	<p> You will shortly receive an email confirmation at <c:out value="${emailBackup}"></c:out></p>	
	<form action="index.jsp">
	<label>
	Press this button to go back to the home page
	</label> 
	<br>
	<button>Back</button>
	</form>
</body>
</html>