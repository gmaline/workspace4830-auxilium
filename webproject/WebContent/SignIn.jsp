<%@ include file="Header.jsp" %>
<title>Sign In Page</title>
</head>
<body>
<%@ include file="Navbar.jsp" %>
	<br>
	<div id="container" class="row justify-content-center">
		
		<div class="card">
			<div class="card-header">Login</div>
			<div class="card-body">
				<form action="SignInUser" method="POST">
					<div class="form-group row">
						<label for="email" class="col-sm-4 col-form-label text-md-right">
						Email
						</label>
						
						<div class="col-md-6">
							<input id="email" type="text" name="email">
						
						</div>
					</div>
					<div class="form-group row">
						<label for="password" class="col-sm-4 col-form-label text-md-right">
						Password
						</label>
						
						<div class="col-md-6">
							<input id="password" type="password" name="password">
							<input type="checkbox" onclick="myFunction()">&ensp;Show Password
						
						</div>
					</div>
					
					<input class="button" type="submit" value="Submit" />
				</form>
			</div>
		</div>
		
	<br/>
	</div>
	<script>
		function myFunction() {
		  var x = document.getElementById("password");
		  if (x.type === "password") {
		    x.type = "text";
		  } else {
		    x.type = "password";
		  }
		}
	</script>
<%@ include file="Footer.jsp" %>