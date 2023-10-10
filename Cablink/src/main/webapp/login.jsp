<%@page import="io.opentelemetry.exporter.logging.SystemOutLogRecordExporter"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored = "False"%>
	<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login-Options</title>

<link rel="stylesheet" href="StyleSheets/stylelogin.css">
<link href="https://fonts.googleapis.com/css2?family=Exo+2:ital,wght@1,300&display=swap" rel="stylesheet">
	<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Cinzel:wght@700&family=Exo+2:ital,wght@1,300&display=swap" rel="stylesheet">
	
</head>
<body>
<header style = "margin:0px 0px;">
		
		<b><p align = left style = "font-size:70px;margin:0px 0px;" class = "Name">CabLink</p></b>
		<br>
		
	</header>

 



	 <h2 align = center class = "Namep">Login/Register Options</h2>
	  	<%
 		if(session.getAttribute("uname")!=null){
 			response.sendRedirect("home.jsp");
 		}
 		
 		String msg = (String)session.getAttribute("msg");
 		
 		if(msg==null){
 			msg="";
 		}
 		msg = request.getParameter("msg");
 		if(msg==null){
 			msg="";
 		}
 		System.out.println(msg+" acts1");
 		System.out.println(request.getParameter("mode")+" macts");
 	
 	%>
	 <h3 align=center class="Named"><%out.print(msg); %> </h3>
	<div style = "margin:40px 40px;" class = "passenger-login" align = center>
		<table cellspacing = 50px>
		<tr><th><p class="Named">Passenger Login</p></th><th><p class="Named">Pool Request Login</p></th><th><p class="Named">Taxi Driver Login</p></th></tr>
		<tr>
		<td class="circle glow-on-hover"><a href = "loginval.jsp?mode=passenger&op=check" id="passenger"><img alt="unable" src="Images/passenger.jpg" style = "margin:0px 60px;"></a></td>
		<td class="circle glow-on-hover"><a href = "loginval.jsp?mode=tdriver&op=check" id="tdriver"><img alt="unable" src="Images/tdi.png" style = "margin:0px 60px;" width = 300px align = bottom></a></td>
		<td class="circle glow-on-hover"><a href = "loginval.jsp?mode=pdriver&op=check" id="pdriver"><img alt="unable" src="Images/pd.png" style = "margin:0px 60px;" width = 280px align = bottom></a></td>
		</tr>
		
		</table>
		
	</div>
</body>
</html>