angular.module('dashboard', [])
  .controller('dash', function($scope) {
    $scope.greeting = {id: 'xxx', content: 'Hello World!'}

        if (typeof(EventSource) !== "undefined") {
            // Yes! Server-sent events support!
            var source = new EventSource('/streams');

            source.onmessage = function (event) {
                console.log("Im here bitch");
                console.log(event);
            };
        }
    }
);