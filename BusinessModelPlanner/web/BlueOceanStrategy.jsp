<%-- 
    Document   : BlueOceanStrategy
    Created on : 7 Jan, 2017, 8:20:29 PM
    Author     : Dell
--%>

<%@page import="com.app.model.entity.BOSProduct"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.app.model.entity.Demographics"%>
<%@page import="com.app.model.BOSDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Blue Ocean Strategy</title>
        <%
            String error = (String) request.getAttribute("errorMsg");
            BOSDAO bosDAO = new BOSDAO();
            Demographics loggedIn = (Demographics) session.getAttribute("user");
            String loggedInUser = loggedIn.getUserid();
        %>
    </head>
    <body>
        <form action="BOSUpdate">
            <p>What is your Project Name?
                <input type="text" name="projectName" maxlength="60" size="60">
                Product/Service: 
                <select name="type">
                    <option value="typeProduct">Product</option>
                    <option value="typeService">Service</option>
                </select>
                Please Enter Name
                <input type="text" name="productName" maxlength="60" size="60">
                Budget of Product/Service:
                <input type="text" name="budget" maxlength="60" size="60">
            </p>
            <p> 
                <input type="submit" name="createProject" value="Create New Project!"><BR>
        </form>
        <BR><BR>

        <form action="BOSUpdate">
            Load Project: 
            <select name="existingProject">
                <%
                    ArrayList<BOSProduct>existingProjs = bosDAO.retrieveAllProjectsByUser(loggedInUser);
                    for(BOSProduct proj : existingProjs) {
                        out.println("<option value='" + proj.getProjectName() + "'>" + proj.getProjectName() + "</option>");
                    }
                %>
            </select>
            <input type="submit" name="loadProject" value="Load Project!"><BR>
        </form>
        <%            if (error != null) {
                out.println("<font color='red'>" + error + "</br><br> </font>");
            }

        %>


    </body>
</html>
