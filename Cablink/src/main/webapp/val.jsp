<%@page import="io.opentelemetry.exporter.logging.SystemOutLogRecordExporter"%>
<%@page import="com.src.objs.ObjectGenerator"%>
<%@page import="com.src.security.SecurityServices"%>
<%@page import="com.src.security.SecurityServicesInterface"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="False" import = "com.src.Dao.*,com.src.services.*,com.src.model.*"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1"> 
<title>Insert title here</title>
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
	<%
		ObjectGenerator objgetter = new ObjectGenerator();
		SecurityServicesInterface ssi = objgetter.getSecurityServices();
		PassengerServiceInterface psi = objgetter.getPassengerServices();
		BookingServicesInterface bsi = objgetter.getBookingServices();
		
		RequestBookingInterface rbi = objgetter.getRequestDriverServices();
		PermDriverServicesInterface pdsi = objgetter.getPermDriverServices();
		TempDriverServicesInterface tdsi = objgetter.getTempDriverServices();
		
		String msg = "";
		String op = request.getParameter("op");
		String mode = request.getParameter("mode");
		if(mode.equals("passenger")){
			if(op.equals("check")){
				 
				Passenger user = psi.getDetails(ssi.encrypt(request.getParameter("clid")),ssi.encrypt(request.getParameter("cpwd")));
				if(user!=null){
					RequestDispatcher rpd = request.getRequestDispatcher("home.jsp?mode=passenger");
					session.setAttribute("uname",request.getParameter("clid"));
					session.setAttribute("mode", "passenger");
					session.setAttribute("user", user);
					session.setAttribute("msglog", "Succesfully Logged In");

					rpd.include(request, response);
				}
				else{
					System.out.println("else");
					
					RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
					session.setAttribute("msg", "User Doesn't Exist Register/Invalid Username or Password");
					
					rd.include(request, response);
				}
				
			}
			else if(op.equals("add")){
				
				Passenger user; 
				try{
				user = new Passenger(ssi.encrypt(request.getParameter("uname")),ssi.encrypt(request.getParameter("upwd")),ssi.encrypt(request.getParameter("name")),Long.parseLong(request.getParameter("umob")),request.getParameter("uemail"),request.getParameter("gender").charAt(0),request.getParameter("uaddress"));
				}
				catch(Exception e){
					user = null;
				}
				if(user!=null && psi.addDetails(user)){
					RequestDispatcher rpd = request.getRequestDispatcher("home.jsp?mode=passenger");
					session.setAttribute("uname",request.getParameter("uname"));
					session.setAttribute("mode", "passenger");
					session.setAttribute("user", user);
					session.setAttribute("msgreg","Succesfully Registered");
					
					rpd.include(request, response);
				}
				else{
					RequestDispatcher rd = request.getRequestDispatcher("login.jsp?mode="+request.getParameter("mode")+"&msg=User Already Exists / Email Already Exists");
					session.setAttribute("msg", "User Already Exists / Email Already Exists");
					rd.include(request, response);
				}
			}
			else if(op.equals("edit")){
				
				Passenger user = (Passenger)session.getAttribute("user");
				user.setName(ssi.encrypt(request.getParameter("name")));
				user.setMobile(Long.parseLong(request.getParameter("umob")));
				user.setEmail(request.getParameter("uemail"));
				user.setAddress(request.getParameter("uaddress"));
				user.setGender(request.getParameter("gender").charAt(0));
				if(psi.updateDetails(user)){
					
					RequestDispatcher rpd = request.getRequestDispatcher("services.jsp?mode=passenger");
					rpd.include(request, response);
				}
				
			}
			else if(op.equals("del")){
				
				Passenger user = (Passenger)session.getAttribute("user");
				
				if(psi.deleteDetails(user)){
					
					RequestDispatcher rpd = request.getRequestDispatcher("login.jsp?mode=passenger");
					session.invalidate();
					rpd.include(request, response);
				}
				
			}
			else if(op.equals("logout")){
					RequestDispatcher rpd = request.getRequestDispatcher("login.jsp?msg=Logged Out "+ssi.decrypt(((Passenger)session.getAttribute("user")).getUsername()));
					session.invalidate();
					rpd.include(request, response);
				
				
				
			}
			else if(op.equals("bookpass")){
				RequestDispatcher rpd = request.getRequestDispatcher("booked.jsp");
				Passenger user = (Passenger)session.getAttribute("user");
				Booking book = new Booking(request.getParameter("from"),request.getParameter("to"),user.getUsername(),request.getParameter("drivuname"),Double.parseDouble(request.getParameter("bookfare")),Double.parseDouble(request.getParameter("routedistance")));
				
				boolean q1 = bsi.addBooking(book);
		
				boolean q2 = rbi.setRequest(request.getParameter("drivuname"),request.getParameter("from"),request.getParameter("to"));
				if(q2){
					rpd.include(request, response);
				}
			}
	
			
			else if(op.equals("delbook")){
				Booking b = (Booking)session.getAttribute("booking");
				Passenger user = (Passenger)session.getAttribute("user");
				Booking b1 = bsi.getBooking(user.getUsername());
				
				RequestDispatcher rmd = request.getRequestDispatcher("home.jsp");
				if(b!=null && bsi.deleteBooking(b.getfromplace(), b.gettoplace(), b.getCust_username())){
					rmd.include(request, response);
					session.setAttribute("booking",null);
				}
				if(b1!=null && bsi.deleteBooking(b1.getfromplace(), b1.gettoplace(), b1.getCust_username())){
					rmd.include(request, response);
					b1=null;
				}
			}
		}
		else if(mode.equals("tdriver")){
			
			String redirect = null;
			
			if(op.equals("check")){

				TempDriver tdriver = tdsi.getDetails(ssi.encrypt(request.getParameter("clid")),ssi.encrypt(request.getParameter("cpwd")));
				if(tdriver!=null){
					RequestDispatcher rtd = request.getRequestDispatcher("home.jsp?mode=tdriver");
					session.setAttribute("uname",request.getParameter("clid"));
					session.setAttribute("mode", "tdriver");
					session.setAttribute("user", tdriver);
					session.setAttribute("msglog", "Succesfully Logged In");
					
				
						rtd.include(request, response);
					
				}
				else{
					RequestDispatcher rd = request.getRequestDispatcher("login.jsp?mode="+request.getParameter("mode")+"&msg=User Doesn't Exist Register/Invalid Username or Password");
					rd.include(request, response);
				}
			}
			else if(op.equals("add")){
				
				TempDriver user ;
				
				try{
					user = new TempDriver(ssi.encrypt(request.getParameter("uname")),ssi.encrypt(request.getParameter("upwd")),ssi.encrypt(request.getParameter("name")),Long.parseLong(request.getParameter("umob")),request.getParameter("uemail"),request.getParameter("gender").charAt(0),request.getParameter("uaddress"));
				}
				catch(Exception e){
					user = null;
				}
				if(user!=null && tdsi.addDetails(user)){
					RequestDispatcher rtd = request.getRequestDispatcher("home.jsp?mode=tdriver");
					session.setAttribute("uname",request.getParameter("uname"));
					session.setAttribute("mode", "tdriver");
					session.setAttribute("user", user);	
					session.setAttribute("msgreg","Succesfully Registered");
				
					rtd.include(request, response);
					
				}
				else{
					RequestDispatcher rd = request.getRequestDispatcher("login.jsp?mode="+request.getParameter("mode")+"&msg=User Already Exists / Email Already Exists");
					rd.include(request, response);
				}
				
				
			}
			else if(op.equals("edit")){
				TempDriver user = (TempDriver)session.getAttribute("user");
				user.setName(ssi.encrypt(request.getParameter("name")));
				user.setMobile(Long.parseLong(request.getParameter("umob")));
				user.setEmail(request.getParameter("uemail"));
				user.setAddress(request.getParameter("uaddress"));
				user.setGender(request.getParameter("gender").charAt(0));
				if(tdsi.updateDetails(user)){
					
					RequestDispatcher rpd = request.getRequestDispatcher("services.jsp?mode=tdriver");
					rpd.include(request, response);
				}
			}
			else if(op.equals("del")){
				TempDriver user = (TempDriver)session.getAttribute("user");
				
				if(tdsi.deleteDetails(user)){
					
					RequestDispatcher rpd = request.getRequestDispatcher("login.jsp?msg=Deleted Succesfully s"+ssi.decrypt(((TempDriver)session.getAttribute("user")).getUsername()));
					session.invalidate();
					rpd.include(request, response);
				}
			}
			else if(op.equals("logout")){
				RequestDispatcher rpd = request.getRequestDispatcher("login.jsp?msg=Logged out "+ssi.decrypt(((TempDriver)session.getAttribute("user")).getUsername()));
			
				session.invalidate();
				rpd.include(request, response);
			}
			else if(op.equals("book")){
				System.out.println("book-yesh-tdriver");
				RequestDispatcher rpd = request.getRequestDispatcher("booked.jsp");
				TempDriver user = (TempDriver)session.getAttribute("user");
				
				boolean q1 = bsi.setBooking(user.getUsername(), request.getParameter("from"), request.getParameter("to"));
				if(q1){
					rpd.include(request, response);
				}
			}
		}
		else if(mode.equals("pdriver")){
			
			

			if(op.equals("check")){
				PermDriver pd = pdsi.getDetails(ssi.encrypt(request.getParameter("clid")),ssi.encrypt(request.getParameter("cpwd")));

				if(pd!=null){
					RequestDispatcher rtd = request.getRequestDispatcher("home.jsp?mode=pdriver");
					session.setAttribute("uname",request.getParameter("clid"));
					session.setAttribute("mode", "pdriver");
					session.setAttribute("user", pd);
					session.setAttribute("msglog", "Succesfully Logged In");
			
					rtd.include(request, response);
				}
				else{
					RequestDispatcher rd = request.getRequestDispatcher("loginval.jsp?mode="+request.getParameter("mode")+"&msg=User Doesn't Exist Register");
					rd.include(request, response);
				}
			}
			else if(op.equals("add")){
				PermDriver user=null;
				try{
				 user = new PermDriver(ssi.encrypt(request.getParameter("uname")),ssi.encrypt(request.getParameter("upwd")),ssi.encrypt(request.getParameter("name")),Long.parseLong(request.getParameter("umob")),request.getParameter("uemail"),request.getParameter("gender").charAt(0),request.getParameter("uaddress"));
				}
				catch(Exception e){
					user = null;
				}
				if(user!=null && pdsi.addDetails(user)){
					RequestDispatcher rtd = request.getRequestDispatcher("home.jsp?mode=pdriver");
					session.setAttribute("uname",request.getParameter("uname"));
					session.setAttribute("mode", "pdriver");
					session.setAttribute("user", user);
					session.setAttribute("msgreg","Succesfully Registered");
				
					rtd.include(request, response);
					
				}
				else{
					RequestDispatcher rd = request.getRequestDispatcher("loginval.jsp?mode="+request.getParameter("mode")+"&msg=User Already Exists / Email Already Exists");
					rd.include(request, response);
				}
				
				
			}
			else if(op.equals("edit")){
				PermDriver user = (PermDriver)session.getAttribute("user");
				user.setName(ssi.encrypt(request.getParameter("name")));
				user.setMobile(Long.parseLong(request.getParameter("umob")));
				user.setEmail(request.getParameter("uemail"));
				user.setAddress(request.getParameter("uaddress"));
				user.setGender(request.getParameter("gender").charAt(0));
				if(pdsi.updateDetails(user)){
					
					RequestDispatcher rpd = request.getRequestDispatcher("services.jsp?mode=pdriver");
					rpd.include(request, response);
				}
				else{
					RequestDispatcher rpd = request.getRequestDispatcher("home.jsp?msg=Updated Succesfully");
					rpd.include(request, response);
				}
			}
			else if(op.equals("del")){
				PermDriver user = (PermDriver)session.getAttribute("user");
				
				if(pdsi.deleteDetails(user)){
					
					RequestDispatcher rpd = request.getRequestDispatcher("login.jsp?mode=pdriver");
					session.invalidate();
					rpd.include(request, response);
				}
				else{
					response.sendRedirect("Error.jsp?type=del");
				}
			}
			else if(op.equals("logout")){
				RequestDispatcher rpd = request.getRequestDispatcher("login.jsp?msg=Logged out "+ssi.decrypt(((PermDriver)session.getAttribute("user")).getUsername()));
				session.invalidate();
				rpd.include(request, response);
			}
			else if(op.equals("book")){
				System.out.println("book-yesh-tdriver");
				RequestDispatcher rpd = request.getRequestDispatcher("booked.jsp");
				PermDriver user = (PermDriver)session.getAttribute("user");
				
				boolean q1 = bsi.setBooking(user.getUsername(), request.getParameter("from"), request.getParameter("to"));
				if(q1){
					rpd.include(request, response);
				}
			}
		}
		else{
			System.out.print("Mode Null");
		}
	
	%>
</body>
</html>