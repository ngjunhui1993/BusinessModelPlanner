<%@include file="Protect.jsp"%>
<!DOCTYPE html>
<html lang="en">
    <%@include file="header.jsp"%>
    <!-- BOSC CSS -->
    <link href="resources/css/BOSC.css" rel="stylesheet" />

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
        
        <!--INCLUDE FOOTER AND JAVASCRIPT -->
        <%@include file="footer.jsp"%>
        
        <!-- JAVASCRIPT FOR BOSC  -->
        <!-- STRATEGY CANVAS SCRIPTS -->
        <script src="resources/js/strategycanvas.js"></script>
        <!-- UI JQUERY  -->
        <script src="https://code.jquery.com/ui/1.11.2/jquery-ui.min.js"></script>
        
        <!-- END FOOTER SECTION -->

</html>
