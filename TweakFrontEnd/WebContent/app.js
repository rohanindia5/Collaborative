var app = angular.module("myApp", [ "ngRoute","ngCookies" ]);

// ngRoute
app.config(function($routeProvider) {

	$routeProvider.when("/", {
		templateUrl : "Home/Home.html",
		controller : "HomeController"
	})
	.when("/viewBlog", {
		templateUrl : "Blog/viewBlog.html",
		controller : "BlogController1"
	})
	.when("/addBlog", {
		templateUrl : "Blog/addBlog.html",
		controller : "BlogController1"
	})
	.when("/viewABlog", {
		templateUrl : "Blog/viewABlog.html",
		controller : "BlogController1"
	})
	.when("/viewJob", {
		templateUrl : "Jobs/viewJob.html",
		controller : "JobController"
	})
	.when("/addJob", {
		templateUrl : "Jobs/addJob.html",
		controller : "JobController"
	})
	.when("/Forum", {
		templateUrl : "Forum/Forum.html",
		controller : "ForumController"
	})
	.when("/Products", {
		templateUrl : "Products/Products.html",
		controller : "ProductController"
	})
	.when("/Account", {
		templateUrl : "User/User.html",
		controller : "UserController"
	})
	.otherwise({
		redirectTo : '/'
	});

});

app.run(function ($rootScope, $location, $cookies, $http){
	$rootScope.$on('$locationChangeStart', function(event, next, current){
		console.log('$locationChangeStart');
		
		var userPages = [];
		var adminPages = [];
		
		var currentPage = $location.path();
		
		var isUserPage = !($.inArray(currentPage, userPages)==-1);
		var isAdminPage = !($.inArray(currentPage, adminPages)==-1);
		
		var loggedIn = $rootScope.loggedInUser;
		
			if(angular.equals(loggedIn, {}))
			{
				if(isUserPage || isAdminPage)
				{
					alert("Please login to do this operation");
					$location.path("/login");
				}	
			}
			else
			{
				if(isAdminPage && $rootScope.loggedInUserRole!='ROLE_ADMIN')
				{
					alert("You are not authorized to access this page");
					$location.path("/");
				}	
			}	
	});
	
	//To keep user logged in after page refresh
	$rootScope.loggedInUser = $cookies.get("loggedInUser");
	$rootScope.loggedInUserRole = $cookies.get("loggedInUserRole");
	$rootScope.userLoggedIn = $cookies.get('userLoggedIn');
	if($rootScope.loggedInUser)
	{
		$http.defaults.headers.common['Authorization'] = 'Basic '+$rootScope.loggedInUser;
	}	
});

app.directive('fileModel', ['$parse', function ($parse) {
	 return {
	 restrict: 'A',
	 link: function(scope, element, attrs) {
	 var model = $parse(attrs.fileModel);
	 var modelSetter = model.assign;

	element.bind('change', function(){
	 scope.$apply(function(){
	 modelSetter(scope, element[0].files[0]);
	 });
	 });
	 }
	 };
}]);