'use strict';
var springAngularApp = angular.module('springAngularApp');
springAngularApp.controller('ProductController', function($scope, $rootScope, $uibModal, $location, ProductService, baseURL) {
	$scope.products=[];
		
	$scope.getProductsData = function(){
		ProductService.getProducts(function(value){
			$scope.products = value;
		});
	};
	
	$scope.addProduct = function(){
		var modalInstance = $uibModal.open({
			animation : true,
			templateUrl : 'ui/views/products/AddProduct.html',
			controller : 'AddProductPopupController',
		});
		modalInstance.result.then(function(result){
			if(angular.isDefined(result)){
				$scope.getProductsData();
			}
		});
	};
	
	$scope.editProduct = function(productEdited){
		
		var modalInstance = $uibModal.open({
			animation : true,
			templateUrl : 'ui/views/products/EditProduct.html',
			controller : 'EditProductPopupController',
			resolve : {
				product : function() {
					return productEdited;
				}
			}
		});
		modalInstance.result.then(function(result){
			if(angular.isDefined(result)){
				$scope.getProductsData();
			}
		});
	};
	
});

