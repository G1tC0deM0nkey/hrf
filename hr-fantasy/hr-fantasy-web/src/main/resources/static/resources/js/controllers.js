var controllers = angular.module('myApp.controllers',[]);

controllers.controller('UserController', function ($scope, $http) {

    $scope.user = {
        name: null,
        password: null,
        token: null
    };

    $scope.login = function(user) {

        var loginItem = $( "li[id='loginitem']" )[0];
        var logoutItem = $( "li[id='logoutitem']" )[0];

        var username = user.name;
        var password = user.password;

        $http.post('/user/login?username=' + username + '&pin=' + password)
            .success(function(data) {
                user.token = data;

                $scope.setUser($scope.user);
            })
            .error(function(data) {
                alert('User Authentication Failed for ' + username);
                user.name = null;
                user.token = null;
                user.password = null;

                $scope.setUser($scope.user);
            });

    };

    $scope.logout = function(user) {

        $http.post('user/logout?username=' + user.name)
            .success(function(data) {
                user.name = null;
                user.password = null;
                user.token = null;

                $scope.setUser($scope.user);
            })
            .error(function(data) {
                user.name = null;
                user.password = null;
                user.token = null;

                $scope.setUser($scope.user);
            });

    };

    $scope.setUser = function (user) {
        $scope.user = user;
        $scope.$broadcast('user', user);

        var loginItem = $( "li[id='loginitem']" )[0];
        var logoutItem = $( "li[id='logoutitem']" )[0];

        if(user.name != null && user.token != null)
        {
            loginItem.className='dropdown hide';
            logoutItem.className='dropdown';
        }
        else {
            loginItem.className='dropdown';
            logoutItem.className='dropdown hide';
        }
    };

    $scope.showNewAccount = function() {
        var na = $("#newaccount");
        na.removeClass('hidden');

        var naa = $("#newaccountalert");
        naa.removeClass('hidden');

        var fa = $("#forgotalert");
        fa.addClass('hidden');

        var sia = $("#signinalert");
        sia.addClass('hidden');
    }

    $scope.showForgottenCredentials = function() {
        var na = $("#newaccount");
        na.addClass('hidden');

        var naa = $("#newaccountalert");
        naa.addClass('hidden');

        var fa = $("#forgotalert");
        fa.removeClass('hidden');

        var sia = $("#signinalert");
        sia.addClass('hidden');
    }

});

controllers.controller('CompetitionsController', function($scope, $http){

});

controllers.controller('EntriesController', function($scope, $http){

});

controllers.controller('ResultsController', function($scope, $http){

});


