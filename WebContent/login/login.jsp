<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Login</title>
    <link href="${pageContext.request.contextPath}/login/lg-style.css" rel="stylesheet" type="text/css"/>
    <link href="https://fonts.googleapis.com/css2?family=Alegreya&family=Playfair+Display&family=Rozha+One&display=swap" rel="stylesheet">
	
	 <link rel="stylesheet" href="${pageContext.request.contextPath}/HomePage/home-style.css" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://fonts.googleapis.com/css2?family=Alegreya&family=Playfair+Display&family=Rozha+One&display=swap" rel="stylesheet">
  	<link rel="preconnect" href="https://fonts.gstatic.com">
	<link href="https://fonts.googleapis.com/css2?family=Charmonman:wght@400;700&display=swap" rel="stylesheet">

</head>
<body>
<div class="login-pg">
    <div class="login-box box">
        <h1>Đăng nhập</h1>
        <form class="login-frm" action="${pageContext.request.contextPath}/Login" method="post">
            <div class="c-input">
            	<div class="input-title">Địa chỉ email:
            		<i class="input-error-txt" style="display: none;">*</i>
            	</div> 
            	<input placeholder="" autocomplete="" type="text" name="email" class="" required>
            	<label class="errorText">
            		<c:out value="${emailError}"></c:out>
            	</label></div>
            <div class="c-input">
	            <div class="input-title">Mật khẩu:
	            <i class="input-error-txt" style="display: none;">*</i>
	            </div> <input placeholder="" autocomplete="" type="password" name="password" class="" required>
	            <label class="errorText">
	            	<c:out value="${passError}"></c:out>
	            </label>
            </div>
            <input type="submit" value="Đăng nhập">
            <a href="${pageContext.request.contextPath}/login/registration.jsp">Chưa có tài khoản?</a>
            <a href="${pageContext.request.contextPath}/login/forgetpass.jsp">Quên mật khẩu?</a>
        </form>
    </div>
</div>
</body>
</html>