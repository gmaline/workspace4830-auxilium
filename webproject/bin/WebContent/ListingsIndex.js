/**
 * 
 */
window.onload = getListings();
		
function displayListings(response) {
	
	var listingsDisplay = document.getElementById("listings");
	
	var listings = JSON.parse(response);
	
	if (listings == null) {
		listingsDisplay.innerHTML = "<p>No listings to display :(</p>";
	}
	else {
		for (listing in listings) {
			document.getElementById("listings").innerHTML += "<div class=\"col-4\">" + 
			"<div class=\"card\">" +
				"<div class=\"card-body\">" +
					`<h5 class=\"car-title\">${listings[listing].name}</h5>` +
					`<p class=\"card-text\">${listings[listing].description}</p>` +
					`<a href=\"/webproject/Listing?id=${listings[listing].id}\" class=\"btn btn-primary\">View</a>` +
				"</div>" +
			"</div>";
		}
	}
}

function getListings() {
	//TODO: Change this to the actual server once it's deployed.
	var http = new XMLHttpRequest();
	var url = "http://localhost:8080/webproject/Listings";
	http.open("GET", url, true);
	http.send();
	
	http.onreadystatechange = function() {
		if ((this.readyState == 4) && (this.status == 200)) {
			displayListings(http.responseText);
		}
	}
}