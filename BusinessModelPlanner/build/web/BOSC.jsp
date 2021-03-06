
<%@page import="java.util.ArrayList"%>
<%@page import="com.app.model.BOSDAO"%>
<%@page import="com.app.model.entity.BOSProduct"%>
<%@page import="com.app.model.entity.Demographics"%>
<%@page import="com.app.model.entity.BOSOperator"%>
<script>
    var lines =[];
    var boxCount = 2;
    var linesCount = 2;
    var globalLineAllign = 10;
    </script>
<!DOCTYPE html>
<html lang="en">
    <%@include file="header.jsp"%>
    <!-- BOSC CSS -->
    <link href="resources/css/BOSC.css" rel="stylesheet" />
<%    
    String error = (String) request.getAttribute("errorMsg");
    String projectName = "Enter Project Name";
    int currentValue = 0;
    if(session.getAttribute("BOSCNewProject") == null){
        session.setAttribute( "BOSCNewProject", "true" );
    }
    ArrayList<String> operator1 = new ArrayList<String>();
    ArrayList<String> operator2 = new ArrayList<String>();
    ArrayList<String> operator3 = new ArrayList<String>();
    ArrayList<String> operator4 = new ArrayList<String>();
    String factor1Name = "Factor 1";
    String factor2Name = "Factor 2";
    ArrayList<BOSOperator> operatorList =  null;
    if(session.getAttribute("operatorList") != null){
    operatorList = (ArrayList<BOSOperator>) session.getAttribute("operatorList");
        projectName = operatorList.get(0).getProjectName();
        currentValue = (Integer) session.getAttribute("currentValue");
        factor1Name = operatorList.get(0).getFactorName();
        factor2Name = operatorList.get(1).getFactorName();
    }
    %>
            <section>
            <div class="container">	
                <div class="tooltipcontent">
                    <div class="dummy dummy-text">
                        <span class="tooltip-item" style="font-size:1.8em">BLUE OCEAN STRATEGIC CANVAS</span><br>
                        Simha Innovation's Blue Ocean Strategy Canvas differs from all existing implementations of the Strategy Canvas as it enables users to 
input price points across all factors and display real time calculations of the budget required to achieve the new value curve.
The weights options allows users to determine the most important factor that should be implemented first.
The grid allows users to determine the number of increments or decrements for each factor.
Firstly, determine how many operators are required for your value curve. 

