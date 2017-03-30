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
    </head>
    <body>
        <!--
        CONTENT
        1. EXPLANATION (TOOLTIPS)
        2. QADIM MODEL
        3. SIDE PANEL (PROJECT NAME AND BUTTONS)
        -->
        <!--EXPLANATION-->
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
            <!--END OF EXPLANATION-->
            <!--QADIM MODEL-->
            <table>
                <tr><td>
                        <!--PROJECT CONTENT-->
                        <div id="qadimcontent">
                            <!--FIRST ROW-->
                            <div ng-controller="oneCtrl as loki">
                                <div class='contentWrapper ng-cloak'>
                                    <ul class="thumbnails">
                                        <!--OPERATOR ONE-->
                                        <li ng-repeat="item in operatorOne" data-drop="true" ng-model='operatorOne' jqyoui-droppable="{index: {{$index}}, onDrop:'loki.dropCallback(item.title, $index)'}">
                                            <div class="thumbnail" data-toggle="modal" data-target="#operatorOneModal" data-drag="{{item.drag}}" data-jqyoui-options="{revert: 'invalid'}" ng-model="operatorOne" jqyoui-draggable="{index: {{$index}},animate:true}">
                                                <!--EDIT OPERATOR ONE FORM-->
                                                <div class="formModal" id="operatorOneModal">
                                                    <div class="formModal-content">
                                                        <div class="modal-content">
                                                            <input ng-model="item.title" variableinput placeholder="Edit Operator" id="operatorOneName"><br>
                                                            <input ng-model="item.comment" variableinput placeholder="Edit Comment" id="operatorOneComment"><br>
                                                            <div class="modal-footer">
                                                                <span class="closeProjectForm">x</span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <!--OPERATOR ONE DISPLAY-->
                                                <div id="opOneName">{{item.title}}</div><br>
                                                <div id="opOneComment">{{item.comment}}</div>
                                            </div>
                                        </li>
                                        <!--OPERATOR TWO-->
                                        <li ng-repeat="item in operatorTwo" data-drop="true" ng-model='operatorTwo' jqyoui-droppable="{index: {{$index}}, onDrop:'loki.dropCallback(item.title, $index)'}">
                                            <div class="thumbnail" data-toggle="modal" data-target="#operatorTwoModal" data-drag="{{item.drag}}" data-jqyoui-options="{revert: 'invalid'}" ng-model="operatorTwo" jqyoui-draggable="{index: {{$index}},animate:true}">
                                                <!--EDIT OPERATOR TWO FORM-->
                                                <div class="formModal" id="operatorTwoModal">
                                                    <div class="formModal-content">
                                                        <div class="modal-content">
                                                            <input ng-model="item.title" variableinput placeholder="Edit Operator" id="operatorTwoName"><br>
                                                            <input ng-model="item.comment" variableinput placeholder="Edit Comment" id="operatorTwoComment"><br>
                                                            <div class="modal-footer">
                                                                <span class="closeProjectForm">x</span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <!--OPERATOR TWO DISPLAY-->
                                                <div id="opTwoName">{{item.title}}</div><br>
                                                <div id="opTwoComment">{{item.comment}}</div>
                                            </div>
                                        </li>
                                        <!--OPERATOR THREE-->
                                        <li ng-repeat="item in operatorThree" data-drop="true" ng-model='operatorThree' jqyoui-droppable="{index: {{$index}}, onDrop:'loki.dropCallback(item.title, $index)'}">
                                            <div class="thumbnail" data-toggle="modal" data-target="#operatorThreeModal" data-drag="{{item.drag}}" data-jqyoui-options="{revert: 'invalid'}" ng-model="operatorThree" jqyoui-draggable="{index: {{$index}},animate:true}">
                                                <!--EDIT OPERATOR THREE FORM-->
                                                <div class="formModal" id="operatorThreeModal">
                                                    <div class="formModal-content">
                                                        <div class="modal-content">
                                                            <input ng-model="item.title" variableinput placeholder="Edit Operator" id="operatorThreeName"><br>
                                                            <input ng-model="item.comment" variableinput placeholder="Edit Comment" id="operatorThreeComment"><br>
                                                            <div class="modal-footer">
                                                                <span class="closeProjectForm">x</span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <!--OPERATOR THREE DISPLAY-->
                                                <div id="opThreeName">{{item.title}}</div><br>
                                                <div id="opThreeComment">{{item.comment}}</div>
                                            </div>
                                        </li>
                                        <!--OPERATOR FOUR-->
                                        <li ng-repeat="item in operatorFour" data-drop="true" ng-model='operatorFour' jqyoui-droppable="{index: {{$index}}, onDrop:'loki.dropCallback(item.title, $index)'}">
                                            <div class="thumbnail" data-toggle="modal" data-target="#operatorFourModal" data-drag="{{item.drag}}" data-jqyoui-options="{revert: 'invalid'}" ng-model="operatorFour" jqyoui-draggable="{index: {{$index}},animate:true}">
                                                <!--EDIT OPERATOR FOUR FORM-->
                                                <div class="formModal" id="operatorFourModal">
                                                    <div class="formModal-content">
                                                        <div class="modal-content">
                                                            <input ng-model="item.title" variableinput placeholder="Edit Operator" id="operatorFourName"><br>
                                                            <input ng-model="item.comment" variableinput placeholder="Edit Comment" id="operatorFourComment"><br>
                                                            <div class="modal-footer">
                                                                <span class="closeProjectForm">x</span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <!--OPERATOR FOUR DISPLAY-->
                                                <div id="opFourName">{{item.title}}</div><br>
                                                <div id="opFourComment">{{item.comment}}</div>
                                            </div>
                                        </li>
                                        <!--PROJECT NAME-->
                                        <li ng-repeat="item in currentProjectName" data-drop="false" ng-model='currentProjectName' jqyoui-droppable="{index: {{$index}}, onDrop:'loki.dropCallback(item.title, $index)'}">
                                            <div class="thumbnail" data-toggle="modal" data-target="#currentProjectNameModal" data-drag="{{item.drag}}" data-jqyoui-options="{revert: 'invalid'}" ng-model="currentProjectName" jqyoui-draggable="{index: {{$index}},animate:true}">
                                                <!--EDIT PROJECT NAME FORM-->
                                                <div class="formModal" id="currentProjectNameModal">
                                                    <div class="formModal-content">
                                                        <div class="modal-content">
                                                            <input ng-model="item.title" variableinput placeholder="Edit Project Name" id="currentProjectName"><br>
                                                            <div class="modal-footer">
                                                                <span class="closeProjectForm">x</span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <!--PROJECT NAME DISPLAY-->
                                                <div id="curProjectName">{{item.title}}</div><br>
                                            </div>
                                        </li>
                                        <!--OPERATOR FIVE-->
                                        <li ng-repeat="item in operatorFive" data-drop="true" ng-model='operatorFive' jqyoui-droppable="{index: {{$index}}, onDrop:'loki.dropCallback(item.title, $index)'}">
                                            <div class="thumbnail" data-toggle="modal" data-target="#operatorFiveModal" data-drag="{{item.drag}}" data-jqyoui-options="{revert: 'invalid'}" ng-model="operatorFive" jqyoui-draggable="{index: {{$index}},animate:true}">
                                                <!--EDIT OPERATOR FIVE FORM-->
                                                <div class="formModal" id="operatorFiveModal">
                                                    <div class="formModal-content">
                                                        <div class="modal-content">
                                                            <input ng-model="item.title" variableinput placeholder="Edit Operator" id="operatorFiveName"><br>
                                                            <input ng-model="item.comment" variableinput placeholder="Edit Comment" id="operatorFiveComment"><br>
                                                            <div class="modal-footer">
                                                                <span class="closeProjectForm">x</span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <!--OPERATOR FIVE DISPLAY-->
                                                <div id="opFiveName">{{item.title}}</div><br>
                                                <div id="opFiveComment">{{item.comment}}</div>
                                            </div>
                                        </li>
                                        <!--OPERATOR SIX-->
                                        <li ng-repeat="item in operatorSix" data-drop="true" ng-model='operatorSix' jqyoui-droppable="{index: {{$index}}, onDrop:'loki.dropCallback(item.title, $index)'}">
                                            <div class="thumbnail" data-toggle="modal" data-target="#operatorSixModal" data-drag="{{item.drag}}" data-jqyoui-options="{revert: 'invalid'}" ng-model="operatorSix" jqyoui-draggable="{index: {{$index}},animate:true}">
                                                <!--EDIT OPERATOR SIX FORM-->
                                                <div class="formModal" id="operatorSixModal">
                                                    <div class="formModal-content">
                                                        <div class="modal-content">
                                                            <input ng-model="item.title" variableinput placeholder="Edit Operator" id="operatorSixName"><br>
                                                            <input ng-model="item.comment" variableinput placeholder="Edit Comment" id="operatorSixComment"><br>
                                                            <div class="modal-footer">
                                                                <span class="closeProjectForm">x</span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <!--OPERATOR SIX DISPLAY-->
                                                <div id="opSixName">{{item.title}}</div><br>
                                                <div id="opSixComment">{{item.comment}}</div>
                                            </div>
                                        </li>
                                        <!--OPERATOR SEVEN-->
                                        <li ng-repeat="item in operatorSeven" data-drop="true" ng-model='operatorSeven' jqyoui-droppable="{index: {{$index}}, onDrop:'loki.dropCallback(item.title, $index)'}">
                                            <div class="thumbnail" data-toggle="modal" data-target="#operatorSevenModal" data-drag="{{item.drag}}" data-jqyoui-options="{revert: 'invalid'}" ng-model="operatorSeven" jqyoui-draggable="{index: {{$index}},animate:true}">
                                                <!--EDIT OPERATOR SEVEN FORM-->
                                                <div class="formModal" id="operatorSevenModal">
                                                    <div class="formModal-content">
                                                        <div class="modal-content">
                                                            <input ng-model="item.title" variableinput placeholder="Edit Operator" id="operatorSevenName"><br>
                                                            <input ng-model="item.comment" variableinput placeholder="Edit Comment" id="operatorSevenComment"><br>
                                                            <div class="modal-footer">
                                                                <span class="closeProjectForm">x</span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <!--OPERATOR SEVEN DISPLAY-->
                                                <div id="opSevenName">{{item.title}}</div><br>
                                                <div id="opSevenComment">{{item.comment}}</div>
                                            </div>
                                        </li>
                                        <!--OPERATOR EIGHT-->
                                        <li ng-repeat="item in operatorEight" data-drop="true" ng-model='operatorEight' jqyoui-droppable="{index: {{$index}}, onDrop:'loki.dropCallback(item.title, $index)'}">
                                            <div class="thumbnail" data-toggle="modal" data-target="#operatorEightModal" data-drag="{{item.drag}}" data-jqyoui-options="{revert: 'invalid'}" ng-model="operatorEight" jqyoui-draggable="{index: {{$index}},animate:true}">
                                                <!--EDIT OPERATOR EIGHT FORM-->
                                                <div class="formModal" id="operatorEightModal">
                                                    <div class="formModal-content">
                                                        <div class="modal-content">
                                                            <input ng-model="item.title" variableinput placeholder="Edit Operator" id="operatorEightName"><br>
                                                            <input ng-model="item.comment" variableinput placeholder="Edit Comment" id="operatorEightComment"><br>
                                                            <div class="modal-footer">
                                                                <span class="closeProjectForm">x</span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <!--OPERATOR SEVEN DISPLAY-->
                                                <div id="opEightName">{{item.title}}</div><br>
                                                <div id="opEightComment">{{item.comment}}</div>
                                            </div>
                                        </li>
                                        <!--CLOSE HERE-->
                                    </ul>
                                </div>
                            </div>

                        </div>

                        <!--END OF QADIM MODEL-->
                    </td>
                    <!--
                    QADIM SIDE TOOLS
                        - PROJECT NAME
                        - SAVE BUTTON
                        - DOWNLOAD BUTTON
                    -->
                    <td>
                        <p style="font-size:20px; color:#fff; margin-bottom:-2.2em">
                            YOU ARE MODIFYING PROJECT<br></p>
                        <p style="font-size:40px; color:#fff;margin-bottom:-.02em">
                            <%
                                String projectName = (String) request.getSession().getAttribute("projectName");
                            %>
                            <b><%=projectName%></b>
                        </p>

                        <button class="progress-button" data-style="flip-open" data-perspective data-horizontal id="newLoadProject">New/Load</button><br><br>
                        <!-- NEW / LOAD PROJECT MODAL -->
                        <div id="myProjectForm" class="formModal">
                            <!-- Modal content -->
                            <div class="formModal-content">
                                <span class="closeProjectForm">x</span>
                                <p>
                                    New or Load Project<br>
                                    Do you want to create a new project or load an existing project?<br>
                                    CREATE NEW PROJECT <br>
                                    <button class="btn btn-2 btn-2a"  onclick="window.location.href = 'QADIMnewProject.jsp'">CREATE NEW PROJECT</button>
                                    --
                                </p>
                            </div>
                        </div>
                        <!-- END NEW / LOAD PROJECT MODAL -->
                        <button class="progress-button" data-style="fill" data-horizontal id="QaDIMSave">Save</button><br><br>
                        <button class="progress-button" data-style="shrink" data-horizontal>Download</button>
                    </td>
                    <!--END OF QADIM TOOLS-->
                </tr>
            </table>
            <br><br>
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
        <script>
                                                [].slice.call(document.querySelectorAll('button.progress-button')).forEach(function (bttn) {
                                        new ProgressButton(bttn, {
                                        callback: function (instance) {
                                        var progress = 0,
                                                interval = setInterval(function () {
                                                progress = Math.min(progress + Math.random() * 0.1, 1);
                                                        instance._setProgress(progress);
                                                        if (progress === 1) {
                                                instance._stop(1);
                                                        clearInterval(interval);
                                                }
                                                }, 200);
                                        }
                                        });
                                        });</script>
        <!--SCRIPT FOR QADIM SAVE FUNCTION-->
        <script src ="resources/js/qadim/qadimSave.js"></script>

        <!--SCRIPTS FOR NEW LOAD PROJECT BUTTON MODAL FORM-->
        <script src ="resources/js/qadim/qadimFormModal.js"></script>
        <script src="resources/js/qadim/qadimClassie.js"></script>
    </body>
</html>
