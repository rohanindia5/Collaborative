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
						$rootScope.loggedInUserId=self.usercred.userId;
						$rootScope.loggedInUserFirstName=self.usercred.userFirstName;
						$rootScope.loggedInUserLastName=self.usercred.userLastName;
						$http.defaults.headers.common['Authorization'] = 'Basic '+$rootScope.loggedInUser;
						$cookies.put('loggedInUser', $rootScope.loggedInUser);
						$cookies.put('userLoggedIn', $rootScope.userLoggedIn);
						$cookies.put('loggedInUserRole', $rootScope.loggedInUserRole);
						$cookies.put('loggedInUserId',$rootScope.loggedInUserId);
						$cookies.put('loggedInUserFirstName',$rootScope.loggedInUserFirstName);
						$cookies.put('loggedInUserLastName',$rootScope.loggedInUserLastName);
						$location.path("/Profile");
											
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
				
	self.logout = function() {
					console.log("logout method in controller started");
					UserService
						.logout()
						.then(
								function(udata) {
									self.usercred = udata;
									$rootScope.loggedInUser = {};
									$rootScope.userLoggedIn = false;
									$rootScope.loggedInUserRole = {};
									$http.defaults.headers.common['Authorization'] = 'Basic '+$rootScope.loggedInUser;
									$cookies.remove('loggedInUser');
									$cookies.remove('loggedInUserRole');
									$cookies.remove('loggedInUserId');
									$cookies.remove('loggedInUserFirstName');
									$cookies.remove('loggedInUserLastName');
									$cookies.remove('userLoggedIn');
									$location.path("/Account");
								},
								function(errorresponse) {
									console.error("Error while logging out user");
								}
						);
				};			
					
				
	self.submitUser = submitUser;
				function submitUser(){
					var file = $scope.userImage;
					var uploadUrl =  'http://localhost:8081/Tweak/userUpload';
					console.log('file is:',file);
					var fd = new FormData();
					fd.append('file', file);
					$http.post(uploadUrl, fd, {
						transformRequest : angular.identity,
					 	 headers : {
					 	   'Content-Type' : undefined
					 	   }
					 	   }).success(function() {
					 	   console.log('success');
					 	   }).error(function() {
					 	   console.log('error');
					 	   });
					
					    }
				
	self.getAllUser = function() {
					console.log('calling the method getAllUser');
					UserService.getAllUser().then(function(d) {
					self.users = d;
					},
					function(errResponse) {
					console.error('Error while fetching All  user');
					});
				};
	self.getAllUser(); // calling getAllJobs function
}])