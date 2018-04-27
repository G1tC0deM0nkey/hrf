var controllers = angular.module('myApp.controllers',[]);

controllers.controller('UserController', function ($scope, $http) {

    $scope.config = {
        ownerName: "Administrator",
        ownerEmail: "abc@abc.com"
    };

    $scope.user = {
        userName: null,
        password: null,
        token: null
    };

    $scope.newUser = {
    };

    $scope.login = function(user) {

        var loginItem = $( "li[id='loginitem']" )[0];
        var logoutItem = $( "li[id='logoutitem']" )[0];

        var username = user.userName;
        var password = user.password;

        $http.post('/user/login?username=' + username + '&pin=' + password)
            .success(function(data) {
                var user = data;

                $scope.setUser(user);
            })
            .error(function(data) {
                alert('User Authentication Failed for ' + username);
                var user = {};

                $scope.setUser(user);
            });

    };

    $scope.logout = function(user) {

        $http.post('/user/logout?username=' + user.userName)
            .success(function(data) {
                var user = {};

                $scope.setUser(user);
            })
            .error(function(data) {
                user = {};

                $scope.setUser(user);
            });

    };

    $scope.setUser = function (user) {
        $scope.user = user;
        $scope.$broadcast('user', user);

        var loginItem = $( "li[id='loginitem']" )[0];
        var logoutItem = $( "li[id='logoutitem']" )[0];

        if(user.displayName && user.token)
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

    $scope.createNewUser = function() {

        $http({
            method: "POST",
            url: "/user/add",
            data: JSON.stringify($scope.newUser),
            headers: { 'Content-type': 'application/json' }
        })
        .then(function (success) {
            alert(success);
        },
        function(error) {
            alert(error);
        });

    }

});


controllers.controller('AccountController', function($scope, $http){

    $scope.authorised = function () {
        return $scope.$parent.user && $scope.$parent.user.token;
    }

});

controllers.controller('CompetitionsController', function($scope, $http){
    $scope.authorised = function () {
        return $scope.$parent.user && $scope.$parent.user.token;
    }
});

controllers.controller('EntriesController', function($scope, $http){
    $scope.authorised = function () {
        return $scope.$parent.user && $scope.$parent.user.token;
    }
});

controllers.controller('ResultsController', function($scope, $http){
    $scope.authorised = function () {
        return $scope.$parent.user && $scope.$parent.user.token;
    }
});

controllers.controller('AdminController', function($scope, $http){

    $scope.authorised = function () {
        return $scope.$parent.user && $scope.$parent.user.token && $scope.$parent.user.admin;
    }

});



