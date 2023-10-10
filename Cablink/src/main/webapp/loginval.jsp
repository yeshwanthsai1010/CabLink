<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="False"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<link rel="stylesheet" href="StyleSheets/stylelogin.css">
<link href="https://fonts.googleapis.com/css2?family=Exo+2:ital,wght@1,300&display=swap" rel="stylesheet">
	<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Cinzel:wght@700&family=Exo+2:ital,wght@1,300&display=swap" rel="stylesheet">
<script type="text/javascript" src="Javascript/script.js"></script>


</head>
<body>
<header style = "margin:0px 0px;">
		
		<b><p align = left style = "font-size:70px;margin:0px 0px;" class = "Name">CabLink</p></b>
		<br>
		
	</header>
	<br>
	<br>
	<h2 align = "center" class = "Namep">Login</h2>
	

<form action="val.jsp?mode=${param.mode}&op=${param.op}" method="post" class="containerlogin" id="loginform">
<table align="center" cellspacing = 25px>
<tr>
<td><p class = "Namep"><label>Enter CabLink id/Username :</label></p></td>
<td class="Named" ><input type="text" name="clid" id="uname"></td>
</tr>
<tr>
<td><p class = "Namep"><label>Enter Password :</label></p></td>
<td class="Named"><input type="password" name="cpwd" id="upwd"></td>
</tr>
<tr>
<td style="text-align:center"><button type = "submit" class = "glow-on-hover" onclick = "clicklogin()" id="submit">Submit</button></td>
<td style="text-align:center"><button class = "glow-on-hover" id="reset" type="reset">Reset</button></td>
</tr>
<tr><td colspan=2 style="text-align:center"><button class = "glow-on-hover enl" id="registercl"><a href = "register.jsp?mode=${param.mode}">New User?Click Here</a></button></td></tr>
</table>
</form>

	
</body>
</html>