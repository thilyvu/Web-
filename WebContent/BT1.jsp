<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
</head>
<body>
	<div style="width: fit-content;border-width: 0.2rem;border-style: double; padding: 0.5em;">
	<form action="servletbt1">
	<label>	Quantity:</label>
	<input type="number" id="number" name="number" required="required">
		<button type="submit" >
			PURCHASE
		</button>
		
	</form>
	</div>
</body>
</html>