<%@include file="Protect.jsp"%>
<%@page import="com.app.model.entity.Group"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.app.model.entity.Demographics"%>
<%@page import="com.app.model.GroupDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SIMHA INNOVATION MODEL</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link rel="stylesheet" type="text/css" href="resources/css/index/pullupmenu.css" />
        <link rel="stylesheet" type="text/css" href="resources/css/index/admin.css" />
        <script src="resources/js/index/snap.svg-min.js"></script>
    </head>
    <body>
        <div class="indexcontainer" style="width:100%">
            <nav id="menu" class="menu">
                <button class="menu__handle"><span>Menu</span></button>
                <div class="menu__inner">
                    <ul>
                        <li><a href="Logout">LOGOUT</a></li>
                            <%                                if (user.getType().equals("administrator")) {
                            %>
                        <li><a href="index.jsp">BACK TO MAIN PAGE</a></li>
                            <%
                                }
                            %>
                    </ul>
                </div>
                <div class="morph-shape" data-morph-open="M-10,100c0,0,44-95,290-95c232,0,290,95,290,95" data-morph-close="M-10,100c0,0,44,95,290,95c232,0,290-95,290-95">
                    <svg width="100%" height="100%" viewBox="0 0 560 200" preserveAspectRatio="none">
                    <path fill="none" d="M-10,100c0,0,44,0,290,0c232,0,290,0,290,0"/>
                    </svg>
                </div>
            </nav>
            <!--BODY-->
            <div class="main" style="width:100%">
                <div class="main">
                    <div style="background: #424242; width:100%; height:200px; color:#fff;">
                        <center>
                            <img src="resources/image/webapplogo.png" alt="SIMHA" width="300" style='padding-top:35px;'><br>
                        </center>
                        <div style='margin:20px;'>
                            <%    String name = user.getName().toUpperCase();
                            %>
                            <h4>WELCOME, ADMINISTRATOR <%=name%></h4>
                            <h4 STYLE="margin-top: -10PX;">ADMINISTRATOR PAGE</h4>
                        </div>
                    </div>
                    <div>
                        <br>
                        <CENTER>
                            This page allows you to upload data for Business Model Buffet<br>
                            <form action="MainFileUpload"  method="post" enctype="multipart/form-data">
                                Upload Company Data file Here: <BR>

                                <input id="uploadFile" placeholder="Choose File" disabled="disabled" />
                                <div class="fileUpload btn btn-primary">
                                    <span>Upload</span>
                                    <input id="uploadBtn" name="upfile" type="file" class="upload" />

                                </div><br>
                                <input type="submit" value="submit">
                            </form>
                            <%
                                String error = (String) request.getAttribute("uploadError");
                                String uploadedFile = (String) request.getAttribute("success");
                                if (error != null) {
                            %>
                            <br>ERROR: <%=error.toUpperCase()%><br>

                            <%
                                };
                                if (uploadedFile != null) {
                            %>
                            <br><%=uploadedFile.toUpperCase()%><br>
                            <%};%>
                        </CENTER>
                    </div>
                </div>
            </div>
        </div>

        <script src="resources/js/index/classie.js"></script>
        <script src="resources/js/index/indexbotmenu.js"></script>
        <script>
            document.getElementById("uploadBtn").onchange = function () {
                document.getElementById("uploadFile").value = this.value;
            };
        </script>
    </body>
</html>
