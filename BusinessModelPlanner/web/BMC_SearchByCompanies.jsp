<%@page import="com.app.model.entity.CanvasCompany"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.app.model.CanvasDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="resources/css/demo.css">
        <link rel="stylesheet" href="resources/css/listnav.css">
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
                            </div>
                        </div>
                        <br><br><br>
                        </td>
                        </tr>
                        <tr>
                            <td>
                                <!--Company List-->

                                <ul id="demoSix" class="demo imageList"> 
                                    <br>
                                    
                                    <%
                                        CanvasDAO canvasDAO = new CanvasDAO();
                                        ArrayList<String> companyList = canvasDAO.retrieveAllCompanies();
                                        for(String name : companyList) {
                                            out.println("<li><img src='resources/image/CompanyIcon.png' width='40' height='40'><a href='BMC_Results_2.jsp?companyName="+name+"'>"+name+"</a><p class='last-name'>"+name+"</p></li>");
                                        }
                                    %>

                                    

                            </td>
                        </tr>
        </table>
        <script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
        <script src="resources/js/jquery-listnav.js"></script>
        <script src='https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.js'></script>
        <script src='https://cdn.rawgit.com/mohbasheer/angular-chips/master/dist/angular-chips.min.js'></script>
        <script src='https://cdn.rawgit.com/angular-ui/bootstrap-bower/master/ui-bootstrap.js'></script>
        <script src='https://cdn.rawgit.com/angular-ui/bootstrap-bower/master/ui-bootstrap-tpls.js'></script>
        <script src="resources/js/autofill.js"></script>
        <script>
                                            $(function () {

                                            $('#demoSix').listnav({
                                            filterSelector: '.last-name',
                                                    includeNums: false,
                                                    removeDisabled: true,
                                                    allText: 'All Companies',
                                                    showCounts: false,
                                                    noMatchText: 'No match found'
                                            });
                                                    $('.demo a').click(function (e) {
                                            e.preventDefault();
                                            });
                                            });
        </script>

    </body>
</html>