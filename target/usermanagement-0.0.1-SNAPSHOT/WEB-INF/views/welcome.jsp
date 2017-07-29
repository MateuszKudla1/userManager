<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>

	<script>


var userApp = angular.module('userApp', []);
userApp.controller('userCtrl', function($rootScope, $http,$scope){
	$rootScope.users = [];
  //  $rootScope.ort = 'witaj mateusz';
   
  $rootScope.refreshUser = function(){
    
    $http.get('/usermanagement/user').then(successCallback, errorCallback);

    function successCallback(response){
    	$rootScope.users = response.data;
    	console.log(response);
    	console.log($rootScope);
    }
    function errorCallback(error){
    	console.log(error, 'can not get data.');
    }
    
    };
    
    $rootScope.deleteUser = function(){
        
        $http.delete('/usermanagement/user').then(successCallback, errorCallback);

        function successCallback(response){
        	$rootScope.refreshUser();
        	console.log(response);
        	console.log($rootScope);
        }
        function errorCallback(error){
        	console.log(error, 'can not delete data.');
        }
        
        };
    
    
}); 
</script>


<title>Witaj</title>
</head>
<body ng-app="userApp">
	<section>
	<div class="jumbotron">
			<div class="container">
				<h1>User management  </h1>
			
				<section >
				<p ng-controller="userCtrl"><a class="btn btn-danger" ng-click="refreshUser()">Users</a></p>
				
			
				<table class="table table-hover">
				<tr>
				<th>Imie</th>
				<th>Nazwisko</th>
				<th>Wiek</th>
				</tr>
				<tr ng-repeat="p in users">
				<td>{{p.firstname}}</td>
				<td>{{p.lastname}}</td>
				<td>{{p.age}}</td>
				<td><a class="btn btn-danger" ng-click="deleteUser()">Delete</a></td>
				 </tr>
				</table>
				
				<h1>{{ort}}</h1>
				<h2>{{users.persons[0].lastname}}</h2>
			
				
	
				
			</section>
			</div>
		
	</section>
	
</div>
	
</body>
</html>
