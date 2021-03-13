<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.ArrayList" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Register Account</title>
    <link href="${pageContext.request.contextPath}/login/lg-style.css" rel="stylesheet" type="text/css"/>
    <link href="https://fonts.googleapis.com/css2?family=Alegreya&family=Playfair+Display&family=Rozha+One&display=swap" rel="stylesheet">
	 
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://fonts.googleapis.com/css2?family=Alegreya&family=Playfair+Display&family=Rozha+One&display=swap" rel="stylesheet">
  <link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Charmonman:wght@400;700&display=swap" rel="stylesheet">
</head>
<body>
<script>
function dropDownMenu() {
  var x = document.getElementById("section-1");
  var y = document.getElementById("s1-col2");
  if (x.className === "section-1") {
    x.className += " responsive";
  } else {
    x.className = "menu";
  }
  if (x.className === "s1-col2") {
	    x.className += " responsive";
	  } else {
	    x.className = "menu";
	  }
}
</script>
<div class="signup-pg">
    <div class="regbox box">
        <h1>Đăng ký</h1>
        <c:out value="${taikhoan}"></c:out>
        <form class="signup-frm" action="${pageContext.request.contextPath}/RegistrationServlet" method="post">
            <div class="c-input">
            	<div class="input-title">Địa chỉ email:
            	<i class="input-error-txt" style="display: none;">*</i>
            	</div> 
            	<input placeholder="" autocomplete="" type="email" class="" required name="email">
            </div>
            <div class="c-input">
            	<div class="input-title">Số điện thoại:
            	<i class="input-error-txt" style="display: none;">*</i>
            	</div> <input placeholder="" autocomplete="" type="text"  class="" required name="phone">
            </div>
            <div class="c-input">
            	<div class="input-title">Mật khẩu: <c:out value="${matkhau}"></c:out>
            	<i class="input-error-txt" style="display: none;">*</i>
            	</div> 
            	<input placeholder="" autocomplete="" type="password"  class="" required name="mk">
            </div>
            <div class="c-input">
            	<div class="input-title">Xác nhận mật khẩu:
            	<i class="input-error-txt" style="display: none;">*</i>
            	</div> <input placeholder="" autocomplete="" type="password" class="" required name="mk1">
            </div>
            <input type="submit" value="Đăng ký">
            <a href="${pageContext.request.contextPath}/login/login.jsp">Đã có tài khoản?</a>
            <a href="${pageContext.request.contextPath}/login/forgetpass.jsp">Quên mật khẩu?</a>
        </form>
    </div>
</div>
</body>
</html>