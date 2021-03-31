<%@ include file="Header.jsp" %>
<title>Create User</title>
</head>
<body>
<%@ include file="Navbar.jsp" %>
<main>
	<div style="width:100%">
		<h2 style="text-align:center">Create an Account</h2>
		<br>
		<form action="TBD" method="POST">
			Full Name:  &nbsp;&ensp; <input type="text" name="email"> <br />
			<br/>
			Email:    &emsp;&ensp;&ensp;&ensp; <input type="text" name="email"> <br />
			<br/>
			Password: &ensp;&ensp; <input type="text" name="password"> <br />
			<br/>
			Organization: <input type="text" name="organization"> <br />
			<br/>
			Age: &emsp;&emsp;&emsp;&ensp;&nbsp; <input type="text" name="age"> <br />
			<br/>
			<input type="submit" value="Submit" />
		</form>
		
		
	</div>
	<br/>

	<a href="/webproject/SignIn.jsp">Already have an account? Sign In</a> <br>
</main>
<%@ include file="Footer.jsp" %>