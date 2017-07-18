package com.tweak.modal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class BlogLike 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int blogLikeId;
	@ManyToOne
	@JoinColumn(name="userId",nullable=false,updatable=false,insertable=false)
	private UserTable user;
	private int userId;
	
	@ManyToOne
	@JoinColumn(name="blogId",nullable=false,updatable=false,insertable=false)
	private Blog blog;
	private int blogId;
	public int getBlogLikeId() {
		return blogLikeId;
	}
	public void setBlogLikeId(int blogLikeId) {
		this.blogLikeId = blogLikeId;
	}
	public UserTable getUser() {
		return user;
	}
	public void setUser(UserTable user) {
		this.user = user;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public Blog getBlog() {
		return blog;
	}
	public void setBlog(Blog blog) {
		this.blog = blog;
	}
	public int getBlogId() {
		return blogId;
	}
	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}
	
	
}
