<%@page import="java.util.Scanner"%>
<%@page import="com.app.model.entity.CanvasCompany"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.app.model.CanvasDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Business Model Canvas</title>
        <!--CSS FOR INDEX-->
        <link rel="stylesheet" type="text/css" href="resources/css/bmc-component.css" />
        <!--CSS FOR COMPANY SEARCH-->
        <link rel="stylesheet" href="resources/css/bmc-searchcom-style.css">
        <link rel="stylesheet" href="resources/css/bmc-searchcom-listnav.css"> 
        <!--CSS FOR COMPANY AUTOFILL-->

        <!--CSS FOR DRIVERS SEARCH-->
        <link rel="stylesheet" type="text/css" href="resources/css/bmc-searchdrivers-component.css" />
      
        <!--CSS FOR DRIVERS SEARCH SELECT SCRIPTS-->
        <link rel="stylesheet" href="resources/css/bmc-valuedropdownlist.css">

    </head>

    <body>
        <div class="container">	
            <div id="bl-main" class="bl-main">
                <!--SECTION FOR SEARCH COMPANIES-->
                <section>
                    <div class="bl-box">
                        <h2 class="bl-icon bl-icon-about">Search by Companies</h2>
                    </div>
                    <!--CONTENT-->
                    <div class="bl-content">
                        <!--Auto Search Function-->

                        <br><br>

                        <div>
                            <!--BACKEND TO POPULATE COMPANY LIST HERE-->
                            <ul id="demoFour" class="demoFourClass">
                                <%                                        CanvasDAO canvasDAO = new CanvasDAO();
                                    ArrayList<String> companyList = canvasDAO.retrieveAllCompanies();
                                    for (String name : companyList) {
                                %>
                                <li><a href='BMC_Results_2.jsp?companyName=<%=name%>'><%=name%></a>
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

                <!--SECTION FOR SEARCH DRIVERS-->
                <section id="bl-work-section">
                    <div class="bl-box">
                        <h2 class="bl-icon bl-icon-works">Search by Drivers</h2>
                    </div>
                    <div class="bl-content">
                        <h2>SEARCH BY DRIVERS</h2>
                        <div>
                            <div>

        <form action="CanvasController">
                                <div ng-controller="SelectHeaderController" class="md-padding selectdemoSelectHeader" ng-app="SearchDriversApp">
                                    <div class="container demo-3">
                                        <ul class="grid cs-style-4">
                                            <!--KEY PARTNERS-->
                                            <li>
                                                <figure>
                                                    <div><img src="resources/image/keypartners.jpg" alt="keypartners"></div>
                                                    <figcaption>
                                                        <h3>Key Partners</h3>
                                                        <span>SHORT DESCRIPTION</span>
                                                        <!--SEARCH OPTIONS-->
                                                        
                                                        <%
                                                            CanvasDAO cDAO = new CanvasDAO();
                                                            ArrayList<String> traits = cDAO.retrieveTraitsByDriver("key_partnerships");
                                                            out.println(traits.size());
                                                        %>
                                                        <DIV>
                                                            <form>
                                                                <div class="multiselect">
                                                                    <div class="selectBox" onclick="checkBoxValues()">
                                                                        <select>
                                                                            <option>Select an option</option>
                                                                        </select>
                                                                        <div class="overSelect"></div>
                                                                    </div>
                                                                    <div id="checkboxes">
                                                                        <!--LOAD DATA HERE-->
                                                                        <%
                                                                            int count = 1;
                                                                            for(String trait : traits) {
                                                                                out.println("<label for='"+count+"'><input type='checkbox' id='"+count+"'/>"+trait+"</label>");
                                                                                count++;
                                                                            }
                                                                        %>
                                                                   <!--     <label for="one">
                                                                            <input type="checkbox" id="one" />First checkbox</label>
                                                                        <label for="two">
                                                                            <input type="checkbox" id="two" />Second checkbox</label>
                                                                        <label for="three">
                                                                            <input type="checkbox" id="three" />Third checkbox</label>-->
                                                                    </div>
                                                                </div>
                                                            </form>
                                                        </DIV>

                                                    </figcaption>
                                                </figure>
                                            </li>

                                            <!--KEY ACTIVITIES-->
                                            <li>
                                                <figure>
                                                    <div><img src="resources/image/keyactivities.jpg" alt="img06"></div>
                                                    <figcaption>
                                                        <h3>Key Activities</h3>
                                                        <span>SHORT DESCRIPTION</span>
                                                        <!--SEARCH OPTIONS-->
                                                         <%
                                                            cDAO = new CanvasDAO();
                                                            traits = cDAO.retrieveTraitsByDriver("key_activities");
                                                            out.println(traits.size());
                                                        %>
                                                        <DIV>
                                                            
                                                                <div class="multiselect">
                                                                    <div class="selectBox" onclick="checkBoxValues()">
                                                                        <select>
                                                                            <option>Select an option</option>
                                                                        </select>
                                                                        <div class="overSelect"></div>
                                                                    </div>
                                                                    <div id="checkboxes">
                                                                        <!--LOAD DATA HERE-->
                                                                        <%
                                                                            count = 1;
                                                                            for(String trait : traits) {
                                                                                out.println("<label for='"+count+"'><input type='checkbox' id='"+count+"' name=allTheTraits value='"+trait+"'>"+trait+"</label>");
                                                                                count++;
                                                                            }
                                                                        %>
                                                                   <!--     <label for="one">
                                                                            <input type="checkbox" id="one" />First checkbox</label>
                                                                        <label for="two">
                                                                            <input type="checkbox" id="two" />Second checkbox</label>
                                                                        <label for="three">
                                                                            <input type="checkbox" id="three" />Third checkbox</label>-->
                                                                    </div>
                                                                </div>
                                                            
                                                        </DIV>
                                                    </figcaption>
                                                </figure>
                                            </li>

                                            <li>
                                                <figure>
                                                    <div><img src="resources/image/keyresources.jpg" alt="img02"></div>
                                                    <figcaption>
                                                        <h3>Key Resources</h3>
                                                        <span>SHORT DESCRIPTION</span>
                                                        <!--SEARCH OPTIONS-->
                                                        <%
                                                            cDAO = new CanvasDAO();
                                                            traits = cDAO.retrieveTraitsByDriver("key_resources");
                                                            out.println(traits.size());
                                                        %>
                                                        <DIV>
                                                                <div class="multiselect">
                                                                    <div class="selectBox" onclick="checkBoxValues()">
                                                                        <select>
                                                                            <option>Select an option</option>
                                                                        </select>
                                                                        <div class="overSelect"></div>
                                                                    </div>
                                                                    <div id="checkboxes">
                                                                        <!--LOAD DATA HERE-->
                                                                        <%
                                                                            count = 1;
                                                                            for(String trait : traits) {
                                                                               out.println("<label for='"+count+"'><input type='checkbox' id='"+count+"' name=allTheTraits value='"+trait+"'>"+trait+"</label>");
                                                                                count++;
                                                                            }
                                                                        %>
                                                                   <!--     <label for="one">
                                                                            <input type="checkbox" id="one" />First checkbox</label>
                                                                        <label for="two">
                                                                            <input type="checkbox" id="two" />Second checkbox</label>
                                                                        <label for="three">
                                                                            <input type="checkbox" id="three" />Third checkbox</label>-->
                                                                    </div>
                                                                </div>
                                                        </DIV>
                                                    </figcaption>
                                                </figure>
                                            </li>
                                            <li>
                                                <figure>
                                                    <div><img src="resources/image/valueproposition.jpg" alt="img04"></div>
                                                    <figcaption>
                                                        <h3>Value Proposition</h3>
                                                        <span>SHORT DESCRIPTION</span>
                                                        <!--SEARCH OPTIONS-->
                                                        <%
                                                            cDAO = new CanvasDAO();
                                                            traits = cDAO.retrieveTraitsByDriver("value_proposition");
                                                            out.println(traits.size());
                                                        %>
                                                        <DIV>
                                                                <div class="multiselect">
                                                                    <div class="selectBox" onclick="checkBoxValues()">
                                                                        <select>
                                                                            <option>Select an option</option>
                                                                        </select>
                                                                        <div class="overSelect"></div>
                                                                    </div>
                                                                    <div id="checkboxes">
                                                                        <!--LOAD DATA HERE-->
                                                                        <%
                                                                            count = 1;
                                                                            for(String trait : traits) {
                                                                                 out.println("<label for='"+count+"'><input type='checkbox' id='"+count+"' name=allTheTraits value='"+trait+"'>"+trait+"</label>");
                                                                                count++;
                                                                            }
                                                                        %>
                                                                   <!--     <label for="one">
                                                                            <input type="checkbox" id="one" />First checkbox</label>
                                                                        <label for="two">
                                                                            <input type="checkbox" id="two" />Second checkbox</label>
                                                                        <label for="three">
                                                                            <input type="checkbox" id="three" />Third checkbox</label>-->
                                                                    </div>
                                                                </div>
                                                        </DIV>
                                                    </figcaption>
                                                </figure>
                                            </li>
                                            <li>
                                                <figure>
                                                    <div><img src="resources/image/customersegments.jpg" alt="img01"></div>
                                                    <figcaption>
                                                        <h3>Customer Segments</h3>
                                                        <span>SHORT DESCRIPTION</span>
                                                        <!--SEARCH OPTIONS-->
                                                        <%
                                                            cDAO = new CanvasDAO();
                                                            traits = cDAO.retrieveTraitsByDriver("customer_acquisition");
                                                            out.println(traits.size());
                                                        %>
                                                        <DIV>
                                                                <div class="multiselect">
                                                                    <div class="selectBox" onclick="checkBoxValues()">
                                                                        <select>
                                                                            <option>Select an option</option>
                                                                        </select>
                                                                        <div class="overSelect"></div>
                                                                    </div>
                                                                    <div id="checkboxes">
                                                                        <!--LOAD DATA HERE-->
                                                                        <%
                                                                            count = 1;
                                                                            for(String trait : traits) {
                                                                                 out.println("<label for='"+count+"'><input type='checkbox' id='"+count+"' name=allTheTraits value='"+trait+"'>"+trait+"</label>");
                                                                                count++;
                                                                            }
                                                                        %>
                                                                   <!--     <label for="one">
                                                                            <input type="checkbox" id="one" />First checkbox</label>
                                                                        <label for="two">
                                                                            <input type="checkbox" id="two" />Second checkbox</label>
                                                                        <label for="three">
                                                                            <input type="checkbox" id="three" />Third checkbox</label>-->
                                                                    </div>
                                                                </div>
                                                        </DIV>

                                                    </figcaption>
                                                </figure>
                                            </li>
                                            <li>
                                                <figure>
                                                    <div><img src="resources/image/customerrelationship.jpg" alt="img03"></div>
                                                    <figcaption>
                                                        <h3>Customer Relationship</h3>
                                                        <span>SHORT DESCRIPTION</span>
                                                        <!--SEARCH OPTIONS-->
                                                        <%
                                                            cDAO = new CanvasDAO();
                                                            traits = cDAO.retrieveTraitsByDriver("customer_relations");
                                                            out.println(traits.size());
                                                        %>
                                                        <DIV>
                                                                <div class="multiselect">
                                                                    <div class="selectBox" onclick="checkBoxValues()">
                                                                        <select>
                                                                            <option>Select an option</option>
                                                                        </select>
                                                                        <div class="overSelect"></div>
                                                                    </div>
                                                                    <div id="checkboxes">
                                                                        <!--LOAD DATA HERE-->
                                                                        <%
                                                                            count = 1;
                                                                            for(String trait : traits) {
                                                                                 out.println("<label for='"+count+"'><input type='checkbox' id='"+count+"' name=allTheTraits value='"+trait+"'>"+trait+"</label>");
                                                                                count++;
                                                                            }
                                                                        %>
                                                                   <!--     <label for="one">
                                                                            <input type="checkbox" id="one" />First checkbox</label>
                                                                        <label for="two">
                                                                            <input type="checkbox" id="two" />Second checkbox</label>
                                                                        <label for="three">
                                                                            <input type="checkbox" id="three" />Third checkbox</label>-->
                                                                    </div>
                                                                </div>
                                                    </figcaption>
                                                </figure>
                                            </li>
                                            <li>
                                                <figure>
                                                    <div><img src="resources/image/channels.jpg" alt="img03"></div>
                                                    <figcaption>
                                                        <h3>Channels</h3>
                                                        <span>SHORT DESCRIPTION</span>
                                                        <!--SEARCH OPTIONS-->
                                                        <%
                                                            cDAO = new CanvasDAO();
                                                            traits = cDAO.retrieveTraitsByDriver("channel_strategy");
                                                            out.println(traits.size());
                                                        %>
                                                        <DIV>
                                                                <div class="multiselect">
                                                                    <div class="selectBox" onclick="checkBoxValues()">
                                                                        <select>
                                                                            <option>Select an option</option>
                                                                        </select>
                                                                        <div class="overSelect"></div>
                                                                    </div>
                                                                    <div id="checkboxes">
                                                                        <!--LOAD DATA HERE-->
                                                                        <%
                                                                            count = 1;
                                                                            for(String trait : traits) {
                                                                                 out.println("<label for='"+count+"'><input type='checkbox' id='"+count+"' name=allTheTraits value='"+trait+"'>"+trait+"</label>");
                                                                                count++;
                                                                            }
                                                                        %>
                                                                   <!--     <label for="one">
                                                                            <input type="checkbox" id="one" />First checkbox</label>
                                                                        <label for="two">
                                                                            <input type="checkbox" id="two" />Second checkbox</label>
                                                                        <label for="three">
                                                                            <input type="checkbox" id="three" />Third checkbox</label>-->
                                                                    </div>
                                                                </div>
                                                        </DIV>
                                                    </figcaption>
                                                </figure>
                                            </li>
                                            <li>
                                                <figure>
                                                    <div><img src="resources/image/coststructure.jpg" alt="img03"></div>
                                                    <figcaption>
                                                        <h3>Cost Structure</h3>
                                                        <span>SHORT DESCRIPTION</span>
                                                        <!--SEARCH OPTIONS-->
                                                        <%
                                                            cDAO = new CanvasDAO();
                                                            traits = cDAO.retrieveTraitsByDriver("cost_management");
                                                            out.println(traits.size());
                                                        %>
                                                        <DIV>
                                                                <div class="multiselect">
                                                                    <div class="selectBox" onclick="checkBoxValues()">
                                                                        <select>
                                                                            <option>Select an option</option>
                                                                        </select>
                                                                        <div class="overSelect"></div>
                                                                    </div>
                                                                    <div id="checkboxes">
                                                                        <!--LOAD DATA HERE-->
                                                                        <%
                                                                            count = 1;
                                                                            for(String trait : traits) {
                                                                                 out.println("<label for='"+count+"'><input type='checkbox' id='"+count+"' name=allTheTraits value='"+trait+"'>"+trait+"</label>");
                                                                                count++;
                                                                            }
                                                                        %>
                                                                   <!--     <label for="one">
                                                                            <input type="checkbox" id="one" />First checkbox</label>
                                                                        <label for="two">
                                                                            <input type="checkbox" id="two" />Second checkbox</label>
                                                                        <label for="three">
                                                                            <input type="checkbox" id="three" />Third checkbox</label>-->
                                                                    </div>
                                                                </div>
                                                        </DIV>
                                                    </figcaption>
                                                </figure>
                                            </li>
                                            <li>
                                                <figure>
                                                    <div><img src="resources/image/revenuestreams.jpg" alt="img03"></div>
                                                    <figcaption>
                                                        <h3>Revenue Streams</h3>
                                                        <span>SHORT DESCRIPTION</span>
                                                        <!--SEARCH OPTIONS-->
                                                        <%
                                                            cDAO = new CanvasDAO();
                                                            traits = cDAO.retrieveTraitsByDriver("revenues");
                                                            out.println(traits.size());
                                                        %>
                                                        <DIV>
                                                                <div class="multiselect">
                                                                    <div class="selectBox" onclick="checkBoxValues()">
                                                                        <select>
                                                                            <option>Select an option</option>
                                                                        </select>
                                                                        <div class="overSelect"></div>
                                                                    </div>
                                                                    <div id="checkboxes">
                                                                        <!--LOAD DATA HERE-->
                                                                        <%
                                                                            count = 1;
                                                                            for(String trait : traits) {
                                                                                 out.println("<label for='"+count+"'><input type='checkbox' id='"+count+"' name=allTheTraits value='"+trait+"'>"+trait+"</label>");
                                                                                count++;
                                                                            }
                                                                        %>
                                                                   <!--     <label for="one">
                                                                            <input type="checkbox" id="one" />First checkbox</label>
                                                                        <label for="two">
                                                                            <input type="checkbox" id="two" />Second checkbox</label>
                                                                        <label for="three">
                                                                            <input type="checkbox" id="three" />Third checkbox</label>-->
                                                                    </div>
                                                                </div>
                                                        </DIV>
                                                    </figcaption>
                                                </figure>
                                            </li>


                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <input type="submit" value="submit" name="traitsSearch">
                        </form>

                        <span class="bl-icon bl-icon-close"></span>
                </section>
            </div>
        </div>

        <!-- SCRIPT FOR MAIN INDEX -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
        <script src="resources/js/bmc-modernizr.custom.js"></script>
        <script src="resources/js/bmc-boxlayout.js"></script>
        <script>
                                                                        $(function () {
                                                                            Boxlayout.init();
                                                                        });
        </SCRIPT>                                                                                                                

        <!--SCRIPT FOR COMPANY SEARCH-->
        <script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
        <script src="resources/js/bmc-searchcom-listnav.js"></script>
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

        <script>
            var expanded = false;

            function checkBoxValues() {
                var checkboxes = document.getElementById("checkboxes");
                if (!expanded) {
                    checkboxes.style.display = "block";
                    expanded = true;
                } else {
                    checkboxes.style.display = "none";
                    expanded = false;
                }
            }
        </SCRIPT>

        <!--SCRIPT FOR COMPANY SEARCH AUTOFILL-->

        <!--SCRIPT FOR DRIVERS SEARCH-->
        <script src='https://ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular.js'></script>
        <script src='https://ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular-animate.min.js'></script>
        <script src='https://ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular-route.min.js'></script>
        <script src='https://ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular-aria.min.js'></script>
        <script src='https://ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular-messages.min.js'></script>
        <script src='https://s3-us-west-2.amazonaws.com/s.cdpn.io/t-114/svg-assets-cache.js'></script>
        <script src='https://cdn.gitcdn.link/cdn/angular/bower-material/v1.1.3/angular-material.js'></script>
        <script src="resources/js/bmc-searchdrivers-select.js"></script>

    </body>
</html>
