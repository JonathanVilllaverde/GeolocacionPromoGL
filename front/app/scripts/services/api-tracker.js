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

    this.getAgents = function(success, error, sw, ne){
        var resource = '/getAgents';
        var url = serverURL + resource +'/'+sw.lat()+'/'+sw.lng()+'/'+ne.lat()+'/'+ne.lng();
        ApiUtils.startPolling('getAgents',url, success);
    }

    this.getNotInArea = function(success, error){
        var resource = '/getNotInArea';
        ApiUtils.get(serverURL + resource)
            .then(function(data) {
                success(data);
                console.log(data);
            }, function(data) {
                error(data);
            });
    }



 }]);
