<%-- 
    Document   : BlueOceanStrategyObject
    Created on : 7 Jan, 2017, 9:26:45 PM
    Author     : Dell
--%>

<%@page import="com.app.model.entity.BOSOperator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.app.model.entity.Demographics"%>
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
            String projectName = (String) session.getAttribute("bosProjectName");
            Demographics loggedIn = (Demographics) session.getAttribute("user");
            // System.out.println(loggedIn.getUserid());
            String loggedInUser = loggedIn.getUserid();
            BOSProduct product = bosDAO.retrieveProject(projectName);
        %>
        <p>
            Project Name: <%=product.getProjectName()%><BR>
            Product Name: <%=product.getProductName()%><BR>
            Type: <%=product.getType()%><BR>
            Budget: <%=product.getBudget()%><BR>
        </p>
        <p>

            <a href="AddingBosOperator.jsp">Add an Operator</a><BR>
            current num of operators: <%=bosDAO.retrieveOperators(projectName, loggedInUser).size()%>
        </p>
        <%

            ArrayList<BOSOperator> currentOperatorsAccordingToWeight = bosDAO.getAllOperatorsAccordingToWeight(projectName, loggedInUser);
            if (currentOperatorsAccordingToWeight != null) {
                out.println("Current Operators: <BR>");
                for (BOSOperator op : currentOperatorsAccordingToWeight) {
                    out.println(op.getOperatorID() + ". " + op.getOperatorName() + ", " + op.getWeight());
                }
            } else {
                out.println("no record leh.");
            }

        %>
    </body>
</html>
