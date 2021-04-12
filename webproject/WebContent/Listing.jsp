<%@ include file="Header.jsp" %>
<title>Listing</title>
</head>
<body>
<%@ include file="Navbar.jsp" %>
	
		<br><br><br>
		<div class="text-center col-4 offset-4">
			<h4>${name}</h4>
			<br><br>
			<p><strong>Quality:</strong>${quality}</p>
			<br><br>
			<p><strong>Description:</strong>${description}</p>
			<br><br>
			<p><strong>Posted by:</strong>${user}</p>
			<br><br>
			<button type="button" class="btn btn-primary">Request this item</button>
		</div>

</body>
</html>
<%@ include file="Footer.jsp" %>
