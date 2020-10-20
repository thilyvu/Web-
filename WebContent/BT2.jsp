<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h4>Widget Order Form</h4>
	<form action="Servletbt2">
	<table >
    <tr>
      <td align="right">Number to purchase:</td>
      <td><input type="text" name="NumberOfProduct"></td>
    </tr><tr>
      <td align="right">Your name:</td>
      <td> <input type="text" name="NameofCustomer"></td>
    </tr><tr>
      <td align="right">Your email:</td>
      <td> <input type="text" name="Email"></td>
    </tr><tr>
      <td></td>
      <td><button type="submit"> place order</button></td>
    </tr>
  </table>
	</form>
</body>
</html>