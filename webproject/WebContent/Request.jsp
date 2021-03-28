<%@ include file="Header.jsp" %>
<title>Request Page</title>
</head>

<body>
<%@ include file="Navbar.jsp" %>
	<main>
	<div id="container">
		
		<div style="width:100%">
		<h2 style="text-align:center">Request an Available Item</h2>
		
		<form name="requester" action="SubmitRequest" method="POST">
	
		Item ID: <input type="number" id="id" name="item" required placeholder="Item ID"><br />
		<br/>
		<span class="error"><p id="item_error"></p></span>
		
		<input type="submit" value="Submit" />
	</form>
		
		</div>
		
	</div>
	</main>
<%@ include file="Footer.jsp" %>

