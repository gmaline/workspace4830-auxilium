<%@ include file="Header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<title>Profile Page</title>
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
	<div>
		<h1> Account Profile </h1>
	</div>
	<body>
		<main>
			<div id="container">
				<div style="width:100%" >
					<section>
					<br>
					Full Name:  ${fullName}
					<br>
					<br>
					Email:  ${email}
					<br>
					<br>
					Age:  ${age}
					<br>
					<br>
					Role:  ${role}
					<br>
					<br>
					${org}
					<br>
					<br>
					You have<span id="somespan"></span> requests on the following items:
					<br>
					<c:forEach items="${notifs}" var="notif">
					
						<!-- Button trigger modal -->
						<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#notificationModal${notif.id}">
						  ${notif.donation.name}
						</button>
						
						<!-- Modal -->
						<div class="modal fade" id="notificationModal${notif.id}">
						  <div class="modal-dialog">
						    <div class="modal-content">
						      <div class="modal-header">
						        <h5 class="modal-title" id="exampleModalLabel">${notif.notifier.firstName} ${notif.notifier.lastName} has requested your listing for ${notif.donation.name}</h5>
						        <button type="button" class="close" data-dismiss="modal">
						          <span>&times;</span>
						        </button>
						      </div>
						      <div class="modal-body">
						        Contact them at ${notif.notifier.email} to complete the transaction.
						        <br>
						        <i>Pressing "Accept Request" will permanently remove the listing. Write down contact information before accepting.</i>
						      </div>
						      <div class="modal-footer">
						        <button onclick="denyRequest(${notif.id})" id="denyRequest" type="button" class="btn btn-secondary" data-dismiss="modal">Deny Request</button>
						        <button onclick="acceptRequest(${notif.id})" id="acceptRequest" type="button" class="btn btn-primary" data-dismiss="modal">Accept Request</button>
						      </div>
						    </div>
						  </div>
						</div>
					</c:forEach>
					<br>
					<br>
					</section>
				</div>
			</div>
		</main>

	</body>
</html>

<%@ include file="Footer.jsp" %>
<script>
function denyRequest(notificationId) {
	var params = {
		notificationResponse: "deny",
		notificationId: notificationId
	};
	
	$.post("http://localhost:8080/webproject/ProcessNotification", $.param(params), function(response) {
		location.reload();
	});
}
	
function acceptRequest(notificationId) {
	var params = {
			notificationResponse: "accept",
			notificationId: notificationId
		};
	
	$.post("http://localhost:8080/webproject/ProcessNotification", $.param(params), function(response) {
		location.reload();
	});
}
</script>/html>