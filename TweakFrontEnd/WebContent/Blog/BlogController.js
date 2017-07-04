app.controller('BlogController',['BlogService','$location', '$rootScope',function(BlogService,$location,$rootScope) {
	console.log("BlogController...")
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

}])
