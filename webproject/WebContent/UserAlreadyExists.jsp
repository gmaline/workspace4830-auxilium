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
			<label for="cars">Role:</label>
			  <select name="role" id="role">
			    <option value="student">Student</option>
			    <option value="organization">Organization</option>
			  </select><br/>
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
			<h6 style="color:red;">User already exists. Please try again or <a href="/webproject/SignIn.jsp"> Sign in</a>.</h6>
			<input type="submit" value="Submit" />
		</form>
		
		
	</div>
	<br/>
</main>
<%@ include file="Footer.jsp" %>