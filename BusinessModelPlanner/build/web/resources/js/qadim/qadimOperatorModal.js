// Get the modal
var formModal = document.getElementById('operatorOneModal');
// Get the button that opens the modal
var formBtn = document.getElementById("operatorOneModalbtn");
// Get the <span> element that closes the modal
var formSpan = document.getElementsById("closeOperator")[0];
// When the user clicks on the button, open the modal 
formBtn.onclick = function () {
    formModal.style.display = "block";
}
// When the user clicks on <span> (x), close the modal
formSpan.onclick = function () {
    formModal.style.display = "none";
}
// When the user clicks anywhere outside of the modal, close it
window.onclick = function (event) {
    if (event.target == formModal) {
        formModal.style.display = "none";
    }
}