Edit the names of the factors by simply clicking on its label.
Next, enter the number of grids and the increment/decrement cost or savings
Drag the blue(original) curve to depict the current value curve.
Enter the total cost of the implementation of the blue curve.
Finally, you can edit your green(new) curve and see the budget required for your implementation.
You may save your current progress and load it out in the future, alternatively, you may download your implementations onto an
Excel Spreadsheet for offline usage.
                    </div>
                </div>    

            </div>
        </section>
    <%
    if((String)session.getAttribute("BOSCNewProject") == "true"){
    
    %>
       <section class="for-full-back color-white bodyStart" id="about-models">
            <div class="container">
                <div class="row text-center g-pad-bottom">
                    <div class="col-md-8 col-md-offset-2 ">
                        <form method="GET" name="BOSCNewButton" action="BOSCPageUpdate">
                                <input type="hidden" name="newProject" id="newProject" value="false"/>
                                <input class="newProjectButton" type="submit" value="CREATE NEW PROJECT"/>
                        </form>
                       <br/>
                        <%
                                Demographics user = (Demographics)request.getSession().getAttribute("user");
                                String username = user.getUserid();
                                ArrayList<BOSProduct> userProjectList = BOSDAO.retrieveAllProjectsByUser(username);
                                if(userProjectList!=null && userProjectList.size()!= 0 ){
                        %>
                    <form action="BOSCPageUpdate" class="loadForm">
                        <table>
                            <tr>
                                <td>
                                     <input class="loadProjectButton" type="submit" value="LOAD"/><br/>
                                </td>
                            <td>
                    <select class="loadProjectValue" name="projectToLoad" required="required">
                        <option value="" selected>Select Project</option>
                        <%for(BOSProduct project :userProjectList){%>
                        <option value="<%=project.getProjectName()%>"><%=project.getProjectName()%></option>
                        <%}%>    
                    </select>
                    </td>
                    </tr>
                        </table>
                    </form>
                    
                                            <%}
                    %>
                    </div>

                </div>

            </div>
        </section>
    <%
        
    }else{
%>
        <!--ABOUT SECTION-->
        <section class="for-full-back color-white bodyStart" id="about-models">
            <div class="container">
                <div class="row text-center g-pad-bottom">
                    <div class="col-md-8 col-md-offset-2 ">
                        <h2><span class="projectTitle" id="projectTitle" contenteditable="true"><%=projectName%></span></h2>
                        <br/>
                        <table style="display:inline;">
                            <tr>
                                <td>
                                    <br/>
                                    <form class="BOSCNewForm" method="GET" name="BOSCNewButton" action="BOSCPageUpdate">
                                            <input type="hidden" name="startNewProject" id="startNewProject" value="false"/>
                                            <input class="fontBlack newLoadProjectButton" type="submit" value="New/Load Project"/>
                                    </form>
                                </td>
                                <td>
                                    <button class="saveProjectButton fontBlack" id="save" type="button" >Save</button><br/>
                                </td>
                            </tr>
                        </table>
                        
                        <br/>
                     <a href="BOSDownload" class="btn btn-sq-sm btn-danger">                                     
                            <i class="fa fa-download fa-2x">
                            </i><br/>DOWNLOAD</a> 
                    </div>

                </div>

            </div>
        </section>
        <!--END ABOUT SECTION-->
        <!-- this is the save function. upon clicking on the save button, the system must obtain all 
        several values.
        1. Project Name
        2. All weights
        3. All grids
        4. All Blue and Green dots
        5. Current Value
        6. New Value
        7. All increment Values
        8. All factor Names
        after obtaining these, the system must send information to database, and display ok alert
        validate that all values goes through to db
        validate that no values are changed
        ajax possibly, to prevent refresh. upon refresh, all values will disappear, need to fix this issue.
        loading will be a bitch, but see how it goes from here
        -->


        <!-- BOSC BODY SECTION-->
        <section>
            <div class="row g-pad-bottom">
                <div class="legendContainer">
                    <div class="topLabel"></div>
                    <div class="legendNames">
                        LEGEND : &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <i class="fa fa-circle dotA"></i> - Original Curve | 
                        <i class="fa fa-circle dotB"></i> - New Curve 
                    </div>
                </div>
                <div class="row">
                    <div id="valuesContainer" class="valuesContainer">
                        <div class="valueContainer">
                            Current Value: 
                            <span class="value original fontBlack" id="currentValue" contenteditable="true"><%=currentValue%></span>
                        </div>
                        <div class="valueContainer">
                            New Value: 
                            <span class="value new fontBlack" id="newValue" contenteditable="false">0</span>
                        </div>
                        <div class="valueContainer">
                            <input id="indicationCheck" type="checkbox"/>Adjust Higher Weight First Indicator
                        </div>
                    </div>

                </div>
                <div class="indicationContainer">
                    <div class="labelTop"></div>
                    <div id="indicationNames" class="indicationNames">
                        <div class="indicationBox">
                            <span class="indication" id="indication1" contenteditable="false"></span><br/>
                        </div>
                        <div class="indicationBox">
                            <span class="indication" id="indication2" contenteditable="false"></span><br/>
                           
                        </div>
                         <%
                        if (operatorList != null){
                            for(int i = 2; i <= operatorList.size()-1; i++){
                            
                            
                         %>
                        <div class="indicationBox">
                            <span class="indication" id="indication<%=i+1%>" contenteditable="false"></span><br/>
                           
                        </div>
                         <%
                            }
                           }
                         %>
                        
                    </div>

                </div>
                <div id="container">
                    <div id="labels">
                        <b><div id="topLabel">High </div>
                            <div id="bottomLabel">Low </div></b>
                    </div>
                    <div id="factors">
            <!--            <ul id="sortable">-->
                            <div id="box1" class="box boxOdd">
                                <div class="draggable draggable1A draggable1 ">
                                  <i id="dotA1" class="fa fa-circle dotA"></i>
                                  <i id="canvasBottom" class="canvasBottom"></i>
                                </div>
                                <div class="draggable draggable1B draggable1 dotBottom">
                                  <i id="dotB1" class="fa fa-circle dotB" ></i>
                                </div>
                            </div>
                            <div id="box2" class="box boxEven">
                                <div class="draggable draggable2 draggable2A">
                                  <i id="dotA2" class="fa fa-circle dotA"></i>
                                </div>
                                <div class="draggable draggable2 draggable2B dotBottom">
                                  <i id="dotB2" class="fa fa-circle dotB"></i>
                                </div>
                            </div>
                                                    <%
                        if (operatorList != null){
                            for(int i = 3; i <= operatorList.size(); i++){
                            if(i%2!=0){
                            
                            %>
                            <div id="box<%=i%>" class="box boxOdd">
                                <div class="draggable draggable<%=i%> draggable<%=i%>A">
                                  <i id="dotA<%=i%>" class="fa fa-circle dotA"></i>
                                </div>
                                <div class="draggable draggable<%=i%> draggable<%=i%>B dotBottom">
                                  <i id="dotB<%=i%>" class="fa fa-circle dotB"></i>
                                </div>
                            </div>
                            <%
                            }else{
                            %>
                            <div id="box<%=i%>" class="box boxEven">
                                <div class="draggable draggable<%=i%> draggable<%=i%>A">
                                  <i id="dotA<%=i%>" class="fa fa-circle dotA"></i>
                                </div>
                                <div class="draggable draggable<%=i%> draggable<%=i%>B dotBottom">
                                  <i id="dotB<%=i%>" class="fa fa-circle dotB"></i>
                                </div>
                            </div>
                            <%
                            }

                                }
                            }
                            %>
            <!--            </ul>-->
                    </div>
                      <button id="addBox"/>

                            <i id="addLogo" class="fa fa-plus addLogo" aria-hidden="true"></i>
                      </div>
                </div>
                <div class="factorContainer">
                    <div class="labelBottom"></div>
                    <div id="factorsNames" class="factorsNames">
                        <div class="factorBox">
                            <span class="factorName" id="factor1" contenteditable="true"><%=factor1Name%></span><br/>
                            Weight: 
                            <select class="weight fontBlack" id="weight1">
                                <option value="1" <%if(operatorList!= null && operatorList.get(0).getWeight()==1){%> selected <%}%> >1</option>
                                <option value="2" <%if(operatorList!= null && operatorList.get(0).getWeight()==2){%> selected <%}%> >2</option>
                                <option value="3" <%if(operatorList!= null && operatorList.get(0).getWeight()==3){%> selected <%}%> >3</option>
                                <option value="4" <%if(operatorList!= null && operatorList.get(0).getWeight()==4){%> selected <%}%> >4</option>
                                <option value="5" <%if(operatorList!= null && operatorList.get(0).getWeight()==5){%> selected <%}%> >5</option>
                            </select><br/>
                            Grid:  
                            <select class="fontBlack" id="grid1">
                                <option value="0" <%if(operatorList!= null && operatorList.get(0).getGrid()==0){%> selected <%}%> >0</option>
                                <option value="1" <%if(operatorList!= null && operatorList.get(0).getGrid()==1){%> selected <%}%> >1</option>
                                <option value="2" <%if(operatorList!= null && operatorList.get(0).getGrid()==2){%> selected <%}%> >2</option>
                                <option value="3" <%if(operatorList!= null && operatorList.get(0).getGrid()==3){%> selected <%}%> >3</option>
                                <option value="4" <%if(operatorList!= null && operatorList.get(0).getGrid()==4){%> selected <%}%> >4</option>
                                <option value="5" <%if(operatorList!= null && operatorList.get(0).getGrid()==5){%> selected <%}%> >5</option>
                                <option value="6" <%if(operatorList!= null && operatorList.get(0).getGrid()==6){%> selected <%}%> >6</option>
                                <option value="7" <%if(operatorList!= null && operatorList.get(0).getGrid()==7){%> selected <%}%> >7</option>
                                <option value="8" <%if(operatorList!= null && operatorList.get(0).getGrid()==0){%> selected <%}else if(operatorList == null){%> selected <%}%>>8</option>
                            </select><br/>
                            Value: 
                            <span class="factorValue fontBlack" id="value1" contenteditable="false"><%if(operatorList!= null){%><%=operatorList.get(0).getPerUnitValue()%><%}else{%>0<%}%></span></br>
                           <span class="GreenDotValue" id="greenDot1" hidden="">0</span><br>
                              <span class="BlueDotValue" id="blueDot1" hidden="">0</span><br>
                        </div>
                        <div class="factorBox">
                            <span class="factorName" id="factor2" contenteditable="true"><%=factor2Name%></span><br/>
                            Weight:
                            <select class="weight fontBlack" id="weight2">
                                <option value="1" <%if(operatorList!= null && operatorList.get(1).getWeight()==1){%> selected <%}%> >1</option>
                                <option value="2" <%if(operatorList!= null && operatorList.get(1).getWeight()==2){%> selected <%}%> >2</option>
                                <option value="3" <%if(operatorList!= null && operatorList.get(1).getWeight()==3){%> selected <%}%> >3</option>
                                <option value="4" <%if(operatorList!= null && operatorList.get(1).getWeight()==4){%> selected <%}%> >4</option>
                                <option value="5" <%if(operatorList!= null && operatorList.get(1).getWeight()==5){%> selected <%}%> >5</option>
                            </select><br/>
                            Grid:  
                            <select class="fontBlack" id="grid2">
                                <option value="0" <%if(operatorList!= null && operatorList.get(1).getGrid()==0){%> selected <%}%> >0</option>
                                <option value="1" <%if(operatorList!= null && operatorList.get(1).getGrid()==1){%> selected <%}%> >1</option>
                                <option value="2" <%if(operatorList!= null && operatorList.get(1).getGrid()==2){%> selected <%}%> >2</option>
                                <option value="3" <%if(operatorList!= null && operatorList.get(1).getGrid()==3){%> selected <%}%> >3</option>
                                <option value="4" <%if(operatorList!= null && operatorList.get(1).getGrid()==4){%> selected <%}%> >4</option>
                                <option value="5" <%if(operatorList!= null && operatorList.get(1).getGrid()==5){%> selected <%}%> >5</option>
                                <option value="6" <%if(operatorList!= null && operatorList.get(1).getGrid()==6){%> selected <%}%> >6</option>
                                <option value="7" <%if(operatorList!= null && operatorList.get(1).getGrid()==7){%> selected <%}%> >7</option>
                                <option value="8" <%if(operatorList!= null && operatorList.get(1).getGrid()==0){%> selected <%}else if(operatorList == null){%> selected <%}%>>8</option>
                            </select><br/>
                            Value: 
                            <span class="factorValue fontBlack" id="value2" contenteditable="false"><%if(operatorList!= null){%><%=operatorList.get(1).getPerUnitValue()%><%}else{%>0<%}%></span><br>
                              <span class="GreenDotValue" id="greenDot2" hidden="" >0</span><br>
                              <span class="BlueDotValue" id="blueDot2" hidden="">0</span><br>
                              <span class="boxCount" id="boxCounter" hidden="true">2</span><br>
                             
                            <!--hidden=""-->
                            
                        </div>
                        <%
                        if (operatorList != null){
                            for(int i = 2; i <= operatorList.size()-1; i++){
                            %>
                            <div class="factorBox">
                            <span class="factorName" id="factor<%=(i+1)%>" contenteditable="true"><%=operatorList.get(i).getFactorName()%></span><br/>
                            Weight:
                            <select class="weight fontBlack" id="weight<%=(i+1)%>">
                                <option value="1" <%if(operatorList!= null && operatorList.get(i).getWeight()==1){%> selected <%}%> >1</option>
                                <option value="2" <%if(operatorList!= null && operatorList.get(i).getWeight()==2){%> selected <%}%> >2</option>
                                <option value="3" <%if(operatorList!= null && operatorList.get(i).getWeight()==3){%> selected <%}%> >3</option>
                                <option value="4" <%if(operatorList!= null && operatorList.get(i).getWeight()==4){%> selected <%}%> >4</option>
                                <option value="5" <%if(operatorList!= null && operatorList.get(i).getWeight()==5){%> selected <%}%> >5</option>
                            </select><br/>
                            Grid:  
                            <select id="grid<%=(i+1)%>">
                                <option value="0" <%if(operatorList!= null && operatorList.get(i).getGrid()==0){%> selected <%}%> >0</option>
                                <option value="1" <%if(operatorList!= null && operatorList.get(i).getGrid()==1){%> selected <%}%> >1</option>
                                <option value="2" <%if(operatorList!= null && operatorList.get(i).getGrid()==2){%> selected <%}%> >2</option>
                                <option value="3" <%if(operatorList!= null && operatorList.get(i).getGrid()==3){%> selected <%}%> >3</option>
                                <option value="4" <%if(operatorList!= null && operatorList.get(i).getGrid()==4){%> selected <%}%> >4</option>
                                <option value="5" <%if(operatorList!= null && operatorList.get(i).getGrid()==5){%> selected <%}%> >5</option>
                                <option value="6" <%if(operatorList!= null && operatorList.get(i).getGrid()==6){%> selected <%}%> >6</option>
                                <option value="7" <%if(operatorList!= null && operatorList.get(i).getGrid()==7){%> selected <%}%> >7</option>
                                <option value="8" <%if(operatorList!= null && operatorList.get(i).getGrid()==0){%> selected <%}else if(operatorList == null){%> selected <%}%>>8</option>
                            </select><br/>
                            Value: 
                            <span class="factorValue" id="value<%=(i+1)%>" contenteditable="false"><%if(operatorList!= null){%><%=operatorList.get(i).getPerUnitValue()%><%}else{%>0<%}%></span><br>
                              <span class="GreenDotValue" id="greenDot<%=(i+1)%>" hidden="" >0</span><br>
                              <span class="BlueDotValue" id="blueDot<%=(i+1)%>" hidden="">0</span><br>

                             
                            <!--hidden=""-->
                            
                        </div>
                              <%
                              if (operatorList != null){
                                  %>
                              
                              <script>
                    var myElement = document.getElementsByClassName("box");
                    
                    for(i=0; i<myElement.length; i++) {
                        myElement[i].style.width = ((100.00/<%=operatorList.size()%>)+"%");
                    }
                    var myElement = document.getElementsByClassName("factorBox");
                    
                    for(i=0; i<myElement.length; i++) {
                        myElement[i].style.width = ((100.00/<%=operatorList.size()%>)+"%");
                    }
                    
                    
                    var myElement = document.getElementsByClassName("indicationBox");
                    
                    for(i=0; i<myElement.length; i++) {
                        myElement[i].style.width = ((100.00/<%=operatorList.size()%>)+"%");
                    }
                                  </script>
                            
                            <%
                              }
                                }
                        }
                        %>
                    </div>

                </div>
            </div>
        </section>
        <%
            
            }
        %>
        <!-- END BOSC BODY SECTION-->

        <!--FOOTER SECTION -->
        
        <!--INCLUDE FOOTER AND JAVASCRIPT -->
            <!-- END FOOTER SECTION -->
    
    <!--STANDARD JS USED ACROSS ALL PAGES-->
    
    <!-- JAVASCRIPT FILES PLACED AT THE BOTTOM TO REDUCE THE LOADING TIME  -->
    <!-- CORE JQUERY  -->
    <script src="resources/js/jquery-1.10.2.js"></script>
    <!-- BOOTSTRAP CORE SCRIPT   -->
    <script src="resources/js/bootstrap.js"></script>
    <!-- SIDE MENU SCRIPTS -->
    <script src="resources/js/modernizr.custom.js"></script>
    <script src="resources/js/classie.js"></script>
    <!-- VEGAS SLIDESHOW SCRIPTS -->
    <script src="resources/js/jquery.vegas.min.js"></script>
    <!-- CUSTOM SCRIPTS -->
    <script src="resources/js/custom.js"></script>
    <!--SCRIPTS FOR AJAX-->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script src="https://code.jquery.com/ui/1.11.2/jquery-ui.min.js"></script>

