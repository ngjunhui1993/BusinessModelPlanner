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
        <a href="Logout"><i class="fa fa-sign-out fa-2x"></i>Log Out</a>
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
            <div class="row text-center g-pad-bottom allBody">
                <div class="col-md-8 col-md-offset-2 ">
                    <h3>Innovation Models</h3>
                    <h4>
                        Please Select One of The ModelS to Work On
                    </h4>
                </div>

            </div>
            <div class="row text-center g-pad-bottom">
                <div class="col-md-12 ">
                    <div class="col-md-4 col-sm-4 col-xs-6">
                        <a href="QADIM.jsp" class="btn btn-danger btn-lg head-btn-one">QADIM</a> 
                    </div>
                    <div class="col-md-4 col-sm-4 col-xs-6">
                        <a href="BlueOceanStrategy" class="btn btn-primary btn-lg">Blue Ocean Strategy</a>
                    </div>
                    <div class="col-md-4 col-sm-4 col-xs-6">
                        <a href="BusinessModelCanvas" class="btn btn-success btn-lg">Business Model Canvas</a>
                    </div>
                </div>
            </div>
            <div class="row g-pad-bottom">
                <div class="col-md-4 text-center">
                    <h3>QADIM</h3>
                    <p>
                        QADIM also known as Quick and Dirty Innovation Method
                    </p>
                </div>
                <div class="col-md-4 text-center">
                    <h3>Blue Ocean Strategy</h3>
                    <p>
                        Blue Ocean Strategy explanation
                    </p>
                </div>
                                <div class="col-md-4 text-center">
                    <h3>Business Model Canvas</h3>
                    <p>
                        Business Model Canvas explanations
                    </p>
                </div>
            </div>

        </div>
    </section>
    <!--END ABOUT SECTION-->

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

</body>
</html>
