<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="False"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title></title>
<link rel="stylesheet" href="StyleSheets/stylelogin.css">
<link href="https://fonts.googleapis.com/css2?family=Exo+2:ital,wght@1,300&display=swap" rel="stylesheet">
	<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Cinzel:wght@700&family=Exo+2:ital,wght@1,300&display=swap" rel="stylesheet">

<link rel="stylesheet" href="stylelogin.css">
<script type="text/javascript" src="Javascript/script.js"></script>
</head>
<body>
	<header style="margin: 0px 0px;">
		<h1>
			<p style="font-size: 50px; margin: 0px 0px;" class = "Name">CabLink
				<a href = 'services.jsp?mode=${sessionScope.mode }' style = "font-size:50px;margin:0px 0px;float:right" class="Named"><c:out value="${sessionScope.uname}"></c:out></a></p>
				
		</h1>
	</header>

	<br>
	<br>
<c:choose>
<c:when test="${param.op eq 'edit'}">
<div class = "containersingle">
	<h2 align = center class= "Namep">Enter Values to be Updated</h2>
	
		<form method = "POST" action = "val.jsp?op=edit&mode=${sessionScope.mode}" class="container">
		<table cellspacing = 15px align =center>
			<tr>
				<td class="Named"><p ><label>Enter Full Name:</label></p></td>
				<td><input type = "text" name = "name" id="name"></td>
			</tr>
		
			<tr>
				<td class="Named"><label>Enter Mobile Number:</label></td>
				<td><input type = "tel" name = "umob" id="umob"></td>
			</tr>
			<tr>
				<td class="Named"><label>Enter Email ID:</label></td>
				<td><input type = "email" name = "uemail" id="uemail"></td>
			</tr>
			<tr>
				<td class="Named"><label>Enter Address:</label></td>
				<td><textarea name="uaddress" id="uadr"></textarea></td>
			</tr>
			<tr>
				<td class="Named"><label>Select Gender:</label></td>
				<td><input class = 'radio' type = "radio" name = "gender" value = "Male">Male
				<input class = 'radio' type = "radio" name = "gender" value = "Female">Female</td>
			</tr>
			<tr>
				<td style="text-align:center"><button type = "submit" class = "glow-on-hover" >Submit</button></td>
				<td style="text-align:center"><button type = "reset" class = "glow-on-hover" >Reset</button></td>
			</tr>
		</table>
	
	
	</form>
	</div>
</c:when>
<c:otherwise>
<div class="containersingle">
	<h2 align = center class= "Namep">Register</h2>
		
		<form method = "POST" action = "val.jsp?op=add&mode=${param.mode}"  id="registration">
		<table cellspacing = 15px align =center>
			<tr>
				<td class="Named"><label>Enter Full Name:</label></td>
				<td ><input type ="text" name = "name" id="name"></td>
			</tr>
			<tr>
				<td class="Named"><label>Enter UserName:</label></td>
				<td><input type = "text" name = "uname" id="uname"></td>
			</tr>
			<tr>
				<td class="Named"><label>Enter Password:</label></td>
				<td><input type = "password" name = "upwd" id="upwd"></td>
			</tr>
			<tr>
				<td class="Named"><label>Enter Mobile Number:</label></td>
				<td><input type = "tel" name = "umob" id="umob"></td>
			</tr>
			<tr>
				<td class="Named"><label>Enter Email ID:</label></td>
				<td><input type = "email" name = "uemail" id="uemail"></td>
			</tr>
			<tr>
				<td class="Named"><label>Enter Address:</label></td>
				<td ><textarea name="uaddress" id="uaddress"></textarea></td>
			</tr>
			<tr>
				<td class="Named"><label >Select Gender:</label></td>
				<td><input class = 'radio' type = "radio" name = "gender" value = "Male" id="Male"><label class = 'Namedr'>Male</label><td>
				<input class = 'radio' type = "radio" name = "gender" value = "Female" id="Female"><label class='Namedr' >Female</label></td>
			</tr>
			<tr>
				<td style="text-align:center"><button type = "submit" class = "glow-on-hover" onclick = "clickregister()" style="width:120px" id="submit">Submit</button></td>
				<td style="text-align:center"><button type = "reset" class = "glow-on-hover" style="width:120px" id="reset">Reset</button></td>
			</tr>
		</table>
	
	
	</form>
	</div>
</c:otherwise>
</c:choose>


</body>
</html>