'use strict';
var springAngularApp = angular.module('springAngularApp',[ 'ngRoute', 'ngResource','ngAnimate', 'ui.bootstrap','springAngularApp.alertMessage','springAngularApp.services']);
var springAngularAppServices = angular.module('springAngularApp.services',['ngResource']);
springAngularApp.config(
	['$routeProvider', '$locationProvider', '$httpProvider', 
		     function($routeProvider, $locationProvider, $httpProvider) 
		     {
		
				$routeProvider.when('/home', {
					templateUrl : 'ui/views/products/ManageProducts.html',
					controller : 'ProductController'
				});
		
				$routeProvider.when('/products', {
					templateUrl : 'ui/views/products/ManageProducts.html',
					controller : 'ProductController'
				});
		
				$routeProvider.otherwise({
					templateUrl : 'ui/views/products/ManageProducts.html',
					controller : 'ProductController'
				});
		
				/*
				 * Register error provider that shows message on failed
				 * requests or redirects to login page on unauthenticated
				 * requests
				 */
				$httpProvider.interceptors.push(function($q, $rootScope, $location) {
					return {
						'responseError' : function(rejection) {
							var status = rejection.status;
							var config = rejection.config;
						
							if (status === 401) {
								$location.path('/login');
								$rootScope.$broadcast('error',rejection.data.message);
								return;
							} else if (status === 500) {
								$rootScope.$broadcast('error',rejection.data.message);
							} else {
								$rootScope.$broadcast('error',rejection.data.message);
							}
							return $q.reject(rejection);
						}
					};
				});
             }
	]);
springAngularApp.constant('baseURL', '/springangularexample/api');