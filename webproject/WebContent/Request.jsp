<%@ include file="Header.jsp" %>
<title>Request Page</title>
</head>

<body>

	<%	HttpSession pression = request.getSession();
    	String user = (String)pression.getAttribute("email"); 
		if(user == null){
		 response.setContentType("text/html");
		 out.println("<script type=\"text/javascript\">");
		 out.println("alert('You MUST Log In To Make a REQUEST!');");
		 out.println("location='SignIn.jsp';");
		 out.println("</script>");
	} %>

<%@ include file="Navbar_LoggedIn.jsp" %>
	<main>
	<div id="container">		
		
		<div style="width:100%">
		<h2 style="text-align:center">Request an Available Item</h2>
		
		<form name="requester" action="SubmitRequest" method="POST">
		<br><br>
		Item ID: <input type="number" min="1" id="id" name="item" required placeholder="Item ID"><br />
		<br/>
		<span class="error"><p id="item_error"></p></span>
		
		<input type="submit" value="Submit" />
		</form>
		
		</div>
		
	</div>
	</main>
	
<%@ include file="Footer.jsp" %>

