package com.tweak.modal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class JobApplication 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int jobApplicationId;
	private int jobId;
	
	private int userId;
	private String status;
	
	@ManyToOne
	@JoinColumn(name="userId",nullable=false,updatable=false,insertable=false)
	private UserTable userTable;
	
	@ManyToOne
	@JoinColumn(name="jobId",nullable=false,updatable=false,insertable=false)
	private Jobs jobs;

	public int getJobApplicationId() {
		return jobApplicationId;
	}

	public void setJobApplicationId(int jobApplicationId) {
		this.jobApplicationId = jobApplicationId;
	}

	public int getJobId() {
		return jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public UserTable getUserTable() {
		return userTable;
	}

	public void setUserTable(UserTable userTable) {
		this.userTable = userTable;
	}

	public Jobs getJobs() {
		return jobs;
	}

	public void setJobs(Jobs jobs) {
		this.jobs = jobs;
	}
	
}
