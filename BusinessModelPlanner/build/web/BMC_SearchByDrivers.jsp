<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="resources/css/bmc-searchdrivers-component.css" />
        <!--SELECT SCRIPTS-->
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700,400italic">
        <link rel='stylesheet prefetch' href='https://cdn.gitcdn.link/cdn/angular/bower-material/v1.1.3/angular-material.css'>
        <link rel='stylesheet prefetch' href='https://material.angularjs.org/1.1.3/docs.css'>
        <link rel="stylesheet" href="resources/css/bmc-searchdrivers-selectstyle.css">
    </head>

    <body>
        <h1>Search by Drivers</h1>

        <form action="BMC_Results_2.jsp">
        <div ng-controller="SelectHeaderController" class="md-padding selectdemoSelectHeader" ng-cloak="" ng-app="MyApp">
            <div class="container demo-3">
                <ul class="grid cs-style-4">
                    <!--KEY PARTNERS-->
                    <li>
                        <figure>
                            <div><img src="resources/image/keypartners.jpg" alt="img05"></div>
                            <figcaption>
                                <h3>Key Partners</h3>
                                <span>SHORT DESCRIPTION</span>
                                <!--SEARCH OPTIONS-->

                                <div>
                                    <md-input-container>
                                        <label>Key Partners</label>
                                        <md-select ng-model="selectedPartners" md-on-close="clearSearchTerm()" data-md-container-class="selectdemoSelectHeader" multiple="">
                                            <md-select-header class="demo-select-header">
                                                <input ng-model="searchTerm" type="search" placeholder="Search for key partner" class="demo-header-searchbox md-text">
                                            </md-select-header>
                                            <md-optgroup label="keypartners">
                                                <md-option ng-value="partner" ng-repeat="partner in keypartners|
              filter:searchTerm">      {{partner}}</md-option>
                                            </md-optgroup>
                                        </md-select>
                               
                               <input type="text" value="{{selectedPartners | json}}" name="keyPartners" hidden>
                                                
                               
                                    </md-input-container>
                                </div>
                                                                        
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
                                <div>
                                    <md-input-container>
                                        <label>Key Activities</label>
                                        <md-select ng-model="selectedActivities" md-on-close="clearSearchTerm()" data-md-container-class="selectdemoSelectHeader" multiple="">
                                            <md-select-header class="demo-select-header">
                                                <input ng-model="searchTerm" type="search" placeholder="Search for key activities" class="demo-header-searchbox md-text">
                                            </md-select-header>
                                            <md-optgroup label="keyactivities">
                                                <md-option ng-value="activity" ng-repeat="activity in keyactivities|
              filter:searchTerm">{{activity}}</md-option>
                                            </md-optgroup>
                                        </md-select>
                                        <input type="text" value="{{selectedActivities | json}}" name="keyActivities" hidden>
                                        
                                    </md-input-container>
                                </div>
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
                                <div>
                                    <md-input-container>
                                        <label>Key Resources</label>
                                        <md-select ng-model="selectedResources" md-on-close="clearSearchTerm()" data-md-container-class="selectdemoSelectHeader" multiple="">
                                            <md-select-header class="demo-select-header">
                                                <input ng-model="searchTerm" type="search" placeholder="Search for key resources" class="demo-header-searchbox md-text">
                                            </md-select-header>
                                            <md-optgroup label="keyresources">
                                                <md-option ng-value="resources" ng-repeat="resources in keyresources|
              filter:searchTerm">{{resources}}</md-option>
                                            </md-optgroup>
                                        </md-select>
                                        <input type="text" value="{{selectedResources | json}}" name="keyResources" hidden>
                                        
                                    </md-input-container>
                                </div>
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
                                <div>
                                    <md-input-container>
                                        <label>Value Proposition</label>
                                        <md-select ng-model="selectedValues" md-on-close="clearSearchTerm()" data-md-container-class="selectdemoSelectHeader" multiple="">
                                            <md-select-header class="demo-select-header">
                                                <input ng-model="searchTerm" type="search" placeholder="Search for value propostion" class="demo-header-searchbox md-text">
                                            </md-select-header>
                                            <md-optgroup label="valueproposition">
                                                <md-option ng-value="proposition" ng-repeat="proposition in valueproposition|
              filter:searchTerm">{{proposition}}</md-option>
                                            </md-optgroup>
                                        </md-select>
                                        
                                        <input type="text" value="{{selectedValues | json}}" name="valueProposition" hidden>
                                    </md-input-container>
                                </div>
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
                                <div>
                                    <md-input-container>
                                        <label>Customer Segments</label>
                                        <md-select ng-model="selectedSegments" md-on-close="clearSearchTerm()" data-md-container-class="selectdemoSelectHeader" multiple="">
                                            <md-select-header class="demo-select-header">
                                                <input ng-model="searchTerm" type="search" placeholder="Search for customer segments" class="demo-header-searchbox md-text">
                                            </md-select-header>
                                            <md-optgroup label="customersegments">
                                                <md-option ng-value="segments" ng-repeat="segments in customersegments|
              filter:searchTerm">{{segments}}</md-option>
                                            </md-optgroup>
                                        </md-select>
                                        <input type="text" value="{{selectedSegments | json}}" name="customerSegments" hidden>
                                    </md-input-container>
                                </div>
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
                                <div>
                                    <md-input-container>
                                        <label>Customer Relationship</label>
                                        <md-select ng-model="selectedRelationships" md-on-close="clearSearchTerm()" data-md-container-class="selectdemoSelectHeader" multiple="">
                                            <md-select-header class="demo-select-header">
                                                <input ng-model="searchTerm" type="search" placeholder="Search for customer relationship" class="demo-header-searchbox md-text">
                                            </md-select-header>
                                            <md-optgroup label="customerrelationship">
                                                <md-option ng-value="relationship" ng-repeat="relationship in customerrelationship|
              filter:searchTerm">{{relationship}}</md-option>
                                            </md-optgroup>
                                        </md-select>
                                        <input type="text" value="{{selectedRelationships | json}}" name="customerRelationship" hidden>
                                    </md-input-container>
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
                                <div>
                                    <md-input-container>
                                        <label>Channels</label>
                                        <md-select ng-model="selectedChannels" md-on-close="clearSearchTerm()" data-md-container-class="selectdemoSelectHeader" multiple="">
                                            <md-select-header class="demo-select-header">
                                                <input ng-model="searchTerm" type="search" placeholder="Search for channels" class="demo-header-searchbox md-text">
                                            </md-select-header>
                                            <md-optgroup label="channels">
                                                <md-option ng-value="channel" ng-repeat="channel in channels|
              filter:searchTerm">{{channel}}</md-option>
                                            </md-optgroup>
                                        </md-select>
                                        <input type="text" value="{{selectedChannels | json}}" name="channels" hidden>
                                    </md-input-container>
                                </div>
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
                                <div>
                                    <md-input-container>
                                        <label>Cost Structures</label>
                                        <md-select ng-model="selectedCost" md-on-close="clearSearchTerm()" data-md-container-class="selectdemoSelectHeader" multiple="">
                                            <md-select-header class="demo-select-header">
                                                <input ng-model="searchTerm" type="search" placeholder="Search for cost structures" class="demo-header-searchbox md-text">
                                            </md-select-header>
                                            <md-optgroup label="coststructures">
                                                <md-option ng-value="coststructure" ng-repeat="coststructure in coststructures|
              filter:searchTerm">{{coststructure}}</md-option>
                                            </md-optgroup>
                                        </md-select>
                                        <input type="text" value="{{selectedCost | json}}" name="costStructure" hidden>
                                    </md-input-container>
                                </div>
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
                                <div>
                                    <md-input-container>
                                        <label>Revenue Streams</label>
                                        <md-select ng-model="selectedRevenue" md-on-close="clearSearchTerm()" data-md-container-class="selectdemoSelectHeader" multiple="">
                                            <md-select-header class="demo-select-header">
                                                <input ng-model="searchTerm" type="search" placeholder="Search for cost structures" class="demo-header-searchbox md-text">
                                            </md-select-header>
                                            <md-optgroup label="revenuestreams">
                                                <md-option ng-value="revenue" ng-repeat="revenue in revenuestreams|
              filter:searchTerm">{{revenue}}</md-option>



                                            </md-optgroup>
                                        </md-select>
                                        <input type="text" value="{{selectedRevenue | json}}" name="revenue" hidden>
                                    </md-input-container>

                                </div>
                            </figcaption>
                        </figure>
                    </li>
                    <br>
                    
                    <input type="submit" name="searchByTraits"><br>
                    <a href="BMCindex.jsp">BACK</a>
                 

                </ul>   
            </div>
        </div></form>
        
        <script src='https://ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular.js'></script>
        <script src='https://ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular-animate.min.js'></script>
        <script src='https://ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular-route.min.js'></script>
        <script src='https://ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular-aria.min.js'></script>
        <script src='https://ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular-messages.min.js'></script>
        <script src='https://s3-us-west-2.amazonaws.com/s.cdpn.io/t-114/svg-assets-cache.js'></script>
        <script src='https://cdn.gitcdn.link/cdn/angular/bower-material/v1.1.3/angular-material.js'></script>
         <script src="resources/js/bmc-searchdrivers-toucheffects.js"></script>
        <script src="resources/js/bmc-searchdrivers-select.js"></script>
        <script src="resources/js/bmc-searchdrivers-modernizr.custom.js"></script>
    </body>
</html>
