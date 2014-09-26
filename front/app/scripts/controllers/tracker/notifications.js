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

   $scope.notifications =[];

   APITrackerService.stopPolling('getAgentsIdle');

   var onSuccess = function(data){
       $scope.notifications = data.data;
   };

   var onError = function(){
      console.log('error');
   };

    APITrackerService.getAgentsIdle(onSuccess, onError);

  }]);