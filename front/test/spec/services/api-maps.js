'use strict';

describe('Service: apiMaps', function () {

  // load the service's module
  beforeEach(module('geolocacionApp'));

  // instantiate service
  var apiMaps;
  beforeEach(inject(function (_apiMaps_) {
    apiMaps = _apiMaps_;
  }));

  it('should do something', function () {
    expect(!!apiMaps).toBe(true);
  });

});
