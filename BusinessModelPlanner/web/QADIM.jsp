<%@page import="com.app.model.QaDIMDAO"%>
<%@page import="com.app.model.entity.QadimProduct"%>
<%@page import="com.app.model.entity.Demographics"%>
<%@page import="java.util.ArrayList"%>
<%@include file="Protect.jsp"%>
<%    String error = (String) request.getAttribute("errorMsg");
    String productName = null;
    String projectName = null;
    ArrayList<String> operator1 = new ArrayList<String>();
    ArrayList<String> operator2 = new ArrayList<String>();
    ArrayList<String> operator3 = new ArrayList<String>();
    ArrayList<String> operator4 = new ArrayList<String>();

    if (session.getAttribute("productName") != null) {
        productName = (String) session.getAttribute("productName");
    }
    if (session.getAttribute("projectName") != null) {
        projectName = (String) session.getAttribute("projectName");
    }
    if (session.getAttribute("operator1") != null) {
        operator1 = (ArrayList<String>) session.getAttribute("operator1");
    }
    if (session.getAttribute("operator2") != null) {
        operator2 = (ArrayList<String>) session.getAttribute("operator2");
    }
    if (session.getAttribute("operator3") != null) {
        operator3 = (ArrayList<String>) session.getAttribute("operator3");
    }
    if (session.getAttribute("operator4") != null) {
        operator4 = (ArrayList<String>) session.getAttribute("operator4");
    }
