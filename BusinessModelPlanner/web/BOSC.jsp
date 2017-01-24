<%@include file="Protect.jsp"%>
<!DOCTYPE html>
<!--[if lt IE 7 ]><html class="ie ie6" lang="en"> <![endif]-->
<!--[if IE 7 ]><html class="ie ie7" lang="en"> <![endif]-->
<!--[if IE 8 ]><html class="ie ie8" lang="en"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!-->
<html lang="en">
    <!--<![endif]-->
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <meta name="description" content="">
        <meta name="author" content="">
        <!--[if IE]>
            <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
            <![endif]-->
        <title>SIMHA - Business Model Planner Tool</title>
        <!--REQUIRED STYLE SHEETS-->
        <!-- BOOTSTRAP CORE STYLE CSS -->
        <link href="resources/css/bootstrap.css" rel="stylesheet" />
        <!-- FONTAWESOME STYLE CSS -->
        <link href="resources/css/font-awesome.min.css" rel="stylesheet" />
        <!--ANIMATED FONTAWESOME STYLE CSS -->
        <link href="assets/css/font-awesome-animation.css" rel="stylesheet" />
        <!-- VEGAS STYLE CSS -->
        <link href="resources/scripts/vegas/jquery.vegas.min.css" rel="stylesheet" />
        <!-- SIDE MENU STYLE CSS -->
        <link href="resources/css/component.css" rel="stylesheet" />
        <!-- CUSTOM STYLE CSS -->
        <link href="resources/css/indexStyle.css" rel="stylesheet" />
        <!-- GOOGLE FONT -->
        <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
        <!-- BOSC CSS -->
        <link href="resources/css/BOSC.css" rel="stylesheet" />
        <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
          <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
        <![endif]-->
    </head>
    <body class="cbp-spmenu-push">

        <!-- MAIN HEADING-->
        <div class="for-full-back color-bg-one topbar" id="main-sec">
            <div class="container">
                <div class="row text-center">
                    <div class="col-md-8 col-md-offset-2 ">
                        <h1 class="pad-adjust"><a href="index.jsp"><img class="webapplogo" src="resources/image/webapplogo.png" alt="SIMHA"></a></h1>
                    </div>
                </div>
            </div>
        </div>
        <!--END MAIN HEADING-->
        <!--LEFT SLIDE MENU-->
        <nav class="cbp-spmenu cbp-spmenu-vertical cbp-spmenu-left" id="cbp-spmenu-s1">
            <h3>Models</h3>
            <a href="#">Select Model:</a>
            <a href="#QADIM.jsp"></i>QADIM</a>
            <a href="#price-sec"></i>Blue Ocean Strategy</a>
            <a href="#services-sec"></i>Business Model Canvas</a>
        </nav>

        <div class="row" id="icon-left">
            <div class="col-md-12">
                <i id="showLeftPush" class="fa fa-bars fa-4x faa-horizontal animated"></i>
            </div>
        </div>
        <!--END LEFT SLIDE MENU-->

        <!--RIGHT SLIDE MENU-->
        <nav class="cbp-spmenu cbp-spmenu-vertical cbp-spmenu-right" id="cbp-spmenu-s2">
            <h3>Settings</h3>
            <a href="#">Profile Options :</a>
            <a href="#"><i class="fa fa-pencil fa-2x"></i>Edit Profile</a>
            <a href="Logout"> <i class="fa fa-sign-out fa-2x"></i>Log Out</a>
        </nav>

        <div class="row" id="icon-right">
            <div class="col-md-12">
                <i id="showRightPush" class="fa fa-cog fa-4x "></i>
            </div>
        </div>
        <!--END RIGHT SLIDE MENU-->

        <!--ABOUT SECTION-->
        <section class="for-full-back color-white bodyStart" id="about-models">
            <div class="container">
                <div class="row text-center g-pad-bottom">
                    <div class="col-md-8 col-md-offset-2 ">
                        <h3>Blue Ocean Strategic Canvas</h3>
                    </div>

                </div>

            </div>
        </section>
        <!--END ABOUT SECTION-->

         

        <!-- BOSC BODY SECTION-->
        <section>
            <div class="row g-pad-bottom">
                <div class="legendContainer">
                    <div class="topLabel"></div>
                    <div class="legendNames">
                        LEGEND : &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <i class="fa fa-circle dotA"></i> - Original Curve | 
                        <i class="fa fa-circle dotB"></i> - New Curve 
                    </div>
                </div>
                <div id="container">
                    <div id="labels">
                        <b><div id="topLabel">High</div>
                            <div id="bottomLabel">Low</div></b>
                    </div>
                    <div id="factors">
            <!--            <ul id="sortable">-->
                            <div id="box1" class="box boxOdd">
                                <div class="draggable draggable1">
                                  <i id="dotA1" class="fa fa-circle dotA"></i>
                                </div>
                                <div class="draggable draggable1">
                                  <i id="dotB1" class="fa fa-circle dotB" ></i>
                                </div>
                            </div>
                            <div id="box2" class="box boxEven">
                                <div class="draggable draggable2">
                                  <i id="dotA2" class="fa fa-circle dotA"></i>
                                </div>
                                <div class="draggable draggable2">
                                  <i id="dotB2" class="fa fa-circle dotB"></i>
                                </div>
                            </div>
            <!--            </ul>-->
                    </div>
                      <div id="addBox" type="button">

                            <i id="addLogo" class="fa fa-plus addLogo" aria-hidden="true"></i>
                      </div>
                </div>
                <div class="factorContainer">
                    <div class="labelBottom"></div>
                    <div id="factorsNames" class="factorsNames">
                        <div class="factorName">
                            <span id="factor1" contenteditable="true">Factor 1</span>
                        </div>
                        <div class="factorName">
                            <span id="factor2" contenteditable="true">Factor 2</span>
                        </div>
                    </div>

                </div>
            </div>
            Testing <span id="gy"></span><br />
        </section>
        <!-- END BOSC BODY SECTION-->

        <!--FOOTER SECTION -->
        <div class="for-full-back color-bg-one" id="footer">
            SIMHA Business Model Planner Tool | All Right Reserved

        </div>
        <!-- END FOOTER SECTION -->

        <!-- JAVASCRIPT FILES PLACED AT THE BOTTOM TO REDUCE THE LOADING TIME  -->
        <!-- CORE JQUERY  -->
        <script src="resources/js/jquery-1.10.2.js"></script>
        <!-- BOOTSTRAP CORE SCRIPT   -->
        <script src="resources/js/bootstrap.js"></script>
        <!-- SIDE MENU SCRIPTS -->
        <script src="resources/js/modernizr.custom.js"></script>
        <script src="resources/js/classie.js"></script>
        <!-- VEGAS SLIDESHOW SCRIPTS -->
        <script src="resources/js/jquery.vegas.min.js"></script>
        <!-- CUSTOM SCRIPTS -->
        <script src="resources/js/custom.js"></script>
        <!-- LIGHTBOX SCRIPTS -->
        <script src="resources/js/lightbox-form.js" type="text/javascript"></script>
        <!-- STRATEGY CANVAS SCRIPTS -->
        <script src="resources/js/strategycanvas.js"></script>
        <!-- AJAX JQUERY  -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
        <!-- UI JQUERY  -->
        <script src="https://code.jquery.com/ui/1.11.2/jquery-ui.min.js"></script>
        
    </body>
</html>