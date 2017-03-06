<%@page import="com.app.model.entity.CanvasCompany"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.app.model.CanvasDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/chip.css" type="text/css" rel="stylesheet">
    </head>

    <body>
        <STYLE TYPE="text/css">
            table{
                font-family: Arial; 
                font-size: 10pt;

            }

            td, td[rowspan] {
                vertical-align: top;
                text-align: left;
            }
        </STYLE>
        <!--COMPANIES RESULT INPUT-->
        <div id="rcorners2">
            <h3>Companies:</h3>
            
         <!---   <div class="chip">
                <img src="resources/image/CompanyIcon.png" alt="Person" width="96" height="96">
                Company ABC
            </div>
            <div class="chip">
                <img src="img/CompanyIcon.png" alt="Person" width="96" height="96">
                Company EFG
            </div>
        </div> --->
         
         <%
             String companyName = (String)request.getParameter("companyName");
             out.println("<div class='chip'><img src='resources/image/CompanyIcon.png' alt='Person' width='96' height='96'>"+companyName+"</div>");
             CanvasDAO canvasDAO = new CanvasDAO();
             ArrayList<CanvasCompany> companySelected = canvasDAO.retrieveCompanyDetailsByName(companyName);
           //check if method works:  out.println(companySelected.get(4).getValueDriver());
         %>
        <br>

        <table style="border-bottom: none; width: 703px; height: 418px; margin-left: auto; margin-right: auto; border-collapse: collapse;" border="2px solid black">
            <tbody>
                <tr>
                    <!--KEY PARTNERS-->
                    <td style="width: 150px;border:2px solid black;" rowspan="2">
                        <B>KEY PARTNERS</B>
                        <BR>
                        <%
                            for(CanvasCompany c : companySelected) {
                               //check: out.println("in for");
                                if(c.getValueDriver().toLowerCase().equals("key partnerships")) {
                                   //check: out.println("true");
                                    String choice = c.getChoice();
                                    out.println(choice + "<BR><BR>");
                                    
                                }
                            }
                        %>
                    </td>
                    <!--KEY ACTIVITIES-->
                    <td style="width: 150px;border:2px solid black;">
                        <B>KEY ACTIVITIES</B>
                        <BR>
                        <%
                            for(CanvasCompany c : companySelected) {
                               //check: out.println("in for");
                                if(c.getValueDriver().toLowerCase().equals("key activities")) {
                                   //check: out.println("true");
                                    String choice = c.getChoice();
                                    out.println(choice + "<BR><BR>");
                                    
                                }
                            }
                        %>
                    </td>
                    <!--KEY RESOURCES-->
                    <td style="width: 150px;border:2px solid black;" rowspan="2">
                        <B>KEY RESOURCES</B>
                        <BR>
                        <%
                            for(CanvasCompany c : companySelected) {
                               //check: out.println("in for");
                                if(c.getValueDriver().toLowerCase().equals("key resources")) {
                                   //check: out.println("true");
                                    String choice = c.getChoice();
                                    out.println(choice + "<BR><BR>");
                                    
                                }
                            }
                        %>
                    </td>
                    <!--VALUE PROPOSITION-->
                    <td style="width: 150px;border:2px solid black;">
                        <B>VALUE PROPOSITION</B>
                        <BR>
                        <%
                            for(CanvasCompany c : companySelected) {
                               //check: out.println("in for");
                                if(c.getValueDriver().toLowerCase().equals("value proposition")) {
                                   //check: out.println("true");
                                    String choice = c.getChoice();
                                    out.println(choice + "<BR><BR>");
                                    
                                }
                            }
                        %>
                    </td>
                    <!--CUSTOMER SEGMENTS-->
                    <td style="width: 150px;border:2px solid black;" rowspan="2">
                        <B>CUSTOMER ACQUISITION</B>
                        <BR>
                        <%
                            for(CanvasCompany c : companySelected) {
                               //check: out.println("in for");
                                if(c.getValueDriver().toLowerCase().equals("customer acquisition")) {
                                   //check: out.println("true");
                                    String choice = c.getChoice();
                                    out.println(choice + "<BR><BR>");
                                    
                                }
                            }
                        %>
                    </td>
                </tr>
                <tr>
                    <!--CUSTOMER R/S-->
                    <td style="width: 150px;border:2px solid black;">
                        <B>CUSTOMER RELATIONS</B>
                        <BR>
                        <%
                            for(CanvasCompany c : companySelected) {
                               //check: out.println("in for");
                                if(c.getValueDriver().toLowerCase().equals("customer relations")) {
                                   //check: out.println("true");
                                    String choice = c.getChoice();
                                    out.println(choice + "<BR><BR>");
                                    
                                }
                            }
                        %>
                    </td>
                    <!--CHANNELS-->
                    <td style="width: 150px;border:2px solid black;">
                        <B>CHANNEL STRATEGY</B>
                        <BR>
                        <%
                            for(CanvasCompany c : companySelected) {
                               //check: out.println("in for");
                                if(c.getValueDriver().toLowerCase().equals("channel strategy")) {
                                   //check: out.println("true");
                                    String choice = c.getChoice();
                                    out.println(choice + "<BR><BR>");
                                    
                                }
                            }
                        %>
                    </td>
                </tr>
            </tbody>
        </table>
        <table style="border-top: none; height: 24px; margin-left: auto; margin-right: auto; border-collapse: collapse" border="2px solid black" width="703" cellspacing="1">
            <tbody style="margin-left: auto; margin-right: auto;">
                <tr style="height: 23px;">
                    <!--COST STRUCTURE-->
                    <td style="width: 348px; height: 80px; text-align: center; border:2px solid black;" >
                        <B>COST MANAGEMENT</B>
                        <BR>
                        <%
                            for(CanvasCompany c : companySelected) {
                               //check: out.println("in for");
                                if(c.getValueDriver().toLowerCase().equals("cost management")) {
                                   //check: out.println("true");
                                    String choice = c.getChoice();
                                    out.println(choice + "<BR><BR>");
                                    
                                }
                            }
                        %>
                    </td>
                    <!--REVENUE STREAMS-->
                    <td style="width: 354px; height: 80px; text-align: center; border:2px solid black;">
                        <B>REVENUE STREAMS</B>
                        <BR>
                        <%
                            for(CanvasCompany c : companySelected) {
                               //check: out.println("in for");
                                if(c.getValueDriver().toLowerCase().equals("revenues")) {
                                   //check: out.println("true");
                                    String choice = c.getChoice();
                                    out.println(choice + "<BR><BR>");
                                    
                                }
                            }
                        %>
                        
                    </td>
                </tr>
            </tbody>
        </table>
    </body>
</html>
