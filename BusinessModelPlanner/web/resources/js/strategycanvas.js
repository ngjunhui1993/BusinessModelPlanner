$(function() {
    
    
            var boxCount = 2;
            var linesCount = 2;
            var linkLine = $('<div class="line lineA" id="line1A"></div>');
            var lines = []
            var dotAY = $('#dotA1').offset().top;
            var dotBY = $('#dotB1').offset().top;
            var topOfCanvas = $('#topLabel').offset().top;
            var bottomOfCanvas = topOfCanvas + $('#container').outerHeight();
            var canvasHeight = Math.abs(topOfCanvas - bottomOfCanvas) ;
//            var bottomDifferenceA = document.getElementByID('#topLabel').offset.top - 
//                    document.getElementByID('#bottomLabel').offset.top ;
            //var bottomDifferenceB = Math.abs(dotBY - bottomOfCanvas);
            var difference = Math.abs(dotAY - dotBY);
            console.log("Bottom of canvas for A = " +canvasHeight );
//            console.log(" var difference = " + difference);
            
            lines.push(linkLine);
            lines[0].appendTo('body');
            linkLine = $('<div class="line lineB" id="line1B"></div>');
            lines.push(linkLine);
            lines[1].appendTo('body');
            $("#addBox").click(function() {
                removeIndication();
                if (boxCount < 8){
                    linesCount += 2;
                    boxCount++;
                    
                    var box = document.createElement("div");
                    if(boxCount%2 == 1){
                        box.className = 'box boxOdd';
                    }else{
                        box.className = 'box boxEven';
                    }
                    box.id = 'box'+boxCount;
                    var drag1 = document.createElement("div");
                    drag1.className = 'draggable draggable'+boxCount+'A draggable'+boxCount;
                    var drag2 = document.createElement("div");
                    drag2.className = 'draggable dotBottom draggable'+boxCount+'B draggable'+boxCount;
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
                    factorName.className = 'factorBox';
                    factorName.innerHTML = '<span class="factorName" id="factor' + boxCount + '" contenteditable="true">\n\
                    Factor ' + boxCount + '</span><br/>Weight: <select class="weight" id="weight' + boxCount + '"> \n\
                    <option value="1">1</option>\n\
                    <option value="2">2</option>\n\
                    <option value="3">3</option>\n\
                    <option value="4">4</option>\n\
                    <option value="5">5</option>\n\
                    </select><br/>\n\
                    Grid: <select id="grid' + boxCount + '"><option value="0">0</option>\n\
                    <option value="1">1</option>\n\
                    <option value="2">2</option><option value="3">3</option>\n\
                    <option value="4">4</option><option value="5">5</option>\n\
                    <option value="6">6</option><option value="7">7</option>\n\
                    <option value="8" selected="selected">8</option></select><br/>\n\
                    Value: <span class="factorValue" id="value' + boxCount + '" contenteditable="false">0</span><br>\n\
                     <span class="GreenDotValue" id="greenDot'+ boxCount +'" hidden="" >0</span><br>\n\
                     <span class="BlueDotValue" id="blueDot' + boxCount + '" hidden="" >0</span><br>';
                     document.getElementById('boxCounter').innerHTML = boxCount ;
                    document.getElementById('factorsNames').appendChild(factorName);
                    var indicatorName = document.createElement("div");
                    indicatorName.className = 'indicationBox';
                    indicatorName.id = 'indicationBox'+boxCount;
                    indicatorName.innerHTML = '<span class="indication" id="indication'+boxCount+'" contenteditable="false"></span><br/>';
                    document.getElementById('indicationNames').appendChild(indicatorName);
                    spanActivate();

                    var myElement = document.getElementsByClassName("box");
                    
                    for(i=0; i<myElement.length; i++) {
                        myElement[i].style.width = ((100.00/boxCount)+"%");
                    }
                    
                    myElement = document.getElementsByClassName("draggable");
                    
                    for(i=0; i<myElement.length; i++) {
                        myElement[i].style.position = 'relative';
                        myElement[i].style.left = 50+'%';
                    }
                    
                    var myElement = document.getElementsByClassName("factorBox");
                    
                    for(i=0; i<myElement.length; i++) {
                        myElement[i].style.width = ((100.00/boxCount)+"%");
                    }
                    
                    var myElement = document.getElementsByClassName("indicationBox");
                    
                    for(i=0; i<myElement.length; i++) {
                        myElement[i].style.width = ((100.00/boxCount)+"%");
                    }
                    $('.weight').change(function() {
                            removeIndication();
                    })
                    var temp = '<div class="line lineA" id="line'+(boxCount-1)+'A"></div>'
                    linkLine = $(temp);
                    lines[linesCount-2] = linkLine;
                    lines[linesCount-2].appendTo('body');
                    temp = '<div class="line lineB" id="line'+(boxCount-1)+'B"></div>'
                    linkLine = $(temp);
                    lines[linesCount-1] = linkLine;
                    lines[linesCount-1].appendTo('body');
                    lineAllign();
                    $(".draggable"+boxCount).draggable({
                        axis: "y",
                        containment: ".box",
                        grid: [difference/8,difference/8],
                        scroll: false,
                        distance: 0,

                      },{drag: function(event, ui){
                          lineAllign();
                          }
                    });
                    $('.draggable'+boxCount+'A').css('top', difference+'px');
                    $('.draggable'+boxCount+'B').css('top', difference+'px');
                    var tempdotAY = $('#dotA'+boxCount).offset().top;
                    var tempdotBY = $('#dotB'+boxCount).offset().top;
                    var tempDifference = Math.abs(tempdotAY - tempdotBY);
                    $('.draggable'+boxCount+'B').css('top', (difference-tempDifference)+'px');
                    lineAllign();
                    

                    document.getElementById("grid3").onchange=function() {
                            $('.draggable3A').css('top', difference+'px');
                            $('.draggable3B').css('top', difference+'px');
                            var tempdotAY = $('#dotA3').offset().top;
                            var tempdotBY = $('#dotB3').offset().top;
                            var tempDifference = Math.abs(tempdotAY - tempdotBY);
                            $('.draggable3B').css('top', (difference-tempDifference)+'px');
                            lineAllign();
                            var className = ".draggable3";
                            var number = difference/this.value;
                            $(className).draggable({
                                axis: "y",
                                containment: ".box", 
                                scroll: false,
                                grid: [number,number],
                                distance: 0,

                            },{drag: function(event, ui){
                                    lineAllign();
                            }
                            });

                        }
                        document.getElementById("grid4").onchange=function() {
                            $('.draggable4A').css('top', difference+'px');
                            $('.draggable4B').css('top', difference+'px');
                            var tempdotAY = $('#dotA4').offset().top;
                            var tempdotBY = $('#dotB4').offset().top;
                            var tempDifference = Math.abs(tempdotAY - tempdotBY);
                            $('.draggable4B').css('top', (difference-tempDifference)+'px');
                            lineAllign();
                            var className = ".draggable4";
                            var number = difference/this.value;
                            $(className).draggable({
                                axis: "y",
                                containment: ".box", 
                                scroll: false,
                                grid: [number,number],
                                distance: 0,

                            },{drag: function(event, ui){
                                    lineAllign();
                            }
                            });

                        }
                        document.getElementById("grid5").onchange=function() {
                            $('.draggable5A').css('top', difference+'px');
                            $('.draggable5B').css('top', difference+'px');
                            var tempdotAY = $('#dotA5').offset().top;
                            var tempdotBY = $('#dotB5').offset().top;
                            var tempDifference = Math.abs(tempdotAY - tempdotBY);
                            $('.draggable5B').css('top', (difference-tempDifference)+'px');
                            lineAllign();
                            var className = ".draggable5";
                            var number = difference/this.value;
                            $(className).draggable({
                                axis: "y",
                                containment: ".box", 
                                scroll: false,
                                grid: [number,number],
                                distance: 0,

                            },{drag: function(event, ui){
                                    lineAllign();
                            }
                            });

                        }
                        document.getElementById("grid6").onchange=function() {
                            $('.draggable6A').css('top', difference+'px');
                            $('.draggable6B').css('top', difference+'px');
                            var tempdotAY = $('#dotA6').offset().top;
                            var tempdotBY = $('#dotB6').offset().top;
                            var tempDifference = Math.abs(tempdotAY - tempdotBY);
                            $('.draggable6B').css('top', (difference-tempDifference)+'px');
                            lineAllign();
                            var className = ".draggable6";
                            var number = difference/this.value;
                            $(className).draggable({
                                axis: "y",
                                containment: ".box", 
                                scroll: false,
                                grid: [number,number],
                                distance: 0,

                            },{drag: function(event, ui){
                                    lineAllign();
                            }
                            });

                        }
                        document.getElementById("grid7").onchange=function() {
                            $('.draggable7A').css('top', difference+'px');
                            $('.draggable7B').css('top', difference+'px');
                            var tempdotAY = $('#dotA7').offset().top;
                            var tempdotBY = $('#dotB7').offset().top;
                            var tempDifference = Math.abs(tempdotAY - tempdotBY);
                            $('.draggable7B').css('top', (difference-tempDifference)+'px');
                            lineAllign();
                            var className = ".draggable7";
                            var number = difference/this.value;
                            $(className).draggable({
                                axis: "y",
                                containment: ".box", 
                                scroll: false,
                                grid: [number,number],
                                distance: 0,

                            },{drag: function(event, ui){
                                    lineAllign();
                            }
                            });

                        }
                        document.getElementById("grid8").onchange=function() {
                            $('.draggable8A').css('top', difference+'px');
                            $('.draggable8B').css('top', difference+'px');
                            var tempdotAY = $('#dotA8').offset().top;
                            var tempdotBY = $('#dotB8').offset().top;
                            var tempDifference = Math.abs(tempdotAY - tempdotBY);
                            $('.draggable8B').css('top', (difference-tempDifference)+'px');
                            lineAllign();
                            var className = ".draggable8";
                            //this.value refers to the 8
                            var number = difference/this.value;
                            $(className).draggable({
                                axis: "y",
                                containment: ".box", 
                                scroll: false,
                                grid: [number,number],
                                distance: 0,

                            },{drag: function(event, ui){
                                    lineAllign();
                            }
                            });

                        }
                        
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
                calculateValue();
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
              grid: [difference/8,difference/8],
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
            
            function calculateValue(){
                
                var sum = parseInt(document.getElementById("currentValue").textContent);
                //var positionOfDot ;
                for(i = 1; i<=boxCount; i++){
                    // i can obtain the position of the dots for each columns respective to their grids here
                    // dot B is the green dot.
                    //console.log($('#dotB1').offset().top + " dotB green dot");
                    //console.log($('#canvasBottom').offset().top +" canvas bottom");
                    //temp difference is the absolute double difference between the position of dotAi and dotBi 
                    var tempDifference = Math.abs($('#dotA'+i).offset().top - $('#dotB'+i).offset().top);
                    
                    
                    var blueDot = '#dotA' + i;
                    var greenDot = '#dotB' + i;
                    var gridValue = document.getElementById("grid"+i);
                    var times = parseInt(gridValue.options[gridValue.selectedIndex].value);
                   // console.log(times);
                    if($('#dotA'+i).offset().top > $('#dotB'+i).offset().top && tempDifference > 10){
                        sum += parseInt(document.getElementById("value"+i).textContent)*Math.ceil(tempDifference/(Math.ceil(difference)/times));
                      
                    }else if(tempDifference > 10){
                        sum -= parseInt(document.getElementById("value"+i).textContent)*Math.ceil(tempDifference/(Math.ceil(difference)/times));
                    }
                    // here is for the current position of the dot from 0 - GridValue
                    // still only green2
                     //positionOfDot = Math.ceil(awayFromBottomGreen1/(Math.ceil(canvasHeight)/times));
                     var awayFromBottomBlue1 = Math.abs($('#dotA'+1).offset().top - bottomOfCanvas ) ;
                    var awayFromBottomGreen1 = Math.abs($('#dotB'+1).offset().top - bottomOfCanvas ) ;
                    var awayFromBottomBlue2 = Math.abs($('#dotA'+2).offset().top - bottomOfCanvas ) ;
                    var awayFromBottomGreen2 = Math.abs($('#dotB' + 2).offset().top - bottomOfCanvas);
                    positionOfGreenDot1 = Math.ceil(awayFromBottomGreen1 / (Math.ceil(canvasHeight - 15) / times));
                    positionOfBlueDot1 = Math.ceil(awayFromBottomBlue1 / (Math.ceil(canvasHeight - 15) / times));
                    positionOfGreenDot2 = Math.ceil(awayFromBottomGreen2 / (Math.ceil(canvasHeight - 15) / times));
                    positionOfBlueDot2 = Math.ceil(awayFromBottomBlue2 / (Math.ceil(canvasHeight - 15) / times));
                    document.getElementById("greenDot1").innerHTML = positionOfGreenDot1;
                    document.getElementById("blueDot1").innerHTML = positionOfBlueDot1;
                    document.getElementById("greenDot2").innerHTML = positionOfGreenDot2;
                    document.getElementById("blueDot2").innerHTML = positionOfBlueDot2;
                   // console.log("Box Count : "+boxCount);
                   if(boxCount == 3){
                  
                        var awayFromBottomBlue = Math.abs($('#dotA3').offset().top - bottomOfCanvas ) ;
                        var awayFromBottomGreen = Math.abs($('#dotB3').offset().top - bottomOfCanvas ) ; 
                       // console.log(awayFromBottomGreen);
                        positionOfGreenDot = Math.ceil(awayFromBottomGreen / (Math.ceil(canvasHeight - 15) / times));
                        positionOfBlueDot = Math.ceil(awayFromBottomBlue / (Math.ceil(canvasHeight - 15) / times));
                        console.log(positionOfBlueDot);
                        document.getElementById("greenDot3").innerHTML = positionOfGreenDot;
                        document.getElementById("blueDot3").innerHTML = positionOfBlueDot;
                    }else if(boxCount == 4){
                        var awayFromBottomBlue = Math.abs($('#dotA3').offset().top - bottomOfCanvas ) ;
                        var awayFromBottomGreen = Math.abs($('#dotB3').offset().top - bottomOfCanvas ) ; 
                        positionOfGreenDot = Math.ceil(awayFromBottomGreen / (Math.ceil(canvasHeight - 15) / times));
                        positionOfBlueDot = Math.ceil(awayFromBottomBlue / (Math.ceil(canvasHeight - 15) / times));
                        console.log(positionOfBlueDot);
                        document.getElementById("greenDot3").innerHTML = positionOfGreenDot;
                        document.getElementById("blueDot3").innerHTML = positionOfBlueDot;
                        //4
                        var awayFromBottomBlue = Math.abs($('#dotA4').offset().top - bottomOfCanvas ) ;
                        var awayFromBottomGreen = Math.abs($('#dotB4').offset().top - bottomOfCanvas ) ; 
                        positionOfGreenDot = Math.ceil(awayFromBottomGreen / (Math.ceil(canvasHeight - 15) / times));
                        positionOfBlueDot = Math.ceil(awayFromBottomBlue / (Math.ceil(canvasHeight - 15) / times));
                        console.log(positionOfBlueDot);
                        document.getElementById("greenDot4").innerHTML = positionOfGreenDot;
                        document.getElementById("blueDot4").innerHTML = positionOfBlueDot;
                    }else if (boxCount == 5){
                        //3
                        var awayFromBottomBlue = Math.abs($('#dotA3').offset().top - bottomOfCanvas ) ;
                        var awayFromBottomGreen = Math.abs($('#dotB3').offset().top - bottomOfCanvas ) ; 
                        positionOfGreenDot = Math.ceil(awayFromBottomGreen / (Math.ceil(canvasHeight - 15) / times));
                        positionOfBlueDot = Math.ceil(awayFromBottomBlue / (Math.ceil(canvasHeight - 15) / times));
                        console.log(positionOfBlueDot);
                        document.getElementById("greenDot3").innerHTML = positionOfGreenDot;
                        document.getElementById("blueDot3").innerHTML = positionOfBlueDot;
                        //4
                        var awayFromBottomBlue = Math.abs($('#dotA4').offset().top - bottomOfCanvas ) ;
                        var awayFromBottomGreen = Math.abs($('#dotB4').offset().top - bottomOfCanvas ) ; 
                        positionOfGreenDot = Math.ceil(awayFromBottomGreen / (Math.ceil(canvasHeight - 15) / times));
                        positionOfBlueDot = Math.ceil(awayFromBottomBlue / (Math.ceil(canvasHeight - 15) / times));
                        console.log(positionOfBlueDot);
                        document.getElementById("greenDot4").innerHTML = positionOfGreenDot;
                        document.getElementById("blueDot4").innerHTML = positionOfBlueDot;
                        //5
                        var awayFromBottomBlue = Math.abs($('#dotA5').offset().top - bottomOfCanvas ) ;
                        var awayFromBottomGreen = Math.abs($('#dotB5').offset().top - bottomOfCanvas ) ; 
                        positionOfGreenDot = Math.ceil(awayFromBottomGreen / (Math.ceil(canvasHeight - 15) / times));
                        positionOfBlueDot = Math.ceil(awayFromBottomBlue / (Math.ceil(canvasHeight - 15) / times));
                        console.log(positionOfBlueDot);
                        document.getElementById("greenDot5").innerHTML = positionOfGreenDot;
                        document.getElementById("blueDot5").innerHTML = positionOfBlueDot;
                    }else if (boxCount == 6){
                        //3
                        var awayFromBottomBlue = Math.abs($('#dotA3').offset().top - bottomOfCanvas ) ;
                        var awayFromBottomGreen = Math.abs($('#dotB3').offset().top - bottomOfCanvas ) ; 
                        positionOfGreenDot = Math.ceil(awayFromBottomGreen / (Math.ceil(canvasHeight - 15) / times));
                        positionOfBlueDot = Math.ceil(awayFromBottomBlue / (Math.ceil(canvasHeight - 15) / times));
                        console.log(positionOfBlueDot);
                        document.getElementById("greenDot3").innerHTML = positionOfGreenDot;
                        document.getElementById("blueDot3").innerHTML = positionOfBlueDot;
                        //4
                        var awayFromBottomBlue = Math.abs($('#dotA4').offset().top - bottomOfCanvas ) ;
                        var awayFromBottomGreen = Math.abs($('#dotB4').offset().top - bottomOfCanvas ) ; 
                        positionOfGreenDot = Math.ceil(awayFromBottomGreen / (Math.ceil(canvasHeight - 15) / times));
                        positionOfBlueDot = Math.ceil(awayFromBottomBlue / (Math.ceil(canvasHeight - 15) / times));
                        console.log(positionOfBlueDot);
                        document.getElementById("greenDot4").innerHTML = positionOfGreenDot;
                        document.getElementById("blueDot4").innerHTML = positionOfBlueDot;
                        //5
                        var awayFromBottomBlue = Math.abs($('#dotA5').offset().top - bottomOfCanvas ) ;
                        var awayFromBottomGreen = Math.abs($('#dotB5').offset().top - bottomOfCanvas ) ; 
                        positionOfGreenDot = Math.ceil(awayFromBottomGreen / (Math.ceil(canvasHeight - 15) / times));
                        positionOfBlueDot = Math.ceil(awayFromBottomBlue / (Math.ceil(canvasHeight - 15) / times));
                        console.log(positionOfBlueDot);
                        document.getElementById("greenDot5").innerHTML = positionOfGreenDot;
                        document.getElementById("blueDot5").innerHTML = positionOfBlueDot;
                        //6
                        var awayFromBottomBlue = Math.abs($('#dotA6').offset().top - bottomOfCanvas ) ;
                        var awayFromBottomGreen = Math.abs($('#dotB6').offset().top - bottomOfCanvas ) ; 
                        positionOfGreenDot = Math.ceil(awayFromBottomGreen / (Math.ceil(canvasHeight - 15) / times));
                        positionOfBlueDot = Math.ceil(awayFromBottomBlue / (Math.ceil(canvasHeight - 15) / times));
                        console.log(positionOfBlueDot);
                        document.getElementById("greenDot6").innerHTML = positionOfGreenDot;
                        document.getElementById("blueDot6").innerHTML = positionOfBlueDot;
                    }else if (boxCount == 7){
                        //3
                        var awayFromBottomBlue = Math.abs($('#dotA3').offset().top - bottomOfCanvas ) ;
                        var awayFromBottomGreen = Math.abs($('#dotB3').offset().top - bottomOfCanvas ) ; 
                        positionOfGreenDot = Math.ceil(awayFromBottomGreen / (Math.ceil(canvasHeight - 15) / times));
                        positionOfBlueDot = Math.ceil(awayFromBottomBlue / (Math.ceil(canvasHeight - 15) / times));
                        console.log(positionOfBlueDot);
                        document.getElementById("greenDot3").innerHTML = positionOfGreenDot;
                        document.getElementById("blueDot3").innerHTML = positionOfBlueDot;
                        //4
                        var awayFromBottomBlue = Math.abs($('#dotA4').offset().top - bottomOfCanvas ) ;
                        var awayFromBottomGreen = Math.abs($('#dotB4').offset().top - bottomOfCanvas ) ; 
                        positionOfGreenDot = Math.ceil(awayFromBottomGreen / (Math.ceil(canvasHeight - 15) / times));
                        positionOfBlueDot = Math.ceil(awayFromBottomBlue / (Math.ceil(canvasHeight - 15) / times));
                        console.log(positionOfBlueDot);
                        document.getElementById("greenDot4").innerHTML = positionOfGreenDot;
                        document.getElementById("blueDot4").innerHTML = positionOfBlueDot;
                        //5
                        var awayFromBottomBlue = Math.abs($('#dotA5').offset().top - bottomOfCanvas ) ;
                        var awayFromBottomGreen = Math.abs($('#dotB5').offset().top - bottomOfCanvas ) ; 
                        positionOfGreenDot = Math.ceil(awayFromBottomGreen / (Math.ceil(canvasHeight - 15) / times));
                        positionOfBlueDot = Math.ceil(awayFromBottomBlue / (Math.ceil(canvasHeight - 15) / times));
                        console.log(positionOfBlueDot);
                        document.getElementById("greenDot5").innerHTML = positionOfGreenDot;
                        document.getElementById("blueDot5").innerHTML = positionOfBlueDot;
                        //6
                        var awayFromBottomBlue = Math.abs($('#dotA6').offset().top - bottomOfCanvas ) ;
                        var awayFromBottomGreen = Math.abs($('#dotB6').offset().top - bottomOfCanvas ) ; 
                        positionOfGreenDot = Math.ceil(awayFromBottomGreen / (Math.ceil(canvasHeight - 15) / times));
                        positionOfBlueDot = Math.ceil(awayFromBottomBlue / (Math.ceil(canvasHeight - 15) / times));
                        console.log(positionOfBlueDot);
                        document.getElementById("greenDot6").innerHTML = positionOfGreenDot;
                        document.getElementById("blueDot6").innerHTML = positionOfBlueDot;
                        //7
                        var awayFromBottomBlue = Math.abs($('#dotA7').offset().top - bottomOfCanvas ) ;
                        var awayFromBottomGreen = Math.abs($('#dotB7').offset().top - bottomOfCanvas ) ; 
                        positionOfGreenDot = Math.ceil(awayFromBottomGreen / (Math.ceil(canvasHeight - 15) / times));
                        positionOfBlueDot = Math.ceil(awayFromBottomBlue / (Math.ceil(canvasHeight - 15) / times));
                        console.log(positionOfBlueDot);
                        document.getElementById("greenDot7").innerHTML = positionOfGreenDot;
                        document.getElementById("blueDot7").innerHTML = positionOfBlueDot;
                    }else if (boxCount == 8){
                        //3
                        var awayFromBottomBlue = Math.abs($('#dotA3').offset().top - bottomOfCanvas ) ;
                        var awayFromBottomGreen = Math.abs($('#dotB3').offset().top - bottomOfCanvas ) ; 
                        positionOfGreenDot = Math.ceil(awayFromBottomGreen / (Math.ceil(canvasHeight - 15) / times));
                        positionOfBlueDot = Math.ceil(awayFromBottomBlue / (Math.ceil(canvasHeight - 15) / times));
                        console.log(positionOfBlueDot);
                        document.getElementById("greenDot3").innerHTML = positionOfGreenDot;
                        document.getElementById("blueDot3").innerHTML = positionOfBlueDot;
                        //4
                        var awayFromBottomBlue = Math.abs($('#dotA4').offset().top - bottomOfCanvas ) ;
                        var awayFromBottomGreen = Math.abs($('#dotB4').offset().top - bottomOfCanvas ) ; 
                        positionOfGreenDot = Math.ceil(awayFromBottomGreen / (Math.ceil(canvasHeight - 15) / times));
                        positionOfBlueDot = Math.ceil(awayFromBottomBlue / (Math.ceil(canvasHeight - 15) / times));
                        console.log(positionOfBlueDot);
                        document.getElementById("greenDot4").innerHTML = positionOfGreenDot;
                        document.getElementById("blueDot4").innerHTML = positionOfBlueDot;
                        //5
                        var awayFromBottomBlue = Math.abs($('#dotA5').offset().top - bottomOfCanvas ) ;
                        var awayFromBottomGreen = Math.abs($('#dotB5').offset().top - bottomOfCanvas ) ; 
                        positionOfGreenDot = Math.ceil(awayFromBottomGreen / (Math.ceil(canvasHeight - 15) / times));
                        positionOfBlueDot = Math.ceil(awayFromBottomBlue / (Math.ceil(canvasHeight - 15) / times));
                        console.log(positionOfBlueDot);
                        document.getElementById("greenDot5").innerHTML = positionOfGreenDot;
                        document.getElementById("blueDot5").innerHTML = positionOfBlueDot;
                        //6
                        var awayFromBottomBlue = Math.abs($('#dotA6').offset().top - bottomOfCanvas ) ;
                        var awayFromBottomGreen = Math.abs($('#dotB6').offset().top - bottomOfCanvas ) ; 
                        positionOfGreenDot = Math.ceil(awayFromBottomGreen / (Math.ceil(canvasHeight - 15) / times));
                        positionOfBlueDot = Math.ceil(awayFromBottomBlue / (Math.ceil(canvasHeight - 15) / times));
                        console.log(positionOfBlueDot);
                        document.getElementById("greenDot6").innerHTML = positionOfGreenDot;
                        document.getElementById("blueDot6").innerHTML = positionOfBlueDot;
                        //7
                        var awayFromBottomBlue = Math.abs($('#dotA7').offset().top - bottomOfCanvas ) ;
                        var awayFromBottomGreen = Math.abs($('#dotB7').offset().top - bottomOfCanvas ) ; 
                        positionOfGreenDot = Math.ceil(awayFromBottomGreen / (Math.ceil(canvasHeight - 15) / times));
                        positionOfBlueDot = Math.ceil(awayFromBottomBlue / (Math.ceil(canvasHeight - 15) / times));
                        console.log(positionOfBlueDot);
                        document.getElementById("greenDot7").innerHTML = positionOfGreenDot;
                        document.getElementById("blueDot7").innerHTML = positionOfBlueDot;
                        //8
                        var awayFromBottomBlue = Math.abs($('#dotA8').offset().top - bottomOfCanvas ) ;
                        var awayFromBottomGreen = Math.abs($('#dotB8').offset().top - bottomOfCanvas ) ; 
                        positionOfGreenDot = Math.ceil(awayFromBottomGreen / (Math.ceil(canvasHeight - 15) / times));
                        positionOfBlueDot = Math.ceil(awayFromBottomBlue / (Math.ceil(canvasHeight - 15) / times));
                        console.log(positionOfBlueDot);
                        document.getElementById("greenDot8").innerHTML = positionOfGreenDot;
                        document.getElementById("blueDot8").innerHTML = positionOfBlueDot;
                    }
                    
                
                }
                document.getElementById("newValue").textContent = sum;
                
                          
               
                             
                               
                               
                       
            }
            

                
                    document.getElementById('indicationCheck').onclick = function() {
                        // access properties using this keyword
                        if ( this.checked ) {
                            var first = 0;
                            var second = 0;
                            var third = 0;
                            var forth = 0;

                            for(j=5;j>0;j--){
                                for(i = 1; i <= boxCount; i++){
                                    var weightBox = document.getElementById("weight"+i);
                                    var weight = parseInt(weightBox.options[weightBox.selectedIndex].value);
                                    if (weight == j && first == 0 || first == weight){
                                        first = weight;
                                        document.getElementById("indication"+i).textContent = "1ST";
                                    }else if(weight == j && second == 0 || second == weight){
                                        second = weight;
                                        document.getElementById("indication"+i).textContent = "2ND";
                                    }else if(weight == j && third == 0 || third == weight){
                                        third = weight;
                                        document.getElementById("indication"+i).textContent = "3RD";
                                    }else if(weight == j && forth == 0 || forth == weight){
                                        forth = weight;
                                        document.getElementById("indication"+i).textContent = "4TH";
                                    }else{
                                        document.getElementById("indication"+i).textContent = "5TH";
                                    }

                                }
                            }

                        } else {
                            for(i = 1; i <= boxCount; i++){
                                document.getElementById("indication"+i).textContent = "";
                            }
                        }
                    };
            
            function removeIndication(){
                document.getElementById("indicationCheck").checked = false;
                for(i = 1; i <= boxCount; i++){
                    document.getElementById("indication"+i).textContent = "";
                }
            }
            function spanActivate(){
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
                
                var title = document.getElementsByClassName("projectTitle");

                for(i=0; i<title.length; i++) {
                    title[i].onclick = function(event) {
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
                            input.value = 'TITLE REQUIRED!';
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

                //calculate
                var valueElement = document.getElementsByClassName("factorValue");

                for(i=0; i<valueElement.length; i++) {
                    valueElement[i].onclick = function(event) {
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
                        if(input.value == "" || input.value == null || input.value != parseInt(input.value, 10)){
                            input.value = '0';
                        }else{
                            input.value = Math.abs(parseInt(input.value, 10));
                        }
                        span.parentNode.removeChild(input);

                        // Update the span
                        span.innerHTML = input.value;

                        // Show the span again
                        span.style.display = "";
                        calculateValue();
                      };
                    }
                  };
                }
            }
            
            

            spanActivate();
                    $('.draggable1A').css('top', difference+'px');
                    $('.draggable1B').css('top', difference+'px');
                    var tempdotAY = $('#dotA1').offset().top;
                    var tempdotBY = $('#dotB1').offset().top;
                    var tempDifference = Math.abs(tempdotAY - tempdotBY);
                    $('.draggable1B').css('top', (difference-tempDifference)+'px');
                    lineAllign();
            //change grid
                document.getElementById("grid1").onchange=function() {
                    $('.draggable1A').css('top', difference+'px');
                    $('.draggable1B').css('top', difference+'px');
                    var tempdotAY = $('#dotA1').offset().top;
                    var tempdotBY = $('#dotB1').offset().top;
                    var tempDifference = Math.abs(tempdotAY - tempdotBY);
                    $('.draggable1B').css('top', (difference-tempDifference)+'px');
                    lineAllign();
                    var className = ".draggable1";
                    $('.draggable1').offset().top = dotAY;
                    var number = difference/this.value;
                    $(className).draggable({
                        axis: "y",
                        containment: ".box", 
                        scroll: false,
                        grid: [number,number],
                        distance: 0,
    
                    },{drag: function(event, ui){
                            lineAllign();
                    }
                    });
                              
                  }
                  $('.draggable2A').css('top', difference+'px');
                  $('.draggable2B').css('top', difference+'px');
                  var tempdotAY = $('#dotA2').offset().top;
                  var tempdotBY = $('#dotB2').offset().top;
                  var tempDifference = Math.abs(tempdotAY - tempdotBY);
                  $('.draggable2B').css('top', (difference-tempDifference)+'px');
                  lineAllign();
                  
                  $('.weight').change(function() {
                     removeIndication();
                  });
                document.getElementById("grid2").onchange=function() {
                    $('.draggable2A').css('top', difference+'px');
                    $('.draggable2B').css('top', difference+'px');
                    var tempdotAY = $('#dotA2').offset().top;
                    var tempdotBY = $('#dotB2').offset().top;
                    var tempDifference = Math.abs(tempdotAY - tempdotBY);
                    $('.draggable2B').css('top', (difference-tempDifference)+'px');
                    lineAllign();
                    var className = ".draggable2";
                    var number = difference/this.value;
                    $(className).draggable({
                        axis: "y",
                        containment: ".box", 
                        scroll: false,
                        grid: [number,number],
                        distance: 0,
    
                    },{drag: function(event, ui){
                            lineAllign();
                    }
                    });
                              
                  }
                  
                $('#save').onclick = function(event){
                   var request;
                   var url = '/BusinessModelPlanner/BOSCParser';// the url that i want to get my information from
                   // the tool to connect to the browser
                   
                    if (window.XMLHttpRequest) {
                        request = new XMLHttpRequest();
                    }
                    else if (window.ActiveXObject) {
                        request = new ActiveXObject("Microsoft.XMLHTTP");
                    }
                    // lets try to put some information from the canvas to the console
                    var currentWeight = document.getElementById('weight1').innerHTML;
                    // i create a data array to follow json convention, inside this array contains objects
                     var data = [
                         {
                            "weight" : currentWeight
                         }   
                     
                        
                        
                     ];
                    // display the value in console first
                    console.log(curentWeight);// not sure if this works
                    // i want to send data to my servlet so that servlet can extract out the values, and put inside db
                    // i think i need to use POST.
                    // the URL would specify which page i am posting to i suppose
                    try {
                        //send the information to URL.
                        request.open("POST", url, true);
                        // onreadystatechange invokes the specified function when the server respond.
                        request.onreadystatechange = successSaveFunction;
                        request.send(null);
                    } catch (e) {
                        console.log("Unable to connect to server when trying to save");
                        alert("Unable to connect to save. Please contact system administrator.");
                    }
                };
                      /*  click(function(event){ 
                     var savedFactors = [];
                     var savedGrids = [] ;
                     var dotA = [];
                     var dotB = [];
                     var projectName = document.getElementById('projectTitle').innerHTML;
                     var savedWeight = [];
                     var per_unit_value = [];
                     var max_value = document.getElementById('currentValue');
                     for(i = 1 ; i <= boxCount ; i ++){
                         var factor = document.getElementById('factor'+ i ).innerHTML;
                         // save the factors in an ascending order, but now i only have the ID, i need value.
                         savedFactors.push(factor);
                         var grid = document.getElementById("grid"+i).innerHTML;
                         savedGrids.push(grid);
                         // i cannot get values off these dots. i need offset.
                         //tempdotAY = $('#dotA1').offset().top;
                         var currentDotA = $('#dotA'+i).offset().top;
                         dotA.push(currentDotA);
                         var CurrentDotB = $('#dotB'+i).offset().top;
                         dotB.push(CurrentDotB);
                         var currentWeight = document.getElementById('weight'+i).innerHTML;
                         savedWeight.push(currentWeight);
                         var currentPerUnitValue = document.getElementById('value'+i).innerHTML;
                         per_unit_value.push(currentPerUnitValue);
                     }
                     $.ajax({
                        url:'/BusinessModelPlanner/BOSSaveManager',
                        type: "POST",
                        dataType: "json",
                        contentType : 'application/json',
                        cache : false,
                        processData: false,
                        mimeType: 'application/json',
                        data:{
                            savedFactors: savedFactors, 
                            savedGrids : savedGrids, 
                            dotA : dotA, 
                            dotaB: dotB, 
                            projectName: projectName,
                            weight:savedWeight,
                            per_unit_value: per_unit_value,
                            max_value : max_value,
                        },
                         success: function(data){
                                alert(data);
                            },
                            error: function(){
                                alert("error");
                            }           
                     });
                 });*/
                 // i need a method to obtain the values of each dot, based on the grid, the difference in offset
                 // from top to bottom of the canvas, i am able to
                 //  calculate the range of the values associated with the grid points.
                 // the current behavior of the canvas?
                 // only when grid is set to 8, the curve is at the highest point.
                 //when grid is set to 
                var request;
                function sendInfo()
                {
                    var v = document.vinform.t1.value;
                    var url = "BOSC.jsp";

                    if (window.XMLHttpRequest) {
                        request = new XMLHttpRequest();
                    }
                    else if (window.ActiveXObject) {
                        request = new ActiveXObject("Microsoft.XMLHTTP");
                    }

                    try {
                        request.onreadystatechange = getInfo;
                        //go to the url to get the informa
                        request.open("POST", url, true);
                        request.send();
                    } catch (e) {
                        console.log("Unable to connect to server");
                        alert("Unable to connect to server");
                    }
                }

                function getInfo() {
                    if (request.readyState == 4) {
                        var val = request.responseText;
                        document.getElementById('projectTitle').innerHTML = val;
                    }
                }
                function successSaveFunction(){
                     if (request.readyState == 4) {
                         alert("Canvas has been saved");
                     }
                    
                }
            
           
           
            
          });
         
          
         