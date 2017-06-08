package com.tweak.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tweak.DAO.JobsDAOImp;
import com.tweak.modal.Jobs;

@Service
@Transactional
public class JobsService 
{
	@Autowired
	JobsDAOImp jobsDAOImp;
	public void addJobs(Jobs jobs)
	{
		jobsDAOImp.addJobs(jobs);
	}
	public List<Jobs> displayJobs()
	{
		return jobsDAOImp.displayJobs();
	}
	public Jobs updateJobs(int jobsId)
	{
		return jobsDAOImp.updateJobs(jobsId);
	}
	public void deleteJobs(int jobsId)
	{
		jobsDAOImp.deleteJobs(jobsId);
	}
}
