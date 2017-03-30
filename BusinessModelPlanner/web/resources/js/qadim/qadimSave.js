/*
 * This is the script for save functionality, i use ajax.getElementByID(the element ID), and get its inner html 
 * after which, the data should be parsed to a servlet.The servlet handles changes the json into normal objects
 * The parser servlet will then pass the data to the qadimdao.validations required.-- >
 */

$('#QaDIMSave').click(function parse() {
    var saveQADIMProjectName = document.getElementById("curProjectName").innerHTML;
    //Get Operators Name and Comments
    var opName1 = document.getElementById("opOneName").innerHTML;
    var opComment1 = document.getElementById("opOneComment").innerHTML;
    
    var opName2 = document.getElementById("opTwoName").innerHTML;
    var opComment2 = document.getElementById("opTwoComment").innerHTML;
    
    var opName3 = document.getElementById("opThreeName").innerHTML;
    var opComment3 = document.getElementById("opThreeComment").innerHTML;
    
    var opName4 = document.getElementById("opFourName").innerHTML;
    var opComment4 = document.getElementById("opFourComment").innerHTML;
    
    var opName5 = document.getElementById("opFiveName").innerHTML;
    var opComment5 = document.getElementById("opFiveComment").innerHTML;
    
    var opName6 = document.getElementById("opSixName").innerHTML;
    var opComment6 = document.getElementById("opSixComment").innerHTML;
    
    var opName7 = document.getElementById("opSevenName").innerHTML;
    var opComment7 = document.getElementById("opSevenComment").innerHTML;
    
    var opName8 = document.getElementById("opEightName").innerHTML;
    var opComment8 = document.getElementById("opEightComment").innerHTML;
    
    //Get Operator Comments
    
    $.ajax
            (
                    {
                        //testing using console log
                        //console.log(saveQADIMProjectName);
                        url: 'QADIMParser',
                        data: {
                            saveQADIMProjectName: saveQADIMProjectName,
                            opName1: opName1,
                            opComment1: opComment1,
                            
                            opName2: opName2,
                            opComment2: opComment2,
                            
                            opName3: opName3,
                            opComment3: opComment3,
                            
                            opName4: opName4,
                            opComment4: opComment4,
                            
                            opName5: opName5,
                            opComment5: opComment5,
                            
                            opName6: opName6,
                            opComment6: opComment6,
                            
                            opName7: opName7,
                            opComment7: opComment7,
                            
                            opName8: opName8,
                            opComment8: opComment8
                        },
                        type: 'GET',
                        cache: false,
                        success: function () {
                            alert(saveQADIMProjectName);
                        },
                        error: function () {
                            alert('You have an existing project with the same title! Use a different project title');
                        }
                    }
            );
});