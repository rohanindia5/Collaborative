package com.tweak.modal;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import org.springframework.web.multipart.MultipartFile;

import org.hibernate.annotations.Columns;

@Entity
public class Blog 
{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int blogId;
	private String blogName;
	@Column(columnDefinition="CLOB")
	private String blogContent;
	@Column(columnDefinition="Date")
	private Date blogDate;
	private int blogLikes;
	private int blogComment;
	private int userId;
	@ManyToOne
	@JoinColumn(name="userId",nullable=false,updatable=false,insertable=false)
	private UserTable user;
	
	@Transient
	private MultipartFile blogImage;
	
	
	public int getBlogId() {
		return blogId;
	}
	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}
	
	
	public String getBlogName() {
		return blogName;
	}
	public void setBlogName(String blogName) {
		this.blogName = blogName;
	}
	public String getBlogContent() {
		return blogContent;
	}
	public void setBlogContent(String blogContent) {
		this.blogContent = blogContent;
	}
	public int getBlogLikes() {
		return blogLikes;
	}
	public void setBlogLikes(int blogLikes) {
		this.blogLikes = blogLikes;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public UserTable getUser() {
		return user;
	}
	public void setUser(UserTable user) {
		this.user = user;
	}
	public Date getBlogDate() {
		return blogDate;
	}
	public void setBlogDate(Date blogDate) {
		this.blogDate = blogDate;
	}
	public int getBlogComment() {
		return blogComment;
	}
	public void setBlogComment(int blogComment) {
		this.blogComment = blogComment;
	}	
	
}
