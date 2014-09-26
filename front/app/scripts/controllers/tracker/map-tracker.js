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
    $scope.areas = [];
    $scope.ZOOM_LIMIT = 1;
    $scope.dynMarkers = [];

    var onSuccess = function(res){
      $scope.agents = res.data;

      for (var i=0; i< $scope.agents.length; i++) {
        var latLng = new google.maps.LatLng($scope.agents[i].location.lat, $scope.agents[i].location.lng),
          icon = 'images/track.jpg',
          found = setMarkerPosition($scope.agents[i].id, latLng);

        if ( ! found ){
          if ( $scope.agents[i].name ){
            icon = 'images/officer.png';
          }

          var marker = new google.maps.Marker({
            position: latLng,
            title: $scope.agents[i].name,           
            id: $scope.agents[i].id,
            icon: icon
          });

          google.maps.event.addListener(marker, 'click', showInfoWindow);

          $scope.dynMarkers.push(marker);
        }
      };

      $scope.markerClusterer = new MarkerClusterer($scope.map, $scope.dynMarkers, getMarkerClustererOptions());
  	};

    var renderAreas = function(data){
      $scope.areas = [];
      for (var i = 0; i < data.length; i++) {
        var points = [];
        var polygon_points = data[i].poligono.points;
        for (var j = 0; j < polygon_points.length; j++) {
          points.push([polygon_points[j].x,polygon_points[j].y]);
        };

        var area = {
          'id':data[i].id,
          'name':data[i].name,
          'points': points
        };

        $scope.areas.push(area);
      }
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

      APITrackerService.getAreas(renderAreas, onError);

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

        APITrackerService.stopPolling('getAgents');
        
        // Limite del zoom para visualizar los agentes, pasando este limite no se piden agentes
        if ( $scope.map.zoom >= $scope.ZOOM_LIMIT ){
          APITrackerService.getAgents(onSuccess, onError, southWest, northEast);
        }

      });
      
    });

    var infoWindow = new google.maps.InfoWindow({
    	content: '',
    	maxWidth: 200
    });

	var showInfoWindow = function() {
		var agent = getAgentById(this.id),
			content = '<div class="container"><div class="row"><div class="col-mod-12">';
      if ( agent.name ){
        content += '<h3 class="firstHeading">Gendarme</h3>';
        content += '<p>Nombre: <i>'+agent.name+'</i> <br>';
        if ( agent.vehicle ){
          content += 'Vehiculo asignado: <i>'+agent.vehicle.type+'</i> <br>patente: '+ agent.vehicle.patente;
        } else {
          content += 'Vehiculo asignado: <i>ninguno</i>';
        }
        content += '</p>';
      } else {
        content += '<h3 class="firstHeading">Patrulla</h3>';
        content += '<p>Vehiculo: <i>'+agent.type+'</i> <br>patente: '+ agent.patente +'</p>';
      }

      content += '<div ng-controller="AgentHistoryCtrl">';
        content += '<button type="button" ng-click="showHistory($event)" id="'+agent.id+'" class="btn btn-success">Ver Historial</button>';
			content += '</div>';

      content += '</div></div>';
      content += '</div>';

      var compiled = $compile(content)($scope);

		  infoWindow.content = compiled[0];
    	infoWindow.open($scope.map, this);
  }

  var setMarkerPosition = function(id, latLng){
    for (var i = $scope.dynMarkers.length - 1; i >= 0; i--) {
      if( $scope.dynMarkers[i].id === id ){
        $scope.dynMarkers[i].setPosition(latLng);
        return true;
      }
    }
    return false;
  }

  var getMarkerClustererOptions = function(){
    return {styles: [{
          height: 53,
          url: "images/marker.png",
          width: 53
        }]};
  }

  }]);
