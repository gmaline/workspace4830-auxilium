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
			Password: <input type="password" name="password" id="input"> <br />
		
			<input type="checkbox" onclick="myFunction()">&ensp;Show Password
			<script>
			function myFunction() {
			  var x = document.getElementById("input");
			  if (x.type === "password") {
			    x.type = "text";
			  } else {
			    x.type = "password";
			  }
			}
			</script>
			<br/>
			<br/>
			<input type="submit" value="Submit" />
		</form>
		</div>
		
	</div>
	<br/>
	<a href="/webproject/CreateUser.jsp">Create an Account</a> <br>
	</main>
<%@ include file="Footer.jsp" %>