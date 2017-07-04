app.service('UserService',['$http','$q','$rootScope',function($http,$q,$rootScope){
	console.log("Service...")
	var url='http://localhost:8081/Tweak/'
	return{
			registerUser: function(user)
				{
					console.log("in userService",user)
            		return $http.post(url+'/addUser', user)
            		.then(function(response){
                                return response.data;}, 
                          function(errResponse){
                                console.error('Error while registering user');
                                return $q.reject(errResponse);}
                    	  );
				},
	
	authenticate: function(usercred)
				{
					return $http.post(url+'/authenticateuser',usercred)
					.then(function(response){
						return response.data;},
						null
					);
				}
	
		  }
}]);