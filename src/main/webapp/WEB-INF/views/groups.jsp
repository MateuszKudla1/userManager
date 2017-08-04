<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>

<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular-route.js"></script>




<script>
var userApp = angular.module('userApp', ["ngRoute"]);
userApp.controller('userCtrl', function($rootScope, $http){
	

	$rootScope.groups = [];
	$rootScope.group= {};
	$rootScope.selectedGroup = {};
	$rootScope.id="";

    $rootScope.flag = false;
	  $rootScope.reset = function () {
	        $rootScope.selectedGroup = {};
	    };
	
     $rootScope.getTemplate2 = function (group) {
        if (group.id === $rootScope.selectedGroup.id) return 'edit2';
        else return 'display2';
    };
    
    $rootScope.editContact = function (e) {
        $rootScope.selectedGroup = angular.copy(e);
    };
   
  $rootScope.refreshGroups = function(){
    
    $http.get('/usermanagement/groups').then(successCallback, errorCallback);

    function successCallback(response){
    	$rootScope.reset();
    	$rootScope.groups = response.data;
    	console.log(response);
    	console.log($rootScope);
    }
    function errorCallback(error){
    	console.log(error, 'can not get data.');
    }
    
    };
    
    $rootScope.refreshGroup = function(idk){
        
        $http.get('/usermanagement/group/'+idk).then(successCallback, errorCallback);

        function successCallback(response){
        	
        	$rootScope.usersInGroup = response.data;
        	console.log(response);
        	console.log($rootScope);
        }
        function errorCallback(error){
        	console.log(error, 'can not get data.');
        }
        
        };
    
    $rootScope.getGroupId = function(id){
        
        $http.get('/usermanagement/groups/'+id).then(successCallback, errorCallback);

        function successCallback(response){
      		$rootScope.id = id;
        	$rootScope.group = response.data;
        	$rootScope.refreshGroup(id);
        	$rootScope.groupName = $rootScope.group.groupname;
        	console.log(response);
        	console.log('eeeeee');
        	console.log($rootScope);
        }
        function errorCallback(error){
        	console.log(error, 'can not get ddddata.');
        }
        
        };
        
        $rootScope.t = function(id){
            
            $http.get('/usermanagement/group/'+id).then(successCallback, errorCallback);

            function successCallback(response){
          
            	$rootScope.groups = response.data;
            	test();
            	console.log(response);
            	console.log('eeeeee');
            	console.log($rootScope);
            }
            function errorCallback(error){
            	console.log(error, 'can not get ddddata.');
            }
            
            };
            
        
            
            
       
    
    
    
    
    $rootScope.deleteGroup = function(groupID){
        
        $http.delete('/usermanagement/groups/'+groupID).then(successCallback, errorCallback);

        function successCallback(response){
        	$rootScope.refreshGroups();
        	console.log(response);
        	console.log($rootScope);
        }
        function errorCallback(error){
        	console.log(error, 'can not delete data.');
        }
        
        };
        
        $rootScope.deleteUserInGroup = function(userID,groupID){
            
            $http.delete('/usermanagement/groups/'+userID+'/'+groupID).then(successCallback, errorCallback);

            function successCallback(response){
            
            	$rootScope.getGroupId(groupID);
            	console.log(response);
            	console.log($rootScope);
            	console.log(groupID,userID);
            }
            function errorCallback(error){
            	console.log(error, 'can not delete data.');
            	console.log(groupID,userID);
            }
            
            };
        
        
        
            
            
            
            
            $rootScope.updateGroup = function(p){
                
                $http.post('/usermanagement/Allgroups',p).then(successCallback, errorCallback);

                function successCallback(response){
                	$rootScope.refreshGroups();
                	console.log(response);
                	console.log(p);
                }
                function errorCallback(error){
                	console.log(error, 'can not update data.');
                }
                
                };
            
            
               userApp.config(function($routeProvider) {
                	  $routeProvider
                	  .when("/grouper", {
                	    templateUrl : "js/group.html/"
                	  });
                	});            
  
    
    
}); 
</script>


</head>
<body ng-app="userApp">
	<section>
	<div class="jumbotron">
			<div class="container" ng-controller="userCtrl" data-ng-init="refreshGroups()">
				<h1>Groups</h1>
			
				<section >
				<p ><a class="btn btn-danger" ng-click="refreshGroups()">All Groups</a></p>
				<p><a class="btn btn-danger" href="/usermanagement/Addgroup">Add Group</a></p>
			
				<table class="table table-hover">
				<tr>
				<th>Group name</th>
				<th>Members</th>
				  <tbody>
            <tr  ng-repeat="group in groups" ng-include="getTemplate2(group)">
            </tr>
        </tbody>
        </table>
				
				
				  <script  type="text/ng-template" id="display2">
				<td>{{group.groupname}}</td>
				<td><a class="btn btn-danger" href="#" ng-click="getGroupId(group.id)">Show members</a></td>
				<td><a class="btn btn-danger" ng-click="editContact(group)">Edit</a></td>
				<td><a class="btn btn-danger" ng-click="deleteGroup(group.id)">Delete</a></td>
				 </script>
				 
				    <script type="text/ng-template" id="edit2">
        <td><input type="text" ng-model="selectedGroup.groupname" /></td>
        <td><a class="btn btn-danger" >Add user</a></td>
  		<td><a class="btn btn-danger" ng-click="updateGroup(selectedGroup)">Save</a></td>
				<td><a class="btn btn-danger" ng-click="reset()">Cancel</a></td>
				
    </script>
    
    	<div ng-controller="userCtrl" class="container">
				<h1>{{groupName}}</h1>
			
				<section >
				
				<p ng-controller="userCtrl"><a class="btn btn-danger" href="/usermanagement/user/addUser">Add User</a></p>
			
				<table class="table table-hover">
				<tr>
				<th>Firstname</th>
				<th>Lastname</th>
				<th>Username</th>
				<th>Birth date</th>
       </tr>
      	
      	<tr ng-repeat = "p in usersInGroup">
				<td>{{p.firstname}}</td>
				<td>{{p.lastname}}</td>
				<td>{{p.username}}</td>
				<td>{{p.birthdate}}</td>
				<td><a class="btn btn-danger" ng-click="deleteUserInGroup(p.id,id)">Delete user from group</a></td>
				
				 </tr>
				 
        
        </table>
				
				
			
				
			
			
				
	<p ng-controller="userCtrl"><a class="btn btn-danger" href="/usermanagement/">Users</a></p>
				
			</section>
			</div>
			
			
		
	</section>
	
</div>
	
</body>
</html>
