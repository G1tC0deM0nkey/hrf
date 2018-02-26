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

        $http.post('/user/login?username=' + username + '&password=' + password)
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

        $http.post('user/logout?username=' + user.name + '&token=' + user.token)
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
    }

});

controllers.controller('TodayController', function($scope, $http){

});

controllers.controller('TomorrowController', function($scope, $http){

});

controllers.controller('HomeController', function($scope, $http){

});

controllers.controller('ListRacesController',function($scope, $http){
	$http.get('races/find')
	.success(function(data){
		$scope.fixtures = data;
	})
	.error(function(data){
		alert('Error');
	});
});

controllers.controller('PromptInitialisationController',function($scope, $http){

});

controllers.controller('ToggleInitialisationController',function($scope, $http){

});
