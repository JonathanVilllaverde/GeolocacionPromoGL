'use strict';

/**
 * @ngdoc function
 * @name geolocacionApp.controller:TrackerNotificationsCtrl
 * @description
 * # TrackerNotificationsCtrl
 * Controller of the geolocacionApp
 */
angular.module('geolocacionApp')
  .controller('NotificationsCtrl',  ['$scope', function ($scope) {
   	$scope.notifications = [
   		{
   			"name": "Alerta 1"
   		},{
   			"name": "Alerta 2"
   		},{
   			"name": "Alerta 3"
   		},{
   			"name": "Alerta 4"
   		}
   	];
  }]);