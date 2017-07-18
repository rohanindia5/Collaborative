app.service('BlogService', ['$http', '$q','$rootScope', function($http, $q,$rootScope){
	
	console.log("BlogService...")
	
	var url='http://localhost:8081/Tweak'
		
    return {

		postABlog: function(blog){
            return $http.post(url+'/addBlog', blog)
                    .then(
                            function(response){
                                return response.data;
                            }, 
                            function(errResponse){
                                console.error('Error while posting blog');
                                return $q.reject(errResponse);
                            }
                    );
				},
				
		postABlogComment: function(blogComment){
			return $http.post(url+'/addBlogComment',blogComment)
		             .then(
		            		 function(response){
		            			 return response.data;
		                     }, 
		                     function(errResponse){
		                    	 console.error('Error while posting blog comment');
		                    	 return $q.reject(errResponse);
		                     }
		                    );
						},
						postABlogLike: function(blogLike){
							return $http.post(url+'/addBlogLike',blogLike)
						             .then(
						            		 function(response){
						            			 return response.data;
						                     }, 
						                     function(errResponse){
						                    	 console.error('Error while posting blog like');
						                    	 return $q.reject(errResponse);
						                     }
						                    );
										},				
				
				getAllBlogs: function(){
		            return $http.get(url+'/getBlog')
		                    .then(
		                            function(response){
		                                return response.data;
		                            }, 
		                            function(errResponse){
		                                console.error('Error while getting all jobs');
		                                return $q.reject(errResponse);
		                            }
		                    );
					},
					getAllBlogsUser: function(){
			            return $http.get(url+'/getBlogOfUser')
			                    .then(
			                            function(response){
			                                return response.data;
			                            }, 
			                            function(errResponse){
			                                console.error('Error while getting user blog');
			                                return $q.reject(errResponse);
			                            }
			                    );
						},
					
				getAllBlogComments: function(){
			            return $http.get(url+'/getBlogComment')
			                    .then(
			                            function(response){
			                                return response.data;
			                            }, 
			                            function(errResponse){
			                                console.error('Error while getting all blog comments');
			                                return $q.reject(errResponse);
			                            }
			                    );
						},	
					
					getBlogDetails: function(blogID) {
		            	console.log("Getting blog details of " + blogID)
		                return $http.get(url+"/getBlogDetails/" + blogID)
		                	
		                        .then(
		                                function(response){
		                                	$rootScope.selectedBlog = response.data;
		                                	
		                                    return response.data;
		                                }, 
		                                function(errResponse){
		                                    console.error('Error while getting blog details');
		                                   
		                                }
		                        );
						},	
				
					
			}
}])	