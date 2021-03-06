<%@ include file="Header.jsp" %>
<title>Donation</title>
</head>

<body>

	<%	HttpSession pression = request.getSession();
    	String user = (String)pression.getAttribute("email"); 
		if(user == null){
		 response.setContentType("text/html");
		 out.println("<script type=\"text/javascript\">");
		 out.println("alert('You MUST Log In To Make a Donation!');");
		 out.println("location='SignIn.jsp';");
		 out.println("</script>");
		}
	%>
    	
    <%@ include file= "Navbar_LoggedIn.jsp" %>


	<div id="bodyContent">
		<div>
			<div class="text-center">
				<br>
				<div id="typeContainer">
					<h2>What type of donation are you submitting?</h2>
					<br>
					<div class="row">
						<div class="col-6 offset-1">
							<select class="form-control" id="type" name="type">
								<option value="Book">Book</option>
								<option value="Notebook">Notebook</option>
								<option value="Pens & Pencils">Pens & Pencils</option>
								<option value="Other">Other</option>
							</select>
						</div>
						<div class="col-4">
							<button type="button" class="btn btn-primary form-control" onclick="checkForm()">Next</button>
						</div>
					</div>
				</div>
			</div>

			<h2 class="text-center" id="submissionType" hidden></h2>
			<button id="goBack" type="button" class="btn btn-primary float-right" onclick="goBack()" hidden>Go Back</button>
			<br><br>

			<form action="ProcessDonation" method="post" id="formNotBook" hidden>
				<label for="name">Name:</label>
				<input type="text" class="form-control" id="name" name="name" required>
				<br>
				<label for="quality">Quality:</label>
				<select class="form-control" id="quality" name="quality" required>
					<option value="Like-New">Like-New</option>
					<option value="Slightly Used">Slightly Used</option>
					<option value="Moderately Used">Moderately Used</option>
					<option value="Heavily Used">Heavily Used</option>
				</select>
				<br>
				<label for="description">Description:</label>
				<textarea class="form-control" id="description" name="description" required></textarea>
				<br>
				<input class="btn btn-primary" type="submit" value="Submit">
			</form>

			<!-- <form action="ProcessDonation" method="post" id="formBook" hidden>
				<label for="title">Title:</label>
				<input type="text" class="form-control" id="title" name="title" required>
				<br>
				<label for="author">Author:</label>
				<input type="text" class="form-control" id="author" name="author" required>
				<br>
				<label for="isbn">ISBN:</label>
				<input type="text" class="form-control" id="isbn" name="isbn" required>
				<br>
				<label for="quality">Quality:</label>
				<select class="form-control" id="qualityBook" name="quality" required>
					<option value="Like-New">Like-New</option>
					<option value="Slightly Used">Slightly Used</option>
					<option value="Moderately Used">Moderately Used</option>
					<option value="Heavily Used">Heavily Used</option>
				</select>
				<br>
				<label for="description">Description:</label>
				<textarea class="form-control" id="descriptionBook" name="description" required></textarea>
				<br>
				<input class="btn btn-primary" type="submit" value="Submit">
			</form> -->

		</div>
		
	</div>
	<script src="Donation.js"></script>
<%@ include file="Footer.jsp" %>
