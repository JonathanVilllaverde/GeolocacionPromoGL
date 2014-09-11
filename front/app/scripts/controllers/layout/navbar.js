'use strict';

/**
 * @ngdoc function
 * @name geolocacionApp.controller:LayoutNavbarCtrl
 * @description
 * # LayoutNavbarCtrl
 * Controller of the geolocacionApp
 */
angular.module('geolocacionApp')
   .controller('NavbarCtrl', [ '$scope', '$location', function ($scope, $location) {
  	$scope.isActive = function (viewLocation) {
			return (viewLocation === $location.path());			
		};    
}]);