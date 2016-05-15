'use strict';
var springAngularAppAlertMsg = angular.module('springAngularApp.alertMessage',[]);

springAngularAppAlertMsg.directive('alertMessage', function() {
	return {
		restrict : 'E',
		templateUrl : 'ui/components/alertMessage/alertMessage.html',
		Controller : 'AlertMessageController'
	}
});

springAngularAppAlertMsg.controller('AlertMessageController',
	function($scope) {
		$scope.alert = null;

		// Picks up the event to display a saved message.
		$scope.$on('messageEvent', function(event, message) {
			$scope.alert = {
				type : 'alert-success',
				message : message
			};

		});

		// Picks up the event to display a server error message.
		$scope.$on('error', function(event, message) {
			$scope.alert = {
				type : 'alert-danger',
				message : message
			};
		});

		$scope.$on('logout', function(event, message) {
			$scope.alert = {
				type : 'alert-success',
				message : message
			};
		});
		$scope.$on('closeAlert', function(event) {
			closeAlertInternal();
		});

		$scope.getAlertClass = function() {
			var alertClass = '';

			if (alert != null && alert.type) {
				alertClass = alert.type;
			}
			return alertClass;
		};

		var closeAlertInternal = function() {
			$scope.alert = null;
		}

});