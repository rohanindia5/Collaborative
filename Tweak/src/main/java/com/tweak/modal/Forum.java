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
public class Forum 
{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int forumId;
	private String forumName;
	@Column(columnDefinition="CLOB")
	private String forumContent;
	@Column(columnDefinition="Date")
	private Date forumDate;
	private int forumLikes;
	private int forumComment;
	public int getForumComment() {
		return forumComment;
	}
	public void setForumComment(int forumComment) {
		this.forumComment = forumComment;
	}
	private int userId;
	@ManyToOne
	@JoinColumn(name="userId",nullable=false,updatable=false,insertable=false)
	private UserTable user;
	public int getForumId() {
		return forumId;
	}
	public void setForumId(int forumId) {
		this.forumId = forumId;
	}
	
	public String getForumName() {
		return forumName;
	}
	public void setForumName(String forumName) {
		this.forumName = forumName;
	}
	public String getForumContent() {
		return forumContent;
	}
	public void setForumContent(String forumContent) {
		this.forumContent = forumContent;
	}
	public Date getForumDate() {
		return forumDate;
	}
	public void setForumDate(Date forumDate) {
		this.forumDate = forumDate;
	}
	public int getForumLikes() {
		return forumLikes;
	}
	public void setForumLikes(int forumLikes) {
		this.forumLikes = forumLikes;
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
	
}
