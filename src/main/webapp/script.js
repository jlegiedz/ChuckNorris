var app = angular.module("menu",[]);
app.controller("menuController", function($scope) {
    $scope.links = [
        'Main Page',
        'Register',
        'Login',
        'Logout'
    ];
});