%>
<!DOCTYPE html>
<!--[if lt IE 7 ]><html class="ie ie6" lang="en"> <![endif]-->
<!--[if IE 7 ]><html class="ie ie7" lang="en"> <![endif]-->
<!--[if IE 8 ]><html class="ie ie8" lang="en"> <![endif]-->
<!--[if (gte IE 9)|!(IE)]><!-->
<html lang="en">
    <!--Include header-->
    <%@include file="header.jsp"%>
    <!-- QADIM CSS -->
    <link href='resources/css/QADIM.css' rel='stylesheet' type='text/css'>
    <!-- LIGHTBOX CSS -->
    <link href="resources/css/lightbox-form.css" type="text/css" rel="stylesheet">
    <!--DRAG AND DROP CSS-->
    <link href="resources/css/dragndrop.css" rel="stylesheet" />
    <link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.min.css" rel="stylesheet" type="text/css" />


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
        <span class="boxtitle" >QADIM: New Project</span>
        <form method="GET" name="QADIMbasicform" action="QADIMPageUpdate" target="_parent"  data-toggle="lightbox" onsubmit="return checkRepeat()">

            <p>What is your Project Name?
                <input type="text" name="projectName" maxlength="60" size="60" required>
                Please Enter Product Name
                <input type="text" name="productName" maxlength="60" size="60" required>
            </p>
            <p> 
                <input type="submit" name="submit"><BR>
                <input type="button" name="cancel" value="Cancel" onClick="closebox()"><br>

                <%
                    if (error != null) {
                        out.println("<font color='red'>" + error + "</br><br> </font>");
                    }

                %>
            </p>
        </form>
    </div>

    <div class="box" id="loadProject">
        <span class="boxtitle" >QADIM: Load Project</span>

        <%                String userid = user.getUserid();
            ArrayList<QadimProduct> product = QaDIMDAO.retrieveAllProjects(userid);
        %>
        <form method="GET" action="LoadManager" target="_parent">

            <p>Choose your project to load
                <select class="projectList" name="projectList">
                    <%for (QadimProduct q : product) {%>
                    <option value="<%=q.getProjectName()%>"><%=q.getProjectName()%></option>    
                    <% }%>  
                </select>
            </p>
            <p> 
                <input type="submit" name="submit" value="Load"><BR>

                <%

                    if (error != null) {
                        out.println("<font color='red'>" + error + "</br><br> </font>");
                    }

                %>
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

    <% if (!operator1.isEmpty()) {%>
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
                        Comments<br/>
                        <input type="text" name="comments" maxlength="60" size="60" value="<%=operator1.get(2)%>">
                    </td>
                    <td>
                        Complementary Comments<br/>
                        <input type="text" name="comComments" maxlength="60" size="60" value="<%=operator1.get(3)%>">
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

    <% if (!operator2.isEmpty()) {%>
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
                        Comments<br/>
                        <input type="text" name="comments" maxlength="60" size="60" value="<%=operator1.get(2)%>">
                    </td>
                    <td>
                        Complementary Comments<br/>
                        <input type="text" name="comComments" maxlength="60" size="60" value="<%=operator1.get(3)%>">
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

    <% if (!operator3.isEmpty()) {%>
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
                        Comments<br/>
                        <input type="text" name="comments" maxlength="60" size="60" value="<%=operator1.get(2)%>">
                    </td>
                    <td>
                        Complementary Comments<br/>
                        <input type="text" name="comComments" maxlength="60" size="60" value="<%=operator1.get(3)%>">
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

    <% if (!operator4.isEmpty()) {%>
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
                        Comments<br/>
                        <input type="text" name="comments" maxlength="60" size="60" value="<%=operator1.get(2)%>">
                    </td>
                    <td>
                        Complementary Comments<br/>
                        <input type="text" name="comComments" maxlength="60" size="60" value="<%=operator1.get(3)%>">
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
                    if (productName != null) {
                %>
                <h3><b><%=projectName%></b></h3>
                <form action="MainValidation" >
                                 <div class="row">
                        <div class="col-lg-12">
                            <p>
                                <a href="#" class="btn btn-sq-sm btn-primary">
                                    <i class="glyphicon glyphicon-file fa-2x"></i><br/>
                                    NEW/LOAD PROJECT
                                </a>
                                <a href="#" class="btn btn-sq-sm btn-warning">
                                    <i class="glyphicon glyphicon-save fa-2x"></i><br/>
                                    SAVE
                                </a>
                                <a href="FileDownload" class="btn btn-sq-sm btn-danger">
                                    <i class="glyphicon glyphicon-download fa-2x"></i><br/>
                                    DOWNLOAD
                                </a> 
                            </p>
                        </div>
                    </div>
                    
                    <input type="submit" value="New / Load Project" name="Save"/>
                    <input class="saveButton" type="submit" value="Save" name="Save"/>
                </form>
    
                <table class="QADIM-Table">
                    <tr>
                    <div class="box2" id="addOperator" width="100%">
                        <col style="width:30%">
                        <col style="width:30%">
                        <col style="width:30%">
                        <form method="GET" action="QADIMPageUpdate" target="_parent">
                            <tr border: none>
                                <td><center>
                                <div class="draggable">Add</div>
                                <div class="draggable">Remove</div>
                                <div class="draggable">Raise</div>
                            </center></td>
                             <td><center>
                                <div class="draggable">Reduce</div>
                                <div class="draggable">Combine</div>
                                <div class="draggable">Separate</div>
                            </center></td>
                            <td>
                                <div id="droppableHolder">
                                    Drag desired operator here:<br />    
                                    <input type="text" name="operatorName" id="droppable" />
                                </div>
                                Comments<br/>
                                <input type="text" name="comments" maxlength="60" size="25">
                                <input type="hidden" name="addOperatorCheck" value="">
                                <input type="submit" name="submit">
                            </td>
                            </tr>
                        </form>
                    </div>
                    </tr>
                    <tr>
                        <td id="operator1">
                            <%
                                if (!operator1.isEmpty()) {
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
                                if (!operator2.isEmpty()) {
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
                                if (!operator3.isEmpty()) {
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
                                if (!operator4.isEmpty()) {
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
                                if (!operator4.isEmpty()) {
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
                                if (!operator3.isEmpty()) {
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
                                if (!operator2.isEmpty()) {
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
                                if (!operator1.isEmpty()) {
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
                <% } else { %>

                <button class="QADIMStartButton" onClick="openStep1Box(1)">New Project</button>
                <button class="QADIMLoadButton" onClick="openLoadProjectBox(1)">Load Project</button>
                <% }%>
            </div>
        </div>
    </section>
    <!-- END QADIM BODY SECTION-->

    <!--INCLUDE FOOTER AND JAVASCRIPT -->
    <%@include file="footer.jsp"%>

    <!-- JAVASCRIPT FOR QADIM  -->
    <!-- LIGHTBOX SCRIPTS -->
    <script src="resources/js/lightbox-form.js" type="text/javascript"></script>
    <!--SCRIPTS FOR DRAG AND DROP-->
    <script src="resources/js/dragndrop.js"></script>

</html>
