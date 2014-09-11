'use strict';

describe('Controller: LayoutHeaderCtrl', function () {

  // load the controller's module
  beforeEach(module('frontGeolocacionApp'));

  var LayoutHeaderCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    LayoutHeaderCtrl = $controller('LayoutHeaderCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
