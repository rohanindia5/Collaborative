app	.controller('JobController',['JobService','$location', '$rootScope',function(JobService,  $location, $rootScope) {
	var self = this;

	this.job = {
		jobId : '',
		jobName : '',
		jobLocation : '',
		jobCompany : '',
		jobDescription : '',
		jobSkills : '',
		jobDate : '',
		jobExperience : ''
	};
	
	this.jobs = [];
	
	self.submit = function() {
		{
			console.log('submit a new job', self.job);
			self.postAJob(self.job);
		}
			
	};

	self.postAJob = function(job) {
		console.log('submit a new job', self.job);
		JobService.postAJob(job).then(function(d) {
		alert("You successfully posted the job")
		}, function(errResponse) {
			console.error('Error while posting job.');
		});
	};
}])