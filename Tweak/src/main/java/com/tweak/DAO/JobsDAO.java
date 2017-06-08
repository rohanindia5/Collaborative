package com.tweak.DAO;

import java.util.List;

import com.tweak.modal.Jobs;

public interface JobsDAO {
	public void addJobs(Jobs jobs);
	public List<Jobs> displayJobs();
	public Jobs updateJobs(int jobsId);
	public void deleteJobs(int jobsId);
}
