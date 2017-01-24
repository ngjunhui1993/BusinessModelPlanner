<%-- 
    Document   : AddingBosOperator
    Created on : 10 Jan, 2017, 10:01:51 AM
    Author     : Dell
--%>

<%@page import="com.app.model.BOSDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
        <form action="BOSUpdate">
            <p>
                Operator Name: <input type="text" name="operatorName"><BR>
                Weight (0-5): <input type="text" name="weight"><BR>
                Maximum Value: <input type="text" name="maxValue"><BR>
                Incremental Cost Per Unit Increase: <input type="text" name="costPerUnit"><BR>                  
                <input type="submit" name="addOperator" value="Add An Operator">
            </p>
        </form>
    <%
            String projectName = (String) session.getAttribute("bosProjectName");
            String operatorName = request.getParameter("operatorName");
            String weight = request.getParameter("weight");
            String maxValue = request.getParameter("maxValue");
            String costPerUnit = request.getParameter("costPerUnit");
            String error = (String) request.getAttribute("errorMsg");
            
            //out.println(projectName);
            
        

            if (error != null) {
                out.println("<font color='red'>" + error + "</br><br> </font>");
            }

        
    %>
    
</html>
