<%@ include file="Header.jsp" %>
<title>Home Page</title>
</head>
<body class="home">
	<div>
		<div class="home-nav">
		<!--  if logged in -->
		<%	HttpSession pression = request.getSession();
			String user = (String)pression.getAttribute("email"); 
			if(user == null){%>
				<a class="home-link" href="/webproject/SignIn.jsp">Login</a>
				<a class="home-link" href="/webproject/CreateUser.jsp">Register</a>
			<% }
			else {%>
		    	<a class="home-link" href="Profile">Profile <span class="badge badge-primary" id="notifications"></span></a>
				<a class="home-link" href="LogOut">Log Out</a>
			<% } 
		%>
			
		
			
		</div>
		
		<div class="content">
			<div class="home-title">
				AUXILIUM
			</div>
			<br>
			<div class="home-tag">
				Insert Catchy tagline here
			</div>
			
			<div class="home-links">
				<a class="home-link" href="/webproject/ListingsIndex">Listings</a>
				<a class="home-link" href="/webproject/Donation.jsp">Donate</a>
				<a class="home-link" href="/webproject/Request.jsp">Request</a>
			
			</div>
		
		
		
		</div>
	
	
	</div>




<%@ include file="Footer.jsp" %>

