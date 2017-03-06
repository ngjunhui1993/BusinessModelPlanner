<%@page import="java.util.Scanner"%>
<%@page import="com.app.model.entity.CanvasCompany"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.app.model.CanvasDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="resources/css/bmc-searchcom-style.css">
        <link rel="stylesheet" href="resources/css/bmc-searchcom-listnav.css">
        <script src="resources/js/jquery-1.11.2.min.js"></script>
        <link rel='stylesheet prefetch' href='https://cdn.rawgit.com/mohbasheer/angular-chips/master/dist/main.css'>
        <link rel='stylesheet prefetch' href='https://cdn.rawgit.com/angular-ui/bootstrap-bower/master/ui-bootstrap-csp.css'>
        <link rel='stylesheet prefetch' href='https://cdn.rawgit.com/components/font-awesome/master/css/font-awesome.min.css'>
        <link rel='stylesheet prefetch' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css'>
        <link rel="stylesheet" href="resources/css/autofill.css">


    </head>
    <body>
        <table align="center">
            <tr>
                <td>
                    Search by Companies<br><br>
                    <!--Auto Search Function-->
                    <div ng-app="sample">
                        <br>
                        <div ng-controller="basicController as typeahead">
                            <chips ng-model="typeahead.companies">
                                <chip-tmpl>
                                    <div class="default-chip">
                                        {{chip}}
                                        <span class="glyphicon glyphicon-remove" remove-chip></span>
                                    </div>
                                </chip-tmpl>
                                <input ng-model-control ng-model="typeaheadmodel" uib-typeahead="company for company in typeahead.availableCompanies | filter:$viewValue"></input>
                            </chips>
                            <!-- Printing controller value -->

                            <div class="printvalue">
                                <b>Controller:</b>
                                <div> typeahead.companies = {{typeahead.companies}}</div>

                                <form action="CanvasController">
                                    <input type="text" value={{typeahead.companies}} name="companiesSearched" hidden>
                                    <input type="submit" name="searchCompany">
                                </form>

                                <%
                                    String error = (String) request.getAttribute("errorMsg");
                                    if (error != null) {
                                        out.println("<font color='red'>" + error + "</br><br> </font>");
                                    }
                                %>

                                <%
                                    String input = "{{typeahead.companies}}";
                                    //       out.println(input);
                                    /*  if(input.length()==2) {
                                     input = null;
                                     } else {
                                     input = input.substring(2, input.length()-2);
                                     out.println(input);
                                     } */


                                %>
                            </div>
                        </div>
                        <br><br><br>
                        </td>
                        </tr>
                        <tr>
                            <td>
                                <!--Company List-->

                                <ul id="demoFour" class="demo"><br>

                                    <%                                        
                                        CanvasDAO canvasDAO = new CanvasDAO();
                                        ArrayList<String> companyList = canvasDAO.retrieveAllCompanies();
                                        for (String name : companyList) {
                                            %>
                                    <li><a href='BMC_Results_2.jsp?companyName=<%=name%>'><%=name%></a>
                                    </li>
                                    <%
                                        
                                            }
                                    %>
                                </ul>


                                    </td>
                                    </tr>
                                    </table>

                                    <script src='https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.js'></script>
                                    <script src='https://cdn.rawgit.com/mohbasheer/angular-chips/master/dist/angular-chips.min.js'></script>
                                    <script src='https://cdn.rawgit.com/angular-ui/bootstrap-bower/master/ui-bootstrap.js'></script>
                                    <script src='https://cdn.rawgit.com/angular-ui/bootstrap-bower/master/ui-bootstrap-tpls.js'></script>
                                    <script src="resources/js/autofill.js"></script>
                                    <script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
                                    <script src="resources/js/bmc-searchcom-listnav.js"></script>

                                    <script>
                                            $(function () {
                                            $('#demoFour').listnav({
                                            includeAll: true,
                                                    includeNums: true,
                                                    showCounts: false,
                                                    allText: 'All Companies',
                                                    onClick: function (letter) {
                                                    $(".myLastClicked").text(letter.toUpperCase());
                                                    }
                                            });
                                            });
                                    </script>

                                    </body>
                                    </html>
