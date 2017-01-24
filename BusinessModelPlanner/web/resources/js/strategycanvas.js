$(function() {
    
            var boxCount = 2;
            var linesCount = 2;
            var linkLine = $('<div class="line lineA" id="line1A"></div>');
            var lines = []
            lines.push(linkLine);
            lines[0].appendTo('body');
            linkLine = $('<div class="line lineB" id="line1B"></div>');
            lines.push(linkLine);
            lines[1].appendTo('body');
            $("#addBox").click(function() {
                if (boxCount < 8){
                    linesCount += 2;
                    boxCount++;
                    var box = document.createElement("div");
                    if(boxCount%2 == 1){
                        box.className = 'box boxOdd';
                    }else{
                        box.className = 'box boxEven';
                    }
                    var drag1 = document.createElement("div");
                    drag1.className = 'draggable';
                    var drag2 = document.createElement("div");
                    drag2.className = 'draggable';
                    var dot1 = document.createElement("div");
                    var dot2 = document.createElement("div");
                    dot1.className = 'fa fa-circle dotA';
                    dot1.id = 'dotA'+boxCount;
                    dot2.className = 'fa fa-circle dotB';
                    dot2.id = 'dotB'+boxCount;
                    drag1.appendChild(dot1);
                    box.appendChild(drag1);
                    drag2.appendChild(dot2);
                    box.appendChild(drag2);
                    document.getElementById('factors').appendChild(box);
                    
                    var factorName = document.createElement("div");
                    factorName.className = 'factorName';
                    factorName.id = 'factor'+boxCount;
                    factorName.innerHTML = '<span id="factor'+boxCount+'" contenteditable="true">Factor '+boxCount+'</span>';
                    document.getElementById('factorsNames').appendChild(factorName);
                    
                    var myElement = document.getElementsByClassName("box");
                    
                    for(i=0; i<myElement.length; i++) {
                        myElement[i].style.width = ((100.00/boxCount)+"%");
                    }
                    
                    myElement = document.getElementsByClassName("draggable");
                    
                    for(i=0; i<myElement.length; i++) {
                        myElement[i].style.position = 'relative';
                        myElement[i].style.left = 50+'%';
                    }
                    
                    var myElement = document.getElementsByClassName("factorName");
                    
                    for(i=0; i<myElement.length; i++) {
                        myElement[i].style.width = ((100.00/boxCount)+"%");
                    }
                    
                
                    var temp = '<div class="line lineA" id="line'+(boxCount-1)+'A"></div>'
                    linkLine = $(temp);
                    lines[linesCount-2] = linkLine;
                    lines[linesCount-2].appendTo('body');
                    temp = '<div class="line lineB" id="line'+(boxCount-1)+'B"></div>'
                    linkLine = $(temp);
                    lines[linesCount-1] = linkLine;
                    lines[linesCount-1].appendTo('body');
                    lineAllign();
                    $(".draggable").draggable({
                        axis: "y",
                        containment: ".box", 
                        scroll: false,
                        distance: 0
                      },{drag: function(event, ui){
                          lineAllign();
                          }
                    });
                }
            
              });
        

                lineAllign();
               
               $(document).mousemove(linkMouseMoveEvent);


           function linkMouseMoveEvent(event) {
                for(i=1;i<boxCount;i++){
                    var lineName = '#line'+i+'A';
                    var dotAName = '#dotA'+i;
                    var dotBName = '#dotA'+(i+1);
                    if($(lineName).length > 0) {
                        var dot1OriginX = $(dotAName).offset().left + $(dotAName).outerWidth() / 2;
                        var dot1OriginY = $(dotAName).offset().top + $(dotAName).outerHeight() / 2;
                        var dot2OriginX = $(dotBName).offset().left + $(dotBName).outerWidth() / 2;
                        var dot2OriginY = $(dotBName).offset().top + $(dotBName).outerHeight() / 2;
                        $("#gy").html(dot1OriginY);

                        var length = Math.sqrt((dot2OriginX - dot1OriginX) * (dot2OriginX - dot1OriginX) 
                            + (dot2OriginY - dot1OriginY) * (dot2OriginY - dot1OriginY));

                        var angle = 180 / 3.1415 * Math.acos((dot2OriginY - dot1OriginY) / length);
                        if(dot2OriginX > dot1OriginX)
                            angle *= -1;

                        $(lineName)
                            .css('height', length)
                            .css('-webkit-transform', 'rotate(' + angle + 'deg)')
                            .css('-moz-transform', 'rotate(' + angle + 'deg)')
                            .css('-o-transform', 'rotate(' + angle + 'deg)')
                            .css('-ms-transform', 'rotate(' + angle + 'deg)')
                            .css('transform', 'rotate(' + angle + 'deg)');
                    }
                    lineName = '#line'+i+'B';
                    dotAName = '#dotB'+i;
                    dotBName = '#dotB'+(i+1);
                    
                    if($(lineName).length > 0) {
                        var dot1OriginX = $(dotAName).offset().left + $(dotAName).outerWidth() / 2;
                        var dot1OriginY = $(dotAName).offset().top + $(dotAName).outerHeight() / 2;
                        var dot2OriginX = $(dotBName).offset().left + $(dotBName).outerWidth() / 2;
                        var dot2OriginY = $(dotBName).offset().top + $(dotBName).outerHeight() / 2;

                        var length = Math.sqrt((dot2OriginX - dot1OriginX) * (dot2OriginX - dot1OriginX) 
                            + (dot2OriginY - dot1OriginY) * (dot2OriginY - dot1OriginY));

                        var angle = 180 / 3.1415 * Math.acos((dot2OriginY - dot1OriginY) / length);
                        if(dot2OriginX > dot1OriginX)
                            angle *= -1;

                        $(lineName)
                            .css('height', length)
                            .css('-webkit-transform', 'rotate(' + angle + 'deg)')
                            .css('-moz-transform', 'rotate(' + angle + 'deg)')
                            .css('-o-transform', 'rotate(' + angle + 'deg)')
                            .css('-ms-transform', 'rotate(' + angle + 'deg)')
                            .css('transform', 'rotate(' + angle + 'deg)');
                    }
                }
            }
            
            window.onresize = function(event) {
                lineAllign();
            };

           function endLinkMode() {
               $('#line1A').remove();
               $('#line1B').remove();
               $(document).unbind('mousemove.link').unbind('click.link').unbind('keydown.link');
           }
    
            var boxCenterXOffset = 5;
            var boxCenterYOffset = 5;
            $( "#sortable" ).sortable(
            {
              axis: "x",
              containment: "#factors", 
              scroll: false,
              distance: 0
            },{sort: function(event, ui){
                lines[0]
                   .css("visibility", "hidden");
                lines[1]
                   .css("visibility", "hidden");
                }
                
            },
            {stop: function(event, ui){
                lines[0]
                   .css("visibility", "visible")
                   .css('top', $('#dotA1').offset().top + $('#dotA1').outerWidth() / 2)
                   .css('left', $('#dotA1').offset().left + $('#dotA1').outerHeight() / 2);
                lines[1]
                   .css("visibility", "visible")
                   .css('top', $('#dotB1').offset().top + $('#dotB1').outerWidth() / 2)
                   .css('left', $('#dotB1').offset().left + $('#dotB1').outerHeight() / 2);
                }
            }       
            );
            $( "#sortable" ).disableSelection();
    
            $(".draggable").draggable({
              axis: "y",
              containment: ".box", 
              scroll: false,
              distance: 0
            },{drag: function(event, ui){
                lineAllign();
                }
            });
            
            
            function lineAllign(){
                var count = 0;
                for(i = 2; i <= boxCount; i++){
                    var dot1Name = '#dotA'+(i-1);
                    var dot2Name = '#dotB'+(i-1);
                    lines[count]
                       .css('top', $(dot1Name).offset().top + $(dot1Name).outerWidth() / 2)
                       .css('left', $(dot1Name).offset().left + $(dot1Name).outerHeight() / 2);
                    count++;
                    lines[count]
                       .css('top', $(dot2Name).offset().top + $(dot2Name).outerWidth() / 2)
                       .css('left', $(dot2Name).offset().left + $(dot2Name).outerHeight() / 2);
                    count++;
                    
                }
                  
            }
            var factorsElement = document.getElementsByClassName("factorName");

            for(i=0; i<factorsElement.length; i++) {
                factorsElement[i].onclick = function(event) {
                var span, input, text;

                // Get the event (handle MS difference)
                event = event || window.event;

                // Get the root element of the event (handle MS difference)
                span = event.target || event.srcElement;

                // If it's a span...
                if (span && span.tagName.toUpperCase() === "SPAN") {
                  // Hide it
                  span.style.display = "none";

                  // Get its text
                  text = span.innerHTML;

                  // Create an input
                  input = document.createElement("input");
                  input.type = "text";
                  input.size = Math.max(text.length / 4 * 3, 4);
                  span.parentNode.insertBefore(input, span);
                  // Focus it, hook blur to undo
                  input.focus();
                  input.onblur = function() {
                    // Remove the input
                    if(input.value == "" || input.value == null){
                        input.value = 'REQUIRED!';
                    }
                    span.parentNode.removeChild(input);

                    // Update the span
                    span.innerHTML = input.value;

                    // Show the span again
                    span.style.display = "";
                  };
                }
              };
            }
            
            function getYAxis(obj){
                var left, top;
                left = top = 0;
                if (obj.offsetParent) {
                    do {
                        top  += obj.offsetTop;
                    } while (obj = obj.offsetParent);
                }
                return {
                    y : top
                };
            };

          });
          
          