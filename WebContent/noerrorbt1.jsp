<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div style="width: fit-content;border-width: 0.2rem;border-style: double; padding: 0.5em;">
	<p>Thank you for your order of <c:out value="${quantity}"></c:out>  widgets!</p>
	<form action="index.jsp">
	<label>
	Press this button to go back to the home page
	</label> 
	<br>	
	<button>Back</button>
	</form>
	</div>
</body>
</html>