<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>

<script src="js/app.js/"></script>

<title>Witaj</title>
</head>
<body ng-app="userApp">
	<section>
	<div class="jumbotron">
			<div class="container">
				<h1>{{groupName}}</h1>
			
				<section >
				<p ng-controller="userCtrl"><a class="btn btn-danger" ng-click="refreshUser()">All Users</a></p>
				<p ng-controller="userCtrl"><a class="btn btn-danger" href="/usermanagement/user/addUser">Add User</a></p>
			
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
      	  <script type="text/ng-template" id="display">
				<td>{{p.firstname}}</td>
				<td>{{p.lastname}}</td>
				<td>{{p.username}}</td>
				<td>{{p.birthdate}}</td>
				<td><a class="btn btn-danger" ng-click="deleteUser(p.id)">Delete</a></td>
				<td><a class="btn btn-danger" ng-click="editContact(p)">Edit</a></td>
				 </script>
				 
        
        </table>
				
				
				
				 
	
    </script>
				
			
				
			
			
				
	
				
			</section>
			</div>
			
			
		
	</section>
	
</div>
	
</body>
</html>
