<%@ include file="Header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<title>View Listings</title>
</head>
<body>
<%@ include file="Navbar.jsp" %>
	<br><br>
	<h1 class="text-center">Listings</h1>
	<br>
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