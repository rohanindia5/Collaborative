var app = angular.module("myApp", [ "ngRoute" ]);

// ngRoute
app.config(function($routeProvider) {

	$routeProvider.when("/", {
		templateUrl : "Home/Home.html",
		controller : "HomeController"
	}).when("/Blog", {
		templateUrl : "Blog/Blog.html",
		controller : "BlogController"
	}).when("/Job", {
		templateUrl : "Jobs/Job.html",
		controller : "JobController"
	}).when("/Forum", {
		templateUrl : "Forum/Forum.html",
		controller : "ForumController"
	}).when("/Products", {
		templateUrl : "Products/Products.html",
		controller : "ProductController"
	}).when("/Account", {
		templateUrl : "User/User.html",
		controller : "UserController"
	}).otherwise({
		redirectTo : '/'
	});

});