
let footerMsg = document.getElementById("date");
footerMsg.innerHTML = extractYear();




// Get current Year --------------------------------
function extractYear() {
	return new Date.getFullYear()
}


// Close aside menu --------------------------------
function closeMenu(){
	let aside = document.querySelector("aside");
	aside.classList.toggle("hide");
}
