package com.tweak.modal;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Jobs 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int jobId;
	private String jobName;
	private String jobLocation;
	private String joobCompany;
	private String jobDescription;
	private String jobSkills;
	@Column(columnDefinition="Date")
	private Date jobDate;
	private String jobExperience;
	public int getJobId() {
		return jobId;
	}
	public void setJobId(int jobId) {
		this.jobId = jobId;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public String getJobDescription() {
		return jobDescription;
	}
	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}
	public String getJobSkills() {
		return jobSkills;
	}
	public void setJobSkills(String jobSkills) {
		this.jobSkills = jobSkills;
	}
	public Date getJobDate() {
		return jobDate;
	}
	public void setJobDate(Date jobDate) {
		this.jobDate = jobDate;
	}
	public String getJobLocation() {
		return jobLocation;
	}
	public void setJobLocation(String jobLocation) {
		this.jobLocation = jobLocation;
	}
	public String getJoobCompany() {
		return joobCompany;
	}
	public void setJoobCompany(String joobCompany) {
		this.joobCompany = joobCompany;
	}
	public String getJobExperience() {
		return jobExperience;
	}
	public void setJobExperience(String jobExperience) {
		this.jobExperience = jobExperience;
	}
	
	
}
