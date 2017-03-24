<%-- 
    Document   : BusinessModelCanvas
    Created on : 19 Feb, 2017, 4:20:22 PM
    Author     : Dell
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.app.model.entity.CanvasCompany"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Business Model Canvas</title>
    </head>
    <body>
        <%
        String error = (String) request.getAttribute("errorMsg");
        ArrayList<CanvasCompany> companyList = (ArrayList<CanvasCompany>) request.getAttribute("companySearched");
        %>
        <h1>Find a Company by Name: </h1>
        <br>

        <form action="CanvasController">
            <input type="text" name="companyName">
            <input type="submit" value="Search" name="searchCompany">

        </form>

        <%            
            if (error != null) {
                out.println("<font color='red'>" + error + "</br><br> </font>");
            }
        
            if(companyList != null) {
                for(CanvasCompany c : companyList) {
                    out.println(c.getCompany() + " | " + c.getChoice() + " | " + c.getDescription() + " | " + c.getValueDriver() +"<BR>");
                }
            }
            
if (request.getAttribute("traits")!=null) {
        ArrayList<String> traits = (ArrayList<String>)request.getAttribute("traits");
        for(String trait : traits) {
            out.println(trait);
            out.println("<BR>");
        }
        
    }

if(request.getAttribute("allData")!=null) {
    HashMap<String, ArrayList<String>> allData = (HashMap<String,ArrayList<String>>)request.getAttribute("allData");
    Iterator iter = allData.entrySet().iterator();
    while(iter.hasNext()) {
        out.println(iter.next());
    }
    out.println("<BR><BR>");
    out.println(allData.size());
}
        
    
        %>


    </body>
</html>
