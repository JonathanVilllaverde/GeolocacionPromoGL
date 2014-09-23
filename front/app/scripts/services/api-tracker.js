'use strict';

/**
 * @ngdoc service
 * @name geolocacionApp.apiMaps
 * @description
 * # apiMaps
 * Service in the geolocacionApp.
 */
angular.module('geolocacionApp')
  .service('APITrackerService', ['ApiUtils',function (ApiUtils) {
    // AngularJS will instantiate a singleton by calling "new" on this function
    var serverURL = ApiUtils.getServerURL(); 
  	var resource = '/services/getAgent';

    this.getAgent = function(success, error, sw, ne){
        var url = serverURL + resource +'/'+sw.lat()+'/'+sw.lng()+'/'+ne.lat()+'/'+ne.lng();
        ApiUtils.startPolling('getAgent',url, success);
    	// ApiUtils.get(serverURL + resource +'/'+sw.lat()+'/'+sw.lng()+'/'+ne.lat()+'/'+ne.lng())
     //        .then(function(data) {
     //        	success(data);
     //        	console.log(data);
     //        }, function(data) {
     //        	error(data);
     //        });
    }



 }]);
