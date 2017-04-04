var app = angular.module('app', ['ui.router']);

// app.controller('dash', function($scope, $location) {
//     // $scope.greeting = { id: 'xxx', content: 'Hello World!' }
//     console.log('dashboar');    
//     console.log($location.path());
//     // if (typeof(EventSource) !== "undefined") {
//     //     // Yes! Server-sent events support!
//     //     var source = new EventSource('/streams');

//     //     source.onmessage = function(event) {
//     //         console.log(event);
//     //     };
//     // }
// });

app.config(function($stateProvider, $urlRouterProvider, $locationProvider) {
    $stateProvider
        .state('login', {
            url: '/login',
            templateUrl: 'login.html',
            controller: 'LoginController'
        })
        .state('dashboard', {
            // abstract: true,
            url: "/dashboard",
            templateUrl: 'dashboard.html'
        })
        .state('dashboard.alcalde', {
            url: '/alcalde',
            template: '<h1>Alcalde</h1>'
        })
        .state('dashboard.concejal', {
            url: '/concejal',
            template: '<h1>Concejal</h1>'
        })
    $urlRouterProvider.otherwise("/login");
    //          $locationProvider.html5Mode({ enabled: true, requireBase: true });
});

app.directive('navbar', navbar);

function navbar() {
    var directive = {
        templateUrl: 'navbar.html',
        restrict: 'EA'
    };

    return directive;
}

app.controller('LoginController', LoginController);

LoginController.$inject = ['$scope', '$state'];

function LoginController($scope, $state) {
    console.log('LoginController');

    $scope.login = function(val) {
        if ($scope.email === 'alcalde@gmail.com') {
            $state.go('dashboard.alcalde');
        } else {
            $state.go('dashboard.concejal');
        }

    }
}
