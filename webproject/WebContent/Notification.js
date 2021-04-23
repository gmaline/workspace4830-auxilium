
//Just a bit of JavaScript to load the number of notifications a user has on window load

window.onload = function() {
	if (sessionStorage.getItem('notifications') > 0) {
		$("#notifications").text(sessionStorage.getItem('notifications'));
	}
	
	//Load the number of notifications a user has
	$.get("/webproject/GetNotifications", function(responseText) {
		sessionStorage.setItem('notifications', responseText);
		if (sessionStorage.getItem('notifications') > 0) {
			$("#notifications").text(sessionStorage.getItem('notifications'));
		}
	});
}

