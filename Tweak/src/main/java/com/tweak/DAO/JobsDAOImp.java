package com.tweak.DAO;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.tweak.modal.Jobs;
@Repository
public class JobsDAOImp implements JobsDAO 
{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void addJobs(Jobs jobs) {
		sessionFactory.getCurrentSession().saveOrUpdate(jobs);
		
	}

	@Override
	public List<Jobs> displayJobs() {
		List<Jobs> list=sessionFactory.getCurrentSession().createQuery("from Jobs").getResultList();
		return list;
	}

	@Override
	public Jobs updateJobs(int jobsId) {
		List<Jobs> list=sessionFactory.getCurrentSession().createQuery("from Jobs where jobsId="+jobsId).getResultList();
		return list.get(0);
	}

	@Override
	public void deleteJobs(int jobsId) {
		Jobs jobsDelete=new Jobs();
		jobsDelete.setJobId(jobsId);
		sessionFactory.getCurrentSession().delete(jobsDelete);
		
	}

}
