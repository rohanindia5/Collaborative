app.service('ForumService', ['$http', '$q','$rootScope', function($http, $q,$rootScope){

console.log("ForumService...")
	
	var url='http://localhost:8081/Tweak'
		
    return {

		postAForum: function(forum){
        return $http.post(url+'/addForum', forum)
                .then(
                        function(response){
                            return response.data;
                        }, 
                        function(errResponse){
                            console.error('Error while posting forum');
                            return $q.reject(errResponse);
                        }
                );
			},
			
			postAForumComment: function(forumComment){
		        return $http.post(url+'/addForumComment', forumComment)
		                .then(
		                        function(response){
		                            return response.data;
		                        }, 
		                        function(errResponse){
		                            console.error('Error while posting forumComment');
		                            return $q.reject(errResponse);
		                        }
		                );
					},	
		
					postAForumLike: function(forumLike){
				        return $http.post(url+'/addForumLike', forumLike)
				                .then(
				                        function(response){
				                            return response.data;
				                        }, 
				                        function(errResponse){
				                            console.error('Error while posting forumlike');
				                            return $q.reject(errResponse);
				                        }
				                );
							},
							
		getAllForums: function(){
	            return $http.get(url+'/getForum')
	                    .then(
	                            function(response){
	                                return response.data;
	                            }, 
	                            function(errResponse){
	                                console.error('Error while getting all forum');
	                                return $q.reject(errResponse);
	                            }
	                    );
				},
				
				getAllForumsUser: function(){
		            return $http.get(url+'/getForumOfUser')
		                    .then(
		                            function(response){
		                                return response.data;
		                            }, 
		                            function(errResponse){
		                                console.error('Error while getting all forum user');
		                                return $q.reject(errResponse);
		                            }
		                    );
					},		
				
				getAllForumComments: function(){
		            return $http.get(url+'/getForumComment')
		                    .then(
		                            function(response){
		                                return response.data;
		                            }, 
		                            function(errResponse){
		                                console.error('Error while getting all forum comments');
		                                return $q.reject(errResponse);
		                            }
		                    );
					},		
				
		getForumDetails: function(forumID) {
			console.log("Getting forum details of " + forumID)
			console.log(url+"/getAForum/"+ forumID)
			return $http.get(url+"/getForumDetails/" + forumID)
					.then(
	                       function(response){
	                          $rootScope.selectedForum = response.data;
	                                    return response.data;
	                                }, 
	                       function(errResponse){
	                               console.error('Error while getting forum details');
	                                }
	                        );
					},		
			
		}	
}])