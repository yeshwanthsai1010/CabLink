<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="StyleSheets/stylelogin.css">
<link href="https://fonts.googleapis.com/css2?family=Exo+2:ital,wght@1,300&display=swap" rel="stylesheet">
	<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Cinzel:wght@700&family=Exo+2:ital,wght@1,300&display=swap" rel="stylesheet">
	
<title>About</title>
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
	<div class="containersingle">
    <main>
        <section>
            <h2 class="Namep">Our Vision</h2>
            <p class="Named">At CabLink, we envision a world where transportation is not just a necessity, but an experience that leaves you with a smile. Our mission is to transform the way you move around town, one ride at a time.</p>
        </section>
        <section>
            <h2 class="Namep">Our Story</h2>
            <p class="Named">Our journey began with a simple idea: to connect passengers with reliable, professional drivers, and provide a platform where convenience and security reign supreme. Since our inception, we've been committed to delivering a service that reflects this vision.</p>
        </section>
        <section>
            <h2 class="Namep">Why Choose CabLink?</h2>
            <ul>
                <li class="Named"><b>Customer-Centric:</b> Everything we do revolves around your needs. We listen to your feedback and strive to make every aspect of your ride better.</li>
                <li class="Named"><b>Safety First:</b> Your safety is our top priority. We vet our drivers, and our technology ensures secure, reliable rides.</li>
                <li class="Named"><b>Efficiency:</b> We're all about saving you time. CabLink's real-time matching gets you on the road faster.</li>
                <li class="Named"><b>Ease of Use:</b> Our app is designed with you in mind. It's simple, intuitive, and user-friendly.</li>
                <li class="Named"><b>Community:</b> When you choose CabLink, you're not just taking a ride; you're joining a community of passengers and drivers who share the same commitment to quality transportation.</li>
            </ul>
        </section>
        <!-- Add more sections as needed for your content -->
    </main>
    </div>
   


</body>
</html>