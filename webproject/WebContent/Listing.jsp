<%@ include file="Header.jsp" %>
<title>Listing</title>
</head>
<body>
<%	HttpSession pression = request.getSession();
	String user = (String)pression.getAttribute("email"); 
	if(user == null){%>
		<%@ include file= "Navbar.jsp" %>
	<% }
	else {%>
    	<%@ include file= "Navbar_LoggedIn.jsp" %>
	<% } 
%>

		<br><br><br>
		<div class="text-center col-4 offset-4">
			<h4>${name}</h4>
			<br><br>
			<p><strong>Quality: </strong>${quality}</p>
			<br><br>
			<p><strong>Description: </strong>${description}</p>
			<br><br>
			<p><strong>Posted by: </strong>${user}</p>
			<br><br>
			<p><strong>Item ID: </strong>${id}</p>
			<br><br>
			<form name="request" action="SubmitRequest?item=${id}" method="POST">
				<input type="submit" class="btn btn-primary" value="Request this item">
			</form>
		</div>

</body>
</html>
<%@ include file="Footer.jsp" %>