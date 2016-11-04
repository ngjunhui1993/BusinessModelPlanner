<%-- 
    Document   : QADIMEdit
    Created on : Oct 28, 2016, 9:44:15 PM
    Author     : jiaohui.lee.2014
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.app.model.entity.Operator"%>
<%@page import="com.app.model.entity.QadimProduct"%>
<%@page import="com.app.model.QaDIMDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>QADIM Edit Page</title>
    </head>
    <body>
        <%
            String projectName = request.getParameter("toEdit");
            QadimProduct product = QaDIMDAO.retrieveProject(projectName);
            ArrayList<Operator> operators = QaDIMDAO.retrieveOperators(product.getProductID(), product.getUserID());
            int counter = 0;
        %>
        <form action="QADIMManager">
            <% 
            for(Operator o : operators){
                counter++;
            %>            
                <table>
                    <tr>
                        <td>
                            Operator Name: 
                        </td>
                        <td>
                            <input type="text" name="operatorName<%=counter%>" value="<%=o.getOperatorName()%>"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Verb:
                        </td>
                        <td>
                            <input type="text" name="verb<%=counter%>" value="<%=o.getVerb()%>"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            General Phrase:
                        </td>
                        <td>
                            <input type="text" name="generalPhrase<%=counter%>" value="<%=o.getGeneralPhrase()%>"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Specific Phrase:
                        </td>
                        <td>
                            <input type="text" name="specificPhrase<%=counter%>" value="<%=o.getSpecificPhrase()%>"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Dimensions:
                        </td>
                        <td>
                            <input type="text" name="dimensions<%=counter%>" value="<%=o.getDimensions()%>"/>
                        </td>
                    </tr>
                </table>
            <%}%>
        </form>
        <input type="hidden" name="toEdit" value="<%=product.getProductID()%>"/>
        <input type="hidden" name="userId" value="<%=product.getUserID()%>"/>
        <input type="submit" value="Edit"/>
       
        
    </body>
</html>
