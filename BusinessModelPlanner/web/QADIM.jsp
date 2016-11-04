<%-- 
    Document   : QADIM
    Created on : Oct 22, 2016, 1:44:59 PM
    Author     : jiaohui.lee.2014
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="com.app.model.entity.QadimProduct"%>
<%@page import="com.app.model.QaDIMDAO"%>
<%@page import="com.app.model.entity.Demographics"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <!--Allows user to upload Product-->
        <form action="MainValidation">
            <label for="projectName"> Project Name </label>
                <input type="text" name="projectName" id="projectName"/> <br>
            <label for="product">Product</label>
                <input type="text" name="productName" id="product" /> <br>
                
                
            <% 
                int operatorId =0; //need to increase based on number of operator below
                Demographics user = (Demographics)session.getAttribute("user");
                int numberOfBoxes = Integer.parseInt(request.getParameter("numberOfBoxes"));
                for(int j = 1; j<=numberOfBoxes ;j++){ 
                    operatorId++;
            %>
                <label for="operator">Operator Name</label>
                    <input type="text" name="operatorName<%=j%>" id="operator" /> <br>
                <label for="verb">Verb</label>
                    <input type="text" name="verb<%=j%>" id="verb"/> <br>
                <label for="generalPhrase">General Phase</label>
                    <input type="text" name="generalPhrase<%=j%>" id="generalPhrase"/> <br> <!--Assuming it is 1 line text now -->
                <label for="specificPhrase">Specific Phase</label>
                    <input type="text" name="specificPhrase<%=j%>" id="specificPhrase" /> <br> <!--Assuming user key all phases -->
                <label for="dimension">Dimension</label>
                    <input type="text" name="dimension<%=j%>" id="dimension" /> <br>

                    <input type="hidden" name="operatorId<%=j%>" value="<%=operatorId%>"/>
                    <input type="hidden" name="userID" value="<%=user.getEmail().substring(0, user.getEmail().indexOf("@"))%>"/>

            <%
                }
            %>
                <input type="hidden" name="numberOfBoxes" value="<%=numberOfBoxes%>"/>
                <input type="submit" value="Submit"/>
        </form>
        
        <!--Retrieves ALL projects uploaded to be deleted-->
        <form action="QADIMManager">
            <%  
                String userId = user.getEmail().substring(0,user.getEmail().indexOf("@"));
                ArrayList<QadimProduct> qList= (ArrayList<QadimProduct>)session.getAttribute("allProjects");
                if (qList!=null){%>
            Select Project:
                <select name="toDelete">
                   <% for(QadimProduct q: qList){%>
                   <option value="<%=q.getProjectName()%>"><%=q.getProjectName()%></option>
                   <%}%>
                </select>
                <%}%>    
                <input type="hidden" name="userId" value="<%=userId%>"/>
                <input type="submit" value="Delete" />
        </form>
        
        <!--To Edit a Project-->
        <form action="QADIMEdit.jsp">
            <%             
                if (qList!=null){%>
            Select Project:
                <select name="toEdit">
                   <% for(QadimProduct q: qList){%>
                   <option value="<%=q.getProjectName()%>"><%=q.getProjectName()%></option>
                   <%}%>
                </select>
                <%}%>    
                <input type="hidden" name="userId" value="<%=userId%>"/>
                <input type="submit" value="Edit" />
        </form>
    </body>
</html>
