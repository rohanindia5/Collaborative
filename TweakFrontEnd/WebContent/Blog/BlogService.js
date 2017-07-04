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
			}
}])	