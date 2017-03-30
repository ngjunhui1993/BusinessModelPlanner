// Get the modal
var projectFormmodal = document.getElementById('myProjectForm');
// Get the button that opens the modal
var projectFormBtn = document.getElementById("newLoadProject");
// Get the <span> element that closes the modal
var projectFormSpan = document.getElementsByClassName("closeProjectForm")[0];
// When the user clicks on the button, open the modal 
projectFormBtn.onclick = function () {
    projectFormmodal.style.display = "block";
}

// When the user clicks on <span> (x), close the modal
projectFormSpan.onclick = function () {
    projectFormmodal.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function (event) {
    if (event.target == projectFormmodal) {
        projectFormmodal.style.display = "none";
    }
}
