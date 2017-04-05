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
        <title>Admin Page</title>
    </head>
    <body>
        <div class="main">
            <div style="background: #424242; width:100%; height:200px; color:#fff;">
                <center>
                    <img src="resources/image/webapplogo.png" alt="SIMHA" width="300" style='padding-top:35px;'><br>
                </center>
                <div style='margin:20px;'>
                    <%    String name = user.getName().toUpperCase();
                    %>
                    <h4>WELCOME, ADMINISTRATOR <%=name%></h4>
                    <h4 style='margin-top: -20px;'>ADMINISTRATOR PAGE</h4>
                </div>
            </div>
            <div>
                This page allows you to upload data for Business Model Buffet<br>
                <form action="MainFileUpload"  method="post" enctype="multipart/form-data">
                    Upload Company Data file Here: <input type="file" name="upfile" onChange="this.form.submit()">
                </form>
            </div>
    </body>
</html>
