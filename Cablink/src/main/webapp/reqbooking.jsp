<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		System.out.println("serv"+session.getAttribute("uname"));
 		if(session.getAttribute("uname")==null){
 			response.sendRedirect("login.jsp");
 		}
 	%>
</head>
<body>
<header style="margin: 0px 0px;">
		<h1>
			<span style="font-size: 50px; margin: 0px 0px;">CabLink</span>
				<a href = 'services.jsp' style = "font-size:30px;margin:0px 0px"><c:out value="${sessionScope.uname}"></c:out></a>
				
		</h1>
	</header>
	<nav>
		
		<a href="home.jsp"><input type="button" value="Home" class = "button-52"></a>
		&nbsp <a href="About.html"><input type="button" value="About" class = "button-52"></a>
		&nbsp <a href="services.jsp"><input type="button" value="Service" class = "button-52"></a>
		&nbsp <a href="Contact.html"><input type="button" value="Contact" class = "button-52"></a>
		&nbsp <a href="login.jsp" style="float: right; display: grid; justify-content: right"><input
			type="button" value="Book Now" class = "button-52"></a>

	</nav>
	<br>
	<br>
	<div align=center class = "container" >
	<form action = "./booking">
		<table>
			<tr>
				<td>
					<img src = "edit.png" alt="unable" width = 100px>
				</td>
				<td>
					<a href = "register.jsp?op=edit">Edit Detais</a>
				</td>
			</tr>
			
				<tr>
					<td>
						<img src = "del.png" alt="unable" width=100px>
					</td>
					<td>
						<a href="val.jsp?op=del&mode=${sessionScope.mode}">Delete</p></a>
					</td>
				</tr>
			
			<tr>
			<td>
					<img src = "logout.jpg" alt="unable" width=100px>
				</td>
				<td>
					<a href = "val.jsp?op=logout&mode=passenger">Logout</a>
				</td>
			</tr>
		</table>
	</form>
	</div>
</body>
</html>