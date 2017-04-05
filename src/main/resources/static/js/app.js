var app = angular.module('app', ['ui.router']);

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
            templateUrl: 'alcalde.html',
            controller: 'AlcaldeController'
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

app.factory('dataService', dataService);
dataService.$inject = ['$http'];

function dataService($http) {
    return {
        getSuggestions: getSuggestions,
        getSuggestion: getSuggestion
    };

    function getSuggestions() {
        return $http.get('/suggestion')
            .then(function(response) {
                return response.data;
            })
            .catch(function(error) {
                return error;
            });
    };

    function getSuggestion(id) {
        return $http.get('/suggestion/' + id)
            .then(function(response) {
                return response.data;
            })
            .catch(function(error) {
                return error;
            });
    };
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

app.controller('AlcaldeController', AlcaldeController);

AlcaldeController.$inject = ['$scope', 'dataService'];

function AlcaldeController($scope, dataService) {
    console.log('AlcaldeController');

    activate();

    $scope.suggestions = [];

    if (typeof(EventSource) !== "undefined") {
        var source = new EventSource('/streams');

        source.onmessage = function(event) {
            var data = JSON.parse(event.data);

            var pos = $scope.suggestions.map(function(obj) {
                return obj.id }).indexOf(data.suggestionId);
            if (pos !== -1) {
                //NOTE Agregando a una propuesta existente
                console.log($scope.suggestions[pos]);
                $scope.suggestions[pos].numberOfVotes += 1;
                $scope.$apply();
            } else {
                //NOTE Agregando nueva propuesta
                console.log('Event data', data);
                dataService.getSuggestion(data.suggestionId)
                    .then(function(res) {
                        console.log('res', res);
                        $scope.suggestions.push(res);
                    });
            }
        };
    }

    function activate() {
        dataService.getSuggestions()
            .then(function(response) {
                $scope.suggestions = response;
                console.log($scope.suggestions);
            });
    }
}