'use strict';

/**
 * @ngdoc function
 * @name geolocacionApp.controller:TrackerMapTrackerCtrl
 * @description
 * # TrackerMapTrackerCtrl
 * Controller of the geolocacionApp
 */
angular.module('geolocacionApp')
  .controller('MapTrackerCtrl',  ['$scope','APITrackerService', function ($scope, APITrackerService) {
   	$scope.agents = [];
   	$scope.ZOOM_LIMIT = 1;

  	var onSuccess = function(data){
  		$scope.agents = data.data;
  	};

  	var onError = function(){
  		console.log('error');
  	};

    var getAgentById = function(id){
      for (var i = 0; i < $scope.agents.length; i++) {
        var element = $scope.agents[i];
        if(element.id === id){
          return element;
        }
      }
    };

  	$scope.$on('mapsInitialized', function(evt, maps) {
      $scope.map = maps[0];

      $scope.map.addListener('bounds_changed', function() {
        var sw = $scope.map.getBounds().getSouthWest(),
          ne = $scope.map.getBounds().getNorthEast();
          
          APITrackerService.getAgents(onSuccess, onError, sw, ne);
      });
      
    });

    var infoWindow = new google.maps.InfoWindow({
    	content: '',
    	maxWidth: 200
    });

	$scope.showInfoWindow = function() {
		var agent = getAgentById(this.id),
			content = '<div>'+'<h3 class="firstHeading">'+this.title+'</h3>'+'<div>';

			if ( agent.vehicle ){
				content += '<p>Vehiculo asignado:'+ agent.vehicle.id +'<br>patente: '+ agent.vehicle.patente+'</p>';
			} else {
				content += '<p>Vehiculo asignado: <i>ninguno</i> </p>';
			}
      //content += '<div ng-controller="AgentHistoryCtrl">';
      content += '<button type="button" ng-click="open()" id="'+agent.id+'" class="btn btn-info">Ver Historial</button>';
      //content += '</div>';
			content += '</div></div>';

		infoWindow.content = content;
    	infoWindow.open($scope.map, this);
  }

  $scope.open = function(){
        console.log('here map-tracker controller');
      }

  }]);
