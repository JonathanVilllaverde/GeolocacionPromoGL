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
  .config(function ($routeProvider) {
    $routeProvider
      .when('/', {
        templateUrl: 'views/main.html',
        controller: 'MainCtrl'
      })
      .when('/about', {
        templateUrl: 'views/about.html',
        controller: 'AboutCtrl'
      })
      .when('/contact', {
        templateUrl: 'views/contact.html',
        controller: 'ContactCtrl'
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
      .otherwise({
        redirectTo: '/'
      });
  });
