app.controller('BlogController1',['BlogService','$location', '$rootScope','$scope','$http',function(BlogService,$location,$rootScope,$scope,$http) {
	
	var self = this;
	
	this.blog = 
		{
			blogId : '',
			blogName : '',
			blogContent : '',
			blogDate : '',
			blogLikes : '',
			userId : '',
		};
	
	this.blogs = [];

	self.submit=function() {
		{
			console.log('submit a new blog', self.blog);
			self.postABlog(self.blog);
		}
	};

	self.postABlog = function(blog) {
		console.log('submit a new blog', self.blog);
		BlogService.postABlog(blog).then(function(d) {
		alert("You successfully posted the blog")
		self.submitBlog();
		}, function(errResponse) {
			console.error('Error while posting blog.');
			self.submitBlog();
		});
	};
	
	self.getAllBlogs = function() {
		console.log('calling the method getAllBlogs');
		BlogService.getAllBlogs().then(function(d) {
		self.blogs = d;
		},
		function(errResponse) {
		console.error('Error while fetching All opend jobs');
		});
	};

	self.getAllBlogs(); // calling getAllJobs function
	
	self.getBlogDetails = getBlogDetails
	function getBlogDetails(blogID) {
		console.log('get blog details of the id', blogID);
		BlogService.getBlogDetails(blogID).then(function(d) {
			self.blog = d;			
			$location.path('/viewABlog');
			},
			function(errResponse) {
			console.error('Error while fetching blog details');
			});
		};
		
	self.submitBlog = submitBlog;
	function submitBlog(){
		var file = $scope.blogImage;
		var uploadUrl =  'http://localhost:8081/Tweak/blogUpload';
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


}])