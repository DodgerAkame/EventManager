(function() {
	var list = angular.module('list', [ 'ngRoute' ]);
	list.controller('appController', [ '$http', '$scope',

	function($http) {
		var event = this;
		event.events = [];
		$http.get('/event').then(function(response) {
			event.events = response.data._embedded.event;
		});

	} ]);

})();

var app = angular.module('creation-app', []);

app.controller('MainCtrl', function() {
});

var appedit = angular.module('edit-app', []);

appedit.controller('MainCtrlEdit', [ '$http', '$scope',
		function($http, $scope) {
			var event = this;
			event = [];
			var url = document.URL.split("/");
			$http.get('/event/' + url[url.length - 1]).then(function(response) {
				event = response.data;
				var date = event.date.split('-');
				$scope.event.date = new Date(date[0], date[1] - 1, date[2]);
				$scope.event.title = event.title;
				$scope.event.description = event.description;
				$scope.event.hours = event.hours;
				$scope.event.lieu = event.lieu;
				$scope.event.type = event.type;
			});
		} ]);