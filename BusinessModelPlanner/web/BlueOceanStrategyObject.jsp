<%-- 
    Document   : BlueOceanStrategyObject
    Created on : 7 Jan, 2017, 9:26:45 PM
    Author     : Dell
--%>

<%@page import="com.app.model.entity.BOSProduct"%>
<%@page import="com.app.model.BOSDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Blue Ocean Strategy</title>
    </head>
    <body>
        <%
            BOSDAO bosDAO = new BOSDAO();
            String projectName = (String)session.getAttribute("bosProjectName");
            BOSProduct product = bosDAO.retrieveProject(projectName);
            String error = (String)request.getAttribute("errorMsg");
        %>
        <form action="BOSUpdate">
            <p>
                Project Name: <%=product.getProjectName()%><BR>
                Product Name: <%=product.getProductName()%><BR>
                Type: <%=product.getType()%><BR>
                Budget: <%=product.getBudget()%><BR>
            </p>
            <p>
                Operator Name: <input type="text" name="operatorName"><BR>
                Weight (0-5): <input type="text" name="weight"><BR>
                Maximum Value: <input type="text" name="maxValue"><BR>
                Incremental Cost Per Unit Increase: <input type="text" name="costPerUnit"><BR>                  
                <input type="submit" name="addOperator" value="Add An Operator">
            </p>
        </form>
        <%
            
            if (error != null) {
                out.println("<font color='red'>" + error + "</br><br> </font>");
            }

        %>
    </body>
</html>
