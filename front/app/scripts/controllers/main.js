'use strict';

/**
 * @ngdoc function
 * @name layoutnavbarApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the layoutnavbarApp
 */
angular.module('geolocacionApp')
  .controller('MainCtrl', ['$scope','APIMapsService', function ($scope, APIMapsService) {
  	$scope.agents = [];

  	var onSuccess = function(data){
  		$scope.agents = data.data;
  		console.log( $scope.agents);
  		console.log("se obtuvieron los agents");
  	};

  	var onError = function(){
  		console.log('error');
  	};

  	APIMapsService.getAgent(onSuccess, onError);
  }]);