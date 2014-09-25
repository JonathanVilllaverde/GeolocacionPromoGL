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
        var resource = '/agents/latlngbounds',
            url = serverURL + resource +'?southwest='+JSON.stringify(sw)+'&northeast='+JSON.stringify(ne);

        ApiUtils.startPolling('getAgents',url, success);
    }

    this.getAgentsIdle = function(success, error){
        var resource = '/agents/idle',
            url = serverURL + resource;

        ApiUtils.startPolling('getAgentsIdle',url, success);

    }

    this.getAgentHistory = function(id, success, error){
        var resource = '/agents/'+id+'/history';
        
        ApiUtils.get(serverURL + resource)
            .then(function(data) {
                success(data);
                console.log(data);
            }, function(data) {
                error(data);
            });

    }

 }]);
