<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html ng-app="BusinessModelCanvas">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/style.css">
    </head>
    <body>
        <h1>RESULT PAGE</h1>
        <H2>COMPANY NAME; </H2>
    <body ng-controller="RootController">

        <div class="container">
            <div class="row">
                <div class="col-md-4 title">The Business Model Canvas</div>

                <div class="row">
                    <table class="table table-bordered canvas-table">
                        <tbody>
                            <tr ng-repeat="row in tableLayout">
                                <td ng-repeat="cell in row"
                                    ng-controller="SectionController"
                                    class="canvas-cell"
                                    ng-class="{'tall-cell':  cell.rowspan == 2,
                               'short-cell': cell.rowspan == 1}"
                                    rowspan="{{cell.rowspan}}"
                                    colspan="{{cell.colspan}}">
                                    <div class="table-cell">
                                        <span>{{cell.title}}</span>
                                        <ul>
                                            <li ng-repeat="item in doc.sections[one.keyPartners]">
                                            Hello
                                            </li>

                                        </ul>


                                    </div>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>

            <script src="js/angular.js" type="text/javascript"></script>
            <script src="js/ui-utils.js" type="text/javascript"></script>
            <script src="js/code.js" type="text/javascript"></script>
    </body>
</html>
