<%@ include file="Header.jsp" %>
<title>Home Page</title>
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


<h1>Welcome to Auxilium!</h1>
<div>
While the start of the new school year can be an exciting time for students, it can also be a stressful time for families across the country. 
In 2020, 1 in 6 children lived in poverty. In addition, the average household spends $696.70 on back-to-school supplies. 
For 1 in 6 children living in poverty, this means that families often struggle to buy school supplies while also putting food on the table. 

Many schools and non-profit organizations seek to address this need by hosting back-to-school drives where community members donate much needed items.
However, for many these needs are often left unmet. Teachers, on average, still spend $530 of their own money on school supplies for their classrooms. 
At the same time, when the end of the school year rolls around students throw away their unused or partially used school supplies that they no longer need. 
In fact, approximately 640,000 tons of books are discarded into landfills each year. 
Our web application, Auxilium, hopes to change these statistics by bridging the gap between needs and available resources for families, schools, and other educational organizations. 
</div>
	

<%@ include file="Footer.jsp" %>

