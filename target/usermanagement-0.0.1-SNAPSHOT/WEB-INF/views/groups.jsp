<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.min.js"></script>
<script type="application/javascript" src="js/controller.js/"></script>





</head>
<body ng-app="userApp">
	<section>
	<div class="jumbotron">
			<div class="container" ng-controller="userCtrl">
				<h1>Groups</h1>
			
				<section >
				<p ><a class="btn btn-danger" ng-click="refreshGroups()">All Groups</a></p>
				<p><a class="btn btn-danger" href="/usermanagement/Addgroup">Add Group</a></p>
			
				<table class="table table-hover">
				<tr>
				<th>Group name</th>
				<th>Members</th>
				  <tbody>
            <tr  ng-repeat="s in groups" ng-include="getTemplate2(p)">
            </tr>
        </tbody>
        </table>
				
				
				  <script  type="text/ng-template" id="display2">
				<td>{{s.groupname}}</td>
				<td><a class="btn btn-danger" ng-click="t(s.id)">Show members</a></td>
				<td><a class="btn btn-danger" ng-click="editContact(s)">Edit</a></td>
				<td><a class="btn btn-danger" ng-click="deleteGroup(s.id)">Delete</a></td>
				 </script>
				 
				    <script type="text/ng-template" id="edit2">
        <td><input type="text" ng-model="selectedGroup.groupname" /></td>
        <td><a class="btn btn-danger" ng-click="updateUser(selected)">Add user</a></td>
  		<td><a class="btn btn-danger" ng-click="updateGroup(selectedGroup)">Save</a></td>
				<td><a class="btn btn-danger" ng-click="reset2()">Cancel</a></td>
				
    </script>
				
				
			
				
			
			
				
	
				
			</section>
			</div>
			
			
		
	</section>
	
</div>
	
</body>
</html>
