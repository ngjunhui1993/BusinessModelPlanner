<%@page import="com.app.model.entity.Demographics"%>
<%
    Demographics user = (Demographics)session.getAttribute("user");
    if(user== null ){
        session.setAttribute("errorMsg","Unauthorise Access. Please Log in");
        response.sendRedirect("Login.jsp");
        return;
    }   
    %>