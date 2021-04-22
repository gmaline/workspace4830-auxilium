<%@ include file="Header.jsp" %>
<title>Search Listing</title>
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


<h1>Search for Listings</h1>
<div>
<form action="SimpleFormSearch" method="POST">
	
		Listing name: <input type="text" name="keyword"> <br />
		
		<input type="submit" value="Search" />
	</form></div>
	

<%@ include file="Footer.jsp" %>

