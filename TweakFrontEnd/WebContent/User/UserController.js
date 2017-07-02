app.controller('UserController',['UserService','$location','$rootScope',function(UserService,$location,$rootScope){
	var self=this;
	
	this.user={
				userId:'',
				userName:'',
				password:'',
				userFirstName:'',
				userLastName:'',
				userRole:''
			  };
	
	this.users=[];
	
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
	
}])