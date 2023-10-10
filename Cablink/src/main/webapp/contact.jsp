<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contact</title>
<link rel="stylesheet" href="StyleSheets/stylelogin.css">
<link href="https://fonts.googleapis.com/css2?family=Exo+2:ital,wght@1,300&display=swap" rel="stylesheet">
	<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Cinzel:wght@700&family=Exo+2:ital,wght@1,300&display=swap" rel="stylesheet">

<script type="text/javascript" src="Javascript/script.js"></script>

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
	<div class="containersingle">
    <main >
        <section class="contact-info">
            <h2 class="Named">Customer Support</h2>
            <p class="Named">If you have questions or need assistance, our dedicated customer support team is here to help you 24/7.</p>
            <p class="Named">Email: <a href="mailto:support@cablink.com">support@cablink.com</a></p>
            <p class="Named">Phone: 12897984</p>
        </section>
        <section class="contact-info">
            <h2 class="Named">Feedback</h2>
            <p class="Named">We value your feedback. If you have suggestions or comments, please feel free to share them with us.</p>
            <p class="Named">Email: <a href="mailto:feedback@cablink.com">feedback@cablink.com</a></p>


	        </section>
        <section class="contact-info">
            <h2 class="Named">Business Inquiries</h2>
            <p class="Named">For business-related inquiries, partnerships, or collaborations, please contact our business development team.</p>
            <p class="Named">Email: <a href="mailto:business@cablink.com">business@cablink.com</a></p>
        </section>
        <section class="contact-info">
            <h2 class="Named">Address</h2>
            <p class="Named">CabLink Headquarters</p>
            <p class="Named">123 Main Street</p>
            <p class="Named">Cityville, CA 12345</p>
            <p class="Named">United States</p>
        </section>
        <section class="social-media">
            <h2 class="Named">Connect on Social Media</h2>
            <a href="https://www.facebook.com/CabLink" target="_blank" class="Named">Facebook</a>
            <a href="https://twitter.com/CabLink" target="_blank" class="Named">Twitter</a>
            <a href="https://www.instagram.com/cablink" target="_blank" class="Named">Instagram</a>
            <a href="https://www.linkedin.com/company/cablink" target="_blank" class="Named"dri >LinkedIn</a>
        </section>
    </main>
	</div>
</body>
	
</body>
</html>