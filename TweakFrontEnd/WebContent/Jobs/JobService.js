app.service('JobService', ['$http', '$q','$rootScope', function($http, $q,$rootScope){
	
	console.log("JobService...")
	
	var url='http://localhost:8081/Tweak/'
		
    return {	
		
        postAJob: function(job){
            return $http.post(url+'/addJobs', job)
                    .then(
                            function(response){
                                return response.data;
                            }, 
                            function(errResponse){
                                console.error('Error while posting job');
                                return $q.reject(errResponse);
                            }
                    );
        		},
        		
        getAllJobs: function(){
        	return $http.get(url+'/getJobs/')
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
        		
		   }
}])