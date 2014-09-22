'use strict';

/**
 * @ngdoc overview
 * @name geolocacionApp
 * @description
 * # geolocacionApp
 *
 * Main module of the application.
 */
angular
  .module('geolocacionApp', [
    'ngAnimate',
    'ngCookies',
    'ngResource',
    'ngRoute',
    'ngSanitize',
    'ngTouch',
    'ngMap'
  ])
  .config(['$routeProvider',function ($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'views/main.html',
        controller: 'MainCtrl'
      })
      .when('/layout/header', {
        templateUrl: 'views/layout/header.html',
        controller: 'HeaderCtrl'
      })
      .when('/layout/navbar', {
        templateUrl: 'views/layout/navbar.html',
        controller: 'NavbarCtrl'
      })
      .when('/layout/footer', {
        templateUrl: 'views/layout/footer.html',
        controller: 'FooterCtrl'
      })
      .when('/tracker/dashboard', {
        templateUrl: 'views/tracker/dashboard.html',
        controller: 'DashboardCtrl'
      })
      .when('/tracker/notifications', {
        templateUrl: 'views/tracker/notifications.html',
        controller: 'NotificationsBoardCtrl'
      })
      .when('/tracker/map-tracker', {
        templateUrl: 'views/tracker/map-tracker.html',
        controller: 'MapTrackerCtrl'
      })
      .otherwise({
        redirectTo: '/'
      });
  }]);
