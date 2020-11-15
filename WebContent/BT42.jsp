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
<div style="width: fit-content;border-width: 0.2rem;border-style: double;padding: 0.5em; ">
	<h4>Widget Order Form</h4>
	<form action="servletbt4">
	<table >
    <tr>
      <td align="right">Number to purchase:</td>
      <td><input type="number" name="NumberOfProduct" required="required" placeholder="ex:1" value="<c:out value="${numberbackup}"></c:out>">
      				
		</td>
    </tr><tr>
      <td align="right">Your name:</td>
      <td> <input type="text" name="NameofCustomer" placeholder="ex:Nguyen Van A" required="required" value="<c:out value="${name}"></c:out>"></td>
    </tr><tr>
      <td align="right">Your email:</td>
      <td> <input type="text" name="Email" placeholder="ex:thilyvu.2000@gmail.com"  value="<c:out value="${emailBackup}"></c:out>" required="required" >
      				
					</td>
    </tr><tr>
      <td></td>
      <td><button type="submit"> place order</button></td>
    </tr>
  </table>
	</form>
	</div>
</body>
</html>