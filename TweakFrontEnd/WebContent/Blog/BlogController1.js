app.controller('BlogController1',['BlogService','$location', '$rootScope',function(BlogService,$location,$rootScope) {

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
		}, function(errResponse) {
			console.error('Error while posting blog.');
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


}])