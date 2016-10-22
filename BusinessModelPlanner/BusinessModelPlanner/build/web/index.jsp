<%-- 
    Document   : index.jsp
    Created on : Oct 11, 2016, 5:52:02 PM
    Author     : jiaohui.lee.2014
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="QADIM.jsp" method="post">
            
            Number of Boxes:
            <select name="numberOfBoxes">
                <% for (int i = 1; i<=16;i++){ %>
                    <option value="<%=i%>"><%=i%></option>
                <%}%>
            </select> <br>
            
            <input type="submit" value="Select" />
            
            

            
        </form>
    </body>
</html>