</body>

        
        <!-- JAVASCRIPT FOR BOSC  -->
        <!-- STRATEGY CANVAS SCRIPTS -->
        <script src="resources/js/strategycanvas.js"></script>
        <!-- UI JQUERY  -->
        <script src="https://code.jquery.com/ui/1.11.2/jquery-ui.min.js"></script>
        
        <!-- END FOOTER SECTION -->
        <!-- BOSC Save and Download script-->
        <script type = text/javascript>
            
            $('#newProject').click( function parse() {
                session.setAttribute("BOSCNewProject","false");
                alert("testing");
            }) ;
            
            $('#startNewProject').click( function parse() {
                session.setAttribute("BOSCNewProject","true");
            }) ;
            
            
            $('#save').click( function parse() {
              var boxCounter = parseInt(document.getElementById('boxCounter').innerHTML);
                var blueDots = [];
                var greenDots = [];
                var factors = [] ;
                var weights = [] ;
                var pricePoints = [] ;
                var grids = [] ;
                var tempGrids;
                var tempBlueDots ;
                var tempGreenDots ;
                var tempFactors ;
                var tempWeights ;
                var tempPricePoints ;
                // temp variables are to store each element by id, to be pushed to arrays.
                // i will iterate through all the columns to get all the values from all columns and save to 
                //their respective arrays. array to be passed back.
                //  i need $.serialize(array);
                // green dots
                //blue dots
                // weights
                // grids
                // price points 
                // factor names
                
                for(k=1; k<=boxCounter; k++) {
                    tempGreenDots = document.getElementById("greenDot"+ k).innerHTML;
                    tempBlueDots = document.getElementById("blueDot"+ k).innerHTML;
                    tempWeights = parseInt(document.getElementById("weight"+ k).options[document.getElementById("weight"+ k).selectedIndex].value);
                    tempGrids = parseInt(document.getElementById("grid"+k).options[document.getElementById("grid"+k).selectedIndex].value);
                    tempPricePoints = document.getElementById("value" + k).innerHTML;
                    tempFactors = document.getElementById("factor"+ k).innerHTML;
                    // push to array
                    blueDots.push(tempBlueDots);
                    greenDots.push(tempGreenDots);
                    factors.push(tempFactors);
                    weights.push(tempWeights);
                    pricePoints.push(tempPricePoints);
                    grids.push(tempGrids);
                    // by now all values should be in the array, can be parsed to jsp page via ajax.
                    // jsp page to capture these values with request.getParameterValues()
                    // the rest of the variables that are not dynamic can be captured with request.getParameter()
                }
                //  i need $.serialize(array);
//                    blueDots =  $.serialize(blueDots);
//                    greenDots = $.serialize(greenDots);
//                    factors = $.serialize(factors);
//                    weights = $.serialize(weights);
//                    pricePoints = $.serialize(pricePoints);
//                    grids = $.serialize(grids);
// i need to var myJSON = JSON.stringify(obj); to convert the whole thing into json string. 
                  var jsonBlueDots =  JSON.stringify(blueDots); 
                  var jsonGreenDots =  JSON.stringify(greenDots); 
                  var jsonFactors =  JSON.stringify(factors); 
                  var jsonWeights =  JSON.stringify(weights); 
                  var jsonPricePoints =  JSON.stringify(pricePoints);
                  var jsonGrids =   JSON.stringify(grids); 
                  
                  
//            if (window.XMLHttpRequest){// code for IE7+, Firefox, Chrome, Opera, Safari
//            
//                xmlhttp=new XMLHttpRequest();
//            }
//            else{// code for IE6, IE5
//            
//                xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
//            }    
         //   xmlhttp.onreadystatechange=function() {
           // if (this.readyState==4 && this.status==200) { 
           // this chunk is mostly irrelevant, i only need project name, current and new value and boxCounter(somewhere above)
                var projectName = document.getElementById("projectTitle").innerHTML;
//                var grid1 = parseInt(document.getElementById("grid1").options[document.getElementById("grid1").selectedIndex].value);
//                var grid2 = parseInt(document.getElementById("grid2").options[document.getElementById("grid2").selectedIndex].value);
//                var weight1 = parseInt(document.getElementById("weight1").options[document.getElementById("weight1").selectedIndex].value);
//                var weight2 = parseInt(document.getElementById("weight2").options[document.getElementById("weight2").selectedIndex].value);
//                var savedGreenDotValue1 = document.getElementById("greenDot1").innerHTML;
//                var savedGreenDotValue2 = document.getElementById("greenDot2").innerHTML;
//                var savedBlueDotValue1 = document.getElementById("blueDot1").innerHTML;
//                var savedBlueDotValue2 = document.getElementById("blueDot2").innerHTML;
               
                var savedCurrent = document.getElementById("currentValue").innerHTML;
                var savedNewValue = document.getElementById("newValue").innerHTML;
//                var savedPricePoint1 = document.getElementById("value1").innerHTML;
//                var savedPricePoint2 = document.getElementById("value2").innerHTML;
//                var savedFactorName1 =  document.getElementById("factor1").innerHTML;
//                var savedFactorName2 =  document.getElementById("factor2").innerHTML;
                $.ajax
                (
                {
                    url:'BOSCParser',
            // only project name, current and new values is fixed number, the rest are dynamic.
                    data:{  
                            boxCounter: boxCounter,
                            projectName: projectName,                            
                            savedCurrent: savedCurrent,
                            savedNewValue: savedNewValue, 
                            blueDots: jsonBlueDots,
                            greenDots: jsonGreenDots,
                            factors: jsonFactors,
                            weights: jsonWeights,
                            pricePoints: jsonPricePoints,
                            grids: jsonGrids
                            
                        },
                    type:'GET',
                    cache:false,
                    success:function(){alert('Canvas saved!');},
                    error:function(){alert('You have an existing project with the same title! Use a different project title');}
                }
                );
                
            //}
      
                
           // }
          //  xmlhttp.open("Post","/BOSCParser",true);
         //   xmlhttp.send();
            
        }) ; 
        </script>
        <script type='text/javascript'>
            var linkLine = $('<div class="line lineA" id="line1A"></div>');
            lines.push(linkLine);
            lines[0].appendTo('body');
            linkLine = $('<div class="line lineB" id="line1B"></div>');
            lines.push(linkLine);
            lines[1].appendTo('body');
            $('.draggable1A').css('top', difference+'px');
            $('.draggable1B').css('top', difference+'px');
            var tempdotAY = $('#dotA1').offset().top;
            var tempdotBY = $('#dotB1').offset().top;
            var tempDifference = Math.abs(tempdotAY - tempdotBY);
            $('.draggable1B').css('top', (difference-tempDifference)+'px');
            $('.draggable2A').css('top', difference+'px');
            $('.draggable2B').css('top', difference+'px');
            var tempdotAY = $('#dotA2').offset().top;
            var tempdotBY = $('#dotB2').offset().top;
            var tempDifference = Math.abs(tempdotAY - tempdotBY);
            $('.draggable2B').css('top', (difference-tempDifference)+'px');
            Element.prototype.globalLineAllign = function(){
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
                  
            };
            
        </script>
            <%if(operatorList!=null){
            int lineNumber = 2;
            %>
            <script type='text/javascript' >
             boxCount = <%=operatorList.size()%>;
             linesCount = <%=((operatorList.size()-1)*2)%>;
           <%
             for(int i = 2; i <= (((operatorList.size()-1)*2)-2); i++){
            %>
            linkLine = $('<div class="line lineA" id="line<%=lineNumber%>A"></div>');
            lines.push(linkLine);
            lines[<%=i++%>].appendTo('body');
            linkLine = $('<div class="line lineB" id="line<%=lineNumber%>B"></div>');
            lines.push(linkLine);
            lines[<%=i%>].appendTo('body');
            
            <%
            lineNumber++;
            }
            for(int i = 0; i<operatorList.size(); i++){
            long grid = operatorList.get(i).getGrid();
            int originalV = operatorList.get(i).getOriginalValue()-1;
            int newV = operatorList.get(i).getNewValue()-1;
            %>      
                    $('.draggable'+<%=i+1%>+'A').css('top', ((difference)-((difference/<%=grid%>)*<%=originalV%>))+'px');
                    $('.draggable'+<%=i+1%>+'B').css('top', ((difference-13)-(difference/<%=grid%>)*<%=newV%>)+'px');
                    
                <%
                
            }
            %>
                    document.getElementById("boxCounter").innerHTML = boxCount;


  
            </script>
            <%
                
            }
            %>
</html>
