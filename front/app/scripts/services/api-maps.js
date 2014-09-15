'use strict';

/**
 * @ngdoc service
 * @name geolocacionApp.apiMaps
 * @description
 * # apiMaps
 * Service in the geolocacionApp.
 */
angular.module('geolocacionApp')
  .service('APIMapsService', ['ApiUtils',function (ApiUtils) {
    // AngularJS will instantiate a singleton by calling "new" on this function
    var serverURL = ApiUtils.getServerURL(); 
  	var resource = '/services/getAgent';

    this.getAgent = function(success, error){

    	ApiUtils.get(serverURL + resource +'/1') 
    		// then() called when son gets back
            .then(function(data) {
            	success(data);
            	console.log(data);
            }, function(data) {
            	error(data);
            });
    }

 }]);
