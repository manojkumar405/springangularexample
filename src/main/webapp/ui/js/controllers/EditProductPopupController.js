'use strict';
var springAngularApp = angular.module('springAngularApp');

springAngularApp.controller('EditProductPopupController', function($rootScope, $scope, $http, $location, $uibModalInstance, product) {
	$scope.product = product;
	$scope.onLoad = function(){
//		$('#myModal').draggable({
//		    handle: '.modal-header'
//		});
	},
	$scope.close = function(){
		$uibModalInstance.dismiss();
	},
	
	$scope.updateProduct = function() {
		var product = $scope.product;
		
		var validationMessage = validateProduct(product);
		
		if(validationMessage.length > 0){
			$scope.$broadcast('error', validationMessage);
			return false;
		}
		product.$update().then(function(response){
			$uibModalInstance.close(response);
		},function(response){
			var messages = '';
			if(angular.isDefined(response.data.data) && response.data.data.length >0){
				angular.forEach(response.data.data, function(message) {
					messages += message;
				});
				response.data.handled = true;
				$scope.$broadcast('error', messages);
			}
		});
	};
	
	var validateProduct = function(product) {
		
		var validationMessage = '';
		
		if(angular.isUndefined(product.name) || product.name === ''){
			validationMessage += 'Name is required.';
		}
		if(angular.isUndefined(product.description) || product.description === ''){
			validationMessage += 'Description is required.';
		}
		
		if(angular.isUndefined(product.price) || product.price === 0){
			validationMessage += 'Price is invalid.';
		}
		
		if(angular.isUndefined(product.quantity) || product.quantity === 0){
			validationMessage += 'Quantity is invalid.'
		}
		
		return validationMessage;
	};
});