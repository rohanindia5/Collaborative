app.controller('UserController',['UserService','$location','$rootScope','$scope','$cookies','$http',function(UserService,$location,$rootScope,$scope,$cookies,$http){
	
	var self=this;
	this.user={
				userId:'',
				userName:'',
				password:'',
				userFirstName:'',
				userLastName:'',
				userRole:''
			  };
	
	this.usercred = {
						userId:'',
						userName:'',
						password:'',
						userFirstName:'',
						userLastName:'',
						userRole:''
					};
	
	this.users=[];
	self.usercreds = [];
	
	self.submit = function() 
				{
					{
						console.log('submit a new User', self.user);
						self.registerUser(self.user);
					}
					
				};
				
	self.registerUser = function(user) 
				  {
					console.log('register as new User', self.user);
					UserService.registerUser(user).then(function(d) {
					alert("You successfully registered")
				  },function(errResponse)
				  {
						console.error('Error while registering');
				  });
				  };
				  
	self.authenticate = function(usercred)
					{
						console.log("authenticate method in controller started");
						UserService.authenticate(usercred).then(function(udata) {
						self.usercred = udata;										
						console.log("Valid credentials, navigating to home page");
						$rootScope.loggedInUser = self.usercred.username;
						$rootScope.userLoggedIn = true;
						$rootScope.loggedInUserRole = self.usercred.role;
						$http.defaults.headers.common['Authorization'] = 'Basic '+$rootScope.loggedInUser;
						$cookies.put('loggedInUser', $rootScope.loggedInUser);
						$cookies.put('userLoggedIn', $rootScope.userLoggedIn);
						$cookies.put('loggedInUserRole', $rootScope.loggedInUserRole);
						$location.path("/");
											
					},
						function(errorresponse)
						{
							console.error("Error while logging in user");
						}
						);
					};
					
    self.login = function()
    			{
    				console.log("login method in controller started");
					self.authenticate(self.usercred);
					console.log("login method in controller ended");
				};
					
	
}])