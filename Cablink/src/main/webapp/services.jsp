<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="com.src.services.*,com.src.model.*" isELIgnored="False"%>
	<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Services</title>
<link rel="stylesheet" href="StyleSheets/stylelogin.css">
<link href="https://fonts.googleapis.com/css2?family=Exo+2:ital,wght@1,300&display=swap" rel="stylesheet">
	<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Cinzel:wght@700&family=Exo+2:ital,wght@1,300&display=swap" rel="stylesheet">
	

	<%
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

		System.out.println("serv"+session.getAttribute("uname"));
 		if(session.getAttribute("uname")==null){
 			response.sendRedirect("login.jsp");
 		}
		session.setAttribute("msglog", "");
		session.setAttribute("msgreg", "");
 	
 	%>
</head>
<body>
	<header style="margin: 0px 0px;">
		<h1>
			<p style="font-size: 70px; margin: 0px 0px;" class = "Name">CabLink
				<a href = 'home.jsp' style = "font-size:50px;margin:0px 0px;float:right"><c:out value="${sessionScope.uname}"></c:out></a></p>
		</h1>
	</header>
	<nav>
		
		<a href="home.jsp"><button type="button" style="width:120px" value="Home" class = "glow-on-hover">Home</button></a>
		&nbsp <a href="about.jsp"><button type="button"  style="width:120px" value="About" class = "glow-on-hover">About</button></a>
		&nbsp <a href="services.jsp"><button type="button" style="width:120px" value="Service" class = "glow-on-hover">Services</button></a>
		&nbsp <a href="contact.jsp"><button type="button" style="width:120px" value="Contact" class = "glow-on-hover">Contact</button></a>
		&nbsp <a href="login.jsp" style="float: right; display: grid; justify-content: glow-on-hover"><button
			type="button" style="width:120px" value="Book Now" class = "glow-on-hover">Book Now</button></a>

	</nav>
	<br>
	<br>
	<div align=center class = "containerserv" >
		<table cellspacing = 50px>
			<tr>
				<td class="glow-on-hover">
					<a href = "register.jsp?op=edit" id="edit"><img src = "Images/edit.gif" alt="unable" width=300px height=300px></a>
				</td>
				
			
					<td class="glow-on-hover">
						<a href="val.jsp?op=del&mode=${sessionScope.mode}" id="delete"><img src = "Images/deletei.gif" alt="unable" width=300px height=300px></a>
					</td>
					
		
			<td class="glow-on-hover">
					<a href = "val.jsp?op=logout&mode=${sessionScope.mode }" id="logout"><img src = "Images/logouti.gif" alt="unable" width=300px height=300px></a>
				</td>
				
				
			</tr>
			<tr >
				<td class = "Named" align=center>Edit Details</td>
				<td class = "Named" align=center>Permanently Delete Account</td>
				<td class = "Named" align=center>Logout</td>
			</tr>
			
		</table>
	</div>

</body>
</html>