var App = angular.module('drag-and-drop', ['ngDragDrop']);

App.controller('oneCtrl', function ($scope) {
    $scope.list1 = [
        {'title': 'Add', 'drag': true, 'id': 'item1'},
        {'title': 'Raise', 'drag': true},
        {'title': 'Combine', 'drag': true},
    ];
    $scope.list2A = [
        {'title': 'Factor 4', 'drag': true},
    ];
    $scope.list2B = [
        {'title': 'Complimentary Factor 4', 'drag': true},
    ];
    $scope.list3 = [
        {'title': 'Separate', 'drag': true},
        {'title': 'Reduce', 'drag': true},
        {'title': 'Remove', 'drag': true},
    ];

});

function MyCtrl($scope) {
  $scope.factor1 = "";

  $scope.$watch("name", function(newValue, oldValue) {
    if (newValue.length > 0) {
      $scope.outFactor1 = "Greetings " + newValue;
    }
  });
}
