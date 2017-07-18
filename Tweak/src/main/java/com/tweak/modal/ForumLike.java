package com.tweak.modal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ForumLike 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int forumLikeId;
	
	@ManyToOne
	@JoinColumn(name="forumId",nullable=false,updatable=false,insertable=false)
	private Forum forum;
	private int forumId;
	
	@ManyToOne
	@JoinColumn(name="userId",nullable=false,updatable=false,insertable=false)
	private UserTable user;
	private int userId;
	public int getForumLikeId() {
		return forumLikeId;
	}
	public void setForumLikeId(int forumLikeId) {
		this.forumLikeId = forumLikeId;
	}
	public Forum getForum() {
		return forum;
	}
	public void setForum(Forum forum) {
		this.forum = forum;
	}
	public int getForumId() {
		return forumId;
	}
	public void setForumId(int forumId) {
		this.forumId = forumId;
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
	
	
}
