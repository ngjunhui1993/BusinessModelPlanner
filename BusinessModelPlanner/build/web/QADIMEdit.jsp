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
            String userid = (String)session.getAttribute("user");
            ArrayList<QadimProduct> product = QaDIMDAO.retrieveAllProjects(userid);
        %>
        <form action="QADIMManager">
            <% 
            
       
        %>
    </body>
</html>
