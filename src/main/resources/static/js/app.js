var app = angular.module('dashboard', ['ui.router']);
app.config(function($stateProvider, $urlRouterProvider, $locationProvider) {
         $stateProvider
              .state('login', {
                  url: '/login',
                  templateUrl: 'login.html',
                  controller: 'loginController'
                  // controllerAs: 'lg'
              })
             .state('dashboard', {
//                abstract: true,
                  url: "/dashboard",
                  templateUrl: 'dashboard.html'
//                template: '<div ui-view autoscroll="false" />'
             })
             .state('dashboard.welcome', {
                 url: '/main',
                 template: '<h1>Sup nigga</h1>'
             })
         $urlRouterProvider.otherwise("/login");
//         $locationProvider.html5Mode({ enabled: true, requireBase: true });
     });
app.controller('dash', function($scope, $location) {
        // $scope.greeting = { id: 'xxx', content: 'Hello World!' }
        console.log('dashboar');
        console.log($location.path());
        // if (typeof(EventSource) !== "undefined") {
        //     // Yes! Server-sent events support!
        //     var source = new EventSource('/streams');

        //     source.onmessage = function(event) {
        //         console.log("Im here bitch");
        //         console.log(event);
        //     };
        // }
    });
app.controller('loginController', loginController);
function loginController($scope, $state){
    $scope.click = function(){
        console.log('Works');
        $state.go('dashboard');
    }
}
