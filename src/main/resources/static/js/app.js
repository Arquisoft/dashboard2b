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
            controller: 'AlcaldeController',
            controllerAs: 'alcalde'
        })
        .state('dashboard.consejal', {
            url: '/consejal',
            template: '<h1>Consejal</h1>'
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
            .then(function(response){
                return response.data;
            })
            .catch(function(error){
                return error;
            });
    };

    function getSuggestion(id) {
        return $http.get('/suggestion/')
            .then(function(response){
                return response.data;
            })
            .catch(function(error){
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
            $state.go('dashboard.consejal');
        }
    }
}

app.controller('AlcaldeController', AlcaldeController);

AlcaldeController.$inject = ['dataService'];

function AlcaldeController(dataService) {
    var vm = this;
    console.log('AlcaldeController');

    activate();

    vm.suggestions = [];

    if (typeof(EventSource) !== "undefined") {
        var source = new EventSource('/streams');

        source.onmessage = function(event) {
            var data = JSON.parse(event.data);

            var pos = vm.suggestions.map(function(obj){return obj.id}).indexOf(data.suggestionId);
            if (pos !== -1) {
                console.log(vm.suggestions);
                console.log(pos);
                console.log(vm.suggestions[pos]);
                vm.suggestions[pos].numberOfVotes += 1;
            } else {
                //TODO Request /suggestion/{id}
//                vm.suggestions.push()
            }
        };
    }

    function activate(){
        dataService.getSuggestions()
            .then(function(response){
                vm.suggestions = response;
                console.log(vm.suggestions);
            });
    }
}