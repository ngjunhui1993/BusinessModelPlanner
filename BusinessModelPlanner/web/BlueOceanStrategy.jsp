<%-- 
    Document   : BlueOceanStrategy
    Created on : 7 Jan, 2017, 8:20:29 PM
    Author     : Dell
--%>

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
            </p>
            <p> 
                <input type="submit" name="submit"><BR>
        </form>

        <%

            if (error != null) {
                out.println("<font color='red'>" + error + "</br><br> </font>");
            } 

        %>
        
        
    </body>
</html>
