<%@include file="Protect.jsp"%>
<html>
    <%@include file="header.jsp"%>
    <head>
        <link href="resources/css/hover.css" rel="stylesheet">
    </head>
    <section class="for-full-back color-white bodyStart" id="about-models">
        <div class="container">
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

            <%                    if (user.getType().equals("administrator")) {
            %>
            <form action="Admin.jsp">
                <input type="submit" value="Access Admin Page"/>
            </form>
            
            <form action="Bootstrap.jsp">
                <input type="submit" value="Upload Data into Database"/>
            </form>
            <%
                }
            %>
        </div>

        <%@include file="footer.jsp"%>

</html>