<%@page import="java.util.ArrayList"%>
<%
    String productName = null;
    String projectName = null; 
    ArrayList<String> operator1 = new ArrayList<String>();
    ArrayList<String> operator2 = new ArrayList<String>(); 
    ArrayList<String> operator3 = new ArrayList<String>();
    ArrayList<String> operator4 = new ArrayList<String>();

    if(session.getAttribute("productName") != null){
        productName = (String) session.getAttribute("productName");
    }
    if(session.getAttribute("projectName")!= null){
        projectName =(String) session.getAttribute("projectName");
    }
    if(session.getAttribute("operator1")!= null){
        operator1 = (ArrayList<String>) session.getAttribute("operator1");
    }
    if(session.getAttribute("operator2")!= null){
        operator2 =(ArrayList<String>) session.getAttribute("operator2");
    }
    if(session.getAttribute("operator3")!= null){
        operator3 =(ArrayList<String>) session.getAttribute("operator3");
    }
    if(session.getAttribute("operator4")!= null){
        operator4 =(ArrayList<String>) session.getAttribute("operator4");
    }
%>
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
    <title>Happy6Friends - FYP</title>
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
    <!-- QADIM CSS -->
    <link href='resources/css/QADIM.css' rel='stylesheet' type='text/css'>
    <!-- LIGHTBOX CSS -->
    <link href="resources/css/lightbox-form.css" type="text/css" rel="stylesheet">
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
                    <h1 class="pad-adjust"><i class="fa fa-plus faa-pulse animated"></i>FYP</h1>
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
        <h3>SOCIAL</h3>
        <a href="#">MY SOCIAL PRESENCE</a>
        <a href="#"><i class="fa fa-facebook fa-3x"></i>Facebook</a>
        <a href="#"><i class="fa fa-twitter fa-3x"></i>Twitter</a>
        <a href="#"><i class="fa fa-linkedin fa-3x"></i>Linked In</a>
        <a href="#"><i class="fa fa-google-plus fa-3x"></i>Google Plus</a>
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
                    <h3>QADIM - Quick and Dirty Innovation Model</h3>
                    <h4>
                        Quick and Dirty Innovation Model
                    </h4>
                </div>

            </div>

        </div>
    </section>
    <!--END ABOUT SECTION-->
    <div class="shadowing" id="shadowing"></div>
    <div class="box" id="step1">
      <span class="boxtitle" >QADIM: Step 1</span>
      <form method="GET" action="QADIMPageUpdate" target="_parent">

        <p>What is your Project Name?
          <input type="text" name="projectName" maxlength="60" size="60">
          Please Enter Product Name
          <input type="text" name="productName" maxlength="60" size="60">
        </p>
        <p> 
          <input type="submit" name="submit">
          <input type="button" name="cancel" value="Cancel" onClick="closebox()">
        </p>
      </form>
    </div>
    
    <div class="box" id="editProduct">
      <span class="boxtitle" >QADIM: Edit Product Name</span>
      <form method="GET" action="QADIMPageUpdate" target="_parent">

        <p>
          Please Enter Product Name
          <input type="text" name="productName" maxlength="60" size="60" value="<%=productName%>">
        </p>
        <p> 
          <input type="submit" name="submit">
          <input type="button" name="cancel" value="Cancel" onClick="closebox()">
        </p>
      </form>
    </div>
        
    <div class="box2" id="addOperator">
      <span class="boxtitle2" >QADIM: Add Operator</span>
      <form method="GET" action="QADIMPageUpdate" target="_parent">

        <p>
        <table>
            <tr>
                <td>
                    Operator Name<br/>
                    <input type="text" name="operatorName" maxlength="60" size="60">
                </td>
                <td>
                    Complementary Operator Name<br/>
                    <input type="text" name="comOperatorName" maxlength="60" size="60">
                </td>
            </tr>
                        <tr>
                <td>
                    Enter Verb<br/>
                    <input type="text" name="verb" maxlength="60" size="60">
                </td>
                <td>
                    Enter Complementary Verb<br/>
                    <input type="text" name="comVerb" maxlength="60" size="60">
                </td>
            </tr>
            <tr>
                <td>
                    General Phrase<br/>
                    <input type="text" name="generalPhrase" maxlength="60" size="60">
                </td>
                <td>
                    Complementary General Phrase<br/>
                    <input type="text" name="comGeneralPhrase" maxlength="60" size="60">
                </td>
            </tr>
            <tr>
                <td>
                    Specific Phrase<br/>
                    <input type="text" name="specificPhrase" maxlength="60" size="60">
                </td>
                <td>
                    Complementary Specific Phrase<br/>
                    <input type="text" name="comSpecificPhrase" maxlength="60" size="60">
                </td>
            </tr>
            <tr>
                <td>
                    Dimension<br/>
                    <input type="text" name="dimension" maxlength="60" size="60">
                </td>
                <td>
                    Complementary Dimension<br/>
                    <input type="text" name="comDimension" maxlength="60" size="60">
                </td>
            </tr>
            <input type="hidden" name="addOperatorCheck" value="">
        </table>
        </p>
        <p> 
          <input type="submit" name="submit">
          <input type="button" name="cancel" value="Cancel" onClick="closebox()">
        </p>
      </form>
    </div>
        
    <% if (!operator1.isEmpty()){ %>
    <div class="box2" id="editOperator1">
      <span class="boxtitle2" >QADIM: Edit Operator 1</span>
      <form method="GET" action="QADIMPageUpdate" target="_parent">
          <br/>
          <input type="hidden" name="operator1" id="operator1">
          
        <p>
        <table>
            <tr>
                <td>
                    Operator Name<br/>
                    <input type="text" name="operatorName" maxlength="60" size="60" value="<%=operator1.get(0)%>">
                </td>
                <td>
                    Complementary Operator Name<br/>
                    <input type="text" name="comOperatorName" maxlength="60" size="60" value="<%=operator1.get(1)%>">
                </td>
            </tr>
                        <tr>
                <td>
                    Enter Verb<br/>
                    <input type="text" name="verb" maxlength="60" size="60" value="<%=operator1.get(2)%>">
                </td>
                <td>
                    Enter Complementary Verb<br/>
                    <input type="text" name="comVerb" maxlength="60" size="60" value="<%=operator1.get(3)%>">
                </td>
            </tr>
            <tr>
                <td>
                    General Phrase<br/>
                    <input type="text" name="generalPhrase" maxlength="60" size="60" value="<%=operator1.get(4)%>">
                </td>
                <td>
                    Complementary General Phrase<br/>
                    <input type="text" name="comGeneralPhrase" maxlength="60" size="60" value="<%=operator1.get(5)%>">
                </td>
            </tr>
            <tr>
                <td>
                    Specific Phrase<br/>
                    <input type="text" name="specificPhrase" maxlength="60" size="60" value="<%=operator1.get(6)%>">
                </td>
                <td>
                    Complementary Specific Phrase<br/>
                    <input type="text" name="comSpecificPhrase" maxlength="60" size="60" value="<%=operator1.get(7)%>">
                </td>
            </tr>
            <tr>
                <td>
                    Dimension<br/>
                    <input type="text" name="dimension" maxlength="60" size="60" value="<%=operator1.get(8)%>">
                </td>
                <td>
                    Complementary Dimension<br/>
                    <input type="text" name="comDimension" maxlength="60" size="60" value="<%=operator1.get(9)%>">
                </td>
            </tr>
        </table>
        </p>
        <p>
          <input type="submit" name="submit" value="Delete">
          <input type="submit" name="submit">
          <input type="button" name="cancel" value="Cancel" onClick="closeOpBox1()">
        </p>
      </form>
    </div>
    <%}%>            
    
    <% if (!operator2.isEmpty()){ %>
    <div class="box2" id="editOperator2">
      <span class="boxtitle2" >QADIM: Edit Operator 2</span>
      <form method="GET" action="QADIMPageUpdate" target="_parent">
          <br/>
          <input type="hidden" name="operator2" id="operator2">
          

        <p>
        <table>
            <tr>
                <td>
                    Operator Name<br/>
                    <input type="text" name="operatorName" maxlength="60" size="60" value="<%=operator2.get(0)%>">
                </td>
                <td>
                    Complementary Operator Name<br/>
                    <input type="text" name="comOperatorName" maxlength="60" size="60" value="<%=operator2.get(1)%>">
                </td>
            </tr>
                        <tr>
                <td>
                    Enter Verb<br/>
                    <input type="text" name="verb" maxlength="60" size="60" value="<%=operator2.get(2)%>">
                </td>
                <td>
                    Enter Complementary Verb<br/>
                    <input type="text" name="comVerb" maxlength="60" size="60" value="<%=operator2.get(3)%>">
                </td>
            </tr>
            <tr>
                <td>
                    General Phrase<br/>
                    <input type="text" name="generalPhrase" maxlength="60" size="60" value="<%=operator2.get(4)%>">
                </td>
                <td>
                    Complementary General Phrase<br/>
                    <input type="text" name="comGeneralPhrase" maxlength="60" size="60" value="<%=operator2.get(5)%>">
                </td>
            </tr>
            <tr>
                <td>
                    Specific Phrase<br/>
                    <input type="text" name="specificPhrase" maxlength="60" size="60" value="<%=operator2.get(6)%>">
                </td>
                <td>
                    Complementary Specific Phrase<br/>
                    <input type="text" name="comSpecificPhrase" maxlength="60" size="60" value="<%=operator2.get(7)%>">
                </td>
            </tr>
            <tr>
                <td>
                    Dimension<br/>
                    <input type="text" name="dimension" maxlength="60" size="60" value="<%=operator2.get(8)%>">
                </td>
                <td>
                    Complementary Dimension<br/>
                    <input type="text" name="comDimension" maxlength="60" size="60" value="<%=operator2.get(9)%>">
                </td>
            </tr>
        </table>
        </p>
        <p>
          <input type="submit" name="submit" value="Delete">
          <input type="submit" name="submit">
          <input type="button" name="cancel" value="Cancel" onClick="closeOpBox2()">
        </p>
      </form>
    </div>
    <% } %>
    
    <% if (!operator3.isEmpty()){ %>
    <div class="box2" id="editOperator3">
      <span class="boxtitle2" >QADIM: Edit Operator 3</span>
      <form method="GET" action="QADIMPageUpdate" target="_parent">
          <br/>
          <input type="hidden" name="operator3" id="operator3">
          

        <p>
        <table>
            <tr>
                <td>
                    Operator Name<br/>
                    <input type="text" name="operatorName" maxlength="60" size="60" value="<%=operator3.get(0)%>">
                </td>
                <td>
                    Complementary Operator Name<br/>
                    <input type="text" name="comOperatorName" maxlength="60" size="60" value="<%=operator3.get(1)%>">
                </td>
            </tr>
                        <tr>
                <td>
                    Enter Verb<br/>
                    <input type="text" name="verb" maxlength="60" size="60" value="<%=operator3.get(2)%>">
                </td>
                <td>
                    Enter Complementary Verb<br/>
                    <input type="text" name="comVerb" maxlength="60" size="60" value="<%=operator3.get(3)%>">
                </td>
            </tr>
            <tr>
                <td>
                    General Phrase<br/>
                    <input type="text" name="generalPhrase" maxlength="60" size="60" value="<%=operator3.get(4)%>">
                </td>
                <td>
                    Complementary General Phrase<br/>
                    <input type="text" name="comGeneralPhrase" maxlength="60" size="60" value="<%=operator3.get(5)%>">
                </td>
            </tr>
            <tr>
                <td>
                    Specific Phrase<br/>
                    <input type="text" name="specificPhrase" maxlength="60" size="60" value="<%=operator3.get(6)%>">
                </td>
                <td>
                    Complementary Specific Phrase<br/>
                    <input type="text" name="comSpecificPhrase" maxlength="60" size="60" value="<%=operator3.get(7)%>">
                </td>
            </tr>
            <tr>
                <td>
                    Dimension<br/>
                    <input type="text" name="dimension" maxlength="60" size="60" value="<%=operator3.get(8)%>">
                </td>
                <td>
                    Complementary Dimension<br/>
                    <input type="text" name="comDimension" maxlength="60" size="60" value="<%=operator3.get(9)%>">
                </td>
            </tr>
        </table>
        </p>
        <p>
          <input type="submit" name="submit" value="Delete">
          <input type="submit" name="submit">
          <input type="button" name="cancel" value="Cancel" onClick="closeOpBox3()">
        </p>
      </form>
    </div>
    <% } %> 
    
    <% if (!operator4.isEmpty()){ %>
    <div class="box2" id="editOperator4">
      <span class="boxtitle2" >QADIM: Edit Operator 4</span>
      <form method="GET" action="QADIMPageUpdate" target="_parent">
          <br/>
          <input type="hidden" name="operator4" id="operator4">

        <p>
        <table>
            <tr>
                <td>
                    Operator Name<br/>
                    <input type="text" name="operatorName" maxlength="60" size="60" value="<%=operator4.get(0)%>">
                </td>
                <td>
                    Complementary Operator Name<br/>
                    <input type="text" name="comOperatorName" maxlength="60" size="60" value="<%=operator4.get(1)%>">
                </td>
            </tr>
                        <tr>
                <td>
                    Enter Verb<br/>
                    <input type="text" name="verb" maxlength="60" size="60" value="<%=operator4.get(2)%>">
                </td>
                <td>
                    Enter Complementary Verb<br/>
                    <input type="text" name="comVerb" maxlength="60" size="60" value="<%=operator4.get(3)%>">
                </td>
            </tr>
            <tr>
                <td>
                    General Phrase<br/>
                    <input type="text" name="generalPhrase" maxlength="60" size="60" value="<%=operator4.get(4)%>">
                </td>
                <td>
                    Complementary General Phrase<br/>
                    <input type="text" name="comGeneralPhrase" maxlength="60" size="60" value="<%=operator4.get(5)%>">
                </td>
            </tr>
            <tr>
                <td>
                    Specific Phrase<br/>
                    <input type="text" name="specificPhrase" maxlength="60" size="60" value="<%=operator4.get(6)%>">
                </td>
                <td>
                    Complementary Specific Phrase<br/>
                    <input type="text" name="comSpecificPhrase" maxlength="60" size="60" value="<%=operator4.get(7)%>">
                </td>
            </tr>
            <tr>
                <td>
                    Dimension<br/>
                    <input type="text" name="dimension" maxlength="60" size="60" value="<%=operator4.get(8)%>">
                </td>
                <td>
                    Complementary Dimension<br/>
                    <input type="text" name="comDimension" maxlength="60" size="60" value="<%=operator4.get(9)%>">
                </td>
            </tr>
        </table>
        </p>
        <p>
          <input type="submit" name="submit" value="Delete">
          <input type="submit" name="submit">
          <input type="button" name="cancel" value="Cancel" onClick="closeOpBox4()">
        </p>
      </form>
    </div>
    <% } %>
    
    <!-- QADIM BODY SECTION-->
    <section>
        <div class="container">
            <div class="row g-pad-bottom QADIM-Body">
                
                <% 
                if (productName != null){
                %>
                <h3><%=projectName%></h3>
                <form action="MainValidation" >
                <!--<button class="QADIMSaveButton" >Save</button>-->
                    <input type="submit" value="Save" name="Save"/>
                </form>
                <button class="QADIMAddOperatorButton" onClick="openAddOperatorBox(1)">Add Operator</button>
                <!--<button class="QADIMExportButton" >Export</button>-->
                <br>
                <a href="FileDownload">File Download </a> <br />
                <table class="QADIM-Table">
                    <tr>
                        <td id="operator1">
                          <%
                          if (!operator1.isEmpty()){
                          %>
                              <button class="operator1" onClick="openEditOperator1('1', 1)">
                                        <%=operator1.get(0)%><br/>
                                        <%=operator1.get(2)%>
                              </button>
                          <%
                          }
                          %>
                        </td>
                        <td id="operator2">
                          <%
                          if (!operator2.isEmpty()){
                          %>
                              <button class="operator2" onClick="openEditOperator2('2', 1)">
                                        <%=operator2.get(0)%><br/>
                                        <%=operator2.get(2)%>
                              </button>
                          <%
                          }
                          %>
                        </td>
                        <td id="operator3">
                          <%
                          if (!operator3.isEmpty()){
                          %>
                              <button class="operator3" onClick="openEditOperator3('3', 1)">
                                        <%=operator3.get(0)%><br/>
                                        <%=operator3.get(2)%>
                              </button>
                          <%
                          }
                          %>
                        </td>
                      </tr>
                      <tr>
                          <td id="operator4">
                          <%
                          if (!operator4.isEmpty()){
                          %>
                              <button class="operator4" onClick="openEditOperator4('4', 1)">
                                        <%=operator4.get(0)%><br/>
                                        <%=operator4.get(2)%>
                              </button>
                          <%
                          }
                          %>
                          </td>
                        <td id="product">
                              <button class="productBtn" onClick="openEditProductBox(1)">
                                  <%=productName%>
                              </button>
                        </td>
                        <td id="complimentary4">
                          <%
                          if (!operator4.isEmpty()){
                          %>
                              <button class="operator4" onClick="openEditOperator4('4', 1)">
                                        <%=operator4.get(1)%><br/>
                                        <%=operator4.get(3)%>
                              </button>
                          <%
                          }
                          %>
                        </td>
                    </tr>
                    <tr>
                        <td id="complimentary3">
                            <%
                            if (!operator3.isEmpty()){
                            %>
                                <button class="operator3" onClick="openEditOperator3('3', 1)">
                                          <%=operator3.get(1)%><br/>
                                          <%=operator3.get(3)%>
                                </button>
                            <%
                            }
                            %>
                        </td>
                        <td id="complimentary2">
                        <%
                        if (!operator2.isEmpty()){
                        %>
                            <button class="operator2" onClick="openEditOperator2('2', 1)">
                                      <%=operator2.get(1)%><br/>
                                      <%=operator2.get(3)%>
                            </button>
                        <%
                        }
                        %>
                        </td>
                        <td id="complimentary1">
                        <%
                        if (!operator1.isEmpty()){
                        %>
                            <button class="operator1" onClick="openEditOperator1('1', 1)">
                                      <%=operator1.get(1)%><br/>
                                      <%=operator1.get(3)%>
                            </button>
                        <%
                        }
                        %>
                        </td>
                    </tr>
                </table>
                <% } else{ %>

                    <button class="QADIMStartButton" onClick="openStep1Box(1)">Click Here To Begin</button>

                <% } %>
            </div>
        </div>
    </section>
    <!-- END QADIM BODY SECTION-->

    <!--FOOTER SECTION -->
    <div class="for-full-back color-bg-one" id="footer">
        2014 www.yourdomain.com | All Right Reserved | Terms | Policies | Licenses 
         
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

</body>
</html>
