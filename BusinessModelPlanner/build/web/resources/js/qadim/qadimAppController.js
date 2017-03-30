var App = angular.module('drag-and-drop', ['ngDragDrop']);

App.controller('oneCtrl', function ($scope) {
    $scope.list1 = [
        {'title': 'Add', 'drag': true, 'comment': 'i.e. Comment for Add', 'id':'Operator1'},
        {'title': 'Raise', 'drag': true, 'comment': 'i.e. Comment for Raise', 'id':'Operator2'},
        {'title': 'Combine', 'drag': true, 'comment': 'i.e. Comment for Combine', 'id':'Operator3'},
    ];
    $scope.list2A = [
        {'title': 'Factor 1', 'drag': true, 'comment': 'i.e. Comment for Factor 1', 'id':'Operator4'},
    ];
    $scope.list2C = [
        {'title': 'Product Name', 'drag': false, 'id':'productName'},
    ];
    $scope.list2B = [
        {'title': 'Factor 2', 'drag': true, 'comment': 'i.e. Comment for Factor 2', 'id':'Operator5'},
    ];
    $scope.list3 = [
        {'title': 'Separate', 'drag': true, 'comment': 'i.e. Comment for Separate', 'id':'Operator6'},
        {'title': 'Reduce', 'drag': true, 'comment': 'i.e. Comment for Reduce', 'id':'Operator7'},
        {'title': 'Remove', 'drag': true, 'comment': 'i.e. Comment for Remove', 'id':'Operator8'},
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
