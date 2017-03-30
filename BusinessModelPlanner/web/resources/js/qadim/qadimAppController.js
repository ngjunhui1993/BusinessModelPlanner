var App = angular.module('drag-and-drop', ['ngDragDrop']);

App.controller('oneCtrl', function ($scope) {
    $scope.list1 = [
        {'title': 'Add', 'drag': true, 'comment': 'i.e. Comment for Add'},
        {'title': 'Raise', 'drag': true, 'comment': 'i.e. Comment for Raise'},
        {'title': 'Combine', 'drag': true, 'comment': 'i.e. Comment for Combine'},
    ];
    $scope.list2A = [
        {'title': 'Factor 1', 'drag': true, 'comment': 'i.e. Comment for Factor 1'},
    ];
    $scope.list2C = [
        {'title': 'Product Name', 'drag': false},
    ];
    $scope.list2B = [
        {'title': 'Factor 2', 'drag': true, 'comment': 'i.e. Comment for Factor 2'},
    ];
    $scope.list3 = [
        {'title': 'Separate', 'drag': true, 'comment': 'i.e. Comment for Separate'},
        {'title': 'Reduce', 'drag': true, 'comment': 'i.e. Comment for Reduce'},
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


