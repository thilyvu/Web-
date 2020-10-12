<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
</head>
<body>

<form action="selectReply.jsp"  method="get">
    <div class="container">
        <div class="row">
            <div class="col"><h4>Processor</h4> </div>
            <div class="col"><h4>Accessories</h4> </div>
        </div>
        <div class="row">            
        	<div class="col">
                <input type="radio" name="processor" id="celeron-d" value="Celeron D">
                <label for="celeron-d">Celeron D</label> <br>
                <input type="radio" name="processor" id="pentium-iv" value="Pentium IV">
                <label for="pentium-iv">Pentium IV </label> <br>
                <input type="radio" name="processor" id="pentium-d" value="Pentium D">
                <label for="pentium-d">Pentium D </label> <br>
            </div>
            <div class="col">
                <input type="checkbox" name="chk-accessories" id="chk-accessories"> 
                <label for="chk-accessories">Monitor</label> <br>
                
                <select multiple class="chosen-select" name="list-accessories">
                    <option>Camera</option>
                    <option>Printer</option>
                    <option>Scanner</option>
                </select>
            </div>
        </div>
        <div class="row">
            <div class="col-6">
                <button type="submit" value="Submit" style="margin: 0 auto;">Place Order</button>
            </div>
        </div>
    </div>
</form>


</body>
</html>