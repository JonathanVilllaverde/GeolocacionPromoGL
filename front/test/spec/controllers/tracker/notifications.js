'use strict';

describe('Controller: TrackerNotificationsCtrl', function () {

  // load the controller's module
  beforeEach(module('geolocacionApp'));

  var TrackerNotificationsCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    TrackerNotificationsCtrl = $controller('TrackerNotificationsCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
