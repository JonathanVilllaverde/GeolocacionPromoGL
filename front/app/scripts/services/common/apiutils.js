'use strict';

/**
 * @ngdoc service
 * @name geolocacionApp.common/apiutils
 * @description
 * # common/apiutils
 * Service in the geolocacionApp.
 */
angular.module('geolocacionApp')
  .service('ApiUtils', ['$http','$q', function ($http, $q) {
    // AngularJS will instantiate a singleton by calling "new" on this function
    var serverURL = '';
  	var serverURLNode = 'http://localhost:5000/api';

  	this.getServerURL = function(){
	  	//return serverURL;
	  	return serverURLNode;
	};

	// TODO http://andyshora.com/promises-angularjs-explained-as-cartoon.html
	this.get = function(resourceURL){
		return $http.get(resourceURL)
            .then(function(response) {
                if (typeof response.data === 'object') {
                    return response.data;
                } else {
                    // invalid response
                    return $q.reject(response.data);
                }

            }, function(response) {
                // something went wrong
                return $q.reject(response.data);
        	});
        }
	};
	this.post = function(resourceURL){
		return $http.post(resourceURL)
            .then(function(response) {
                if (typeof response.data === 'object') {
                    return response.data;
                } else {
                    // invalid response
                    return $q.reject(response.data);
                }

            }, function(response) {
                // something went wrong
                return $q.reject(response.data);
        	});
        }
	};

	this.put = function(resourceURL){};
	this.delete = function(resourceURL){};
  }]);
