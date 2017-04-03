var App = angular.module('drag-and-drop', ['ngDragDrop']);
//LOAD PROJECT NAME
var productName = document.getElementById("productNameHidden").innerHTML;
//LOAD VALUES FROM FRONT-END JSP PAGE
var opName1 = document.getElementById("opName1hidden").innerHTML;
var opComment1 = document.getElementById("opComment1hidden").innerHTML;

var opName2 = document.getElementById("opName2hidden").innerHTML;
var opComment2 = document.getElementById("opComment2hidden").innerHTML;
var opName3 = document.getElementById("opName3hidden").innerHTML;
var opComment3 = document.getElementById("opComment3hidden").innerHTML;
var opName4 = document.getElementById("opName4hidden").innerHTML;
var opComment4 = document.getElementById("opComment4hidden").innerHTML;
var opName5 = document.getElementById("opName5hidden").innerHTML;
var opComment5 = document.getElementById("opComment5hidden").innerHTML;
var opName6 = document.getElementById("opName6hidden").innerHTML;
var opComment6 = document.getElementById("opComment6hidden").innerHTML;
var opName7 = document.getElementById("opName7hidden").innerHTML;
var opComment7 = document.getElementById("opComment7hidden").innerHTML;
var opName8 = document.getElementById("opName8hidden").innerHTML;
var opComment8 = document.getElementById("opComment8hidden").innerHTML;
App.controller('oneCtrl', function ($scope) {
    $scope.operatorOne = [
        {'title': opName1, 'drag': true, 'comment': opComment1},
    ];
    $scope.operatorTwo = [
        {'title': opName2, 'drag': true, 'comment': opComment2},
    ];
    $scope.operatorThree = [
        {'title': opName3, 'drag': true, 'comment': opComment3},
    ];
    $scope.operatorFour = [
        {'title': opName4, 'drag': true, 'comment': opComment4},
    ];
    $scope.currentProductName = [
        {'title': productName, 'drag': false},
    ];
    $scope.operatorFive = [
        {'title': opName5, 'drag': true, 'comment': opComment5},
    ];
    $scope.operatorSix = [
        {'title': opName6, 'drag': true, 'comment': opComment6},
    ];
    $scope.operatorSeven = [
        {'title': opName7, 'drag': true, 'comment': opComment7},
    ];
    $scope.operatorEight = [
        {'title': opName8, 'drag': true, 'comment': opComment8},
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
