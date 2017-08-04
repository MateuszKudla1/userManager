<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>

	<script>


var userApps = angular.module('userApps', []);
userApps.controller('userCtrls', function($rootScope, $http,$scope){
	$rootScope.users = [];
	$rootScope.selected = {};
	$rootScope.groups = [];
	$rootScope.groupsToAdd=[];
 
	  $rootScope.reset = function () {
	        $rootScope.selected = {};
	    };
	
     $rootScope.getTemplate = function (p) {
        if (p.id === $rootScope.selected.id) return 'edit';
        else return 'display';
    };
    
    $rootScope.editContact = function (p) {
        $rootScope.selected = angular.copy(p);
    };
   
  $rootScope.refreshUser = function(){
    
    $http.get('/usermanagement/user').then(successCallback, errorCallback);

    function successCallback(response){
    	$rootScope.reset();
    	$rootScope.users = response.data;
    	console.log(response);
    	console.log($rootScope);
    }
    function errorCallback(error){
    	console.log(error, 'can not get data.');
    }
    
    };
    
    
    $rootScope.showUsersGroups = function(userID){
        
        $http.get('/usermanagement/user/'+userID).then(successCallback, errorCallback);

        function successCallback(response){
        	
        	$rootScope.groups = response.data;
        	console.log(response);
        	console.log($rootScope);
        }
        function errorCallback(error){
        	console.log(error, 'can not get data.');
        }
        
        };
        
       $rootScope.showGroupsToAdd = function(userID){
            
            $http.post('/usermanagement/user/'+userID).then(successCallback, errorCallback);

            function successCallback(response){
            	
            	$rootScope.groupsToAdd = response.data;
            	console.log(response);
            	console.log($rootScope);
            }
            function errorCallback(error){
            	console.log(error, 'can not get data.');
            }
            
            };
        
        
    
    
    
    
    $rootScope.deleteUser = function(userID){
        
        $http.delete('/usermanagement/user/'+userID).then(successCallback, errorCallback);

        function successCallback(response){
        	$rootScope.refreshUser();
        	console.log(response);
        	console.log($rootScope);
        }
        function errorCallback(error){
        	console.log(error, 'can not delete data.');
        }
        
        };
        
        $rootScope.updateUser = function(p){
            
            $http.post('/usermanagement/user',p).then(successCallback, errorCallback);

            function successCallback(response){
            	$rootScope.refreshUser();
            	console.log(response);
            	console.log(p);
            }
            function errorCallback(error){
            	console.log(error, 'can not update data.');
            }
            
            };
            
            $rootScope.addUserToGroup = function(userID,groupID){
                
                $http.get('/usermanagement/user/'+userID+'/'+groupID).then(successCallback, errorCallback);

                function successCallback(response){
                	$rootScope.reset();
                	console.log(userID,groupID);
                	
                	
                }
                function errorCallback(error){
                	console.log(error, 'can not update data.');
                	console.log(userID,groupID);
                }
                
                };
            
            $rootScope.addUser = function(p){
                
                $http.post('/usermanagement/user/addUser',p).then(successCallback, errorCallback);

                function successCallback(response){
                	$rootScope.refreshUser();
                	console.log(response);
                	console.log(p);
                }
                function errorCallback(error){
                	console.log(error, 'can not update data.');
                }
                
                };
    
    
}); 
</script>


<title>Witaj</title>
</head>
<body ng-app="userApps">
	<section>
	<div class="jumbotron">
			<div class="container">
				<h1>User management  </h1>
			
				<section >
				<p ng-controller="userCtrls" data-ng-init="refreshUser()"><a class="btn btn-danger" ng-click="refreshUser()">All Users</a></p>
				<p ng-controller="userCtrls"><a class="btn btn-danger" href="/usermanagement/user/addUser">Add User</a></p>
			
				<table class="table table-hover">
				<tr>
				<th>Firstname</th>
				<th>Lastname</th>
				<th>Username</th>
				<th>Birth date</th>
				  <tbody>
            <tr ng-repeat="p in users" ng-include="getTemplate(p)">
            </tr>
        </tbody>
        </table>
				
				
				  <script type="text/ng-template" id="display">
				<td>{{p.firstname}}</td>
				<td>{{p.lastname}}</td>
				<td>{{p.username}}</td>
				<td>{{p.birthdate}}</td>
				<td><a class="btn btn-danger" ng-click="deleteUser(p.id)">Delete</a></td>
				<td><a class="btn btn-danger" ng-click="editContact(p)">Edit</a></td>
<td>

<div class="dropdown">
  <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true" ng-click="showUsersGroups(p.id)">
    Groups
    <span class="caret"></span>
  </button>
  <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
    <li ng-repeat="a in groups"><a href="#">{{a.groupname}}</a></li>

  </ul>
</div>

</td>
				 </script>
				 
				    <script type="text/ng-template" id="edit">
        <td><input type="text" ng-model="selected.firstname" /></td>
        <td><input type="text" ng-model="selected.lastname" /></td>
<td><input type="text" ng-model="selected.username" /></td>
        <td><input type="text" ng-model="selected.birthdate" /></td>
        <td><a class="btn btn-danger" ng-click="updateUser(selected)">Save</a></td>
				<td><a class="btn btn-danger" ng-click="reset()">Cancel</a></td>
<td>
<div class="dropdown">
  <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true" ng-click="showGroupsToAdd(p.id)">
   Add to Group
    <span class="caret"></span>
  </button>
  <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
    <li ng-repeat="ga in groupsToAdd"><a ng-click="addUserToGroup(selected.id,ga.id)">Add to {{ga.groupname}}</a></li>

  </ul>
</div>


</td>
    </script>
				
			
				
			
			
				
	
				<p ng-controller="userCtrls"><a class="btn btn-danger" href="/usermanagement/Allgroups">Groups</a></p>
			</section>
			</div>
			
			
		
	</section>
	
</div>
	
</body>
</html>
