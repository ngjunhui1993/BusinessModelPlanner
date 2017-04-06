<%@page import="com.app.model.entity.CanvasCompany"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.app.model.CanvasDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="Protect.jsp"%>
<!DOCTYPE html>
<html>
    <%@include file="newHeader.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SIMHA INNOVATION MODEL</title>
        <link rel="stylesheet" type="text/css" href="resources/css/bmc/bmc-resultpage.css" />
        <link rel="stylesheet" type="text/css" href="resources/css/bmc/bmc-component.css" />
    </head>
    <body>
        <!--COMPANIES RESULT INPUT-->
        <div class="body">
            <div style="width:1500px; margin:50px 250px;">
                <h2>BUSINESS MODEL CANVAS RESULT</h2>
                <div><table style="width:500px;">
                        <tr>
                            <%                    CanvasDAO canvasDAO = new CanvasDAO();
                                ArrayList<CanvasCompany> companySelected = new ArrayList<>();
                                ArrayList<CanvasCompany> allCompaniesSelected = new ArrayList<>();
                                //if it was redirected from searching of traits:
                                ArrayList<String> companiesMatched = new ArrayList<>();
                                int number = 0;
                                if (request.getAttribute("companiesMatched") != null) {
                                    companiesMatched = (ArrayList<String>) request.getAttribute("companiesMatched");
                                    if (request.getAttribute("maxValue") != null) {
                                        number = (Integer) request.getAttribute("maxValue");
                                    }
                                    for (String name : companiesMatched) {
                            %>
                            <td style="color:#fff;"><h2 style="margin-bottom:-5px; margin-top:2px;"><%=name.toUpperCase()%></h2>
                                <b>Number of Traits Matched: </b><%=number%>
                            </td>
                            <%
                                    companySelected = canvasDAO.retrieveCompanyDetailsByName(name);
                                    for (CanvasCompany c : companySelected) {
                                        allCompaniesSelected.add(c);
                                    }
                                }
                            } else {
                                String companyName = (String) request.getParameter("companyName");
                                String[] companies = (String[]) request.getAttribute("companiesSearched");
                                boolean singleCompany = true;
                                boolean multipleCompanies = true;

                                if (companyName == null || companyName.equals("")) {
                                    singleCompany = false;
                                    if (companies == null || companies.length == 0) {
                                        multipleCompanies = false;
                                        if (request.getParameter("searchByTraits") == null) {
                                            request.setAttribute("errorMsg", "Please do not leave any blanks.");
                                            RequestDispatcher rd = request.getRequestDispatcher("BusinessModelCanvas.jsp");
                                            rd.forward(request, response);
                                    return;
                                }
                            }
                        }

                        if (singleCompany) {%>
                            <td style="color:#fff;"><h2 style="margin-bottom:-5px; margin-top:-20px;">COMPANY SELECTED: <%=companyName.toUpperCase()%></h2>
                            </td>
                            <%
                                        allCompaniesSelected = canvasDAO.retrieveCompanyDetailsByName(companyName);
                                    } else if (multipleCompanies) {
                                        for (String name : companies) {
                                            out.println(name);
                                            companySelected = canvasDAO.retrieveCompanyDetailsByName(name);
                                            for (CanvasCompany c : companySelected) {
                                                allCompaniesSelected.add(c);
                                            }
                                        }
                                    } else {

                                    }
                                }
                            %>
                        </tr></table>
                    <br>
                </div>
                <table class="table top-table">
                    <tbody>
                        <tr>
                            <!--KEY PARTNERS-->
                            <td rowspan="2">
                                <B>KEY PARTNERS</B>
                                <BR>
                                <%
                                    for (CanvasCompany c : allCompaniesSelected) {
                                        //check: out.println("in for");
                                        if (c.getValueDriver().toLowerCase().equals("key partnerships")) {
                                            //check: out.println("true");
                                            String choice = c.getChoice();
                                            out.println(choice + "<BR>");

                                        }
                                    }
                                %>
                            </td>
                            <!--KEY ACTIVITIES-->
                            <td>
                                <B>KEY ACTIVITIES</B>
                                <BR>
                                <%
                                    for (CanvasCompany c : allCompaniesSelected) {
                                        //check: out.println("in for");
                                        if (c.getValueDriver().toLowerCase().equals("key activities")) {
                                            //check: out.println("true");
                                            String choice = c.getChoice();
                                            out.println(choice + "<BR>");

                                        }
                                    }
                                %>
                            </td>
                            <!--KEY RESOURCES-->
                            <td rowspan="2">
                                <B>KEY RESOURCES</B>
                                <BR>
                                <%
                                    for (CanvasCompany c : allCompaniesSelected) {
                                        //check: out.println("in for");
                                        if (c.getValueDriver().toLowerCase().equals("key resources")) {
                                            //check: out.println("true");
                                            String choice = c.getChoice();
                                            out.println(choice + "<BR>");

                                        }
                                    }
                                %>
                            </td>
                            <!--VALUE PROPOSITION-->
                            <td>
                                <B>VALUE PROPOSITION</B>
                                <BR>
                                <%
                                    for (CanvasCompany c : allCompaniesSelected) {
                                        //check: out.println("in for");
                                        if (c.getValueDriver().toLowerCase().equals("value proposition")) {
                                            //check: out.println("true");
                                            String choice = c.getChoice();
                                            out.println(choice + "<BR>");

                                        }
                                    }
                                %>
                            </td>
                            <!--CUSTOMER SEGMENTS-->
                            <td rowspan="2">
                                <B>CUSTOMER ACQUISITION</B>
                                <BR>
                                <%
                                    for (CanvasCompany c : allCompaniesSelected) {
                                        //check: out.println("in for");
                                        if (c.getValueDriver().toLowerCase().equals("customer acquisition")) {
                                            //check: out.println("true");
                                            String choice = c.getChoice();
                                            out.println(choice + "<BR>");

                                        }
                                    }
                                %>
                            </td>
                        </tr>
                        <tr>
                            <!--CUSTOMER R/S-->
                            <td>
                                <B>CUSTOMER RELATIONS</B>
                                <BR>
                                <%
                                    for (CanvasCompany c : allCompaniesSelected) {
                                        //check: out.println("in for");
                                        if (c.getValueDriver().toLowerCase().equals("customer relations")) {
                                            //check: out.println("true");
                                            String choice = c.getChoice();
                                            out.println(choice + "<BR>");

                                        }
                                    }
                                %>
                            </td>
                            <!--CHANNELS-->
                            <td>
                                <B>CHANNEL STRATEGY</B>
                                <BR>
                                <%
                                    for (CanvasCompany c : allCompaniesSelected) {
                                        //check: out.println("in for");
                                        if (c.getValueDriver().toLowerCase().equals("channel strategy")) {
                                            //check: out.println("true");
                                            String choice = c.getChoice();
                                            out.println(choice + "<BR>");

                                        }
                                    }
                                %>
                            </td>
                        </tr>
                    </tbody>
                </table>
                <table class="table bottom-table">
                    <tbody style="margin-left: auto; margin-right: auto;">
                        <tr>
                            <!--COST STRUCTURE-->
                            <td>
                                <B>COST MANAGEMENT</B>
                                <BR>
                                <%
                                    for (CanvasCompany c : allCompaniesSelected) {
                                        //check: out.println("in for");
                                        if (c.getValueDriver().toLowerCase().equals("cost management")) {
                                            //check: out.println("true");
                                            String choice = c.getChoice();
                                            out.println(choice + "<BR>");

                                        }
                                    }
                                %>
                            </td>
                            <!--REVENUE STREAMS-->
                            <td>
                                <B>REVENUE STREAMS</B>
                                <BR>
                                <%
                                    for (CanvasCompany c : allCompaniesSelected) {
                                        //check: out.println("in for");
                                        if (c.getValueDriver().toLowerCase().equals("revenues")) {
                                            //check: out.println("true");
                                            String choice = c.getChoice();
                                            out.println(choice + "<BR>");

                                        }
                                    }
                                %>

                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
