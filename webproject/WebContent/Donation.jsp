<%@ include file="Header.jsp" %>
<title>Donation</title>
<script src="Donation.js"></script>
</head>

<body>
<%@ include file="Navbar.jsp" %>
	<h1>Create a donation</h1>

	<div id="bodyContent">
		<div id="typeContainer">
			<h2>What type of donation are you submitting?</h2>
			
			<select id="type" name="type">
				<option value="Book">Book</option>
				<option value="Notebook">Notebook</option>
				<option value="Pens & Pencils">Pens & Pencils</option>
				<option value="Other">Other</option>
			</select>
			<button type="button" onclick="checkForm()">Next</button>
		</div>
		
		<h2 id="submissionType" hidden></h2>
		
		<button id="goBack" type="button" onclick="goBack()" hidden>Back</button>
				
		<form id="formNotBook" hidden>
			<label for="name">Name:</label>
			<input type="text" id="name" name="name" required>
			<br>
			<label for="quality">Quality:</label>
			<select id="quality" name="quality" required>
				<option value="Like-New">Like-New</option>
				<option value="Slightly Used">Slightly Used</option>
				<option value="Moderately Used">Moderately Used</option>
				<option value="Heavily Used">Heavily Used</option>
			</select>
			<br>
			<label for="description">Description:</label>
			<input type="text" id="description" name="description" required>
			<br>
			<input type="submit" value="Submit">
		</form>
	
		<form id="formBook" hidden>
			<label for="title">Title:</label>
			<input type="text" id="title" name="title" required>
			<br>
			<label for="author">Author:</label>
			<input type="text" id="author" name="author" required>
			<br>
			<label for="isbn">ISBN:</label>
			<input type="text" id="isbn" name="isbn" required>
			<br>
			<label for="quality">Quality:</label>
			<select id="quality" name="quality" required>
				<option value="Like-New">Like-New</option>
				<option value="Slightly Used">Slightly Used</option>
				<option value="Moderately Used">Moderately Used</option>
				<option value="Heavily Used">Heavily Used</option>
			</select>
			<br>
			<label for="description">Description:</label>
			<input style="width:300px; height:100px" type="text" id="description" name="description" required>
			<br>
			<input type="submit" value="Submit" onclick="submitForm()">
		</form>
		
	</div>

<%@ include file="Footer.jsp" %>