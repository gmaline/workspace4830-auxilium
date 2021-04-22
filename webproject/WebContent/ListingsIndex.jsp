<%@ include file="Header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<title>View Listings</title>
</head>
<body>

<%	HttpSession pression = request.getSession();
    	String user = (String)pression.getAttribute("email"); 
		if(user == null){
		 response.setContentType("text/html");
		 out.println("<script type=\"text/javascript\">");
		 out.println("alert('You MUST Log In To View the Listings');");
		 out.println("location='SignIn.jsp';");
		 out.println("</script>");
		}
	%>
    	
    <%@ include file= "Navbar_LoggedIn.jsp" %>
    
	<h1 class="text-center">Listings</h1>
	<br>

    <a class="nav-link" href="/webproject/Search.jsp">Search Listings</a>

	<div class="container">
		<div class="row" id="listings">
			
			<c:forEach items="${posts}" var="post">

				<div class="col-4">
					<div class="card">
						<div class="card-body">
							<h5 class="card-title">${post.name}</h5>
							<p class="card-text">${post.description}</p>
							<a href="/webproject/Listing?id=${post.id}" class="btn btn-primary">View</a>
						</div>
					</div>
				</div>

			</c:forEach>
			
		</div>
	</div>
	
<%@ include file="Footer.jsp" %>
