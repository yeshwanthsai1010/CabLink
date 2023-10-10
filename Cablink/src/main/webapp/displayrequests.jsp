<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored = "False"%>
    	<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="StyleSheets/stylelogin.css">
<link href="https://fonts.googleapis.com/css2?family=Exo+2:ital,wght@1,300&display=swap" rel="stylesheet">
	<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Cinzel:wght@700&family=Exo+2:ital,wght@1,300&display=swap" rel="stylesheet">


<title>Requests</title>
	<%
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
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
				<a href = 'services.jsp' style = "font-size:50px;margin:0px 0px;float:right"><c:out value="${sessionScope.uname}"></c:out></a></p>
				
		</h1>
	</header>
	<nav>
		&nbsp&nbsp
		<a href="home.jsp"><button type="button" style="width:120px" class = "glow-on-hover" >Home</button></a>
		&nbsp&nbsp <a href="about.jsp"><button type="button" style="width:120px" class = "glow-on-hover" >About</button></a>
		&nbsp&nbsp <a href="services.jsp"><button type="button" style="width:120px" class = "glow-on-hover" >Services</button></a>
		&nbsp&nbsp <a href="contact.jsp"><button type="button" style="width:120px" class = "glow-on-hover" >Contact us</button></a>
		&nbsp&nbsp <a href="login.jsp" style="float: right; display: grid; justify-content: right;width:120px;"><button
			type="button" value="Book Now" class = "glow-on-hover" >Book Now</button></a>

	</nav>
	<%
		StringBuilder reqs = (StringBuilder)request.getAttribute("reqs");
		if(reqs!=null){
			if(session.getAttribute("mode").equals("passenger")){
			
	%>	
		<h3 class="Namep" align = "center">Available Trips</h3>
	<%
	
			}
			else{
				
			
	%>
		<h3 class="Namep" align = "center">Booked Requests</h3>
	<%		
			}
			
				out.print(request.getAttribute("reqs"));
		}
		else
		{
	%>
		<h3 class="Namep" align = "center">Trips Unavailable</h3>
	<%
		}
	%>


	
</body>
</html>