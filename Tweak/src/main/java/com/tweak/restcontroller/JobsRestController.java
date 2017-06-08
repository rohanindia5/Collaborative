package com.tweak.restcontroller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import com.tweak.modal.Jobs;

import com.tweak.service.JobsService;

@RestController
public class JobsRestController 
{
	@Autowired
	JobsService jobsService;
	
	@RequestMapping(value="/addJobs",method=RequestMethod.PUT)
	public ResponseEntity<String> addJobs(@RequestBody Jobs jobs)
	{
		jobs.setJobDate(new Date());
		jobsService.addJobs(jobs);
		return new ResponseEntity<String>("Successfully Added",HttpStatus.OK);
	}
	
	@RequestMapping(value="/getJobs",method=RequestMethod.GET)
	public ResponseEntity<List<Jobs>> getFriends()
	{
		List<Jobs> listblogs=jobsService.displayJobs();
		return new ResponseEntity<List<Jobs>>(listblogs,HttpStatus.OK);
	}
	
	@RequestMapping(value="/updateJobs-{jobId}",method=RequestMethod.PUT)
	public ResponseEntity<Jobs> updateUser(@PathVariable("jobId") int jobId,@RequestBody Jobs jobs)
	{
		Jobs curr_user=jobsService.updateJobs(jobId);
		curr_user.setJobName(jobs.getJobName());
		curr_user.setJobDescription(jobs.getJobDescription());
		curr_user.setJobSkills(jobs.getJobSkills());
		jobsService.addJobs(jobs);
		return new ResponseEntity<Jobs>(curr_user,HttpStatus.OK);
	}
	
	@RequestMapping(value="/deleteJobs-{jobId}",method=RequestMethod.DELETE)
	public ResponseEntity<String> deleteUser(@PathVariable("jobId") int jobId)
	{
		jobsService.deleteJobs(jobId);
		return new ResponseEntity<String>("Deleted Blog Successfully",HttpStatus.OK);
	}

}
