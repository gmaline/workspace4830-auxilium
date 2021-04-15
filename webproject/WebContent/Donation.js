console.log("js is working");

function checkForm() {
  var x;

  x = document.getElementById("type").value;

// if (x == "Book") {
//	  document.getElementById("formBook").removeAttribute("hidden");
//  }
//  else {
	  document.getElementById("formNotBook").removeAttribute("hidden");
//  }
  
  document.getElementById("typeContainer").setAttribute("hidden", "");
  document.getElementById("goBack").removeAttribute("hidden");
  document.getElementById("submissionType").removeAttribute("hidden");
  document.getElementById("submissionType").innerHTML = `${x} Submission`;
}


function goBack() {
//	var formBook = document.getElementById("formBook");
	var formNotBook = document.getElementById("formNotBook");
	
//	if (formBook.hasAttribute("hidden") == false) {
//		formBook.setAttribute("hidden", "");
//	}
//	if (formNotBook.hasAttribute("hidden") == false) {
		formNotBook.setAttribute("hidden", "")
//	}
	
	document.getElementById("typeContainer").removeAttribute("hidden");
	document.getElementById("goBack").setAttribute("hidden", "");
	document.getElementById("submissionType").setAttribute("hidden", "");
}