
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	<form action="EmailValidate" method="post">
		<%!boolean checkmang(String a, String[] b) {
		for (String x : b) {
			if (a.equals(x)) {
				return true;
			}
		}
		return false;

	}%>
		<h4>Enter Your Information</h4>
		<table>
			<tr>
				<td>
				<label> Number to purchase: <br> (at least 1)
				</label>
				</td>
				<td>
				<input type="number" name="number"  placeholder="ex:1" required="required" value="<c:out value="${CU}"></c:out>">
						
					<c:set var="a" scope="request" value="${number }"></c:set>
					<c:if test="${a != null }">
						<c:out value="${a}"></c:out>
					</c:if>
			 <br></td>
			 
			</tr>
			<tr>
				<td>
				<label> Your name: </label></td>
				<td>
				
				<input type="text" name="customerName" placeholder="ex Thi Ly Vu" required="required" value="<c:out value="${NameBackUp}"></c:out>">
					* 
					<br></td>

			</tr>
			<tr>

				<td><label> Your phone: <br> (in format xxx-xxx-xxxx)
				</label></td>
				<td><input type="number" placeholder="ex :0905254115" name="phone" required="required" 
				value="<c:out value="${phoneBackUp}"></c:out>">
					 * 
					<c:set var="b" scope="request" value="${phone }"></c:set>
					<c:if test="${b != null }">
					<c:out value="${b }"></c:out>
					</c:if>
					
					
					<br></td>
			</tr>
			<tr>

				<td><label> Your Email: </label></td>
				<td><input type="text" name="email" placeholder="ex:thilyvu.2000@gmail.com" required="required"
					value="<c:out value="${emailBackup}"></c:out>">
					<c:set var="c" scope="request" value="${email }"></c:set>
					<c:if test="${c != null }">
					<c:out value="${c }"></c:out>
					</c:if>
					
		 <label>(optional) </label> <br></td>
			</tr>

		</table>
		<table>
			<tr>
				<td></td>
				<td>
				<label> Number: </label> 
				
				
				<c:set var="CreditCard" scope="request"  value="${CreditCardNumberBU}"></c:set>
				<input type="number" name="expirationnumber" required="required" placeholder="ex:4155279860457" value="<c:out value="${CreditCardNumberBU}"></c:out>">
					
					
					<c:set var="d" scope="request" value="${CreditCardNumber }"></c:set>
						<c:if test="${d != null }">
					<c:out value="${d }"></c:out>
					</c:if>
					<br></td>
			</tr>
			<tr>
				<td>
				<label> Credit Information </label></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td><label> Expiration Date:</label> <select
					name="ExpirationDate">
						<%
							for (int date = 1; date <= 31; date++) {
						%>

						<option
							<%if (request.getParameter("ExpirationDate") != null
								&& Integer.parseInt(request.getParameter("ExpirationDate")) == date) {
									out.print(" SELECTED");
							}%>>

							<%=date%>

						</option>

						<%
							}
						%>
				</select> <select name="ExpirationYear">
						<%
							for (int year = 2008; year <= 2020; year++) {
						%>

						<option
							<%if (request.getParameter("ExpirationYear") != null
		&& Integer.parseInt(request.getParameter("ExpirationYear")) == year) {
	out.print(" SELECTED");
}%>>

							<%=year%>
						</option>

						<%
							}
						%>
				</select></td>
			</tr>
		</table>
		<table>
			<tr>
				<th>Processor</th>
				<th>Accessories</th>
			</tr>
			<tr>
				<td><input type="radio" name="ra" value="Celeron D"
					<%if (request.getParameter("ra") != null && request.getParameter("ra").equals("Celeron D")) {
	out.print(" CHECKED");
}%>>
					Celeron D</td>
				<td><input type="checkbox" name="mo"
					<%if (request.getParameter("mo") != null) {
	out.print(" CHECKED");
}%>>
					Accessories</td>
			</tr>
			<tr>
				<td><input type="radio" name="ra" value="Plentium IV"
					<%if (request.getParameter("ra") != null && request.getParameter("ra").equals("Plentium IV")) {
	out.print(" CHECKED");
}%>>
					Plentium IV</td>
				<td colspan="2"><select name="equ" size=3 multiple="multiple">


						<%
							String[] mang = {};
						if (request.getParameterValues("equ") != null) {
							mang = request.getParameterValues("equ");
						}
						%>
						<option value="Camera"
							<%if (checkmang("Camera", mang)) {
	out.print(" SELECTED");
}%>>Camera
						</option>
						<option value="Printer"
							<%if (checkmang("Printer", mang)) {
	out.print(" SELECTED");
}%>>Printer
						</option>
						<option value="Scanner"
							<%if (checkmang("Scanner", mang)) {
	out.print(" SELECTED");
}%>>Scanner</option>
				</select></td>
			</tr>
			<tr>
				<td><input type="radio" name="ra" value="Plentium D"
					<%if (request.getParameter("ra") != null && request.getParameter("ra").equals("Plentium D")) {
	out.print(" CHECKED");
}%>>Plentium
					D</td>
			</tr>
			<tr>
				<td></td>
				<td>
					<button type="submit">Configure</button>
				</td>
			<tr>
		</table>
		<br> <br>


	</form>
</body>
</html>