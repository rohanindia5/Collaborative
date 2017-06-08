package com.tweak.modal;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@Entity
public class BlogComment 
{
	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int blogCommentId;
	private String blogCommentContext;
	@Column(columnDefinition="Date")
	private Date blogCommentDate;
	private int userId;
	private int blogId;
	@ManyToOne
	@JoinColumn(name="userId",nullable=false,insertable=false,updatable=false)
	private UserTable user;
	@ManyToOne
	@JoinColumn(name="blogId",nullable=false,updatable=false,insertable=false)
	private Blog Blog;
	
	public String getBlogCommentContext() {
		return blogCommentContext;
	}
	public void setBlogCommentContext(String blogCommentContext) {
		this.blogCommentContext = blogCommentContext;
	}
	public Date getBlogCommentDate() {
		return blogCommentDate;
	}
	public void setBlogCommentDate(Date blogCommentDate) {
		this.blogCommentDate = blogCommentDate;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getBlogId() {
		return blogId;
	}
	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}
	public UserTable getUser() {
		return user;
	}
	public void setUser(UserTable user) {
		this.user = user;
	}
	public Blog getBlog() {
		return Blog;
	}
	public void setBlog(Blog blog) {
		Blog = blog;
	}
	public int getBlogCommentId() {
		return blogCommentId;
	}
	public void setBlogCommentId(int blogCommentId) {
		this.blogCommentId = blogCommentId;
	}
	
}
