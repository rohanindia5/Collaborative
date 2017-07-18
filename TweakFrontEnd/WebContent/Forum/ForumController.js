app.controller('ForumController',['ForumService','$location','$rootScope',function(ForumService,$location,$rootScope){
	
	var self = this;
	
	this.forum = 
		{
			forumId : '',
			forumName : '',
			forumContent : '',
			forumDate : '',
			forumLikes : '',
			userId : '',
		};
	
	this.forums = [];
	
	this.forumComment=
		{
			forumCommentId:'',
			forumCommentContext:'',
			forumCommemtDate:'',
			forumId:'',
			userId:'',
		};
	
	this.forumComments=[];
	
	this.forumLike={
			forumLikeId:'',
			forumId:'',
			userId:'',
	};
	this.forumLikes=[];
	
	self.submit=function() {
		{
			console.log('submit a new forum', self.forum);
			self.postAForum(self.forum);
		}
	};

	self.postAForum = function(forum) {
		console.log('submit a new forum', self.forum);
		ForumService.postAForum(forum).then(function(d) {
		alert("You successfully posted the forum")
		}, function(errResponse) {
			console.error('Error while posting forum.');
		});
	};
	
	self.submitComment=function() {
		{
			console.log('submit a new forum', self.forumComment);
			self.postAForumComment(self.forumComment);
		}
	};

	self.postAForumComment = function(forumComment) {
		console.log('submit a new forum comment', self.forumComment);
		ForumService.postAForumComment(forumComment).then(function(d) {
		alert("You successfully posted the forum comment")
		}, function(errResponse) {
			console.error('Error while posting forum comment.');
		});
	};
	
	self.submitLike=function() {
		{
			console.log('submit a new forum like', self.forumLike);
			self.postAForumLike(self.forumLike);
		}
	};

	self.postAForumLike = function(forumLike) {
		console.log('submit a new forum like', self.forumLike);
		ForumService.postAForumLike(forumLike).then(function(d) {
		alert("You successfully posted the forum like")
		}, function(errResponse) {
			console.error('Error while posting forum like.');
		});
	};
	
	self.getAllForums = function() {
		console.log('calling the method getAllForums');
		ForumService.getAllForums().then(function(d) {
		self.forums = d;
		},
		function(errResponse) {
		console.error('Error while fetching All Forums');
		});
	};

	self.getAllForums(); // calling getAllJobs function
	
	self.getAllForumsUser = function() {
		console.log('calling the method getAllForumsUser');
		ForumService.getAllForumsUser().then(function(d) {
		self.forums = d;
		},
		function(errResponse) {
		console.error('Error while fetching All ForumsUser');
		});
	};

	self.getAllForumsUser(); // calling getAllJobs function
	
	self.getForumDetails = getForumDetails
	function getForumDetails(forumID) {
		console.log('get forum details of the id', forumID);
		ForumService.getForumDetails(forumID).then(function(d) {
			self.forum = d;			
			$location.path('/viewAForum');
			},
			function(errResponse) {
			console.error('Error while fetching forum details');
			});
		};
		self.getAllForumComments = function() {
			console.log('calling the method getAllForumComments');
			ForumService.getAllForumComments().then(function(d) {
			self.forumComments = d;
			},
			function(errResponse) {
			console.error('Error while fetching forum comments');
			});
		};
		self.getAllForumComments();	
	

}])