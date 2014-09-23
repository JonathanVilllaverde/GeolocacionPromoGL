'use strict';

/**
 * @ngdoc function
 * @name geolocacionApp.controller:TrackerAgentHistoryCtrl
 * @description
 * # TrackerAgentHistoryCtrl
 * Controller of the geolocacionApp
 */
angular.module('geolocacionApp')
  .controller('AgentHistoryCtrl',  ['$scope', function ($scope) {
   		$scope.open = function(){
   			console.log('here');
   		}
  }]);