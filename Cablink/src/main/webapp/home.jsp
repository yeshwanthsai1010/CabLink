<%@page import="com.src.services.BookingServicesInterface"%>
<%@page import="com.src.services.RequestBooking"%>
<%@page import="com.src.services.RequestBookingInterface"%>
<%@page import="com.src.model.*"%>
<%@page import="com.src.objs.*"%>
<%@page import="com.src.model.Request"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored = "False"%>
	<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<link rel="stylesheet" href="StyleSheets/stylelogin.css">
<link href="https://fonts.googleapis.com/css2?family=Exo+2:ital,wght@1,300&display=swap" rel="stylesheet">
	<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Cinzel:wght@700&family=Exo+2:ital,wght@1,300&display=swap" rel="stylesheet">

<script type="text/javascript" src="Javascript/script.js"></script>

	<%
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
 		if(session.getAttribute("uname")==null){
 			response.sendRedirect("login.jsp");
 		}
 	%>
</head>
<body>
	<%
		String msg = request.getParameter("msg");
		
		if(msg!=null && (msg.equals("Succesfully Completed Your Ride") || msg.equals("Sorry for inconvenience") ))
		{
			session.setAttribute("msglog", "");
			session.setAttribute("msgreg", "");
			System.out.println("MSG");	
			ObjectGenerator objs = new ObjectGenerator();
			BookingServicesInterface bsi = objs.getBookingServices();
			RequestBookingInterface rbi = objs.getRequestDriverServices();
			String mode = (String)session.getAttribute("mode");
			if(mode.equals("tdriver")){
				TempDriver user = (TempDriver)session.getAttribute("user");
				Request reqs = rbi.isBooked(user.getUsername());
				if(reqs!=null){
					rbi.deleteRequest(reqs);
					
				}
			}
			else if(mode.equals("pdriver")){
				PermDriver user = (PermDriver)session.getAttribute("user");
				Request reqs = rbi.isBooked(user.getUsername());
				if(reqs!=null){
					rbi.deleteRequest(reqs);
					
				}
			}
		}
	%>
	<header style="margin: 0px 0px;">
		<h1>
			<p style="font-size: 70px; margin: 0px 0px;" class = "Name">CabLink
				<a href = 'services.jsp' style = "font-size:50px;margin:0px 0px;float:right" id="serv"><c:out value="${sessionScope.uname}"></c:out></a></p>
				
		</h1>
	</header>
	<nav>
		&nbsp&nbsp
		<a href="home.jsp"><button type="button" style="width:120px" class = "glow-on-hover" >Home</button></a>
		&nbsp&nbsp <a href="about.jsp"><button type="button" style="width:120px" class = "glow-on-hover" >About</button></a>
		&nbsp&nbsp <a href="services.jsp"><button type="button" style="width:120px" class = "glow-on-hover" >Services</button></a>
		&nbsp&nbsp <a href="contact.jsp"><button type="button" style="width:120px" class = "glow-on-hover" >Contact us</button></a>
		&nbsp&nbsp <a href="val.jsp?op=logout&mode=${sessionScope.mode }" style="float: right; display: grid; justify-content: right;width:120px;"><button
			type="button" value="Logout" class = "glow-on-hover" >Logout</button></a>

	</nav>
	<br>
	<c:if test="${sessionScope.mode eq 'passenger'}">
	<h2 class = "Namep" align = "center">Welcome to CabLink&#128661;</h2>
	<c:if test="${sessionScope.msglog eq 'Succesfully Logged In'}">
	<p class = "Namep" align = "center">Succesfully Logged In</p>
	</c:if> 
	<c:if test="${sessionScope.msgreg eq 'Succesfully Registered'}">
	<p class = "Namep" align = "center">Succesfully Registered</p>
	</c:if> 
	<div class="container">
	
	<div class = "container1">
		<p class = "Namep" style="width:200px;font-size:35px">Available Trips</p>
		<ul>
			<li><p class = "Namep">From-To</p>
				<ol>
					<li><p class = "Named">Hyderabad-Warangal</p></li>
					<li><p class = "Named">Hyderabad-Karimnagar</p></li>
					<li><p class = "Named">Hyderabad-Khammam</p></li>
					<li><p class = "Named">Warangal-Hyderabad</p></li>
					<li><p class = "Named">Warangal-Karimnagar</p></li>
					<li><p class = "Named">Warangal-Khammam</p></li>
					<li><p class = "Named">Karimnagar-Hyderabad</p></li>
					<li><p class = "Named">Karimnagar-Warangal</p></li>
					<li><p class = "Named">Karimnagar-Khammam</p></li>
					<li><p class = "Named">Khammam-Hyderabad</p></li>
					<li><p class = "Named">Khammam-Warangal</p></li>
					<li><p class = "Named">Khammam-Karimnagar</p></li>
					
				</ol>
			</li>
		
		</ul>
	
	</div>
	<div align=center class = "container2" >
		
		
		<p class="Namep" style="font-size:30px">Select From and To to Fetch Available Cab Details</p>
		<p class="Namep"><c:out value="${param.msg}"></c:out></p>
		<form action="./booking" >
			<table cellspacing = 50px >
				<tr>
					<td align = center class = "Named"><b>From:</b></td>
					<td>
						<select name = "From" class="Named" id = "From">
							<option value = "Hyderabad">Hyderabad</option>
							<option value = "Warangal">Warangal</option>
							<option value = "Karimnagar">Karimnagar</option>
							<option value = "Khammam">Khammam</option>
						</select>
					</td>
				</tr>
				<tr>
					<td align = center class = "Named"><b>To:</b></td>
					<td>
						<select name = "To" class="Named" id = "To">
							<option value = "Hyderabad">Hyderabad</option>
							<option value = "Warangal">Warangal</option>
							<option value = "Karimnagar">Karimnagar</option>
							<option value = "Khammam">Khammam</option>
						</select>
					</td>
				</tr>
				<tr>
					<td colspan = 2 align = center><button type = "submit" value = "Request" class = "glow-on-hover" onclick="clickhome()">Request Cab</button> </td>
				</tr>

			</table>
		</form>
	</div>
	</div>
	</c:if>
		<c:if test="${sessionScope.mode eq 'tdriver'}">
		<h2 class = "Namep" align = "center">Welcome to CabLink&#128661;</h2>
		<c:if test="${sessionScope.msglog eq 'Succesfully Logged In'}">
	<p class = "Namep" align = "center">Succesfully Logged In</p>
	</c:if> 
	<c:if test="${sessionScope.msgreg eq 'Succesfully Registered'}">
	<p class = "Namep" align = "center">Succesfully Registered</p>
	</c:if> 
		<div class ="container">
		<div class = "container1">
		<p class = "Namep" style="width:200px;font-size:35px">Available Trips</p>
		<ul>
			<li><p class = "Namep">From-To</p>
				<ol>
					<li><p class = "Named">Hyderabad-Warangal</p></li>
					<li><p class = "Named">Hyderabad-Karimnagar</p></li>
					<li><p class = "Named">Hyderabad-Khammam</p></li>
					<li><p class = "Named">Warangal-Hyderabad</p></li>
					<li><p class = "Named">Warangal-Karimnagar</p></li>
					<li><p class = "Named">Warangal-Khammam</p></li>
					<li><p class = "Named">Karimnagar-Hyderabad</p></li>
					<li><p class = "Named">Karimnagar-Warangal</p></li>
					<li><p class = "Named">Karimnagar-Khammam</p></li>
					<li><p class = "Named">Khammam-Hyderabad</p></li>
					<li><p class = "Named">Khammam-Warangal</p></li>
					<li><p class = "Named">Khammam-Karimnagar</p></li>
					
				</ol>
			</li>
		
		</ul>
	
	</div>
	<div align=center class = "container2" >
		<p class="Namep" style="font-size:30px">Enter From and To to Fetch Available Passengers</p>
		<p class="Namep"><c:out value="${param.msg}"></c:out></p>
		<form action="./booking" >
			<table cellspacing = 50px >
				<tr>
					<td align = center class="Named"><b>From:</b></td>
					<td>
						<select name = "From" class="Named" id = "From">
							<option value = "Hyderabad">Hyderabad</option>
							<option value = "Warangal">Warangal</option>
							<option value = "Karimnagar">Karimnagar</option>
							<option value = "Khammam">Khammam</option>
						</select>
					</td>
				</tr>
				<tr>
					<td align = center class="Named"><b>To:</b></td>
					<td>
						<select name = "To" class="Named" id = "To">
							<option value = "Hyderabad">Hyderabad</option>
							<option value = "Warangal">Warangal</option>
							<option value = "Karimnagar">Karimnagar</option>
							<option value = "Khammam">Khammam</option>
						</select>
					</td>
				</tr>
								<tr>
				<td class="Named">Enter Available Seats in Vehicle</td>
					<td colspan = 2 align = center><input class="Named" type = "number" name="max_people" id="max_people"></td>
				</tr>
				<tr>
					<td colspan = 2 align = center><button type = "submit" value = "Request Passengers" class = "glow-on-hover" onclick="clickhomed()">Request Passengers</button> </td>
				</tr>
			</table>
		</form>
	</div>
	</div> 
	</c:if>
		<c:if test="${sessionScope.mode eq 'pdriver'}">
		
		<h2 class = "Namep" align = "center">Welcome to CabLink&#128661;</h2>
		<c:if test="${sessionScope.msglog eq 'Succesfully Logged In'}">
	<p class = "Namep" align = "center">Succesfully Logged In</p>
	</c:if> 
	<c:if test="${sessionScope.msgreg eq 'Succesfully Registered'}">
	<p class = "Namep" align = "center">Succesfully Registered</p>
	</c:if> 
		<div class ="container">
		<div class = "container1">
		<p class = "Namep" style="width:200px;font-size:35px">Available Trips</p>
		<ul>
			<li><p class = "Namep">From-To</p>
				<ol>
					<li><p class = "Named">Hyderabad-Warangal</p></li>
					<li><p class = "Named">Hyderabad-Karimnagar</p></li>
					<li><p class = "Named">Hyderabad-Khammam</p></li>
					<li><p class = "Named">Warangal-Hyderabad</p></li>
					<li><p class = "Named">Warangal-Karimnagar</p></li>
					<li><p class = "Named">Warangal-Khammam</p></li>
					<li><p class = "Named">Karimnagar-Hyderabad</p></li>
					<li><p class = "Named">Karimnagar-Warangal</p></li>
					<li><p class = "Named">Karimnagar-Khammam</p></li>
					<li><p class = "Named">Khammam-Hyderabad</p></li>
					<li><p class = "Named">Khammam-Warangal</p></li>
					<li><p class = "Named">Khammam-Karimnagar</p></li>
					
				</ol>
			</li>
		
		</ul>
	
	</div>
	<div align=center class = "container2" >
		<p class="Namep" style="font-size:30px">Enter From and To to Fetch Available Passengers</p>
		<p class="Namep"><c:out value="${param.msg}"></c:out></p>
		<form action="./booking" >
			<table cellspacing = 50px >
				<tr>
					<td align = center class="Named"><b>From:</b></td>
					<td>
						<select name = "From"  class="Named" id = "From">
							<option value = "Hyderabad">Hyderabad</option>
							<option value = "Warangal">Warangal</option>
							<option value = "Karimnagar">Karimnagar</option>
							<option value = "Khammam">Khammam</option>
						</select>
					</td>
				</tr>
				<tr>
					<td align = center class="Named"><b>To:</b></td>
					<td>
						<select name = "To" class="Named" id = "To">
							<option value = "Hyderabad">Hyderabad</option>
							<option value = "Warangal">Warangal</option>
							<option value = "Karimnagar">Karimnagar</option>
							<option value = "Khammam">Khammam</option>
						</select>
					</td>
				</tr>
				<tr>
				<td class="Named">Enter Available Seats in Vehicle</td>
					<td colspan = 2 align = center><input class="Named" type = "number" name="max_people" id="max_people"></td>
				</tr>
				<tr>
					
					<td colspan = 2 align = center><button type = "submit" value = "Request Passengers" class = "glow-on-hover" onclick="clickhomed()">Request Passengers</button> </td>
				</tr>
			</table>
		</form>
	</div>
	</div>
	</c:if>
	

</body>
</html>