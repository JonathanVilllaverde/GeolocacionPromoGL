'use strict';

/**
 * @ngdoc function
 * @name geolocacionApp.controller:TrackerMapTrackerCtrl
 * @description
 * # TrackerMapTrackerCtrl
 * Controller of the geolocacionApp
 */
angular.module('geolocacionApp')
  .controller('MapTrackerCtrl',  ['$scope','APITrackerService','$compile', function ($scope, APITrackerService, $compile) {
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
        var sw = $scope.map.getBounds().getSouthWest();
        var ne = $scope.map.getBounds().getNorthEast();
          
        var southWest = {
          'lat':sw.lat(),
          'lng': sw.lng()
        };

        var northEast = {
          'lat':ne.lat(),
          'lng': ne.lng()
        };

        APITrackerService.getAgents(onSuccess, onError, southWest, northEast);

      });
      
    });

    var infoWindow = new google.maps.InfoWindow({
    	content: '',
    	maxWidth: 200
    });

	$scope.showInfoWindow = function() {
		var agent = getAgentById(this.id),
			content = '<div class="container"><div class="row"><div class="col-mod-12">'+'<h3 class="firstHeading">'+this.title+'</h3>';

			if ( agent.vehicle ){
				content += '<p>Vehiculo asignado: <i>Camioneta</i> <br>patente: '+ agent.vehicle.patente+'</p>';
			} else {
				content += '<p>Vehiculo asignado: <i>ninguno</i> </p>';
			}
      content += '<div ng-controller="AgentHistoryCtrl">';
        content += '<button type="button" ng-click="showHistory($event)" id="'+agent.id+'" class="btn btn-info">Ver Historial</button>';
			content += '</div>';

      content += '</div></div>';
      content += '</div>';

      var compiled = $compile(content)($scope);

		  infoWindow.content = compiled[0];
    	infoWindow.open($scope.map, this);
  }

  }]);
