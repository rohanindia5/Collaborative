package com.tweak.DAO;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tweak.modal.JobApplication;
@Repository
public class JobApplicationDAOImp implements JobApplicationDAO 
{
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public void addJobApplicaton(JobApplication jobapplication) 
	{
		sessionFactory.getCurrentSession().saveOrUpdate(jobapplication);
		
	}
	
	public List<JobApplication> getJobApplication(int userId)
	{
		List<JobApplication> list=sessionFactory.getCurrentSession().createQuery("from JobApplication where userId="+userId).getResultList();
		return list;
	}
	
	public JobApplication getIfJobApplied(int jobId,int userId)
	{
		List<JobApplication> list=sessionFactory.getCurrentSession().createQuery("from JobApplication where userId="+userId+"and jobId="+jobId).getResultList();
		return list.get(0);
	}

}
