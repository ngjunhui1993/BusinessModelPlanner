<%-- 
    Document   : QADIMEdit
    Created on : Oct 28, 2016, 9:44:15 PM
    Author     : jiaohui.lee.2014
--%>

<%@page import="com.app.model.entity.Demographics"%>
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
            Demographics user = (Demographics)session.getAttribute("user");
            String userid = user.getUserid();
            ArrayList<QadimProduct> product = QaDIMDAO.retrieveAllProjects(userid);

        %>
        <form action="QADIMManager">
            <select name="project">
                <%for(QadimProduct q: product){%>
            <option value="<%=q.getProjectName()%>"><%=q.getProjectName()%></option>    
           <% }%>  
            </select>
            <br>
            <input type="submit" value="Edit Project" name="edit"/>
            <input type="submit" value="Delete Project" name="delete"/>
        </form>
            <% 
            String successMsg = (String)request.getAttribute("successMsg");
            if(successMsg!=null){
                out.println(successMsg);
            }
        %>
    </body>
</html>
