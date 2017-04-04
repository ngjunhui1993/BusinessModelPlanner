<%@include file="Protect.jsp"%>
<%@page import="com.app.model.entity.QadimProduct"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.app.model.QaDIMDAO"%>
<%@page import="com.app.model.entity.Demographics"%>
<!DOCTYPE html>
<html ng-app="drag-and-drop">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <!--CSS FOR DRAGGABLE ELEMENTS-->
        <link rel="stylesheet" type="text/css" href="resources/css/qadim/qadimDraggable.css" />
        <!--CSS FOR TOOLTIPS-->
        <link rel="stylesheet" type="text/css" href="resources/css/qadim/qadimTooltip.css" />
        <!--CSS FOR BUTTONS-->
        <link rel="shortcut icon" href="../favicon.ico">
        <link rel="stylesheet" type="text/css" href="resources/css/qadim/qadimButton.css" />
        <script src="resources/js/qadim/qadimmodernizr.custom.js"></script>
        <!--CSS FOR FORM MODAL-->
        <link rel="stylesheet" type="text/css" href="resources/css/qadim/qadimFormModal.css" />
        <!--CSS FOR LOADING PROJECT-->
        <link rel="stylesheet" type="text/css" href="resources/css/qadim/qadim-cs-select.css" />
        <link rel="stylesheet" type="text/css" href="resources/css/qadim/qadim-cs-skin-elastic.css" />
        <!--TEST-->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
    </head>
    <body>
        <%//PROJECT NAME & PRODUCT NAME
            String projectName = (String) request.getSession().getAttribute("projectName");
            String productName = (String) request.getSession().getAttribute("productName");
            //Retrieve Operators and Values from Load
            String opName1 = (String) request.getSession().getAttribute("opName1");
            String opComment1 = (String) request.getSession().getAttribute("opComment1");
            String opName2 = (String) request.getSession().getAttribute("opName2");
            String opComment2 = (String) request.getSession().getAttribute("opComment2");
            String opName3 = (String) request.getSession().getAttribute("opName3");
            String opComment3 = (String) request.getSession().getAttribute("opComment3");
            String opName4 = (String) request.getSession().getAttribute("opName4");
            String opComment4 = (String) request.getSession().getAttribute("opComment4");
            String opName5 = (String) request.getSession().getAttribute("opName5");
            String opComment5 = (String) request.getSession().getAttribute("opComment5");
            String opName6 = (String) request.getSession().getAttribute("opName6");
            String opComment6 = (String) request.getSession().getAttribute("opComment6");
            String opName7 = (String) request.getSession().getAttribute("opName7");
            String opComment7 = (String) request.getSession().getAttribute("opComment7");
            String opName8 = (String) request.getSession().getAttribute("opName8");
            String opComment8 = (String) request.getSession().getAttribute("opComment8");
        %>
        <script>
            <%if (productName != null && !productName.equals("")) {%>
            document.getElementById('curProductName').innerHTML = <%=productName%>;
            <%};%>
            //Retrieve Operators from Load
            //Operator 1
            <%if (opName1 != null && !opName1.equals("")) {%>
            document.getElementById('opName1').innerHTML = <%=opName1%>;
                    document.getElementById('opComment1').innerHTML = <%=opComment1%>;
            <%};%>
            //Operator 2
            <%if (opName2 != null && !opName2.equals("")) {%>

            document.getElementById('opName2').innerHTML = <%=opName2%>;
                    document.getElementById('opComment2').innerHTML = <%=opComment2%>;
            <%};%>
            //Operator 3
            <%if (opName3 != null && !opName3.equals("")) {%>

            document.getElementById('opName3').innerHTML = <%=opName3%>;
                    document.getElementById('opComment3').innerHTML = <%=opComment3%>;
            <%};%>
            //Operator 4
            <%if (opName4 != null && !opName4.equals("")) {%>

            document.getElementById('opName4').innerHTML = <%=opName4%>;
                    document.getElementById('opComment4').innerHTML = <%=opComment4%>;
            <%};%>
            //Operator 5
            <%if (opName5 != null && !opName5.equals("")) {%>

            document.getElementById('opName5').innerHTML = <%=opName5%>;
                    document.getElementById('opComment5').innerHTML = <%=opComment5%>;
            <%};%>
            //Operator 6
            <%if (opName6 != null && !opName6.equals("")) {%>
            document.getElementById('opName6').innerHTML = <%=opName6%>;
                    document.getElementById('opComment6').innerHTML = <%=opComment6%>;
            <%};%>
            //Operator 7
            <%if (opName7 != null && !opName7.equals("")) {%>
            document.getElementById('opName7').innerHTML = <%=opName7%>;
                    document.getElementById('opComment7').innerHTML = <%=opComment7%>;
            <%};%>
            //Operator 8
            <%if (opName8 != null && !opName8.equals("")) {%>
            document.getElementById('opName8').innerHTML = <%=opName8%>;
                    document.getElementById('opComment8').innerHTML = <%=opComment8%>;
            <%};%>
        </script>
        <!--
        CONTENT
        1. EXPLANATION (TOOLTIPS)
        2. QADIM MODEL
        3. SIDE PANEL (PROJECT NAME AND BUTTONS)
        -->
        <!--TOOLTIPS-->
        <div id="maincontent">
            <div class="tooltipcontent">
                <div class="dummy dummy-text">
                    <br><br><br>
                    <span class="tooltip tooltip-effect-3">
                        <span class="tooltip-item" style="font-size:1.8em">QaDIM</span>
                        <span class="tooltip-content clearfix">
                            <span class="tooltip-text" style="padding-left:15px">
                                An innovation framework, also known as the THE QUICK AND DIRTY INNOVATION MODEL.<br>
                            </span></span></span> enable 
                    users to <b><u>identify incremental innovation opportunities</u></b> for 
                    existing or new products or services. The model works on a 3 by 3 framework that allows users to enter desired
                    <span class="tooltip tooltip-effect-3"><span class="tooltip-item">Operators</span> 
                        <span class="tooltip-content clearfix"><span class="tooltip-text" style="padding-left:15px">
                                <strong>Operators</strong> are meaningful verbs or phrases that indicate the incremental innovation opportunities. <br>
                                Drag the operators around and change the operators to any values you desire.<br>

                            </span></span></span> around the product/service. Look out for the 
                    <span class="tooltip tooltip-effect-3">
                        <span class="tooltip-item">Tools</span> 
                        <span class="tooltip-content clearfix">
                            <span class="tooltip-text" style="padding-left:15px">
                                The <strong>Tools</strong> are developed to help you in the following:<br><br>
                                1. <strong>Save</strong> your current project.<br>
                                2. <Strong>Create</strong> a new project or <Strong>load</Strong> previous projects.<br>
                                3. <Strong>Download</Strong> your project in excel format.<br>
                            </span></span></span> on the right to perform more functions. Our model have pre-defined some examples for you to get you started. To change the values, simply click on the operator boxes.<br>
                </div>
            </div>
            <!--END OF TOOLTIPS-->
            <!--
            QADIM MODEL
            - Operators 1 - 8
            - Project Name
            - This section allows users to edit the operators and comments
            -->
            <table>
                <tr><td>
                        <!--PROJECT CONTENT
                        DISPLAY OF OPERATORS
                        EDITING OF OPERATORS MODAL
                        -->
                        <div id="qadimcontent" class="qadimcontent"> 
                            <div ng-controller="oneCtrl as loki">
                                <!--FIRST ROW-->
                                <div class='contentWrapper ng-cloak'>
                                    <ul class="thumbnails">
                                        <!--OPERATOR ONE-->
                                        <li ng-repeat="item in operatorOne" data-drop="true" ng-model='operatorOne' jqyoui-droppable="{index: {{$index}}, onDrop:'loki.dropCallback(item.title, $index)'}">
                                            <div id="operatorOneModalbtn" class="thumbnail" data-toggle="modal" data-target="#operatorOneModal" data-drag="{{item.drag}}" data-jqyoui-options="{revert: 'invalid'}" ng-model="operatorOne" jqyoui-draggable="{index: {{$index}},animate:true}">
                                                <!--OPERATOR ONE DISPLAY-->
                                                <div id="opOneName" class="qadimOperator">{{item.title}}</div><br>
                                                <div id="opOneComment" class="qadimComment">{{item.comment}}</div>
                                            </div>
                                        </li>
                                        <!--OPERATOR TWO-->
                                        <li ng-repeat="item in operatorTwo" data-drop="true" ng-model='operatorTwo' jqyoui-droppable="{index: {{$index}}, onDrop:'loki.dropCallback(item.title, $index)'}">
                                            <div class="thumbnail" data-toggle="modal" data-target="#operatorTwoModal" data-drag="{{item.drag}}" data-jqyoui-options="{revert: 'invalid'}" ng-model="operatorTwo" jqyoui-draggable="{index: {{$index}},animate:true}">
                                                <!--OPERATOR TWO DISPLAY-->
                                                <div id="opTwoName" class="qadimOperator">{{item.title}}</div><br>
                                                <div id="opTwoComment" class="qadimComment">{{item.comment}}</div>
                                            </div>
                                        </li>
                                        <!--OPERATOR THREE-->
                                        <li ng-repeat="item in operatorThree" data-drop="true" ng-model='operatorThree' jqyoui-droppable="{index: {{$index}}, onDrop:'loki.dropCallback(item.title, $index)'}">
                                            <div class="thumbnail" data-toggle="modal" data-target="#operatorThreeModal" data-drag="{{item.drag}}" data-jqyoui-options="{revert: 'invalid'}" ng-model="operatorThree" jqyoui-draggable="{index: {{$index}},animate:true}">
                                                <!--OPERATOR THREE DISPLAY-->
                                               <div id="opThreeName" class="qadimOperator">{{item.title}}</div><br>
                                                <div id="opThreeComment" class="qadimComment">{{item.comment}}</div>
                                            </div>
                                        </li>
                                        <!--OPERATOR FOUR-->
                                        <li ng-repeat="item in operatorFour" data-drop="true" ng-model='operatorFour' jqyoui-droppable="{index: {{$index}}, onDrop:'loki.dropCallback(item.title, $index)'}">
                                            <div class="thumbnail" data-toggle="modal" data-target="#operatorFourModal" data-drag="{{item.drag}}" data-jqyoui-options="{revert: 'invalid'}" ng-model="operatorFour" jqyoui-draggable="{index: {{$index}},animate:true}">
                                                <!--OPERATOR FOUR DISPLAY-->
                                                <div id="opFourName" class="qadimOperator">{{item.title}}</div><br>
                                                <div id="opFourComment" class="qadimComment">{{item.comment}}</div>
                                            </div>
                                        </li>
                                        <!--PRODUCT NAME-->
                                        <li ng-repeat="item in currentProductName" data-drop="false" ng-model='currentProductName' jqyoui-droppable="{index: {{$index}}, onDrop:'loki.dropCallback(item.title, $index)'}">
                                            <div class="thumbnail" data-toggle="modal" data-target="#currentProductNameModal" data-drag="{{item.drag}}" data-jqyoui-options="{revert: 'invalid'}" ng-model="currentProductName" jqyoui-draggable="{index: {{$index}},animate:true}">
                                                <!--PRODUCT NAME DISPLAY-->
                                                <div id="curProductName"class="qadimOperator">{{item.title}}</div><br>
                                            </div>
                                        </li>
                                        <!--OPERATOR FIVE-->
                                        <li ng-repeat="item in operatorFive" data-drop="true" ng-model='operatorFive' jqyoui-droppable="{index: {{$index}}, onDrop:'loki.dropCallback(item.title, $index)'}">
                                            <div class="thumbnail" data-toggle="modal" data-target="#operatorFiveModal" data-drag="{{item.drag}}" data-jqyoui-options="{revert: 'invalid'}" ng-model="operatorFive" jqyoui-draggable="{index: {{$index}},animate:true}">
                                                <!--OPERATOR FIVE DISPLAY-->
                                                <div id="oFiveName" class="qadimOperator">{{item.title}}</div><br>
                                                <div id="opFiveComment" class="qadimComment">{{item.comment}}</div>
                                            </div>
                                        </li>
                                        <!--OPERATOR SIX-->
                                        <li ng-repeat="item in operatorSix" data-drop="true" ng-model='operatorSix' jqyoui-droppable="{index: {{$index}}, onDrop:'loki.dropCallback(item.title, $index)'}">
                                            <div class="thumbnail" data-toggle="modal" data-target="#operatorSixModal" data-drag="{{item.drag}}" data-jqyoui-options="{revert: 'invalid'}" ng-model="operatorSix" jqyoui-draggable="{index: {{$index}},animate:true}">
                                                <!--OPERATOR SIX DISPLAY-->
                                                <div id="opSixName" class="qadimOperator">{{item.title}}</div><br>
                                                <div id="opSixComment" class="qadimComment">{{item.comment}}</div>
                                            </div>
                                        </li>
                                        <!--OPERATOR SEVEN-->
                                        <li ng-repeat="item in operatorSeven" data-drop="true" ng-model='operatorSeven' jqyoui-droppable="{index: {{$index}}, onDrop:'loki.dropCallback(item.title, $index)'}">
                                            <div class="thumbnail" data-toggle="modal" data-target="#operatorSevenModal" data-drag="{{item.drag}}" data-jqyoui-options="{revert: 'invalid'}" ng-model="operatorSeven" jqyoui-draggable="{index: {{$index}},animate:true}">
                                                <!--OPERATOR SEVEN DISPLAY-->
                                                <div id="opSevenName" class="qadimOperator">{{item.title}}</div><br>
                                                <div id="opSevenComment" class="qadimComment">{{item.comment}}</div>
                                            </div>
                                        </li>
                                        <!--OPERATOR EIGHT-->
                                        <li ng-repeat="item in operatorEight" data-drop="true" ng-model='operatorEight' jqyoui-droppable="{index: {{$index}}, onDrop:'loki.dropCallback(item.title, $index)'}">
                                            <div class="thumbnail" data-toggle="modal" data-target="#operatorEightModal" data-drag="{{item.drag}}" data-jqyoui-options="{revert: 'invalid'}" ng-model="operatorEight" jqyoui-draggable="{index: {{$index}},animate:true}">
                                                <!--OPERATOR SEVEN DISPLAY-->
                                                <div id="opEightName" class="qadimOperator">{{item.title}}</div><br>
                                                <div id="opEightComment" class="qadimComment">{{item.comment}}</div>
                                            </div>
                                        </li>
                                        <!--CLOSE HERE-->
                                    </ul>
                                </div>
                                <!--EDIT PRODUCT NAME-->
                                <!--EDIT PRODUCT NAME FORM-->                  
                                <div id="currentProductNameModal" class="formModal">
                                    <div class="formModal-content">
                                        <div id="closeOperator" class="close" data-dismiss="modal">&times;</div>
                                        <div ng-repeat="item in currentProductName">
                                            <h2>Edit Product Name</h2>
                                            <p>Edit Product Name<br>
                                                <input type="text" ng-model="item.title" variableinput placeholder="i.e. Add, Raise, Combine, Separate, Reduce, Remove"><br><br>
                                            <center><button class="btn btn-2 btn-2i" data-dismiss="modal">OK</button></center>
                                            </p>
                                        </div>
                                    </div>
                                </div>
                                <!--EDITING OPERATORS FORM-->
                                <!--EDIT OPERATOR ONE FORMS-->
                                <div id="operatorOneModal" class="formModal">
                                    <div class="formModal-content">
                                        <div id="closeOperator" class="close" data-dismiss="modal">&times;</div>
                                        <div ng-repeat="item in operatorOne">
                                            <h2>Edit Operator One</h2>
                                            <p>Edit Operator:<br>
                                                <input type="text" ng-model="item.title" variableinput placeholder="i.e. Add, Raise, Combine, Separate, Reduce, Remove"><br><br>
                                                Edit Operator Comment:<br>
                                                <input type="text" ng-model="item.comment" variableinput placeholder="i.e. Wheels"><br>
                                            <center><button class="btn btn-2 btn-2i" data-dismiss="modal">OK</button>
                                                <button class="btn btn-2 btn-2i" data-dismiss="modal" data-toggle="modal" data-target="#operatorTwoModal">NEXT</button>
                                            </center>
                                            </p>

                                        </div>
                                    </div>
                                </div>
                                <!--EDIT OPERATOR TWO FORMS-->
                                <div id="operatorTwoModal" class="formModal">
                                    <div class="formModal-content">
                                        <div id="closeOperator" class="close" data-dismiss="modal">&times;</div>
                                        <div ng-repeat="item in operatorTwo">
                                            <h2>Edit Operator Two</h2>
                                            <p>Edit Operator:<br>
                                                <input type="text" ng-model="item.title" variableinput placeholder="i.e. Add, Raise, Combine, Separate, Reduce, Remove"><br><br>
                                                Edit Operator Comment:<br>
                                                <input type="text" ng-model="item.comment" variableinput placeholder="i.e. Wheels"><br>
                                            <center>
                                                <button class="btn btn-2 btn-2i" data-dismiss="modal" data-toggle="modal" data-target="#operatorOneModal"><</button>
                                                <button class="btn btn-2 btn-2i" data-dismiss="modal">OK</button>
                                                <button class="btn btn-2 btn-2i" data-dismiss="modal" data-toggle="modal" data-target="#operatorThreeModal">></button>
                                            </center>
                                            </p>

                                        </div>
                                    </div>
                                </div>
                                <!--EDIT OPERATOR THREE FORMS-->
                                <div id="operatorThreeModal" class="formModal">
                                    <div class="formModal-content">
                                        <div id="closeOperator" class="close" data-dismiss="modal">&times;</div>
                                        <div ng-repeat="item in operatorThree">
                                            <h2>Edit Operator Three</h2>
                                            <p>Edit Operator:<br>
                                                <input type="text" ng-model="item.title" variableinput placeholder="i.e. Add, Raise, Combine, Separate, Reduce, Remove"><br><br>
                                                Edit Operator Comment:<br>
                                                <input type="text" ng-model="item.comment" variableinput placeholder="i.e. Wheels"><br>
                                            <center>
                                                <button class="btn btn-2 btn-2i" data-dismiss="modal" data-toggle="modal" data-target="#operatorTwoModal"><</button>
                                                <button class="btn btn-2 btn-2i" data-dismiss="modal">OK</button>
                                                <button class="btn btn-2 btn-2i" data-dismiss="modal" data-toggle="modal" data-target="#operatorFourModal">></button>
                                            </center>
                                            </p>

                                        </div>
                                    </div>
                                </div>
                                <!--EDIT OPERATOR FOUR FORMS-->
                                <div id="operatorFourModal" class="formModal">
                                    <div class="formModal-content">
                                        <div id="closeOperator" class="close" data-dismiss="modal">&times;</div>
                                        <div ng-repeat="item in operatorFour">
                                            <h2>Edit Operator Four</h2>
                                            <p>Edit Operator:<br>
                                                <input type="text" ng-model="item.title" variableinput placeholder="i.e. Add, Raise, Combine, Separate, Reduce, Remove"><br><br>
                                                Edit Operator Comment:<br>
                                                <input type="text" ng-model="item.comment" variableinput placeholder="i.e. Wheels"><br>
                                            <center>
                                                <button class="btn btn-2 btn-2i" data-dismiss="modal" data-toggle="modal" data-target="#operatorThreeModal"><</button>
                                                <button class="btn btn-2 btn-2i" data-dismiss="modal">OK</button>
                                                <button class="btn btn-2 btn-2i" data-dismiss="modal" data-toggle="modal" data-target="#operatorFiveModal">></button>
                                            </center>
                                            </p>

                                        </div>
                                    </div>
                                </div>
                                <!--EDIT OPERATOR Five FORMS-->
                                <div id="operatorFiveModal" class="formModal">
                                    <div class="formModal-content">
                                        <div id="closeOperator" class="close" data-dismiss="modal">&times;</div>
                                        <div ng-repeat="item in operatorFive">
                                            <h2>Edit Operator Five</h2>
                                            <p>Edit Operator:<br>
                                                <input type="text" ng-model="item.title" variableinput placeholder="i.e. Add, Raise, Combine, Separate, Reduce, Remove"><br><br>
                                                Edit Operator Comment:<br>
                                                <input type="text" ng-model="item.comment" variableinput placeholder="i.e. Wheels"><br>
                                            <center>
                                                <button class="btn btn-2 btn-2i" data-dismiss="modal" data-toggle="modal" data-target="#operatorFourModal"><</button>
                                                <button class="btn btn-2 btn-2i" data-dismiss="modal">OK</button>
                                                <button class="btn btn-2 btn-2i" data-dismiss="modal" data-toggle="modal" data-target="#operatorSixModal">></button>
                                            </center>
                                            </p>

                                        </div>
                                    </div>
                                </div>
                                <!--EDIT OPERATOR SIX FORMS-->
                                <div id="operatorSixModal" class="formModal">
                                    <div class="formModal-content">
                                        <div id="closeOperator" class="close" data-dismiss="modal">&times;</div>
                                        <div ng-repeat="item in operatorSix">
                                            <h2>Edit Operator Six</h2>
                                            <p>Edit Operator:<br>
                                                <input type="text" ng-model="item.title" variableinput placeholder="i.e. Add, Raise, Combine, Separate, Reduce, Remove"><br><br>
                                                Edit Operator Comment:<br>
                                                <input type="text" ng-model="item.comment" variableinput placeholder="i.e. Wheels"><br>
                                            <center>
                                                <button class="btn btn-2 btn-2i" data-dismiss="modal" data-toggle="modal" data-target="#operatorFiveModal"><</button>
                                                <button class="btn btn-2 btn-2i" data-dismiss="modal">OK</button>
                                                <button class="btn btn-2 btn-2i" data-dismiss="modal" data-toggle="modal" data-target="#operatorSevenModal">></button>
                                            </center>
                                            </p>

                                        </div>
                                    </div>
                                </div>
                                <!--EDIT OPERATOR SEVEN FORMS-->
                                <div id="operatorSevenModal" class="formModal">
                                    <div class="formModal-content">
                                        <div id="closeOperator" class="close" data-dismiss="modal">&times;</div>
                                        <div ng-repeat="item in operatorSeven">
                                            <h2>Edit Operator Seven</h2>
                                            <p>Edit Operator:<br>
                                                <input type="text" ng-model="item.title" variableinput placeholder="i.e. Add, Raise, Combine, Separate, Reduce, Remove"><br><br>
                                                Edit Operator Comment:<br>
                                                <input type="text" ng-model="item.comment" variableinput placeholder="i.e. Wheels"><br>
                                            <center>
                                                <button class="btn btn-2 btn-2i" data-dismiss="modal" data-toggle="modal" data-target="#operatorSixModal"><</button>
                                                <button class="btn btn-2 btn-2i" data-dismiss="modal">OK</button>
                                                <button class="btn btn-2 btn-2i" data-dismiss="modal" data-toggle="modal" data-target="#operatorEightModal">></button>
                                            </center>
                                            </p>

                                        </div>
                                    </div>
                                </div>
                                <!--EDIT OPERATOR EIGHT FORMS-->
                                <div id="operatorEightModal" class="formModal">
                                    <div class="formModal-content">
                                        <div id="closeOperator" class="close" data-dismiss="modal">&times;</div>
                                        <div ng-repeat="item in operatorEight">
                                            <h2>Edit Operator Eight</h2>
                                            <p>Edit Operator:<br>
                                                <input type="text" ng-model="item.title" variableinput placeholder="i.e. Add, Raise, Combine, Separate, Reduce, Remove"><br><br>
                                                Edit Operator Comment:<br>
                                                <input type="text" ng-model="item.comment" variableinput placeholder="i.e. Wheels"><br>
                                            <center>
                                                <button class="btn btn-2 btn-2i" data-dismiss="modal" data-toggle="modal" data-target="#operatorSevenModal"><</button>
                                                <button class="btn btn-2 btn-2i" data-dismiss="modal">OK</button>
                                                <button class="btn btn-2 btn-2i" data-dismiss="modal" data-toggle="modal" data-target="#operatorOneModal">></button>
                                            </center>
                                            </p>

                                        </div>
                                    </div>
                                </div>
                                <!--END OF QADIM MODEL-->
                                </td>
                                <!--
                                QADIM SIDE TOOLS
                                    - PROJECT NAME (Non modifiable / current project)
                                    - SAVE BUTTON
                                    - DOWNLOAD BUTTON
                                -->
                                <td>
                                    <p style="font-size:20px; color:#fff; margin-bottom:-2.2em">
                                        YOU ARE MODIFYING PROJECT<br></p><br>
                                    <div id="curProjectName" style="font-size:40px; color:#fff;margin-top:0.5em;text-transform: uppercase;font-weight: bold;"><%=projectName%></div>

                                    <button class="QADIMbtn QadimNewLoadbtn" data-toggle="modal" data-target="#myProjectForm" id="newLoadProject">NEW / LOAD PROJECT </button>
                                    <button class="QADIMbtn QADIMSavebtn" id="QaDIMSave">SAVE PROJECT </button>
                                    
                                    <a href="FileDownload">
                                        <button class="QADIMbtn QADIMDownloadbtn" id="QaDIMSave">DOWNLOAD </button></a>
                                <center>
                                    <a href="QADIMindex.jsp">
                                        <button class="btn btn-2 btn-2i">BACK</button></a></center>

                                <!-- NEW / LOAD PROJECT MODAL -->
                                <div id="myProjectForm" class="formModal">
                                    <!-- Modal content -->
                                    <div class="formModal-content">
                                        <div id="projectClose" class="close" data-dismiss="modal">&times;</div>
                                        <h2>New or Load Project</h2>
                                        <p>
                                            Create a New Project or Load an Existing Project<br>
                                        </p>
                                        <center>
                                            <button class="QADIMModalbtn QadimModalNewProjectbtn"  onclick="window.location.href = 'QADIMnewProject.jsp'">CREATE NEW PROJECT</button>                               
                                            <!--LOAD EXISTING PROJECT-->
                                            <%
                                                String userid = user.getUserid();
                                                ArrayList<QadimProduct> loadedProjects = QaDIMDAO.retrieveAllProjects(userid);
                                                if (loadedProjects.size() != 0) {
                                            %>                               
                                            <h3>OR</h3>
                                            <form action="LoadManager" target="_parent" method="GET">
                                                <input type="submit" class="QADIMIndexLoadbtn QadimIndexLoadBtn" name="submit" value="load">
                                                <select name="toLoadQadim" class="cs-select cs-skin-elastic">
                                                    <%for (QadimProduct project : loadedProjects) {%>
                                                    <option disabled>Load Existing Project</option>
                                                    <option value="<%=project.getProjectName()%>" ><%=project.getProjectName()%></option>
                                                    <%=project.getProjectName()%>
                                                    <%}%>
                                                </select>
                                            </form>
                                            <br><br><br>
                                            <%
                                            } else {
                                            %>
                                            <!--IF NO PROJECTS, NOTHING DISPLAYED-->
                                            <%
                                                }
                                            %>
                                        </center>
                                    </div>
                                </div>
                                <!-- END NEW / LOAD PROJECT MODAL -->
                                </td>
                                <!--END OF QADIM TOOLS-->
                                </tr>
                                </table>
                                <br><br>
                                <!--HIDDEN DIVS TO LOAD QADIM VALUES-->
                                <div hidden id="productNameHidden"><%=productName%></div>
                                <div hidden id="opName1hidden"><%=opName1%></div>
                                <div hidden id="opComment1hidden"><%=opComment1%></div>
                                <div hidden id="opName2hidden"><%=opName2%></div>
                                <div hidden id="opComment2hidden"><%=opComment2%></div>
                                <div hidden id="opName3hidden"><%=session.getAttribute("opName3")%></div>
                                <div hidden id="opComment3hidden"><%=session.getAttribute("opComment3")%></div>
                                <div hidden id="opName4hidden"><%=session.getAttribute("opName4")%></div>
                                <div hidden id="opComment4hidden"><%=session.getAttribute("opComment4")%></div>
                                <div hidden id="opName5hidden"><%=session.getAttribute("opName5")%></div>
                                <div hidden id="opComment5hidden"><%=session.getAttribute("opComment5")%></div>
                                <div hidden id="opName6hidden"><%=session.getAttribute("opName6")%></div>
                                <div hidden id="opComment6hidden"><%=session.getAttribute("opComment6")%></div>
                                <div hidden id="opName7hidden"><%=session.getAttribute("opName7")%></div>
                                <div hidden id="opComment7hidden"><%=session.getAttribute("opComment7")%></div>
                                <div hidden id="opName8hidden"><%=session.getAttribute("opName8")%></div>
                                <div hidden id="opComment8hidden"><%=session.getAttribute("opComment8")%></div>
                            </div>

                            <!--SCRIPTS FOR QADIM DRAGGABLE-->
                            <script src="https://ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
                            <script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1/jquery-ui.min.js"></script>
                            <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.2.0/angular.min.js"></script>
                            <script src="resources/js/qadim/qadimDragDrop.js"></script>
                            <script src="resources/js/qadim/qadimAppController.js"></script>
                            <!--SCRIPT FOR TEXT FUNCTION-->
                            <script>
                                                        changetext = function (e) {
                                                        src = (e.parentNode);
                                                                src.outerHTML = "<div><input +" + "name=input" + "></div>";
                                                        }
                            </script>
                            <!--SCRIPTS FOR BUTTON-->
                            <script src="resources/js/qadim/qadimClassie.js"></script>
                            <script src="resources/js/qadim/qadimProgressButton.js"></script>
                            <!--SCRIPT FOR QADIM SAVE FUNCTION-->
                            <script src ="resources/js/qadim/qadimSave.js"></script>
                            <!--SCRIPTS FOR NEW LOAD PROJECT BUTTON MODAL FORM-->
                            <script src ="resources/js/qadim/qadimFormModal.js"></script>
                            <script src="resources/js/qadim/qadimClassie.js"></script>
                            <!--SCRIPT FOR DROPDOWN-->
                            <script src="resources/js/qadim/qadimClassie.js"></script>
                            <script src="resources/js/qadim/qadimFormSelectFx.js"></script>
                            <script>
                                                        (function () {
                                                        [].slice.call(document.querySelectorAll('select.cs-select')).forEach(function (el) {
                                                        new SelectFx(el);
                                                        });
                                                        })();</script>
                            <!--SCRIPT FOR OPERATOR MODAL-->
                            <script src="resources/js/qadim/qadimOperatorModal.js"></script>


                            </body>
                            </html>
