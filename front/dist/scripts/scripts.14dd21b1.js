"use strict";angular.module("geolocacionApp",["ngAnimate","ngCookies","ngResource","ngRoute","ngSanitize","ngTouch"]).config(["$routeProvider",function(a){a.when("/",{templateUrl:"views/main.html",controller:"MainCtrl"}).when("/about",{templateUrl:"views/about.html",controller:"AboutCtrl"}).when("/contact",{templateUrl:"views/contact.html",controller:"ContactCtrl"}).when("/layout/header",{templateUrl:"views/layout/header.html",controller:"HeaderCtrl"}).when("/layout/navbar",{templateUrl:"views/layout/navbar.html",controller:"NavbarCtrl"}).when("/layout/footer",{templateUrl:"views/layout/footer.html",controller:"FooterCtrl"}).otherwise({redirectTo:"/"})}]),angular.module("geolocacionApp").controller("MainCtrl",["$scope",function(){}]),angular.module("geolocacionApp").controller("AboutCtrl",["$scope",function(){}]),angular.module("geolocacionApp").controller("NavbarCtrl",["$scope","$location",function(a,b){a.isActive=function(a){return a===b.path()}}]),angular.module("geolocacionApp").controller("FooterCtrl",["$scope",function(){}]);