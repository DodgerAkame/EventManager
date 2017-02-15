(function() {
	var list = angular.module('list', [ 'ngRoute' ]);
	list.controller('appController', [ '$http', '$scope',
			function($http, $scope) {
				var event = this;
				event.events = [];
				$http.get('/event').then(function(response) {
					event.events = response.data._embedded.event;

					alert(events[0].date);
				});
				
			} ]);
	
})();