<%@ include file="Header.jsp" %>
<title>Individual User</title>
</head>
<body>
<%@ include file="Navbar.jsp" %>
<div style="width:100%">
		<h2 style="text-align:center">Create an Individual Account</h2>
		
		<form action="TBD" method="POST">
			Full Name: <input type="text" name="email"> <br />
			<br/>
			Email: <input type="text" name="email"> <br />
			<br/>
			Password: <input type="text" name="password"> <br />
			<br/>
			Age: <input type="text" name="age"> <br />
			<br/>
			<input type="submit" value="Submit" />
		</form>
		
		</div>
		<a href="/webproject/CreateUser.jsp">Back to User Types</a> <br>
<%@ include file="Footer.jsp" %>