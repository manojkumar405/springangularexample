angular.module('springAngularApp.services').factory('ProductService', 
		function($resource, $http, baseURL) 
		{
			var productResource = $resource(baseURL + '/products/:id',{id:'@id'},{
				update:{
					method: 'PUT'
				}
			});

			return{
				
				getProducts : function(success) {
					return productResource.query().$promise.then(function(value) {
						success(value);
					}, function(reason) {
						
					}, function(value) {
						
					});
				},
			
				getProductsData : function(){
					var request = $http({
		                method: 'get',
		                url: baseURL + 'stockItems',
		            });
					return request;
				},
				addProduct : function(product){
					return new productResource(product).$save();
				},
				updateProduct : function(product) {
					productResource.$update(product);
				}
			};
		}
);