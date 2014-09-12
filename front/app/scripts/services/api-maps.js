'use strict';

/**
 * @ngdoc service
 * @name geolocacionApp.apiMaps
 * @description
 * # apiMaps
 * Service in the geolocacionApp.
 */
angular.module('geolocacionApp')
  .service('apiMapsService', ['ApiUtils',function (ApiUtils) {
    // AngularJS will instantiate a singleton by calling "new" on this function
    var serverURL = ApiUtils.getServerURL(); 
  	var resource = '/services/getGendarmes';

    this.getGendarmes = function(data, IdPage, success, error){
      //console.log(serverURL + resource + '/' + IdPage);
    	//ApiUtils.post(serverURL + resource + '/' + IdPage, data, success, error);
    }

 }]);
