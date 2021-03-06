<%@page import="java.util.Scanner"%>
<%@page import="com.app.model.entity.CanvasCompany"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.app.model.CanvasDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="Protect.jsp"%>
<!DOCTYPE html>
<html>
    <%@include file="newHeader.jsp"%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SIMHA INNOVATION MODEL</title>
        <!--CSS FOR INDEX-->
        <link rel="stylesheet" type="text/css" href="resources/css/bmc/bmc-component.css" />
        <!--CSS FOR TOOLTIPS-->
        <link rel="stylesheet" type="text/css" href="resources/css/tooltips.css" />
        <!--CSS FOR COMPANY SEARCH-->
        <link rel="stylesheet" href="resources/css/bmc/bmc-searchcom-style.css">
        <link rel="stylesheet" href="resources/css/bmc/bmc-searchcom-listnav.css"> 
        <!--CSS FOR COMPANY AUTOFILL-->
        <!--CSS FOR DRIVERS SEARCH-->
        <link rel="stylesheet" type="text/css" href="resources/css/bmc/bmc-searchdrivers-component.css" />
        <!--CSS FOR DRIVERS SEARCH SELECT SCRIPTS-->
        <link rel="stylesheet" href="resources/css/bmc/bmc-searchdrivers-valuedropdownlist.css">
        <link rel="stylesheet" type="text/css" href="resources/css/qadim/qadimButton.css" />
    </head>
    <body>
        <section>
            <div class="container">	
                <div class="tooltipcontent">
                    <div class="dummy dummy-text">
                        <span class="tooltip-item" style="font-size:1.8em">BUSINESS MODEL BUFFET</span><br>
                        allows users to source through an existing list of
                        implementation choices across all 9 value drivers, and generate the closest matching company that fits your selection.
                        You can also generate all the value drivers pertaining to a specific company, and gather inspiration for your own business model.
                    </div>
                </div>    

            </div>
        </section>
        <div id="bl-main" class="bl-main">
            <!--SECTION FOR SEARCH COMPANIES-->
            <section>
                <div class="bl-box">
                    <h2 class="bl-icon bl-icon-about">Search by Companies</h2>
                </div>
                <!--CONTENT-->
                <div class="bl-content">
                    <h2>SEARCH BY COMPANIES</h2>
                    <!--Auto Search Function-->
                    <br><br>
                    <div>
                        <ul id="demoFour" class="demoFourClass">
                            <%                                        CanvasDAO canvasDAO = new CanvasDAO();
                                ArrayList<String> companyList = canvasDAO.retrieveAllCompanies();
                                for (String name : companyList) {
                            %>
                            <li><a href='BMC_Results.jsp?companyName=<%=name%>'><%=name%></a>
                            </li>
                            <%

                                }
                            %>

                        </ul>
                    </div>
                </div>
                <!--CLOSE BUTTON-->
                <span class="bl-icon bl-icon-close"></span>
            </section>
            <!--SECTION CLOSED-->

            <!--SECTION FOR SEARCH BY DRIVERS-->
            <section id="bl-work-section">
                <div class="bl-box">
                    <h2 class="bl-icon bl-icon-works">Search by Drivers</h2>
                </div>
                <div class="bl-content">
                    <form action="CanvasController">
                        <h2>SEARCH BY DRIVERS</h2>
                        <div>
                            <div class="container demo-3">
                                <ul class="grid cs-style-4">
                                    <!--KEY PARTNERS-->
                                    <li>
                                        <figure>
                                            <div><img src="resources/image/keypartners.jpg" alt="keypartners"></div>
                                            <figcaption>
                                                <h3>Key Partners</h3>
                                                <!--SEARCH OPTIONS-->
                                                <%
                                                    CanvasDAO cDAO = new CanvasDAO();
                                                    ArrayList<String> traits = cDAO.retrieveTraitsByDriver("key_partnerships");
                                                    //      out.println(traits.size());
                                                    if (traits.size() > 0) {
                                                %>
                                                <div class="multiselect" id="keyPartnerSelect">
                                                    <div class="selectBox" onclick="keyPartners()">
                                                        <select>
                                                            <option>Select an option</option>
                                                        </select>
                                                        <div class="overSelect"></div>
                                                    </div>
                                                    <div class="checkboxes" id="keyPartners">
                                                        <!--LOAD DATA HERE-->
                                                        <%
                                                            for (String trait : traits) {%>
                                                        <label><input type='checkbox' name='allTheTraits' value='<%=trait%>'><%=trait%></label><%};%>
                                                    </div>
                                                </div>

                                                <%} else {%>There are currently no traits available<%};%>


                                            </figcaption>
                                        </figure>
                                    </li>

                                    <!--KEY ACTIVITIES-->
                                    <li>
                                        <figure>
                                            <div><img src="resources/image/keyactivities.jpg" alt="img06"></div>
                                            <figcaption>
                                                <h3>Key Activities</h3>
                                                <!--SEARCH OPTIONS-->
                                                <%                                                    traits = cDAO.retrieveTraitsByDriver("key_activities");
                                                    //      out.println(traits.size());
                                                    if (traits.size() > 0) {
                                                %>

                                                <div class="multiselect" id="keyActivitiesSelect">
                                                    <div class="selectBox" onclick="keyactivities()">
                                                        <select>
                                                            <option>Select an option</option>
                                                        </select>
                                                        <div class="overSelect"></div>
                                                    </div>
                                                    <div class="checkboxes" id="keyactivities">
                                                        <!--LOAD DATA HERE-->
                                                        <%
                                                            for (String trait : traits) {%>
                                                        <label><input type='checkbox' name='allTheTraits' value='<%=trait%>'><%=trait%></label><%};%>
                                                    </div>
                                                </div>
                                                <%} else {%>There are currently no traits available<%};%>

                                            </figcaption>
                                        </figure>
                                    </li>

                                    <li>
                                        <figure>
                                            <div><img src="resources/image/keyresources.jpg" alt="img02"></div>
                                            <figcaption>
                                                <h3>Key Resources</h3>
                                                <!--SEARCH OPTIONS-->
                                                <%
                                                    traits = cDAO.retrieveTraitsByDriver("key_resources");
                                                    //      out.println(traits.size());
                                                    if (traits.size() > 0) {
                                                %>

                                                <div class="multiselect" id="keyResourcesSelect">
                                                    <div class="selectBox" onclick="keyresources()">
                                                        <select>
                                                            <option>Select an option</option>
                                                        </select>
                                                        <div class="overSelect"></div>
                                                    </div>
                                                    <div class="checkboxes" id="keyresources">
                                                        <!--LOAD DATA HERE-->
                                                        <%
                                                            for (String trait : traits) {%>
                                                        <label><input type='checkbox' name='allTheTraits' value='<%=trait%>'><%=trait%></label><%};%>
                                                    </div>
                                                </div>
                                                <%} else {%>There are currently no traits available<%};%>

                                            </figcaption>
                                        </figure>
                                    </li>
                                    <li>
                                        <figure>
                                            <div><img src="resources/image/valueproposition.jpg" alt="img04"></div>
                                            <figcaption>
                                                <h3>Value Proposition</h3>
                                                <!--SEARCH OPTIONS-->
                                                <%
                                                    traits = cDAO.retrieveTraitsByDriver("value_proposition");
                                                    //      out.println(traits.size());
                                                    if (traits.size() > 0) {
                                                %>

                                                <div class="multiselect" id="valuePropositionSelect">
                                                    <div class="selectBox" onclick="valueproposition()">
                                                        <select>
                                                            <option>Select an option</option>
                                                        </select>
                                                        <div class="overSelect"></div>
                                                    </div>
                                                    <div class="checkboxes" id="valueproposition">
                                                        <!--LOAD DATA HERE-->
                                                        <%
                                                            for (String trait : traits) {%>
                                                        <label><input type='checkbox' name='allTheTraits' value='<%=trait%>'><%=trait%></label><%};%>
                                                    </div>
                                                </div>
                                                <%} else {%>There are currently no traits available<%};%>

                                            </figcaption>
                                        </figure>
                                    </li>
                                    <li>
                                        <figure>
                                            <div><img src="resources/image/customersegments.jpg" alt="img01"></div>
                                            <figcaption>
                                                <h3>Customer Segments</h3>
                                                <!--SEARCH OPTIONS-->
                                                <%
                                                    traits = cDAO.retrieveTraitsByDriver("customer_acquisition");
                                                    if (traits.size() > 0) {
                                                    //      out.println(traits.size());
                                                %>
                                                <div class="multiselect" id="customerSegmentSelect">
                                                    <div class="selectBox" onclick="customersegments()">
                                                        <select>
                                                            <option>Select an option</option>
                                                        </select>
                                                        <div class="overSelect"></div>
                                                    </div>
                                                    <div class="checkboxes" id="customersegments">
                                                        <!--LOAD DATA HERE-->
                                                        <%
                                                            for (String trait : traits) {%>
                                                        <label><input type='checkbox' name='allTheTraits' value='<%=trait%>'><%=trait%></label><%};%>
                                                    </div>
                                                </div>
                                                <%} else {%>There are currently no traits available<%};%>
                                            </figcaption>
                                        </figure>
                                    </li>
                                    <li>
                                        <figure>
                                            <div><img src="resources/image/customerrelationship.jpg" alt="img03"></div>
                                            <figcaption>
                                                <h3>Customer Relationship</h3>
                                                <!--SEARCH OPTIONS-->
                                                <%                                                    traits = cDAO.retrieveTraitsByDriver("customer_relations");
                                                    //      out.println(traits.size());
                                                    if (traits.size() > 0) {
                                                %>

                                                <div class="multiselect" id="customerRelationshipSelect">
                                                    <div class="selectBox" onclick="customerrelationship()">
                                                        <select>
                                                            <option>Select an option</option>
                                                        </select>
                                                        <div class="overSelect"></div>
                                                    </div>
                                                    <div class="checkboxes" id="customerrelationship">
                                                        <!--LOAD DATA HERE-->
                                                        <%
                                                            for (String trait : traits) {%>
                                                        <label><input type='checkbox' name='allTheTraits' value='<%=trait%>'><%=trait%></label><%};%>
                                                    </div>
                                                </div>
                                                <%} else {%>There are currently no traits available<%};%>
                                            </figcaption>
                                        </figure>
                                    </li>
                                    <li>
                                        <figure>
                                            <div><img src="resources/image/channels.jpg" alt="img03"></div>
                                            <figcaption>
                                                <h3>Channels</h3>
                                                <!--SEARCH OPTIONS-->
                                                <%
                                                    traits = cDAO.retrieveTraitsByDriver("channel_strategy");
                                                    //      out.println(traits.size());
                                                    if (traits.size() > 0) {
                                                %>

                                                <div class="multiselect" id="channelSelect">
                                                    <div class="selectBox" onclick="channels()">
                                                        <select>
                                                            <option>Select an option</option>
                                                        </select>
                                                        <div class="overSelect"></div>
                                                    </div>
                                                    <div class="checkboxes" id="channels">
                                                        <!--LOAD DATA HERE-->
                                                        <%
                                                            for (String trait : traits) {%>
                                                        <label><input type='checkbox' name='allTheTraits' value='<%=trait%>'><%=trait%></label><%};%>
                                                    </div>
                                                </div>
                                                <%} else {%>There are currently no traits available<%};%>
                                            </figcaption>
                                        </figure>
                                    </li>
                                    <li>
                                        <figure>
                                            <div><img src="resources/image/coststructure.jpg" alt="img03"></div>
                                            <figcaption>
                                                <h3>Cost Structure</h3>
                                                <!--SEARCH OPTIONS-->
                                                <%
                                                    traits = cDAO.retrieveTraitsByDriver("cost_management");
                                                    //      out.println(traits.size());
                                                    if (traits.size() > 0) {
                                                %>

                                                <div class="multiselect" id="costStructureSelect">
                                                    <div class="selectBox" onclick="coststructure()">
                                                        <select>
                                                            <option>Select an option</option>
                                                        </select>
                                                        <div class="overSelect"></div>
                                                    </div>
                                                    <div class="checkboxes" id="coststructure">
                                                        <!--LOAD DATA HERE-->
                                                        <%
                                                            for (String trait : traits) {%>
                                                        <label><input type='checkbox' name='allTheTraits' value='<%=trait%>'><%=trait%></label><%};%>
                                                    </div>
                                                </div>
                                                <%} else {%>There are currently no traits available<%};%>
                                            </figcaption>
                                        </figure>
                                    </li>
                                    <li>
                                        <figure>
                                            <div><img src="resources/image/revenuestreams.jpg" alt="img03"></div>
                                            <figcaption>
                                                <h3>Revenue Streams</h3>
                                                <!--SEARCH OPTIONS-->
                                                <%
                                                    traits = cDAO.retrieveTraitsByDriver("revenues");
                                                    //      out.println(traits.size());
                                                    if (traits.size() > 0) {
                                                %>

                                                <div class="multiselect" id="revenueStreamSelect">
                                                    <div class="selectBox" onclick="revenuestreams()">
                                                        <select>
                                                            <option>Select an option</option>
                                                        </select>
                                                        <div class="overSelect"></div>
                                                    </div>
                                                    <div class="checkboxes" id="revenuestreams">
                                                        <!--LOAD DATA HERE-->
                                                        <%
                                                            for (String trait : traits) {%>
                                                        <label><input type='checkbox' name='allTheTraits' value='<%=trait%>'><%=trait%></label><%};%>
                                                    </div>
                                                </div>
                                                <%} else {%>There are currently no traits available<%};%>
                                            </figcaption>
                                        </figure>
                                    </li>
                                    <center><button type="submit" value="submit" name="traitsSearch" class="btn btn-2 btn-2i">SUBMIT</button></center>
                                </ul>

                            </div>
                        </div>

                    </form>
                    <span class="bl-icon bl-icon-close"></span>
            </section>
        </div>

        <!-- SCRIPT FOR MAIN INDEX -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
        <script src="resources/js/bmc/bmc-modernizr.custom.js"></script>
        <script src="resources/js/bmc/bmc-boxlayout.js"></script>
        <script>
                                                        $(function () {
                                                            Boxlayout.init();
                                                        });
        </SCRIPT>                                                                                                                

        <!--SCRIPT FOR COMPANY SEARCH-->
        <script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
        <script src="resources/js/bmc/bmc-searchcom-listnav.js"></script>
        <script>
                                                        $(function () {
                                                            $('#demoFour').listnav({
                                                                includeAll: true,
                                                                includeNums: true,
                                                                showCounts: false,
                                                                allText: 'All Companies',
                                                                onClick: function (letter) {
                                                                    $(".myLastClicked").text(letter.toUpperCase());
                                                                }
                                                            });
                                                        });
        </script>


        <!--SCRIPT FOR COMPANY SEARCH AUTOFILL-->

        <!--SCRIPT FOR DRIVERS SEARCH-->
        <script src="resources/js/bmc/bmc-searchdrivers-dropdown.js"></script>

    </body>
</html>