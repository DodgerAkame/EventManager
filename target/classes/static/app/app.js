(function() {
	var list = angular.module('list', [ 'ngRoute' ]);
	list.controller('appController', [ '$http', function($http) {
		var evtlist = this;
		$http.get('/event').then(function(response) {
			evtlist.events = response.data;
			//TODO voir comment récupérer les events
			for ( var propertyName in evtlist.events._embedded.event.toString()) {
				alert(propertyName);
			}
			
		});
	} ]);

})();