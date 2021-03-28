<%@ include file="Header.jsp" %>
<title>Create User</title>
</head>
<body>
<%@ include file="Navbar.jsp" %>
<main>
	<h2 style="text-align:center">Type of User</h2>
	<div id="container" style="width:100%">
			
			<div style="width:50%">
				<a href="/webproject/CreateUserIndividual.jsp">
				<button type=button value="Individual Use">Individual Account</button>
				</a>
			</div>
			<div style="width:50%">
				<a href="/webproject/CreateUserOrganization.jsp">
				<button type=button>Organization Account</button>
				</a>
			</div>
		
	</div>
	<br/>

	<a href="/webproject/SignIn.jsp">Already have an account? Sign In</a> <br>
</main>
<%@ include file="Footer.jsp" %>