var App = angular.module('drag-and-drop', ['ngDragDrop']);

App.controller('oneCtrl', function ($scope) {
    $scope.operatorOne = [
        {'title': 'Add', 'drag': true, 'comment': 'i.e. Comment for Add'},
    ];
    $scope.operatorTwo = [
        {'title': 'Raise', 'drag': true, 'comment': 'i.e. Comment for Raise'},
    ];
    $scope.operatorThree = [
        {'title': 'Combine', 'drag': true, 'comment': 'i.e. Comment for Combine'},
    ];
    $scope.operatorFour = [
        {'title': 'Factor 1', 'drag': true, 'comment': 'i.e. Comment for Factor 1'},
    ];
    $scope.currentProjectName = [
        {'title': 'Product Name', 'drag': false, 'id': 'productName'},
    ];
    $scope.operatorFive = [
        {'title': 'Factor 2', 'drag': true, 'comment': 'i.e. Comment for Factor 2'},
    ];
    $scope.operatorSix = [
        {'title': 'Separate', 'drag': true, 'comment': 'i.e. Comment for Separate'},
    ];
    $scope.operatorSeven = [
        {'title': 'Reduce', 'drag': true, 'comment': 'i.e. Comment for Reduce'},
    ];
    $scope.operatorEight = [
        {'title': 'Remove', 'drag': true, 'comment': 'i.e. Comment for Remove'},
    ];

});

app.directive('variableinput', [
    function () {
        return {
            require: '?ngModel',
            link: function (scope, element, attributes, controller) {
                controller.$modelValue = 'bar';
                console.log('controller.$modelValue is: ', controller.$modelValue);
            }
        };
    }
]);
