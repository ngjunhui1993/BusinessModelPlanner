<%@page import="com.app.model.entity.QadimProduct"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.app.model.QaDIMDAO"%>
<%@page import="com.app.model.entity.Demographics"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="Protect.jsp"%>
<!DOCTYPE html>
<html>
    <%@include file="newHeader.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SIMHA INNOVATION MODEL</title>
        <!--CSS FOR TOOLTIPS-->
        <link rel="stylesheet" type="text/css" href="resources/css/qadim/qadimTooltip.css" />
        <!--CSS FOR CURRENT PAGE-->
        <link rel="stylesheet" type="text/css" href="resources/css/qadim/qadimForm.css" />
        <link rel="stylesheet" type="text/css" href="resources/css/qadim/qadimformComponent.css" />
        <!--CSS FOR LOADING PROJECT-->
        <link rel="stylesheet" type="text/css" href="resources/css/qadim/qadim-cs-select.css" />
        <link rel="stylesheet" type="text/css" href="resources/css/qadim/qadim-cs-skin-elastic.css" />
        <!--CSS FOR NEW PROJECT BUTTON-->
        <link rel="stylesheet" type="text/css" href="resources/css/qadim/qadimButton.css" />
        <script src="resources/js/qadim/qadimmodernizr.custom.js"></script>
    </head>
    <body id="qadimContent">
    <CENTER>
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
                    existing or new products or services. You can start by either <b>creating a new project</b> or <b>load your existing project</b>
                    below
                </div>
            </div>
            <br><br>
            <!--END OF EXPLANATION-->          
            <!--LOAD NEW PROJECT//NAV TO QADIMnewProjectForm-->

            <button class="QADIMIndexbtn QADIMnewProjectbtn"  onclick="window.location.href = 'QADIMnewProject.jsp'">CREATE NEW PROJECT</button>
            <br>
            <!--IF THERE ARE EXISTING PROJECT-->
            <!--LOAD EXISTING PROJECT-->
            <%                            String userid = user.getUserid();
                ArrayList<QadimProduct> loadedProjects = QaDIMDAO.retrieveAllProjects(userid);
                if (loadedProjects.size() != 0) {
            %>
            <h1>OR</h1>
            <!--LOAD PROJECT
            FOR USERS TO LOAD PREVIOUSLY CREATED PROJECTS
            -->
            <form action="LoadManager" target="_parent" method="GET">
                <input type="submit" class="QADIMIndexLoadbtn QadimIndexLoadBtn" name="submit" value="load">
                <select name="toLoadQadim" class="cs-select cs-skin-elastic">
                    <%for (QadimProduct project : loadedProjects) {%>
                    <option disabled selected>Load Existing Project</option>
                    <option value="<%=project.getProjectName()%>" ><%=project.getProjectName()%></option>
                    <%=project.getProjectName()%>
                    <%};%>
                </select>
            </form>
                <br>
            <!--MANAGE PROJECTS
            FOR USERS TO DELETE EXISTING PROJECTS
            -->
            <button class="QADIMIndexbtn QADIMnewProjectbtn"  onclick="window.location.href = 'QADIMmanageProjects.jsp'">MANAGE EXISTING PROJECTS</button>


            <%
            } else {
            %>
            <!--IF NO PROJECTS, NOTHING DISPLAYED-->
            <%
                }
            %>
            <!--SCRIPT FOR DROPDOWN-->
            <script src="resources/js/qadim/qadimClassie.js"></script>
            <script src="resources/js/qadim/qadimFormSelectFx.js"></script>
            <script>
    (function () {
        [].slice.call(document.querySelectorAll('select.cs-select')).forEach(function (el) {
            new SelectFx(el);
        });
    })();
            </script>
            </body>
            </html>
