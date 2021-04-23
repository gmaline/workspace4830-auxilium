
//Just a bit of JavaScript to load the number of notifications a user has on window load

window.onload = function() {
	
	//Load the number of notifications a user has
	$.get("http://localhost:8080/webproject/GetNotifications", function(responseText) {
		if (responseText != "0") {
			$("#notifications").text(responseText);
		}
	});
}

