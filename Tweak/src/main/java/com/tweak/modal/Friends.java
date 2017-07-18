package com.tweak.modal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Friends 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int friendId;
	private int friendsUserId;
	private int userId;
	private String status;
	private boolean isOnline;
	@ManyToOne
	@JoinColumn(name="userId",nullable=false,insertable=false,updatable=false)
	private UserTable user;
	public int getFriendId() {
		return friendId;
	}
	public void setFriendId(int friendId) {
		this.friendId = friendId;
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
	public int getFriendsUserId() {
		return friendsUserId;
	}
	public void setFriendsUserId(int friendsUserId) {
		this.friendsUserId = friendsUserId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public boolean isOnline() {
		return isOnline;
	}
	public void setOnline(boolean isOnline) {
		this.isOnline = isOnline;
	}
	
	
}
	