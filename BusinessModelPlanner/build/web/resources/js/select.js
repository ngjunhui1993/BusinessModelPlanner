angular
    .module('MyApp',['ngMaterial', 'ngMessages', 'material.svgAssetsCache'])
    .controller('SelectHeaderController', function($scope, $element) {
      $scope.keypartners = ['AdSpace','Affiliate programmes','Enrich partners','THarmonize own business processes with those of partners','Optimally match partners with specific tasks','Remove intermediaries','Work with ethical partners'];
      $scope.keyactivities = ['Align inventory with production – Kanban','Design and build assembly line to reduce change over time','Offer free add-ons - Air-conditioned environment','Offer toys and Happy Meals to attract children'];
      $scope.keyresources = ['Guidance system in fulfillment centers for pickers','Just in time inventory','Require employees to work at partner sites'];
      $scope.valueproposition = ['Increase - Profitability','Lower manufacturing costs','Personalized service – name','Platform as a service'];
      $scope.customersegments = ['Acquire advocates who rave about the product','Direct contact with customers','K-12 programme'];
      $scope.customerrelationship = ['Get customer to discover the product – Street marketing','Giving choice to customers (WOM) increases customer loyalty','Offer cheaper prices resulting from removing intermediaries','Premium members get free two-day shipping'];
      $scope.channels = ['Disrupt channels','Establish interesting partnerships with solution providers','Get third parties to recommend buying from you –Affiliate programme','Remove intermediaries'];
      $scope.coststructures = ['Buy used equipment','Pay suppliers 14 days after a transaction','Reduce channel costs'];
      $scope.revenuestreams = ['Charge for core product / service','Charge for upgrades','Multiple revenue streams','Out-license unwanted in-house resources','Pay per use – number of hours used'];
      
      $scope.searchTerm;
      $scope.clearSearchTerm = function() {
        $scope.searchTerm = '';
      };
      // The md-select directive eats keydown events for some quick select
      // logic. Since we have a search input here, we don't need that logic.
      $element.find('input').on('keydown', function(ev) {
          ev.stopPropagation();
      });
    });


/**
Copyright 2016 Google Inc. All Rights Reserved. 
Use of this source code is governed by an MIT-style license that can be foundin the LICENSE file at http://material.angularjs.org/HEAD/license.
**/