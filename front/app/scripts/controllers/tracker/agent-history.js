'use strict';

/**
 * @ngdoc function
 * @name geolocacionApp.controller:TrackerAgentHistoryCtrl
 * @description
 * # TrackerAgentHistoryCtrl
 * Controller of the geolocacionApp
 */
angular.module('geolocacionApp')
  .controller('AgentHistoryCtrl',  ['$scope','APITrackerService','$modal', function ($scope, APITrackerService, $modal) {

  		$scope.items = [];

   		$scope.showHistory = function(event){

   			var onSuccess = function(data){
		      $scope.items = data;
		      showModal();
		    };

		    var onError = function(){
		      console.log('error');
		    };

		    // HARCODE
		    //event.target.id = '542325cee4b0e1b339fc39dc';

    		APITrackerService.getAgentHistory(event.target.id ,onSuccess, onError);
		};

		var showModal = function(){
			var modalInstance = $modal.open({
		      templateUrl: 'myModalContent.html',
		      controller: ModalInstanceCtrl,
		      resolve: {
		        items: function () {
		          return $scope.items;
		        }
		      }
		    });
		};

		var ModalInstanceCtrl = function ($scope, $modalInstance, items) {
		  $scope.items = items;

		  $scope.ok = function () {
		    $modalInstance.close($scope.selected.item);
		  };

		  $scope.cancel = function () {
		    $modalInstance.dismiss('cancel');
		  };
		};

  }]);