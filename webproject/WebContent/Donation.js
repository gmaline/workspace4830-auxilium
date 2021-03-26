function checkForm() {
  var x;

  x = document.getElementById("type").value;

  if (x == "Book") {
	  document.getElementById("formBook").removeAttribute("hidden");
  }
  else {
	  document.getElementById("formNotBook").removeAttribute("hidden");
  }
  
  document.getElementById("typeContainer").setAttribute("hidden", "");
  document.getElementById("goBack").removeAttribute("hidden");
  document.getElementById("submissionType").removeAttribute("hidden");
  document.getElementById("submissionType").innerHTML = `${x} Submission`;
}

function submitForm() {
	//TODO: Actually send the data
	document.getElementById("bodyContent").innerHTML = "<p>" +
	"Thank you for submitting a donation! We will notify you when it has " +
	"been requested by an organization." +
	"</p>";
}

function goBack() {
	var formBook = document.getElementById("formBook");
	var formNotBook = document.getElementById("formNotBook");

	
	if (formBook.attributes.length < 2) {
		formBook.setAttribute("hidden", "");
	}
	if (formNotBook.attributes.length < 2) {
		formNotBook.setAttribute("hidden", "")
	}
	
	document.getElementById("typeContainer").removeAttribute("hidden");
	document.getElementById("goBack").setAttribute("hidden", "");
	document.getElementById("submissionType").setAttribute("hidden", "");
}