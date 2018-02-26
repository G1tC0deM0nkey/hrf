
var myApp = angular.module('myApp',['ngRoute','myApp.controllers']);

myApp.config(['$routeProvider', '$httpProvider',
        function ($routeProvider, $httpProvider) {
            $routeProvider
                .when('/home', {
                    templateUrl: 'views/home.html',
                    controller: 'HomeController'
                })
                .when('/today', {
                    templateUrl: 'views/today.html',
                    controller: 'TodayController'
                })
                .when('/tomorrow', {
                    templateUrl: 'views/tomorrow.html',
                    controller: 'TomorrowController'
                })
		        .when('/login', {
                    templateUrl: 'views/home.html',
                    controller: 'HomeController'
                })
		        .when('/logout', {
                    templateUrl: 'views/home.html',
                    controller: 'HomeController'
                })
                .otherwise({
                	redirectTo: '/home'
                });

        }])
        .run(['$rootScope', '$location', '$http',
            function($rootScope, $location, $http) {
                $rootScope.$on('$routeChangeStart', function (event, next) {
                	if(!next.$$route){
                		$rootScope.currentPage = '/home';
                	} else {
                		$rootScope.currentPage = next.$$route.originalPath;
                	}
                });

        }])
//        .constant('AUTH_EVENTS', {
//            loginSuccess: 'auth-login-success',
//            loginFailed: 'auth-login-failed',
//            logoutSuccess: 'auth-logout-success',
//            notAuthenticated: 'auth-not-authenticated'
//        })
//        .factory('AuthService', function ($http, Session) {
//          var authService = {};
//
//          authService.login = function (credentials) {
//            return $http
//              .post('/login', credentials)
//              .then(function (res) {
//                Session.create(res.data.id, res.data.user.id,
//                               res.data.user.role);
//                return res.data.user;
//              });
//          };
//
//          authService.isAuthenticated = function () {
//            return !!Session.userId;
//          };
//
//          authService.isAuthorized = function (authorizedRoles) {
//            if (!angular.isArray(authorizedRoles)) {
//              authorizedRoles = [authorizedRoles];
//            }
//            return (authService.isAuthenticated() &&
//              authorizedRoles.indexOf(Session.userRole) !== -1);
//          };
//
//          return authService;
//        })
//        .service('Session', function () {
//          this.create = function (sessionId, userId, userRole) {
//            this.id = sessionId;
//            this.userId = userId;
//            this.userRole = userRole;
//          };
//          this.destroy = function () {
//            this.id = null;
//            this.userId = null;
//            this.userRole = null;
//          };
//          return this;
//        })
//        .controller('ApplicationController', function ($scope,
//                                                     USER_ROLES,
//                                                     AuthService) {
//            $scope.currentUser = null;
//            $scope.userRoles = USER_ROLES;
//            $scope.isAuthorized = AuthService.isAuthorized;
//
//            $scope.setCurrentUser = function (user) {
//              $scope.currentUser = user;
//            };
//        })


        ;
