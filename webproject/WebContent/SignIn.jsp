<%@ include file="Header.jsp" %>
<title>Sign In Page</title>
</head>
<body>
<%@ include file="Navbar.jsp" %>
	<main>
	<div id="container">
		
		<div style="width:100%">
		<h2 style="text-align:center">Sign In to Your Account</h2>
		
		<form action="SignInUser" method="POST">
			Email: <input type="text" name="email"> <br />
			<br/>
			Password: <input type="password" name="password"> <br />
			<br/>
			<input type="submit" value="Submit" />
		</form>
		</div>
		
	</div>
	<br/>
	<a href="/webproject/CreateUser.jsp">Create an Account</a> <br>
	</main>
<%@ include file="Footer.jsp" %>