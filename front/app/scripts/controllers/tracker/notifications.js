'use strict';

/**
 * @ngdoc function
 * @name geolocacionApp.controller:TrackerNotificationsCtrl
 * @description
 * # TrackerNotificationsCtrl
 * Controller of the geolocacionApp
 */
angular.module('geolocacionApp')
  .controller('NotificationsCtrl',  ['$scope','APITrackerService', function ($scope, APITrackerService) {
   	$scope.notifications =[  
   {  
      "id":"5421838088ca59c541f33007",
      "location":null,
      "history":[  

      ],
      "inarea":false,
      "patente":"CFG-222",
      "area":null
   },
   {  
      "id":"5421838088ca59c541f33008",
      "location":null,
      "history":[  

      ],
      "inarea":false,
      "patente":"CFG-223",
      "area":null
   },
   {  
      "id":"5421838088ca59c541f33009",
      "location":{  
         "x":-3.0,
         "y":3.0
      },
      "history":[  

      ],
      "inarea":false,
      "name":"gendarmeNormal",
      "vehicle":null,
      "area":null
   },
   {  
      "id":"5421838088ca59c541f3300a",
      "location":{  
         "x":-73.99756,
         "y":40.73083
      },
      "history":[  

      ],
      "inarea":false,
      "name":"gendarmeCritical",
      "vehicle":null,
      "area":null
   },
   {  
      "id":"5421842388caa8669f289f2e",
      "location":null,
      "history":[  

      ],
      "inarea":false,
      "patente":"CFG-222",
      "area":null
   },
   {  
      "id":"5421842388caa8669f289f2f",
      "location":null,
      "history":[  

      ],
      "inarea":false,
      "patente":"CFG-223",
      "area":null
   },
   {  
      "id":"5421842388caa8669f289f30",
      "location":{  
         "x":-73.99756,
         "y":40.73083
      },
      "history":[  

      ],
      "inarea":false,
      "name":"gendarmeNormal",
      "vehicle":null,
      "area":null
   },
   {  
      "id":"5421842388caa8669f289f31",
      "location":{  
         "x":-73.99756,
         "y":40.73083
      },
      "history":[  

      ],
      "inarea":false,
      "name":"gendarmeCritical",
      "vehicle":null,
      "area":null
   },
   {  
      "id":"5421848688ca170c23c0b935",
      "location":null,
      "history":[  

      ],
      "inarea":false,
      "patente":"CFG-222",
      "area":null
   },
   {  
      "id":"5421848688ca170c23c0b936",
      "location":null,
      "history":[  

      ],
      "inarea":false,
      "patente":"CFG-223",
      "area":null
   },
   {  
      "id":"5421848688ca170c23c0b937",
      "location":{  
         "x":-73.99756,
         "y":40.73083
      },
      "history":[  

      ],
      "inarea":false,
      "name":"gendarmeNormal",
      "vehicle":null,
      "area":null
   },
   {  
      "id":"5421848688ca170c23c0b938",
      "location":{  
         "x":-73.99756,
         "y":40.73083
      },
      "history":[  

      ],
      "inarea":false,
      "name":"gendarmeCritical",
      "vehicle":null,
      "area":null
   },
   {  
      "id":"542187ff88ca9238254ddc08",
      "location":{  
         "x":-73.99756,
         "y":40.73083
      },
      "history":[  

      ],
      "inarea":false,
      "name":"gendarmeCritical",
      "vehicle":null,
      "area":null
   },
   {  
      "id":"542187ff88ca9238254ddc09",
      "location":{  
         "x":-73.99756,
         "y":40.73083
      },
      "history":[  

      ],
      "inarea":false,
      "name":"gendarmeNormal",
      "vehicle":null,
      "area":null
   },
   {  
      "id":"542187ff88ca9238254ddc0b",
      "location":null,
      "history":[  

      ],
      "inarea":false,
      "patente":"CFG-222",
      "area":null
   },
   {  
      "id":"542187ff88ca9238254ddc0c",
      "location":null,
      "history":[  

      ],
      "inarea":false,
      "patente":"CFG-223",
      "area":null
   },
   {  
      "id":"5421885788cafc1448a48d57",
      "location":{  
         "x":-73.99756,
         "y":40.73083
      },
      "history":[  

      ],
      "inarea":false,
      "name":"gendarmeCritical",
      "vehicle":null,
      "area":null
   },
   {  
      "id":"5421885788cafc1448a48d58",
      "location":{  
         "x":-73.99756,
         "y":40.73083
      },
      "history":[  

      ],
      "inarea":false,
      "name":"gendarmeNormal",
      "vehicle":null,
      "area":null
   },
   {  
      "id":"5421885788cafc1448a48d5a",
      "location":null,
      "history":[  

      ],
      "inarea":false,
      "patente":"CFG-222",
      "area":null
   },
   {  
      "id":"5421885788cafc1448a48d5b",
      "location":null,
      "history":[  

      ],
      "inarea":false,
      "patente":"CFG-223",
      "area":null
   },
   {  
      "id":"542189cd88ca597d214c1162",
      "location":null,
      "history":[  

      ],
      "inarea":false,
      "patente":"CFG-222",
      "area":null
   },
   {  
      "id":"542189cd88ca597d214c1163",
      "location":null,
      "history":[  

      ],
      "inarea":false,
      "patente":"CFG-223",
      "area":null
   },
   {  
      "id":"542189cd88ca597d214c1164",
      "location":{  
         "x":-73.99756,
         "y":40.73083
      },
      "history":[  

      ],
      "inarea":false,
      "name":"gendarmeNormal",
      "vehicle":null,
      "area":null
   },
   {  
      "id":"542189cd88ca597d214c1165",
      "location":{  
         "x":-73.99756,
         "y":40.73083
      },
      "history":[  

      ],
      "inarea":false,
      "name":"gendarmeCritical",
      "vehicle":null,
      "area":null
   }];

    var onSuccess = function(data){
      $scope.notifications = data.data;
    };

    var onError = function(){
      console.log('error');
    };

    //APITrackerService.getNotInArea(onSuccess, onError);

  }]);