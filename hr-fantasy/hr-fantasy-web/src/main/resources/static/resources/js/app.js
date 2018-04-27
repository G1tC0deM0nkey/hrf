
var myApp = angular.module('myApp',['ngRoute','myApp.controllers']);

myApp.config(['$routeProvider', '$httpProvider',
        function ($routeProvider, $httpProvider) {
            $routeProvider
                .when('/account', {
                    templateUrl: 'views/account.html',
                    controller: 'AccountController'
                })
                .when('/entries', {
                    templateUrl: 'views/entries.html',
                    controller: 'EntriesController'
                })
                .when('/competitions', {
                    templateUrl: 'views/competitions.html',
                    controller: 'CompetitionsController'
                })
		        .when('/results', {
                    templateUrl: 'views/results.html',
                    controller: 'ResultsController'
                })
                .when('/admin', {
                    templateUrl: 'views/admin.html',
                    controller: 'AdminController'
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



        ;
