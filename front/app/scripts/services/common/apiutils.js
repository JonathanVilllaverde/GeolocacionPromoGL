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
    var serverURLHeroku = 'http://backgeolocation.herokuapp.com';
    var defaultPollingTime = 10000;
    var polls = {};

  	this.getServerURL = function(){
	  	//return serverURL;
	  	//return serverURLNode;
        return serverURLHeroku;
	};

	// TODO http://andyshora.com/promises-angularjs-explained-as-cartoon.html
	this.get = function(resourceURL){
		return $http.get(resourceURL)
            .then(function(response) {
                if (typeof response.data === 'object') {
                    return response.data;
                } else {
                    return $q.reject(response.data);
                }

            }, function(response) {
                return $q.reject(response.data);
       		});
    };

	this.post = function(resourceURL){
		return $http.post(resourceURL)
            .then(function(response) {
                if (typeof response.data === 'object') {
                    return response.data;
                } else {
                    return $q.reject(response.data);
                }

            }, function(response) {
                return $q.reject(response.data);
        	});
    };

    this.startPolling = function(name, url, callback) {
        if (!polls[name]) {
            var poller = function() {
                $http.get(url).then(callback);
            }
            poller();
            polls[name] = setInterval(poller, defaultPollingTime);
        }
    };

    this.stopPolling =  function(name) {
        clearInterval(polls[name]);
        delete polls[name];
    };

	this.put = function(resourceURL){};
	this.delete = function(resourceURL){};

  }]);
