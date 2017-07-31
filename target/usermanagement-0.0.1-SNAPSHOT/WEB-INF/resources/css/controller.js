var userApp = angular.module('userApp', []);
userApp.controller('userCtrl', function($rootScope, $http){
	
	
	$rootScope.groups = [];
	$rootScope.selectedGroup = {};
	$rootScope.groupName="";
 
	  $rootScope.reset2 = function () {
	        $rootScope.selectedGroup = {};
	    };
	
     $rootScope.getTemplate2 = function (z) {
        if (z.id === $rootScope.selectedGroup.id) return 'edit2';
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
    
    $rootScope.getGroupId = function(id){
        
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
            
        
            
            
            
            
        $rootScope.test = function(){
        	$http.get('/usermanagement/group').then(successCallback, errorCallback);

            function successCallback(response){
            	
            	console.log(response);
            	console.log($rootScope);
            }
            function errorCallback(error){
            	console.log(error, 'can not get data.');
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
            
            
                
  
    
    
}); 