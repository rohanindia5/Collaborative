package com.tweak.modal;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ForumComment 
{
	@Id
	/*@GeneratedValue(strategy=GenerationType.IDENTITY)*/
	private int forumCommentId;
	private String forumCommentContext;
	@Column(columnDefinition="Date")
	private Date forumCommentDate;
	private int userId;
	private int forumId;
	@ManyToOne
	@JoinColumn(name="userId",nullable=false,insertable=false,updatable=false)
	private UserTable user;
	@ManyToOne
	@JoinColumn(name="forumId",nullable=false,updatable=false,insertable=false)
	private Forum forum;
	public int getForumCommentId() {
		return forumCommentId;
	}
	public void setForumCommentId(int forumCommentId) {
		this.forumCommentId = forumCommentId;
	}
	
	public String getForumCommentContext() {
		return forumCommentContext;
	}
	public void setForumCommentContext(String forumCommentContext) {
		this.forumCommentContext = forumCommentContext;
	}
	public Date getForumCommentDate() {
		return forumCommentDate;
	}
	public void setForumCommentDate(Date forumCommentDate) {
		this.forumCommentDate = forumCommentDate;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
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
	public Forum getForum() {
		return forum;
	}
	public void setForum(Forum forum) {
		this.forum = forum;
	}
	
	
}
