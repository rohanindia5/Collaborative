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
	
	this.jobApplication=
	{
			jobApplicationId:'',
			jobId:'',
			userId:'',
			status:'',
	};
	this.jobApplications=[];
	
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
	
	self.getAllJobs = function() {
		console.log('calling the method getAllJobs');
		JobService.getAllJobs().then(function(d) {
			self.jobs = d;},
			function(errResponse) {
			console.error('Error while fetching All opend jobs');
		});
	};

	self.getAllJobs(); // calling getAllJobs function
	
	
	self.getAllJobsApplied = function() {
		console.log('calling the method getAllJobsApplied');
		JobService.getAllJobsApplied().then(function(d) {
			self.jobApplications = d;},
			function(errResponse) {
			console.error('Error while fetching All applied jobs');
		});
	};

	self.getAllJobsApplied(); // calling getAllJobs function
	
	self.getJobDetails = getJobDetails
	function getJobDetails(jobID) {
		console.log('get Job details of the id', jobID);
		JobService.getJobDetails(jobID).then(function(d) {
			self.job = d;		
			$location.path('/viewAJob');
			},
			function(errResponse) {
				console.error('Error while fetching blog details');
				});
		};

		self.submitJob = function() {
			{
				console.log('submit a new job', self.jobApplication);
				self.postAJobApp(self.jobApplication);
			}
				
		};
		self.postAJobApp = function(jobApplication) {
			console.log('submit a new job', self.jobApplication);
			JobService.postAJobApp(jobApplication).then(function(d) {
			alert("You successfully posted the job application")
			}, function(errResponse) {
				console.error('Error while posting job application.');
			});
		};
}])