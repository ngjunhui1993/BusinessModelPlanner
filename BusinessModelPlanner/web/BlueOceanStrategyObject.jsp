<%-- 
    Document   : BlueOceanStrategyObject
    Created on : 7 Jan, 2017, 9:26:45 PM
    Author     : Dell
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.TreeMap"%>
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

        /*    ArrayList<BOSOperator> currentOperatorsAccordingToWeight = bosDAO.getAllOperatorsAccordingToWeight(projectName, loggedInUser);
            if (currentOperatorsAccordingToWeight != null && currentOperatorsAccordingToWeight.size() != 0) {
                out.println("Current Operators: <BR>");
                for (BOSOperator op : currentOperatorsAccordingToWeight) {
                    out.println(op.getOperatorID() + ". " + op.getOperatorName() + ", " + op.getWeight());
                }
            } else {
                out.println("no record leh.");
            } */
        
          HashMap<Integer, ArrayList<BOSOperator>> operatorMap = bosDAO.getAllOperators(loggedInUser, projectName);
          if(operatorMap != null & !operatorMap.isEmpty()) {
            //  out.println(operatorMap.keySet().iterator().next());
              out.println("<u>current operators:</u><br>");
              //out.println(operatorMap.values());
              if(operatorMap.containsKey(5)) {
                  ArrayList<BOSOperator> weight5Ops = operatorMap.get(5);
                  for(BOSOperator op : weight5Ops) {
                      out.println(op.getOperatorID() + ". " + op.getOperatorName() + ", " + op.getWeight() + "<BR>");
                  }
              }
              if(operatorMap.containsKey(4)) {
                  ArrayList<BOSOperator> weight4Ops = operatorMap.get(4);
                  for(BOSOperator op : weight4Ops) {
                      out.println(op.getOperatorID() + ". " + op.getOperatorName() + ", " + op.getWeight() + "<BR>");
                  }
              }
              if(operatorMap.containsKey(3)) {
                  ArrayList<BOSOperator> weight3Ops = operatorMap.get(3);
                  for(BOSOperator op : weight3Ops) {
                      out.println(op.getOperatorID() + ". " + op.getOperatorName() + ", " + op.getWeight() + "<BR>");
                  }
              }
              if(operatorMap.containsKey(2)) {
                  ArrayList<BOSOperator> weight2Ops = operatorMap.get(2);
                  for(BOSOperator op : weight2Ops) {
                      out.println(op.getOperatorID() + ". " + op.getOperatorName() + ", " + op.getWeight() + "<BR>");
                  }
              }
              if(operatorMap.containsKey(1)) {
                  ArrayList<BOSOperator> weight1Ops = operatorMap.get(1);
                  for(BOSOperator op : weight1Ops) {
                      out.println(op.getOperatorID() + ". " + op.getOperatorName() + ", " + op.getWeight() + "<BR>");
                  }
              }
              if(operatorMap.containsKey(0)) {
                  ArrayList<BOSOperator> weight0Ops = operatorMap.get(0);
                  for(BOSOperator op : weight0Ops) {
                      out.println(op.getOperatorID() + ". " + op.getOperatorName() + ", " + op.getWeight() + "<BR>");
                  }
              } 
             
             /*   Iterator<Integer> iter = operatorMap.keySet().iterator();
                out.println(iter.next());*/
              
              
          } else {
              out.println("no operators added yet.");
          }

        %>
    </body>
</html>
