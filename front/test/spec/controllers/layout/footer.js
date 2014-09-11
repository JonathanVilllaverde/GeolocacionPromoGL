'use strict';

describe('Controller: LayoutFooterCtrl', function () {

  // load the controller's module
  beforeEach(module('geolocacionApp'));

  var LayoutFooterCtrl,
    scope;

  // Initialize the controller and a mock scope
  beforeEach(inject(function ($controller, $rootScope) {
    scope = $rootScope.$new();
    LayoutFooterCtrl = $controller('LayoutFooterCtrl', {
      $scope: scope
    });
  }));

  it('should attach a list of awesomeThings to the scope', function () {
    expect(scope.awesomeThings.length).toBe(3);
  });
});
