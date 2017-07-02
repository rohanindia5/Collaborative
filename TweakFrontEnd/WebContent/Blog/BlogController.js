app.controller('BlogController',['BlogService','$location','$rootScope',function(BlogService,$location,$rootScope){
	var self=this;
	
	this.blog={
				blogId:'',
				blogName:'',
				blogContent:'',
				blogDate:'',
				blogLikes:'',
				userId:''
			  };
	
	this.blogs=[];
	
	self.submit = function() 
				{
					{
						console.log('submit a new blog', self.blog);
						self.newBlog(self.blog);
					}
					
				};
				
	self.newBlog = function(blog) 
				  {
					console.log('register a new Blog', self.blog);
					BlogService.newBlog(blog).then(function(d) {
					alert("You successfully posted blog")
				  },function(errResponse)
				  {
						console.error('Error while posting blog');
				  });
				  };
	
}])