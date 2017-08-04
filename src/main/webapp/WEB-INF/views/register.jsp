<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head><link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>

<script>

var userApp = angular.module('userAppr', []);
userApp.controller('userCtrlr', function($rootScope, $http,$scope){

	$rootScope.user = {
			"id":0,
			"lastname":null,
			"password":null,
			"birthdate":null,
			"username":null,
			"firstname":null
	};
 
	function myFunction() { 
		 if (window.confirm('Success'))
		 {
		   
		   window.location.href = '/usermanagement/';
		 }
		}
    
	$scope.cancel= function() { 
		 if (window.confirm('Cancel?'))
		 {
		   
		   window.location.href = '/usermanagement/';
		 }
		}
   
            
            $rootScope.addUser = function(p){
                
                $http.post('/usermanagement/user/newUser',p).then(successCallback, errorCallback);

                function successCallback(response){
                	myFunction();
                	console.log(response);
                	console.log(p);
                	
                }
                function errorCallback(error){
                	
                	console.log(error, 'can not add data.');
                }
                
                };
    
    
}); 
</script>


</head>

<body ng-app="userAppr">
<div ng-controller="userCtrlr" class="col-md-6 col-md-offset-3">
    <h2>Add user</h2>
    <form name="form" ng-submit="vm.register()" role="form">
      <div class="form-group" ng-class="{ 'has-error': form.firstName.$dirty && form.firstName.$error.required }">
            <label for="username">Username</label>
            <input type="text" name="firstName" id="firstName" class="form-control" ng-model="user.username" required />
            <span ng-show="form.firstName.$dirty && form.firstName.$error.required" class="help-block">First name is required</span>
        </div>
    
        <div class="form-group" ng-class="{ 'has-error': form.firstName.$dirty && form.firstName.$error.required }">
            <label for="username">First name</label>
            <input type="text" name="firstName" id="firstName" class="form-control" ng-model="user.firstname" required />
            <span ng-show="form.firstName.$dirty && form.firstName.$error.required" class="help-block">First name is required</span>
        </div>
        <div class="form-group" ng-class="{ 'has-error': form.lastName.$dirty && form.lastName.$error.required }">
            <label for="username">Last name</label>
            <input type="text" name="lastName" id="Text1" class="form-control" ng-model="user.lastname" required />
            <span ng-show="form.lastName.$dirty && form.lastName.$error.required" class="help-block">Last name is required</span>
        </div>
        <div class="form-group" ng-class="{ 'has-error': form.username.$dirty && form.username.$error.required }">
            <label for="username">birthdate</label>
            <input type="text"  class="form-control" ng-model="user.birthdate" required />
            
        </div>
        <div class="form-group" ng-class="{ 'has-error': form.password.$dirty && form.password.$error.required }">
            <label for="password">Password</label>
            <input type="password" name="password" id="password" class="form-control" ng-model="user.password" required />
            
        </div>
        <div class="form-actions">
        
            <button type="submit" ng-click="addUser(user)" href="/usermanagement/user/" class="btn btn-primary">Register</button>
         
            <a ng-click="cancel()" class="btn btn-link">Cancel</a>
        </div>
    </form>
</div>
</body>
</html>