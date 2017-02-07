<%-- 
    Document   : Bootstrap
    Created on : Feb 6, 2017, 4:32:51 PM
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
        <form action="MainFileUpload"  method="post" enctype="multipart/form-data">
            Upload Company Data file Here: <input type="file" name="upfile" onChange="this.form.submit()">
        </form>
    </body>
</html>
