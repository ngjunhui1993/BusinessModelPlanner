angular.module('SearchDriversApp',['ngMaterial', 'ngMessages', 'material.svgAssetsCache'])
    .controller('SelectHeaderController', function($scope, $element) {
      $scope.keypartners = ['part1','part2','part3','Testing a really long line here'];
      $scope.keyactivities = ['act1','ac2','act3'];
      $scope.keyresources = ['resource1','resource2','resource3'];
      $scope.valueproposition = ['value1','value2','value3'];
      $scope.customersegments = ['segment1','segment2','segment3'];
      $scope.customerrelationship = ['relationship1','relationship2','relationship3'];
      $scope.channels = ['channel1','channel2','channel3'];
      $scope.coststructures = ['cost1','cost2','cost3'];
      $scope.revenuestreams = ['revenue1','revenue2','revenue3'];
      
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