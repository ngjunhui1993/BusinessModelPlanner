<%@include file="Protect.jsp"%>
<html>
    <%@include file="header.jsp"%>
        <section class="for-full-back color-white bodyStart" id="about-models">
            <div class="container">
                <div class="row text-center g-pad-bottom allBody">
                    <div class="col-md-8 col-md-offset-2 ">
                        <h3>Innovation Models<br>
                            Please Select One of The Models to Work On
                        </h3>
                    </div>

                    <div class="col-md-12 ">
                        <div class="col-md-4 col-sm-4 col-xs-6">
                            <a href="QADIM.jsp" class="btn btn-danger btn-lg head-btn-one">QADIM</a> 
                        </div>
                        <div class="col-md-4 col-sm-4 col-xs-6">
                            <a href="BOSC.jsp" class="btn btn-primary btn-lg">Blue Ocean Strategy</a>
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
  
                <%                    if (user.getType().equals("administrator")) {
                %>
                <form action="Admin.jsp">
                    <input type="submit" value="Access Admin Page"/>
                </form>
                <%
                    }
                %>
            </div>

     <%@include file="footer.jsp"%>

</html>