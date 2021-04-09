<%@ include file="Header.jsp" %>
<title>Create User</title>
</head>
<body>
<%@ include file="Navbar.jsp" %>
<main>
	<div style="width:100%">
		<h2 style="text-align:center">Create an Account</h2>
		<br>
		<form action="CreateUsers" method="POST">
			First Name:  &nbsp;&ensp;&ensp; <input type="text" name="firstName"> <br />
			<br/>
			Last Name:  &nbsp;&ensp;&ensp; <input type="text" name="lastName"> <br />
			<br/>
			Email:    &emsp;&ensp;&ensp;&ensp;&ensp; <input type="text" name="email"> <br />
			<br/>
			Age: &emsp;&emsp;&emsp;&ensp;&nbsp; <input type="text" name="age"> <br />
			<br/>
			Role: &emsp;&emsp;&emsp;&ensp;&nbsp; <input type="text" name="role"> <br />
			<br/>
			Organization: <input type="text" name="organization"> <br />
			<br/>
			Password: &ensp;&ensp; <input type="password" name="password" id="input"> <br />
			
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
			
			<c:if test="${not empty error}">
				<h3>${error}</h3>
			</c:if>
		</form>
		
		
	</div>
	<br/>

	<a href="/webproject/SignIn.jsp">Already have an account? Sign In</a> <br>
</main>
<%@ include file="Footer.jsp" %>