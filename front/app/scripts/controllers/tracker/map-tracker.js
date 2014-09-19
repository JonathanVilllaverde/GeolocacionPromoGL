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
   	$scope.agents = [{  
      "id":"54181fab12f16304295ff590",
      "latLong":{  
         "x":-3.0,
         "y":3.0
      },
      "name":"gendarmeCritical",
      "vehicle":null
   },
   {  
      "id":"54181fab12f16304295ff591",
      "latLong":{  
         "x":-40.0,
         "y":3.0
      },
      "name":"gendarmeCritical",
      "vehicle":null
   },
   {  
      "id":"5418887412f18f79d3ed4936",
      "latLong":{  
         "x":-3.0,
         "y":33.0
      },
      "name":"gendarmeCritical",
      "vehicle":null
   },
   {  
      "id":"541888b212f11adfc45da1b7",
      "latLong":{  
         "x":-33.0,
         "y":33.0
      },
      "name":"gendarmeCritical",
      "vehicle":null
   },
   {  
      "id":"5418865d12f1af1b013d234a",
      "latLong":{  
         "x":-34.0,
         "y":23.0
      },
      "name":"inside",
      "vehicle":null
   },
   {  
      "id":"5418933312f1476cf66d1b3e",
      "latLong":{  
         "x":-23.0,
         "y":13.0
      },
      "name":"gendarmeCritical",
      "vehicle":null
   },
   {  
      "id":"5418865d12f1af1b013d2348",
      "latLong":{  
         "x":-13.0,
         "y":13.0
      },
      "name":"gendarmeCritical",
      "vehicle":null
   },
   {  
      "id":"5418935312f1eef9a7ff6ff4",
      "latLong":{  
         "x":-23.0,
         "y":3.0
      },
      "name":"gendarmeCritical",
      "vehicle":null
   },
   {  
      "id":"54181fac12f16304295ff593",
      "latLong":{  
         "x":-22.0,
         "y":2.0
      },
      "name":"gendarNormal",
      "vehicle":{  
         "id":"54181fac12f16304295ff594",
         "latLong":null,
         "patente":"CFG-222",
         "area":{  
            "poligono":{  
               "points":[  
                  {  
                     "x":-73.99756,
                     "y":40.73083
                  },
                  {  
                     "x":-73.99756,
                     "y":40.741404
                  },
                  {  
                     "x":-73.988135,
                     "y":40.741404
                  },
                  {  
                     "x":-73.988135,
                     "y":40.73083
                  }
               ]
            }
         }
      }
   }];
   	$scope.ZOOM_LIMIT = 1;

  	var onSuccess = function(data){
  		$scope.agents = data;
  	};

  	var onError = function(){
  		console.log('error');
  	};

  	$scope.$on('mapsInitialized', function(evt, maps) {
      $scope.map = maps[0];

      // De acuerdo al zoom que se tiene llamar al servicio
      $scope.map.addListener('zoom_changed', function() { 

      	console.log('changed zoom '+$scope.map.zoom); 
      });

      // Cambio de posicion en el mapa
      $scope.map.addListener('center_changed', function() { 

      	console.log('center changed '+$scope.map.center); 
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

			content += '</div>'+'</div>';

		infoWindow.content = content;
    	infoWindow.open($scope.map, this);
    }

    var getAgentById = function(id){
    	for (var i = 0; i < $scope.agents.length; i++) {
    		var element = $scope.agents[i];
    		if(element.id === id){
    			return element;
    		}
    	};
    }

  	//APITrackerService.getAgent(onSuccess, onError);
  }]);
