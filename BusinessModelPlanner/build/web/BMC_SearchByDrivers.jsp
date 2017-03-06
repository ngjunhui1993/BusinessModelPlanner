<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="shortcut icon" href="../favicon.ico"> 
        <link rel="stylesheet" type="text/css" href="css/default.css" />
        <link rel="stylesheet" type="text/css" href="css/component.css" />
        <script src="js/modernizr.custom.js"></script>
        <!--SELECT SCRIPTS-->
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700,400italic">
        <link rel='stylesheet prefetch' href='https://cdn.gitcdn.link/cdn/angular/bower-material/v1.1.3/angular-material.css'>
        <link rel='stylesheet prefetch' href='https://material.angularjs.org/1.1.3/docs.css'>
        <link rel="stylesheet" href="css/selectstyle.css">
    </head>

    <body>
        <h1>Search by Drivers</h1>

        <div ng-controller="SelectHeaderController" class="md-padding selectdemoSelectHeader" ng-cloak="" ng-app="MyApp">
            <div class="container demo-3">
                <ul class="grid cs-style-4">
                    <!--KEY PARTNERS-->
                    <li>
                        <figure>
                            <div><img src="img/5.png" alt="img05"></div>
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
              filter:searchTerm">{{partner}}</md-option>
                                            </md-optgroup>
                                        </md-select>
                                    </md-input-container>
                                </div>

                            </figcaption>
                        </figure>
                    </li>

                    <!--KEY ACTIVITIES-->
                    <li>
                        <figure>
                            <div><img src="img/6.png" alt="img06"></div>
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
                                    </md-input-container>
                                </div>
                            </figcaption>
                        </figure>
                    </li>

                    <li>
                        <figure>
                            <div><img src="img/2.png" alt="img02"></div>
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
                                    </md-input-container>
                                </div>
                            </figcaption>
                        </figure>
                    </li>
                    <li>
                        <figure>
                            <div><img src="img/4.png" alt="img04"></div>
                            <figcaption>
                                <h3>Value Proposition</h3>
                                <span>SHORT DESCRIPTION</span>
                                <!--SEARCH OPTIONS-->
                                <div>
                                    <md-input-container>
                                        <label>Value Proposition</label>
                                        <md-select ng-model="selectedResources" md-on-close="clearSearchTerm()" data-md-container-class="selectdemoSelectHeader" multiple="">
                                            <md-select-header class="demo-select-header">
                                                <input ng-model="searchTerm" type="search" placeholder="Search for value propostion" class="demo-header-searchbox md-text">
                                            </md-select-header>
                                            <md-optgroup label="valueproposition">
                                                <md-option ng-value="proposition" ng-repeat="proposition in valueproposition|
              filter:searchTerm">{{proposition}}</md-option>
                                            </md-optgroup>
                                        </md-select>
                                    </md-input-container>
                                </div>
                            </figcaption>
                        </figure>
                    </li>
                    <li>
                        <figure>
                            <div><img src="img/1.png" alt="img01"></div>
                            <figcaption>
                                <h3>Customer Segments</h3>
                                <span>SHORT DESCRIPTION</span>
                                <!--SEARCH OPTIONS-->
                                <div>
                                    <md-input-container>
                                        <label>Customer Segments</label>
                                        <md-select ng-model="selectedResources" md-on-close="clearSearchTerm()" data-md-container-class="selectdemoSelectHeader" multiple="">
                                            <md-select-header class="demo-select-header">
                                                <input ng-model="searchTerm" type="search" placeholder="Search for customer segments" class="demo-header-searchbox md-text">
                                            </md-select-header>
                                            <md-optgroup label="customersegments">
                                                <md-option ng-value="segments" ng-repeat="segments in customersegments|
              filter:searchTerm">{{segments}}</md-option>
                                            </md-optgroup>
                                        </md-select>
                                    </md-input-container>
                                </div>
                            </figcaption>
                        </figure>
                    </li>
                    <li>
                        <figure>
                            <div><img src="img/3.png" alt="img03"></div>
                            <figcaption>
                                <h3>Customer Relationship</h3>
                                <span>SHORT DESCRIPTION</span>
                                <!--SEARCH OPTIONS-->
                                <div>
                                    <md-input-container>
                                        <label>Customer Relationship</label>
                                        <md-select ng-model="selectedResources" md-on-close="clearSearchTerm()" data-md-container-class="selectdemoSelectHeader" multiple="">
                                            <md-select-header class="demo-select-header">
                                                <input ng-model="searchTerm" type="search" placeholder="Search for customer relationship" class="demo-header-searchbox md-text">
                                            </md-select-header>
                                            <md-optgroup label="customerrelationship">
                                                <md-option ng-value="relationship" ng-repeat="relationship in customerrelationship|
              filter:searchTerm">{{relationship}}</md-option>
                                            </md-optgroup>
                                        </md-select>
                                    </md-input-container>
                                </div>
                            </figcaption>
                        </figure>
                    </li>
                    <li>
                        <figure>
                            <div><img src="img/3.png" alt="img03"></div>
                            <figcaption>
                                <h3>Channels</h3>
                                <span>SHORT DESCRIPTION</span>
                                <!--SEARCH OPTIONS-->
                                <div>
                                    <md-input-container>
                                        <label>Channels</label>
                                        <md-select ng-model="selectedResources" md-on-close="clearSearchTerm()" data-md-container-class="selectdemoSelectHeader" multiple="">
                                            <md-select-header class="demo-select-header">
                                                <input ng-model="searchTerm" type="search" placeholder="Search for customer segments" class="demo-header-searchbox md-text">
                                            </md-select-header>
                                            <md-optgroup label="channels">
                                                <md-option ng-value="channel" ng-repeat="channel in channels|
              filter:searchTerm">{{channel}}</md-option>
                                            </md-optgroup>
                                        </md-select>
                                    </md-input-container>
                                </div>
                            </figcaption>
                        </figure>
                    </li>
                    <li>
                        <figure>
                            <div><img src="img/3.png" alt="img03"></div>
                            <figcaption>
                                <h3>Cost Structure</h3>
                                <span>SHORT DESCRIPTION</span>
                                <!--SEARCH OPTIONS-->
                                <div>
                                    <md-input-container>
                                        <label>Cost Structures</label>
                                        <md-select ng-model="selectedResources" md-on-close="clearSearchTerm()" data-md-container-class="selectdemoSelectHeader" multiple="">
                                            <md-select-header class="demo-select-header">
                                                <input ng-model="searchTerm" type="search" placeholder="Search for cost structures" class="demo-header-searchbox md-text">
                                            </md-select-header>
                                            <md-optgroup label="coststructures">
                                                <md-option ng-value="coststructure" ng-repeat="coststructure in coststructures|
              filter:searchTerm">{{coststructure}}</md-option>
                                            </md-optgroup>
                                        </md-select>
                                    </md-input-container>
                                </div>
                            </figcaption>
                        </figure>
                    </li>
                    <li>
                        <figure>
                            <div><img src="img/3.png" alt="img03"></div>
                            <figcaption>
                                <h3>Revenue Streams</h3>
                                <span>SHORT DESCRIPTION</span>
                                <!--SEARCH OPTIONS-->
                                <div>
                                    <md-input-container>
                                        <label>Revenue Streams</label>
                                        <md-select ng-model="selectedResources" md-on-close="clearSearchTerm()" data-md-container-class="selectdemoSelectHeader" multiple="">
                                            <md-select-header class="demo-select-header">
                                                <input ng-model="searchTerm" type="search" placeholder="Search for cost structures" class="demo-header-searchbox md-text">
                                            </md-select-header>
                                            <md-optgroup label="revenuestreams">
                                                <md-option ng-value="revenue" ng-repeat="revenue in revenuestreams|
              filter:searchTerm">{{revenue}}</md-option>
                                            </md-optgroup>
                                        </md-select>
                                    </md-input-container>
                                </div>
                            </figcaption>
                        </figure>
                    </li>


                </ul>
            </div>
        </div>
        <script src="js/toucheffects.js"></script>
        <script src='https://ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular.js'></script>
        <script src='https://ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular-animate.min.js'></script>
        <script src='https://ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular-route.min.js'></script>
        <script src='https://ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular-aria.min.js'></script>
        <script src='https://ajax.googleapis.com/ajax/libs/angularjs/1.5.5/angular-messages.min.js'></script>
        <script src='https://s3-us-west-2.amazonaws.com/s.cdpn.io/t-114/svg-assets-cache.js'></script>
        <script src='https://cdn.gitcdn.link/cdn/angular/bower-material/v1.1.3/angular-material.js'></script>

        <script src="js/select.js"></script>

    </body>
</html>
