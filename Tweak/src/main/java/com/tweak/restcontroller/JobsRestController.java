package com.tweak.restcontroller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tweak.modal.JobApplication;
import com.tweak.modal.Jobs;
import com.tweak.service.JobApplicationService;
import com.tweak.service.JobsService;
import com.tweak.service.UserService;

@RestController
public class JobsRestController 
{
	@Autowired
	JobsService jobsService;
	@Autowired
	UserService userService;
	@Autowired
	JobApplicationService jobApplicationService;
	
	@RequestMapping(value="/addJobs",method=RequestMethod.POST)
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
	
	@RequestMapping(value="/getAJob/{jobId}",method=RequestMethod.GET)
	public ResponseEntity<Jobs> getJobDetails(@PathVariable("jobId")int jobId,HttpSession session)
	{
		session.setAttribute("currentjobdetail", jobId);
		Jobs job=jobsService.updateJobs(jobId);
		return new ResponseEntity<Jobs>(job,HttpStatus.OK);
	}
	
	@RequestMapping(value="/addJobApplication",method=RequestMethod.POST)
	public ResponseEntity<String> addJobApplication(@RequestBody JobApplication jobApplication,HttpSession session)
	{
		String currentuser=(String)session.getAttribute("loggedInUser");
		int currentuserid=userService.getUserByName(currentuser).getUserId();
		int currentjobid=(int)session.getAttribute("currentjobdetail");
		try {
			JobApplication list=jobApplicationService.getIfJobApplied(currentjobid, currentuserid);
			
		} catch (Exception e) {
			jobApplication.setUserId(currentuserid);
			jobApplication.setJobId(currentjobid);
			jobApplication.setStatus("Applied");
			jobApplicationService.addJobApplicaton(jobApplication);
		}
		
		return new ResponseEntity<String>("Successfully Adeed",HttpStatus.OK);
	}
	
	@RequestMapping(value="/getJobApplied",method=RequestMethod.GET)
	public ResponseEntity<List<JobApplication>> getJobApplied(HttpSession session)
	{
		String currentuser=(String)session.getAttribute("loggedInUser");
		int currentuserid=userService.getUserByName(currentuser).getUserId();
		List<JobApplication> list=jobApplicationService.getJobApplication(currentuserid);
		return new ResponseEntity<List<JobApplication>>(list,HttpStatus.OK);
	}

}
