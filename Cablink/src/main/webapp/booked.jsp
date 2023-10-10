<%@page import="io.opentelemetry.exporter.logging.SystemOutLogRecordExporter"%>
<%@page import="com.src.services.PermDriverServicesInterface"%>
<%@page import="com.src.services.TempDriverServicesInterface"%>
<%@page import="com.src.services.PassengerServiceInterface"%>
<%@page import="com.src.security.SecurityServicesInterface"%>
<%@page import="com.src.services.BookingServicesInterface"%>
<%@page import="com.src.objs.ObjectGenerator"%>
<%@page import="com.src.model.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Trip Ongoing..</title>
<link rel="stylesheet" href="StyleSheets/stylelogin.css">
<link href="https://fonts.googleapis.com/css2?family=Exo+2:ital,wght@1,300&display=swap" rel="stylesheet">
	<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Cinzel:wght@700&family=Exo+2:ital,wght@1,300&display=swap" rel="stylesheet">
<%
	ObjectGenerator obj = new ObjectGenerator();
	BookingServicesInterface bsi = obj.getBookingServices();
	PassengerServiceInterface psi = obj.getPassengerServices();
	TempDriverServicesInterface tsi = obj.getTempDriverServices();
	PermDriverServicesInterface pdsi = obj.getPermDriverServices();
	SecurityServicesInterface ssi = obj.getSecurityServices();
	System.out.println(request.getParameter("from")+"--"+request.getParameter("to")+"--"+request.getParameter("drivuname"));
	
	Booking booking = bsi.getBooking(request.getParameter("from"),request.getParameter("to"), request.getParameter("drivuname"));
	if(session.getAttribute("mode").equals("passenger")){
		booking = bsi.getBooking(ssi.encrypt((String)session.getAttribute("uname")));
	}

	Passenger passenger = null;
	TempDriver tempdriver = null;
	PermDriver permdriver = null;
	if(booking!=null){
		passenger = psi.getDetails(booking.getCust_username());
		tempdriver = tsi.getDetails(booking.getDriv_username()); 
		permdriver = pdsi.getDetails(booking.getDriv_username()); 
	}

%>
</head>
<body>
		<h1>
			<p style="font-size: 70px; margin: 0px 0px;" class = "Name">CabLink
				<a style = "font-size:50px;margin:0px 0px;float:right"><c:out value="${sessionScope.uname}"></c:out></a></p>
				
		</h1>

	<c:if test="${sessionScope.mode eq 'passenger'}">
		<h2 align=center class="Namep">Ongoing Trip......</h2>
		<div class="container">
		<div><table cellspacing = 20px><tr><th class="Namep">From</th><th class="Namep">To</th></tr><tr><td class="Named"><%=booking.getfromplace() %></td><td class="Named"><%=booking.gettoplace()%></td></tr><tr><th class="Namep">Passenger Name</th><th class="Namep">Driver Name</th></tr><tr><td class="Named"><%=ssi.decrypt(booking.getCust_username())%></td><td class="Named"><%=ssi.decrypt(booking.getDriv_username()) %></td></tr><tr><th class="Namep">Driver Mobile</th><th class="Namep">Driver Email</th></tr><%if(tempdriver!=null){ %><tr><td class="Named"><%=tempdriver.getMobile()%></td><td class="Named"> <%=tempdriver.getEmail() %></td></tr><%}else{ %><tr><td class="Named"><%=permdriver.getMobile()%></td><td class="Named"> <%=permdriver.getEmail() %></td></tr><%} %><tr><th class="Namep">Trip Fare</th><th class="Namep">Trip Distance</th></tr><tr><td class="Named"><%=booking.getBookingfare()%>Rs</td><td class="Named"><%=booking.getRoutedistance()%>Kms</td></tr><tr><td><a href = "home.jsp?mode=tdriver&op=complete&msg=Succesfully Completed Your Ride&from=${param.from}&to=${param.to}"><button class="glow-on-hover ">Reached Destination</button></a></td><td>		<a href = "val.jsp?mode=passenger&op=delbook&msg=Sorry for inconvenience" valign=center><button class="glow-on-hover ">Cancel Booking</button></a>
		</td></tr></table></div>
		
			
					<img src = "Images/trip.gif">
			
		</div>
	</c:if>
		<c:if test="${sessionScope.mode eq 'tdriver'}">
		<h2 align=center class="Namep">Ongoing Trip......</h2>
		<div class="container">
		<div><table cellspacing = 20px><tr><th class="Namep">From</th><th class="Namep">To</th></tr><tr><td class="Named"><%=booking.getfromplace() %></td><td class="Named"><%=booking.gettoplace()%></td></tr><tr><th class="Namep">Passenger Name</th><th class="Namep">Driver Name</th></tr><tr><td class="Named"><%=ssi.decrypt(booking.getCust_username())%></td><td class="Named"><%=ssi.decrypt(booking.getDriv_username()) %></td></tr><tr><th class="Namep">Passenger Mobile</th><th class="Namep">Passenger Email</th></tr><tr><td class="Named"><%=passenger.getMobile()%></td><td class="Named"> <%=passenger.getEmail() %></td></tr><tr><th class="Namep">Trip Fare</th><th class="Namep">Trip Distance</th></tr><tr><td class="Named"><%=booking.getBookingfare()%>Rs</td><td class="Named"><%=booking.getRoutedistance()%>kms</td></tr><tr><td colspan = "2"><a href = "home.jsp?mode=tdriver&op=complete&msg=Succesfully Completed Your Ride&from=${param.from}&to=${param.to}"><button class="glow-on-hover ">Reached Destination</button></a></td></tr></table></div>
		
		<img src = "Images/trip.gif">
		</div>
	</c:if>
		<c:if test="${sessionScope.mode eq 'pdriver'}">
		<h2 align=center class="Namep">Ongoing Trip......</h2>
		<div class="container">
		<div><table cellspacing = 20px><tr><th class="Namep">From</th><th class="Namep">To</th></tr><tr><td class="Named"><%=booking.getfromplace() %></td><td class="Named"><%=booking.gettoplace()%></td></tr><tr><th class="Namep">Passenger Name</th><th class="Namep">Driver Name</th></tr><tr><td class="Named"><%=ssi.decrypt(booking.getCust_username())%></td><td class="Named"><%=ssi.decrypt(booking.getDriv_username()) %></td></tr><tr><th class="Namep">Passenger Mobile</th><th class="Namep">Passenger Email</th></tr><tr><td class="Named"><%=passenger.getMobile()%></td><td class="Named"> <%=passenger.getEmail() %></td></tr><tr><th class="Namep">Trip Fare</th><th class="Namep">Trip Distance</th></tr><tr><td class="Named"><%=booking.getBookingfare()%>Rs</td><td class="Named"><%=booking.getRoutedistance()%>kms</td></tr><tr><td colspan = "2"><a href = "home.jsp?mode=pdriver&op=complete&msg=Succesfully Completed Your Ride&from=${param.from}&to=${param.to}"><button class="glow-on-hover ">Reached Destination</button></a></td></tr></table></div>
		
		<img src = "Images/trip.gif">
		</div>
	</c:if>
</body>
</html>