<%-- 
    Document   : Admin
    Created on : Jan 19, 2017, 7:22:33 PM
    Author     : jiaohui.lee.2014
--%>

<%@page import="com.app.model.entity.Group"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.app.model.entity.Demographics"%>
<%@page import="com.app.model.GroupDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
    </head>
    <body>
        <h1>Administrator Page</h1>
        Current Groups: <br />
        <%
            Demographics user = (Demographics)request.getSession().getAttribute("user");
            ArrayList<Group> existingGroups= GroupDAO.retrieveGroupsByInstructor(user.getEmail());
            if(existingGroups!=null){
                for(Group g: existingGroups){
                %>
                <a href="groupView"><%=g.getSection()%></a><br/>
                <%
                }
            }
        %>
        <br />
        Create Group
        <form action="GroupManager">
            Course: <input type="text" name="course"/> <br>
            Section: <input type="text" name="session"/> <br>
            Course Code: <input type="text" name="courseId"/> <br>
            Password: <input type="password" name="password" /> <br>
            <input type="submit" value="Create Group"/>
        </form>
        
    </body>
</html>
