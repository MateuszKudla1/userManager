var userApp = angular.module('userApp', []);

userApp.controller('userCtrl', function ($scope, $http){
	$scope.refreshUser = function(){
		$http.get('/usermanagement/user')
		.success(function(data){
			$scope.user = data;
		});
	};
});