<%@include file="Protect.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>SIMHA INNOVATION MODEL</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link rel="stylesheet" type="text/css" href="resources/css/index/pullupmenu.css" />
        <link rel="stylesheet" type="text/css" href="resources/css/index/hover.css" />
        <script src="resources/js/index/snap.svg-min.js"></script>
        <!--[if IE]>
        <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->
    </head>
    <body>
        <div class="indexcontainer" style="width:100%">
            <nav id="menu" class="menu">
                <button class="menu__handle"><span>Menu</span></button>
                <div class="menu__inner">
                    <ul>
                        <li><a href="Logout">LOGOUT</a></li>
                            <%                                if (user.getType().equals("administrator")) {
                            %>
                        <li><a href="Admin.jsp">ADMIN PAGE</a></li>
                            <%
                                }
                            %>
                    </ul>
                </div>
                <div class="morph-shape" data-morph-open="M-10,100c0,0,44-95,290-95c232,0,290,95,290,95" data-morph-close="M-10,100c0,0,44,95,290,95c232,0,290-95,290-95">
                    <svg width="100%" height="100%" viewBox="0 0 560 200" preserveAspectRatio="none">
                    <path fill="none" d="M-10,100c0,0,44,0,290,0c232,0,290,0,290,0"/>
                    </svg>
                </div>
            </nav>
            <!--BODY-->
            <div class="main" style="width:100%">
                <div style="background: #424242; width:100%; height:180px; color:#fff;">
                    <center>
                        <img src="resources/image/webapplogo.png" alt="SIMHA" width="300" style='padding-top:35px;'><br>
                    </center>
                    <div style='margin:20px;'>
                        <%    String name = user.getName().toUpperCase();
                        %>
                        <h4>WELCOME, <%=name%></h4>
                    </div>
                </div>
                <div class="row text-center g-pad-bottom allBody">
                    <div>
                        <h4>SELECT YOUR BUSINESS INNOVATION MODEL</h4>
                    </div>

                    <div class="col-md-12 ">
                        <div class="col-md-4 col-sm-4 col-xs-6">
                            <a href="QADIMindex.jsp" class="hvr-float-shadow">
                                <img border="0" class="hvr-float-shadow" alt="QADIM" src="resources/image/QADIM.png" width="250" height="300">
                            </a>
                        </div>

                        <div class="col-md-4 col-sm-4 col-xs-6">
                            <a href="BOSC.jsp" class="hvr-float-shadow">
                                <img border="0" class="hvr-float-shadow"alt="BOSC" src="resources/image/BOS.png" width="250" height="300">
                            </a>
                        </div>
                        <div class="col-md-4 col-sm-4 col-xs-6">
                            <a href="BusinessModelCanvas.jsp" class="hvr-float-shadow">
                                <img border="0" class="hvr-float-shadow" alt="BMC" src="resources/image/BMC.png" width="250" height="300">
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <script src="resources/js/index/classie.js"></script>
        <script src="resources/js/index/indexbotmenu.js"></script>
    </body>
</html>
