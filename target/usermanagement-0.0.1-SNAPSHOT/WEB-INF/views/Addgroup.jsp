<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head><link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>

<script>

var userApp = angular.module('userApp', []);
userApp.controller('userCtrl', function($rootScope, $http,$scope){

	$rootScope.group = 
			  {
			        "id": 0,
			        "groupname": null,
			        "userList": null
			    };
	
 

    
   
            
            $rootScope.addGroup = function(p){
                
                $http.post('/usermanagement/Addgroup',p).then(successCallback, errorCallback);

                function successCallback(response){
                
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

<body ng-app="userApp">
<div ng-controller="userCtrl" class="col-md-6 col-md-offset-3">
    <h2>Add group</h2>
    <form name="form" ng-submit="vm.register()" role="form">
      <div class="form-group" ng-class="{ 'has-error': form.firstName.$dirty && form.firstName.$error.required }">
            <label for="username">Add group name</label>
            <input type="text" name="firstName" id="firstName" class="form-control" ng-model="group.groupname" required />
            <span ng-show="form.firstName.$dirty && form.firstName.$error.required" class="help-block">First name is required</span>
        </div>
    
        <div class="form-actions">
        
            <button type="submit" ng-click="addGroup(group)" href="/usermanagement/user/" class="btn btn-primary">Register</button>
         
            <a href="#!/login" class="btn btn-link">Cancel</a>
        </div>
    </form>
</div>
</body>
</html>