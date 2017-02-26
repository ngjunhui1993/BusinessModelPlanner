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
                        <br/>
                        <h2><span class="projectTitle" id="projectTitle" contenteditable="true">Enter Project Title</span></h2>
                        <button class="BOSCSaveButton" id="save" type="button">Save</button><br/>
                        <a class="downloadButton" href="FileDownload" ><i class="fa fa-download fa-3x" aria-hidden="true"></i> Download Project</a> <br />
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
                <div class="row">
                    <div id="valuesContainer" class="valuesContainer">
                        <div class="valueContainer">
                            Current Value: 
                            <span class="value original" id="currentValue" contenteditable="true">0</span>
                        </div>
                        <div class="valueContainer">
                            New Value: 
                            <span class="value new" id="newValue" contenteditable="false">0</span>
                        </div>
                        <div class="valueContainer">
                            <input id="indicationCheck" type="checkbox"/>Adjust Higher Weight First Indicator
                        </div>
                    </div>

                </div>
                <div class="indicationContainer">
                    <div class="labelTop"></div>
                    <div id="indicationNames" class="indicationNames">
                        <div class="indicationBox">
                            <span class="indication" id="indication1" contenteditable="false"></span><br/>
                        </div>
                        <div class="indicationBox">
                            <span class="indication" id="indication2" contenteditable="false"></span><br/>
                           
                        </div>
                    </div>

                </div>
                <div id="container">
                    <div id="labels">
                        <b><div id="topLabel">High - 8</div>
                            <div id="bottomLabel">Low - 0</div></b>
                    </div>
                    <div id="factors">
            <!--            <ul id="sortable">-->
                            <div id="box1" class="box boxOdd">
                                <div class="draggable draggable1A draggable1 ">
                                  <i id="dotA1" class="fa fa-circle dotA"></i>
                                </div>
                                <div class="draggable draggable1B draggable1 dotBottom">
                                  <i id="dotB1" class="fa fa-circle dotB" ></i>
                                </div>
                            </div>
                            <div id="box2" class="box boxEven">
                                <div class="draggable draggable2 draggable2A">
                                  <i id="dotA2" class="fa fa-circle dotA"></i>
                                </div>
                                <div class="draggable draggable2 draggable2B dotBottom">
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
                        <div class="factorBox">
                            <span class="factorName" id="factor1" contenteditable="true">Factor 1</span><br/>
                            Weight: 
                            <select class="weight" id="weight1">
                                <option value="1">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                                <option value="5">5</option>
                            </select><br/>
                            Grid:  
                            <select id="grid1">
                                <option value="0">0</option>
                                <option value="1">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                                <option value="5">5</option>
                                <option value="6">6</option>
                                <option value="7">7</option>
                                <option value="8" selected="selected">8</option>
                            </select><br/>
                            Value: 
                            <span class="factorValue" id="value1" contenteditable="false">0</span>
                        </div>
                        <div class="factorBox">
                            <span class="factorName" id="factor2" contenteditable="true">Factor 2</span><br/>
                            Weight:
                            <select class="weight" id="weight2">
                                <option value="1">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                                <option value="5">5</option>
                            </select><br/>
                            Grid:  
                            <select id="grid2">
                                <option value="0">0</option>
                                <option value="1">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                                <option value="5">5</option>
                                <option value="6">6</option>
                                <option value="7">7</option>
                                <option value="8" selected="selected">8</option>
                            </select><br/>
                            Value: 
                            <span class="factorValue" id="value2" contenteditable="false">0</span>
                        </div>
                    </div>

                </div>
            </div>
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
