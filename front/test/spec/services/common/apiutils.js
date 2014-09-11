'use strict';

describe('Service: common/apiutils', function () {

  // load the service's module
  beforeEach(module('geolocacionApp'));

  // instantiate service
  var common/apiutils;
  beforeEach(inject(function (_common/apiutils_) {
    common/apiutils = _common/apiutils_;
  }));

  it('should do something', function () {
    expect(!!common/apiutils).toBe(true);
  });

});
