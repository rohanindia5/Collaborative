package com.tweak.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweak.DAO.JobApplicationDAOImp;
import com.tweak.modal.JobApplication;

@Service
@Transactional
public class JobApplicationService 
{
	@Autowired
	JobApplicationDAOImp jobApplicationDAOImp;
	
	public void addJobApplicaton(JobApplication jobapplication)
	{
		jobApplicationDAOImp.addJobApplicaton(jobapplication);
	}
	
	public JobApplication getIfJobApplied(int jobId,int userId)
	{
		return jobApplicationDAOImp.getIfJobApplied(jobId, userId);
	}
	
	public List<JobApplication> getJobApplication(int userId)
	{
		return jobApplicationDAOImp.getJobApplication(userId);
	}
	
}
