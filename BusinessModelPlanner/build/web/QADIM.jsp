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
                                We have pre-defined some default operators for you to get you started! <br>

                            </span></span></span> around the product/service. Look out for the 
                    <span class="tooltip tooltip-effect-3">
                        <span class="tooltip-item">Tools</span> 
                        <span class="tooltip-content clearfix">
                            <span class="tooltip-text" style="padding-left:15px">
                                The <strong>Tools</strong> are developed to help you in the following:<br><br>
                                1. <strong>Save</strong> your current project.<br>
                                2. <Strong>Create</strong> a new project or <Strong>load</Strong> previous projects.<br>
                                3. <Strong>Download</Strong> your project in excel format.<br>
                            </span></span></span> on the right to perform more functions. If you are unsure of what to do, you can always <b>click here</b> for help.
                </div>
            </div>

            <!--END OF EXPLANATION-->

            <!--QADIM MODEL-->
            <table>
                <tr><td>
                        <!--PROJECT CONTENT-->
                        <div id="qadimcontent">
                            <!--FIRST ROW OPERATORS-->
                            <div ng-controller="oneCtrl as loki">
                                <div class='contentWrapper ng-cloak'>
                                    <ul class="thumbnails">
                                        <li ng-repeat="item in list1" data-drop="true" ng-model='list1' jqyoui-droppable="{index: {{$index}}, onDrop:'loki.dropCallback(item.title, $index)'}">

                                            <div class="thumbnail" data-drag="{{item.drag}}" data-jqyoui-options="{revert: 'invalid'}" ng-model="list1" jqyoui-draggable="{index: {{$index}},animate:true}">

                                                <h1>
                                                    <input ng-model="item.title" variableinput><br>
                                                    {{item.title}}
                                                </h1>
                                                <input ng-model="item.comment" variableinput><br>
                                                {{item.comment}}
                                            </div>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                            <!--END FIRST ROW OPERATORS-->
                            <!--SECOND ROW OPERATORS-->
                            <div ng-controller="oneCtrl as loki">
                                <div class='contentWrapper ng-cloak'>
                                    <ul class="thumbnails">
                                        <li ng-repeat="item in list2A" data-drop="true" ng-model='list2A' jqyoui-droppable="{index: {{$index}}, onDrop:'loki.dropCallback(item.title, $index)'}">
                                            <div class="thumbnail" data-drag="{{item.drag}}" data-jqyoui-options="{revert: 'invalid'}" ng-model="list2A" jqyoui-draggable="{index: {{$index}},animate:true}">
                                                <h1>
                                                    <input ng-model="item.title" variableinput><br>
                                                    {{item.title}} 
                                                </h1>
                                                <input ng-model="item.comment" variableinput><br>
                                                {{item.comment}}
                                            </div>
                                        </li>
                                        <!--PRODUCT NAME-->
                                        <li ng-repeat="item in list2C" data-drop="false" ng-model='list2C' jqyoui-droppable="{index: {{$index}}, onDrop:'loki.dropCallback(item.title, $index)'}">
                                            <div class="thumbnail" data-drag="{{item.drag}}" data-jqyoui-options="{revert: 'invalid'}" ng-model="list2B" jqyoui-draggable="{index: {{$index}},animate:true}">
                                                <h1>
                                                    <input ng-model="item.title" variableinput><br>
                                                    {{item.title}}   
                                                </h1>
                                            </div>
                                        </li>
                                        <!--END PRODUCT NAME-->
                                        <li ng-repeat="item in list2B" data-drop="true" ng-model='list2B' jqyoui-droppable="{index: {{$index}}, onDrop:'loki.dropCallback(item.title, $index)'}">
                                            <div class="thumbnail" data-drag="{{item.drag}}" data-jqyoui-options="{revert: 'invalid'}" ng-model="list2B" jqyoui-draggable="{index: {{$index}},animate:true}">
                                                <h1>
                                                    <input ng-model="item.title" variableinput><br>
                                                    {{item.title}}   
                                                </h1>
                                                <input ng-model="item.comment" variableinput><br>
                                                {{item.comment}}
                                            </div>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                            <!--END SECOND ROW OPERATORS-->
                            <!--LAST ROW OPERATORS-->
                            <div ng-controller="oneCtrl as loki">
                                <div class='contentWrapper ng-cloak'>
                                    <ul class="thumbnails">
                                        <li ng-repeat="item in list3" data-drop="true" ng-model='list3' jqyoui-droppable="{index: {{$index}}, onDrop:'loki.dropCallback(item.title, $index)'}">
                                            <div class="thumbnail" data-drag="{{item.drag}}" data-jqyoui-options="{revert: 'invalid'}" ng-model="list3" jqyoui-draggable="{index: {{$index}},animate:true}">
                                                <h1>
                                                    <input ng-model="item.title" variableinput><br>
                                                    {{item.title}}
                                                </h1>
                                                <input ng-model="item.comment" variableinput><br>
                                                {{item.comment}}
                                            </div>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                        <!--END SECOND ROW OPERATORS-->
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
                                <span class="close">x</span>

                                <p>
                                    New or Load Project<br>
                                    Do you want to create a new project or load an existing project?<br>
                                    CREATE NEW PROJECT <br>
                                    <button class="btn btn-2 btn-2a"  onclick="window.location.href = 'QADIMnewProject.jsp'">CREATE NEW PROJECT</button>
                                    --
                                </p>
                            </div>

                        </div>
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
        <!--This is the script for save functionality, i use ajax. getElementByID(the element ID), and get its inner html-->
        <!--after which, the data should be parsed to a servlet. The servlet handles changes the json into normal objects-->
        <!--The parser servlet will then pass the data to the qadimdao. validations required. -->
        <script type="text/javascript">
                    $('#QaDIMSave').click(function parse() {
            var saveQADIMProjectName = document.getElementById("projectName").innerHTML;
                    console.log(saveQADIMProjectName);
                    $.ajax
                    (
                    {
                    //testing   
                    //console.log(saveQADIMProjectName);
                    url:'QADIMParser',
                            data:{
                            saveQADIMProjectName : saveQADIMProjectName

                            },
                            type:'GET',
                            cache:false,
                            success:function(){alert(saveQADIMProjectName); },
                            error:function(){alert('You have an existing project with the same title! Use a different project title'); }
                    }
                    );
            });</script>
        <!--SCRIPTS FOR NEW LOAD PROJECT BUTTON MODAL FORM-->
        <script src="resources/js/qadim/qadimFormModal.js"></script>
        <script src="resources/js/qadim/qadimClassie.js"></script>
    </body>
</html>
