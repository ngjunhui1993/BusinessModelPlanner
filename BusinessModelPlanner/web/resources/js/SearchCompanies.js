var engAlphabets = ['All', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'];

$.each(engAlphabets, function(index, value) {
  $('<li><a href="#" class="letters">' + value + '</a></li>').appendTo('.pager');
});
$(".pager li:nth-child(1) a").css('background-color', '#BA0100');


$("#txtSearch").on("keypress", function(event) {

  // Disallow anything not matching the regex pattern (A to Z uppercase, a to z lowercase and white space)
  // For more on JavaScript Regular Expressions, look here: https://developer.mozilla.org/en-US/docs/JavaScript/Guide/Regular_Expressions
  var englishAlphabetAndWhiteSpace = /[A-Za-z ]/g;

  // Retrieving the key from the char code passed in event.which
  // For more info on even.which, look here: http://stackoverflow.com/q/3050984/114029
  var key = String.fromCharCode(event.which);

  //alert(event.keyCode);

  // For the keyCodes, look here: http://stackoverflow.com/a/3781360/114029
  // keyCode == 8  is backspace
  // keyCode == 37 is left arrow
  // keyCode == 39 is right arrow
  // englishAlphabetAndWhiteSpace.test(key) does the matching, that is, test the key just typed against the regex pattern
  if (event.keyCode == 8 || event.keyCode == 37 || event.keyCode == 39 || englishAlphabetAndWhiteSpace.test(key)) {
    return true;
  }

  // If we got this far, just return false because a disallowed key was typed.
  return false;
});

$('#txtSearch').on("paste", function(e) {
  e.preventDefault();
});
