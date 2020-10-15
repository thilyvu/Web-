<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<style>
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
}
</style>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
			String ra="";
			String mo="";
			String mang[]={};
			if(request.getParameter("ra")!=null) ra=request.getParameter("ra");
			if(request.getParameter("mo")!=null) mo=request.getParameter("mo");
			if(request.getParameterValues("equ")!=null) mang=request.getParameterValues("equ");
	%>
	<table>
		<tr> 
			<th>Processor </th>
			<th>Accessories </th>
		</tr>
		<tr> 
			<td><%=ra%> </td>
			<td>
				<%=mo%><br>
				<%
				for(String x:mang)
				{
					out.print(x+"<br>");
				}
				%>
			 </td>
		</tr>
	</table>
</body>
</html>